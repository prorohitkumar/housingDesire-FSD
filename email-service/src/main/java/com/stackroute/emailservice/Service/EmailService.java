package com.stackroute.emailservice.Service;

import com.stackroute.emailservice.model.EmailDetails;

public interface EmailService {
    public String sendSimpleMail(EmailDetails details);
    public String sendMailWithAttachment(EmailDetails details);

}
