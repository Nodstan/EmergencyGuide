package com.example.ProjectSearchApiHeallthHub.Repos;

import com.example.ProjectSearchApiHeallthHub.Model.EmergencyGuide;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmergencyGuideRepository extends MongoRepository<EmergencyGuide, String> {
    Optional<EmergencyGuide> findBySituationIgnoreCase(String situation);
    List<EmergencyGuide> findBySituationContainingIgnoreCase(String keyword); // fuzzy-like match
}
