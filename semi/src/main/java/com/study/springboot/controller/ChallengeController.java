package com.study.springboot.controller;

import com.study.springboot.dto.ChallengeParticipationResponse;
import com.study.springboot.entity.Challenge;
import com.study.springboot.service.ChallengeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> getAll() {
        return challengeService.getAllChallenges();
    }

    // ✅ 오늘의 챌린지 목록 요청 처리
    @GetMapping("/today")
    public List<ChallengeParticipationResponse> getTodayChallenges(@RequestParam("userId") String userId) {
        return challengeService.getChallengesForUser(userId);
    }

    @PostMapping("/start")
    public void startChallenge(@RequestBody Map<String, String> payload) {
        challengeService.startChallenge(payload.get("userId"), payload.get("challengeTitle"));
    }

    @PostMapping("/complete")
    public void completeChallenge(@RequestBody Map<String, Object> payload) {
        String userId = (String) payload.get("userId");
        String challengeTitle = (String) payload.get("challengeTitle");
        int earnedPoints = (int) payload.get("earnedPoints");
        challengeService.completeChallenge(userId, challengeTitle, earnedPoints);
    }
}
