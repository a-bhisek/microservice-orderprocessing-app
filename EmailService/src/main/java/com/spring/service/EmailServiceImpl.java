package com.spring.service;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.spring.dto.OrderPlacedDTO;
import com.spring.dto.PaymentConfirmationDTO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImpl implements IEmailService{

	@Autowired
	private JavaMailSender sender;
	
	@Value("${from-email}")
	private String fromEmail;
	
	public byte[] generateInvoicePdf(Long orderId, Double amount, String paymentStatus) {
	    
	    try {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	        Document document = new Document();
	        PdfWriter.getInstance(document, outputStream);

	        document.open();

	        document.add(new Paragraph("INVOICE"));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph("Order ID : " + orderId));
	        document.add(new Paragraph("Amount : ₹" + amount));
	        document.add(new Paragraph("Payment Status : " + paymentStatus));
	        document.add(new Paragraph("Generated On : " + java.time.LocalDateTime.now()));

	        document.close();
            log.info("PDF invoice generated.");
	        return outputStream.toByteArray();

	    } catch (Exception e) {
	        throw new RuntimeException("Error while generating PDF", e);
	    }
	}
	
	@Override
	public String sendOrderPlacedMail(OrderPlacedDTO orderDTO) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom(fromEmail);
		helper.setTo(orderDTO.getToMail());
		helper.setSubject("Order Confirmation");
		helper.setSentDate(new Date());
		helper.setText("""
				Dear Customer,

				Thank you for your order.

				We are pleased to inform you that your order has been placed successfully.

				Order Details:

				* Order ID: %s

				Your order is currently being processed. You will receive further updates regarding payment confirmation, shipping, and delivery status.

				If you have any questions or require assistance, please contact our support team.

				Thank you for choosing our services.

				Best Regards,
				Order Processing Team

				 """.formatted(orderDTO.getOrderId()));
		sender.send(message);
		log.info("Order confirmation mail sent");
		return "Order Confirmation Mail Sent";
	}

	@Override
	public String sendPaymentSuccessMail(PaymentConfirmationDTO paymentDTO) throws MessagingException {
		byte[] pdf = generateInvoicePdf(paymentDTO.getOrderId(), paymentDTO.getAmount(), paymentDTO.getPaymentStatus());
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(paymentDTO.getToMail());
        helper.setSubject("Payment Confirmation");
		helper.setSentDate(new Date());
		helper.setText("""
			   Dear Customer,

               We are pleased to inform you that your payment has been successfully processed.

               Payment Details:

               * Payment ID: %d
               * Amount: ₹%.2f
               * Payment Status: %s

               Your transaction has been completed successfully, and your order is now confirmed.

               Please find the invoice attached below for your reference.

               If you have any questions or require assistance, please contact our support team.

               Thank you for choosing our services.

               Best Regards,
               Payment Processing Team
 
				       """.formatted(paymentDTO.getPaymentId(), paymentDTO.getAmount(), paymentDTO.getPaymentStatus()));
		helper.addAttachment(
		        "Invoice_" + paymentDTO.getOrderId() + ".pdf",
		        new ByteArrayResource(pdf)
		);
		sender.send(message);
		log.info("Payment Confirmation mail sent");
		return "Payment Confirmation Mail Sent";
	}

}
