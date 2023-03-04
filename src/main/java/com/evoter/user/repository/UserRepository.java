package com.evoter.user.repository;

import com.evoter.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author showunmioludotun
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
