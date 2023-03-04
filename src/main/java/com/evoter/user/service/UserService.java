package com.evoter.user.service;

import com.evoter.user.model.User;
import com.evoter.user.repository.UserRepository;
import com.evoter.user.dto.AddUserRequest;
import com.evoter.user.dto.UpdateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalTime.now;

/**
 * @author showunmioludotun
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(AddUserRequest request) {
        User user = new User();
        user.setName(request.name());
        user.setAge(request.age());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setSex(request.sex());
        user.setNin(request.nin());
        user.setAdmin(false);
        user.setSuperAdmin(false);
        return userRepository.save(user);
    }

    public User updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id).orElse(null);
        System.out.println(user);
        System.exit(0);
        if (user == null) {
            return null;
        }
        user.setName(request.name());
        user.setAge(request.age());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setSex(request.sex());
        user.setNin(request.nin());
        user.setAdmin(false);
        user.setSuperAdmin(false);
        return userRepository.save(user);
    }
}
