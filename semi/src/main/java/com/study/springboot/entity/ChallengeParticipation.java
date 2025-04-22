package com.study.springboot.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ChallengeParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PARTICIPATION_ID")
    private Long participationId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "JOINED_AT")
    private LocalDate joinedAt;

    @Column(name = "COMPLETED_AT")
    private LocalDate completedAt;

    @Column(name = "EARNED_POINTS")
    private int earnedPoints;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHALLENGE_ID", nullable = false)
    private Challenge challenge;

    public Long getParticipationId() { return participationId; }
    public void setParticipationId(Long participationId) { this.participationId = participationId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getJoinedAt() { return joinedAt; }
    public void setJoinedAt(LocalDate joinedAt) { this.joinedAt = joinedAt; }
    public LocalDate getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDate completedAt) { this.completedAt = completedAt; }
    public int getEarnedPoints() { return earnedPoints; }
    public void setEarnedPoints(int earnedPoints) { this.earnedPoints = earnedPoints; }
    public Challenge getChallenge() { return challenge; }
    public void setChallenge(Challenge challenge) { this.challenge = challenge; }
}