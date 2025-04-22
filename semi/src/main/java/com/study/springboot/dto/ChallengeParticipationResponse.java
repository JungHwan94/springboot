package com.study.springboot.dto;

import java.time.LocalDate;

public class ChallengeParticipationResponse {
    private String challengeTitle;
    private String difficulty;
    private int score;
    private String status;
    private LocalDate joinedAt;
    private LocalDate completedAt;
    private int earnedPoints;

    public ChallengeParticipationResponse(String challengeTitle, String difficulty, int score, String status, LocalDate joinedAt, LocalDate completedAt, int earnedPoints) {
        this.challengeTitle = challengeTitle;
        this.difficulty = difficulty;
        this.score = score;
        this.status = status;
        this.joinedAt = joinedAt;
        this.completedAt = completedAt;
        this.earnedPoints = earnedPoints;
    }

    public String getChallengeTitle() { return challengeTitle; }
    public String getDifficulty() { return difficulty; }
    public int getScore() { return score; }
    public String getStatus() { return status; }
    public LocalDate getJoinedAt() { return joinedAt; }
    public LocalDate getCompletedAt() { return completedAt; }
    public int getEarnedPoints() { return earnedPoints; }
}