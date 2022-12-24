package com.ccs.secretsantaapp.Service;

import com.ccs.secretsantaapp.Model.ParticipantModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecretSantaService {

    public HashMap<ParticipantModel, ParticipantModel> generatePairs(List<ParticipantModel> participants) {
        HashMap<ParticipantModel, ParticipantModel> pairs = new HashMap<>();
        HashMap<ParticipantModel, Integer> map = new HashMap<>();
        ArrayList<ParticipantModel> receivers = new ArrayList<>(participants);
        int upperBound = participants.size() - 1;

        // Populate map with receivers locations
        for(int i = 0; i < receivers.size(); i++){
            map.put(receivers.get(i), i);
        }

        for(int i = 0; i < participants.size(); i++){
            if(upperBound == 0){
                pairs.put(participants.get(i), receivers.get(upperBound));
                break;
            }
            // Swap current giver with upperBound
            swap(receivers, map.get(participants.get(i)), upperBound);

            // Pick random receiver
            Random rand = new Random();
            int randomReceiver = rand.nextInt(upperBound);

            // Put the pair in the map
            pairs.put(participants.get(i), receivers.get(randomReceiver));

            // Reverse swap from step 1
            swap(receivers, map.get(participants.get(i)), upperBound);

            if(map.get(participants.get(i)) != randomReceiver){
                swap(receivers, upperBound, randomReceiver);
            }
            upperBound--;
        }
        return pairs;
    }

    private void swap(ArrayList<ParticipantModel> receivers, int x, int y){
        ParticipantModel temp = receivers.get(x);
        receivers.set(x , receivers.get(y));
        receivers.set(y, temp);
    }

}
