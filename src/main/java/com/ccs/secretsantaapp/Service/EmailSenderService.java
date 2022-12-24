package com.ccs.secretsantaapp.Service;

import com.ccs.secretsantaapp.Model.ParticipantModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmails(HashMap<ParticipantModel, ParticipantModel> pairs){

        for(Map.Entry<ParticipantModel, ParticipantModel> entry : pairs.entrySet()){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("secretsantaappnotification@gmail.com");
            message.setTo(entry.getKey().getEmail());
            message.setSubject("Secret Santa Notification!");
            message.setText("Your gift will be for: " + entry.getValue().getName());
            javaMailSender.send(message);
            System.out.println("Email sent to " + entry.getKey().getEmail());
        }

    }
}
