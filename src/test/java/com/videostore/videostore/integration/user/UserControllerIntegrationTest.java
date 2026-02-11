package com.videostore.videostore.integration.user;

import com.videostore.videostore.integration.AbstractIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerIntegrationTest extends AbstractIntegrationTest {

    private Long user1Id;

    @BeforeEach
    void setUp() throws Exception {
        user1Id = registerUser("User", "Example", "user1", "user1@test.com", "Password12345");
    }

    @Test
    void removeUser_shouldWorkForAdmin() throws Exception {
        String adminToken = registerAndLoginAdmin();

        mockMvc.perform(delete("/users/{userId}", user1Id)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNoContent());
    }

    @Test
    void removeUser_shouldFailForNonAdmin() throws Exception {
        String userToken = login("user1", "Password12345");

        mockMvc.perform(delete("/users/{userId}", user1Id)
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isForbidden());
    }

    @Test
    void removeUser_shouldFailForNonexistentUser() throws Exception {
        String adminToken = registerAndLoginAdmin();

        mockMvc.perform(delete("/users/{userId}", 999L)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void getMe_shouldReturnAuthenticatedUser() throws Exception {
        String userToken = login("user1", "Password12345");

        mockMvc.perform(get("/me")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user1"))
                .andExpect(jsonPath("$.email").value("user1@test.com"));
    }

    @Test
    void getUser_shouldReturnUserForAdmin() throws Exception {
        String adminToken = registerAndLoginAdmin();

        mockMvc.perform(get("/users/{userId}", user1Id)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user1"));
    }

    @Test
    void getUser_shouldFailForNonAdmin() throws Exception {
        String userToken = login("user1", "Password12345");

        mockMvc.perform(get("/users/{userId}", user1Id)
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isForbidden());
    }

    @Test
    void getUser_shouldFailForNonexistentUser() throws Exception {
        String adminToken = registerAndLoginAdmin();

        mockMvc.perform(get("/users/{userId}", 999L)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllUsers_shouldReturnListForAdmin() throws Exception {
        String adminToken = registerAndLoginAdmin();

        registerUser("User", "Example", "user2", "user2@test.com", "Password67890");

        mockMvc.perform(get("/users")
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getAllUsers_shouldFailForNonAdmin() throws Exception {
        String userToken = login("user1", "Password12345");

        mockMvc.perform(get("/users")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isForbidden());
    }
}
