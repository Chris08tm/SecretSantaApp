package com.ccs.secretsantaapp.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "participant_details")
public class ParticipantModel {
    @Id
    @TableGenerator(name = "participant_details", initialValue = 5)
    private Long id;
    private String name;
    private String email;
    private String wishList;
}
