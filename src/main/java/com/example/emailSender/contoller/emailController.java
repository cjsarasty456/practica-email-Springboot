package com.example.emailSender.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailSender.services.emailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class emailController {

    @Autowired
    private emailService emailService;

    @GetMapping("/basicEmail")
    public String sendBasicEmail() {
        emailService.basicMail();
        return "mail sent successfully";
    }

    @GetMapping("/advancedEmail/{email}")
    public String advancedEmail(@PathVariable String email) {
        emailService.advancedEmail(email);
        return "mail sent successfully";
    }
    
    

}
