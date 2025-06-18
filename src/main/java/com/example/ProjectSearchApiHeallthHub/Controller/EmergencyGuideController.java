package com.example.ProjectSearchApiHeallthHub.Controller;

import com.example.ProjectSearchApiHeallthHub.Model.EmergencyGuide;
import com.example.ProjectSearchApiHeallthHub.Repos.EmergencyGuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/emergency")
@CrossOrigin
public class EmergencyGuideController {

    @Autowired
    private EmergencyGuideRepository guideRepo;

    // ✅ Add new emergency guide (Admin)
    @PostMapping
    public ResponseEntity<EmergencyGuide> addGuide(@RequestBody EmergencyGuide guide) {
        EmergencyGuide saved = guideRepo.save(guide);
        return ResponseEntity.ok(saved);
    }

    // ✅ Get exact match by situation
    @GetMapping("/{situation}")
    public ResponseEntity<EmergencyGuide> getGuideBySituation(@PathVariable String situation) {
        Optional<EmergencyGuide> guide = guideRepo.findBySituationIgnoreCase(situation);
        return guide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Optional fuzzy search
    @GetMapping("/search")
    public ResponseEntity<List<EmergencyGuide>> searchGuideByKeyword(@RequestParam("q") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<EmergencyGuide> matches = guideRepo.findBySituationContainingIgnoreCase(keyword);

        if (matches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(matches);
    }

    // ✅ Get all emergency guides (optional utility)
    @GetMapping("/all")
    public List<EmergencyGuide> getAllGuides() {
        return guideRepo.findAll();
    }
}
