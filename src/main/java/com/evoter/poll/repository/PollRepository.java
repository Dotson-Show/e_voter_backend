package com.evoter.poll.repository;

import com.evoter.poll.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author showunmioludotun
 */
public interface PollRepository extends JpaRepository<Poll, Long> {
    @Query(value = "SELECT * FROM poll WHERE poll_type_id = ?1", nativeQuery = true)
    void findAllWithCandidateAndPollType();
}
