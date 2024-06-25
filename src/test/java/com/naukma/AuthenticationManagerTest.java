package com.naukma;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthenticationManagerTest {
    private AuthenticationManager manager;

    @BeforeEach
    void setUp() {
        manager = new AuthenticationManager();
    }

    @Test
    void testValidUser() {
        String username = "john_doe";
        Assumptions.assumeFalse(manager.isSecured(), "Manager should be secured");
        boolean result = manager.isValidUser(username);
        assertThat(result).isTrue();
    }

    @Test
    void testInvalidUser() {
        String username = "unknown_user";
        Assumptions.assumeFalse(manager.isSecured(), "Manager should be secured");
        boolean result = manager.isValidUser(username);
        assertThat(result).isFalse();
    }

    @Test
    void testValidCredentials() {
        String username = "john_doe";
        String password = "password123";
        Assumptions.assumeFalse(manager.isSecured(), "Manager should be secured");
        boolean result = manager.validateCredentials(username, password);
        assertThat(result).isTrue();
    }

    @Test
    void testInvalidCredentials() {
        String username = "john_doe";
        String password = "wrong_password";
        Assumptions.assumeFalse(manager.isSecured(), "Manager should be secured");
        boolean result = manager.validateCredentials(username, password);
        assertThat(result).isFalse();
    }

    @Test
    void testNonExistentUserCredentials() {
        String username = "unknown_user";
        String password = "any_password";
        Assumptions.assumeFalse(manager.isSecured(), "Manager should be secured");
        boolean result = manager.validateCredentials(username, password);
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "john_doe, password123, true",
            "jane_smith, pass456, true",
            "john_doe, wrong_password, false",
            "unknown_user, any_password, false"
    })
    void testValidateCredentials(String username, String password, boolean expectedResult) {
        Assumptions.assumeFalse(manager.isSecured(), "Manager should be secured");
        boolean result = manager.validateCredentials(username, password);
        assertThat(result).isEqualTo(expectedResult);
    }
}
