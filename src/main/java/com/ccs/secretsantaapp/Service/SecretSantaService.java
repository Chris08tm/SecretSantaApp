package com.ccs.secretsantaapp.Service;

import com.ccs.secretsantaapp.Model.ParticipantModel;
import com.ccs.secretsantaapp.Repository.SecretSantaRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@Service
public class SecretSantaService {
    @Autowired
    private PairGeneratorService pairGeneratorService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private SecretSantaRepositoryInterface secretSantaRepositoryInterface;

    public void generatePairsAndSendEmails(ArrayList<ParticipantModel> participants){
        if(participants.size() <= 1){
            System.out.println("Not enough participants");
            return;
        }
        HashMap<ParticipantModel, ParticipantModel> p = pairGeneratorService.generatePairs(participants);
        // emailSenderService.sendEmails(p);
    }

    public List<ParticipantModel> saveParticipants(List<ParticipantModel> participants){
        return secretSantaRepositoryInterface.saveAll(participants);
    }

    public ParticipantModel saveParticipant(ParticipantModel participantModel){
        return secretSantaRepositoryInterface.save(participantModel);
    }


    public ParticipantModel findParticipantByEmail(String email) {
        return secretSantaRepositoryInterface.findByEmail(email);
    }

    public List<ParticipantModel> findAllParticipants() {
        return secretSantaRepositoryInterface.findAll();
    }

    public ParticipantModel updateParticipant(String email, ParticipantModel p) {
        ParticipantModel participantModel = findParticipantByEmail(email);

        if(Objects.nonNull(p.getName()) && !"".equalsIgnoreCase(p.getName())){
            participantModel.setName(p.getName());
        }
        if(Objects.nonNull(p.getEmail()) && !"".equalsIgnoreCase(p.getEmail())){
            participantModel.setEmail(p.getEmail());
        }
        if(Objects.nonNull(p.getWishList()) && !"".equalsIgnoreCase(p.getWishList())){
            participantModel.setWishList(p.getWishList());
        }

        // Send email about update

        return saveParticipant(participantModel);
    }
}
