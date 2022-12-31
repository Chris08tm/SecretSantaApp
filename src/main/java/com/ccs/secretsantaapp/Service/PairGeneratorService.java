package com.ccs.secretsantaapp.Service;

import com.ccs.secretsantaapp.Model.ParticipantModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PairGeneratorService {

    public HashMap<ParticipantModel, ParticipantModel> generatePairs(ArrayList<ParticipantModel> participants) {
        HashMap<ParticipantModel, ParticipantModel> pairs = new HashMap<>();

        for(int i = 0; i < participants.size(); i++){
            Random rand = new Random();
            int randomSpot = rand.nextInt(participants.size());
            swap(participants, i, randomSpot);
        }

        for(int i = 0; i < participants.size(); i++){
            if(i == participants.size() - 1){
                pairs.put(participants.get(i) , participants.get(0));
            }else{
                pairs.put(participants.get(i), participants.get(i+1));
            }

        }

        printPairs(pairs);
        return pairs;
    }

    private void swap(ArrayList<ParticipantModel> receivers, int x, int y){
        ParticipantModel temp = receivers.get(x);
        receivers.set(x , receivers.get(y));
        receivers.set(y, temp);
    }

    private void printPairs(HashMap<ParticipantModel, ParticipantModel> pairs){
        for(Map.Entry<ParticipantModel, ParticipantModel> entry : pairs.entrySet()){
            System.out.println(entry.getKey().getName() + " -> " + entry.getValue().getName());
        }
    }

}
