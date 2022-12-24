package com.ccs.secretsantaapp.Model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticipantModel {
    private String name;
    private String email;
}
