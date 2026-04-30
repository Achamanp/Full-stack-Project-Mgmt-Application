package com.projectManagementApp.services.impl;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.projectManagementApp.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${resend.api.key}")
    private String apiKey;

    @Value("${resend.from.email}")
    private String fromEmail;

    private void sendEmail(String to, String subject, String html) {
        Resend resend = new Resend(apiKey);
        CreateEmailOptions params = CreateEmailOptions.builder()
                .from(fromEmail)
                .to(to)
                .subject(subject)
                .html(html)
                .build();
        try {
            resend.emails().send(params);
        } catch (ResendException e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }

    @Override
    public void sendEmailWithTokken(String userEmail, String link) {
        String subject = "Join Project Team Invitation";
        String html = """
            <html>
            <body style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
                <div style="max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px;">
                    <h2 style="color: #2c3e50; text-align: center;">Project Team Invitation</h2>
                    <p>Hello,</p>
                    <p>You have been invited to join a project team. Click the button below to accept:</p>
                    <div style="text-align: center; margin: 30px 0;">
                        <a href="%s" style="background-color: #3498db; color: white; padding: 12px 25px; text-decoration: none; border-radius: 5px; font-weight: bold;">
                            Join Project Team
                        </a>
                    </div>
                    <div style="background-color: #fff3cd; border: 1px solid #ffeaa7; border-radius: 5px; padding: 15px;">
                        <p style="margin: 0; color: #856404;">
                            <strong>⏰ Important:</strong> This link is valid for <strong>10 minutes only</strong>.
                        </p>
                    </div>
                    <p>If the button doesn't work, copy this link:</p>
                    <p style="word-break: break-all; background-color: #f8f9fa; padding: 10px; border-radius: 5px; font-family: monospace;">%s</p>
                    <p style="font-size: 12px; color: #666; text-align: center;">If you didn't expect this, you can safely ignore this email.</p>
                </div>
            </body>
            </html>
            """.formatted(link, link);

        sendEmail(userEmail, subject, html);
    }

    @Override
public void sendEmailWithHtml(String to, String subject, String html) {
    sendEmail(to, subject, html);
}
}