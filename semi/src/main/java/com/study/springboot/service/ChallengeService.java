package com.study.springboot.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dto.ChallengeParticipationResponse;
import com.study.springboot.entity.Challenge;
import com.study.springboot.entity.ChallengeParticipation;
import com.study.springboot.repository.ChallengeParticipationRepository;
import com.study.springboot.repository.ChallengeRepository;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final ChallengeParticipationRepository participationRepository;

    @Autowired
    public ChallengeService(ChallengeRepository challengeRepository, ChallengeParticipationRepository participationRepository) {
        this.challengeRepository = challengeRepository;
        this.participationRepository = participationRepository;
    }

    /**
     * 전체 챌린지 목록 조회
     */
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    /**
     * 오늘 참여한 챌린지 정보 조회
     */
    public List<ChallengeParticipationResponse> getChallengesForUser(String userId) {
        LocalDate today = LocalDate.now();
        List<ChallengeParticipation> participations = participationRepository.findByUserIdAndJoinedAt(userId, today);


        // 로그 찍기 - 콘솔 확인용
        System.out.println("🧪 참여 수: " + participations.size());
        for (ChallengeParticipation p : participations) {
            System.out.println("🧪 유저: " + p.getUserId());
            if (p.getChallenge() != null) {
                System.out.println("🧪 챌린지 제목: " + p.getChallenge().getTitle());
                System.out.println("🧪 난이도: " + p.getChallenge().getDifficulty());
                System.out.println("🧪 점수: " + p.getChallenge().getScore());
            } else {
                System.out.println("❌ 챌린지 객체가 null임");
            }
        }

        return participations.stream()
                .map(p -> new ChallengeParticipationResponse(
                    p.getChallenge().getTitle(),
                    p.getChallenge().getDifficulty(),
                    p.getChallenge().getScore(),
                    p.getStatus(),
                    p.getJoinedAt(),
                    p.getCompletedAt(),
                    p.getEarnedPoints()
                ))
                .collect(Collectors.toList());
        }

    /**
     * 챌린지 시작 시 참여 정보 저장
     */
    public void startChallenge(String userId, String challengeTitle) {
        Challenge challenge = challengeRepository.findByTitleContaining(challengeTitle)
            .stream()
            .findFirst()
            .orElseThrow(() -> new RuntimeException("해당 제목의 챌린지를 찾을 수 없습니다."));

        ChallengeParticipation participation = new ChallengeParticipation();
        participation.setUserId(userId);
        participation.setStatus("진행 중");
        participation.setJoinedAt(LocalDate.now());
        participation.setChallenge(challenge);

        participationRepository.save(participation);
    }

    /**
     * 챌린지 완료 시 상태 업데이트 및 점수 추가
     */
    public void completeChallenge(String userId, String challengeTitle, int earnedPoints) {
        ChallengeParticipation participation = participationRepository.findByUserId(userId)
            .stream()
            .filter(p -> p.getChallenge().getTitle().equals(challengeTitle) && p.getStatus().equals("진행 중"))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("진행 중인 챌린지를 찾을 수 없습니다."));

        participation.setStatus("완료");
        participation.setCompletedAt(LocalDate.now());
        participation.setEarnedPoints(earnedPoints);

        participationRepository.save(participation);
    }
}
