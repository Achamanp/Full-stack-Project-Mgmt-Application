package com.projectManagementApp.services;



public interface EmailService {
	
	void sendEmailWithTokken(String userEmail, String link);
	void sendEmailWithHtml(String to, String subject, String html);
}
