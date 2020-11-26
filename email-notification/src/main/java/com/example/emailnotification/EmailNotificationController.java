package com.example.emailnotification;

import com.example.emailnotification.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailNotificationController {

    @Autowired
    private SmtpMailSender mailSender;

    @GetMapping("/sendmail/{toEmail}")
    public String sendEmail(@PathVariable String toEmail) throws MessagingException {
        mailSender.send(toEmail, "Test Email", "This is Auto email");
        return "Mail sent";
    }
}
