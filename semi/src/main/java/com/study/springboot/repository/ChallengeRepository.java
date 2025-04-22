package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.entity.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    // 난이도별 챌린지 조회
    List<Challenge> findByDifficulty(String difficulty);

    // 제목으로 챌린지 조회
    List<Challenge> findByTitleContaining(String title);
}
