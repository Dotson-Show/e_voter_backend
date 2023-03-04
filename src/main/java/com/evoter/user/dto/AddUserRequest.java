package com.evoter.user.dto;

public record AddUserRequest(
        String name,
        Integer age,
        String nin,
        String email,
        String password,
        String sex
) {
}
