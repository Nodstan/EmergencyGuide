package com.example.ProjectSearchApiHeallthHub.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "EmergencyGuides")
public class EmergencyGuide {

    @Id
    private String id;
    private String situation;
    private List<String> steps;

    public EmergencyGuide() {}

    public EmergencyGuide(String situation, List<String> steps) {
        this.situation = situation;
        this.steps = steps;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSituation() { return situation; }
    public void setSituation(String situation) { this.situation = situation; }

    public List<String> getSteps() { return steps; }
    public void setSteps(List<String> steps) { this.steps = steps; }
}
