package com.ccs.secretsantaapp.Controller;

import com.ccs.secretsantaapp.Model.ParticipantModel;
import com.ccs.secretsantaapp.Service.SecretSantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chimney")
public class SecretSantaController {

    @Autowired
    private SecretSantaService secretSantaService;

    @PostMapping
    public ParticipantModel saveParticipant(@RequestBody ParticipantModel participantModel){
        return secretSantaService.saveParticipant(participantModel);
    }

    @PostMapping("/participants")
    public List<ParticipantModel> saveParticipants(@RequestBody List<ParticipantModel> participants){
        return secretSantaService.saveParticipants(participants);
    }

    @PutMapping("/{email}")
    public ParticipantModel updateParticipant(@PathVariable String email,
                                              @RequestBody ParticipantModel p){
        return secretSantaService.updateParticipant(email, p);
    }

    @GetMapping
    public List<ParticipantModel> findAllParticipants(){
        return secretSantaService.findAllParticipants();
    }

    @GetMapping("/{email}")
    public ParticipantModel findParticipantByEmail(@PathVariable String email){
        return secretSantaService.findParticipantByEmail(email);
    }

    @GetMapping("/pairs")
    public void sendEmails(){
        ArrayList<ParticipantModel> participants = new ArrayList<>(findAllParticipants());
        secretSantaService.generatePairsAndSendEmails(participants);
    }

}
