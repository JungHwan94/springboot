package com.study.springboot.repository;

import com.study.springboot.entity.ChallengeParticipation;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ChallengeParticipationRepository extends JpaRepository<ChallengeParticipation, Long> {

    List<ChallengeParticipation> findByUserId(String userId);

    @Query("""
    	    SELECT cp FROM ChallengeParticipation cp
    	    JOIN FETCH cp.challenge
    	    WHERE cp.userId = :userId AND cp.joinedAt = :joinedAt
    	""")
    	List<ChallengeParticipation> findByUserIdAndJoinedAt(
    	    @Param("userId") String userId,
    	    @Param("joinedAt") LocalDate joinedAt
    	);


}