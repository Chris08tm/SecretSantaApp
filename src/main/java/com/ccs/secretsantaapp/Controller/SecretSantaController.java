package com.ccs.secretsantaapp.Controller;

import com.ccs.secretsantaapp.Model.ParticipantModel;
import com.ccs.secretsantaapp.Service.EmailSenderService;
import com.ccs.secretsantaapp.Service.SecretSantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chimney")
public class SecretSantaController {

    @Autowired
    private SecretSantaService secretSantaService;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping
    public String submitParticipants(@RequestBody List<ParticipantModel> participants) {
        emailSenderService.sendEmails(secretSantaService.generatePairs(participants));
        return "Emails have been sent";
    }
}
