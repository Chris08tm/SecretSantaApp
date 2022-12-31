package com.ccs.secretsantaapp.Repository;

import com.ccs.secretsantaapp.Model.ParticipantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretSantaRepositoryInterface extends JpaRepository<ParticipantModel, Long> {
    public ParticipantModel findByEmail(String email);
}
