package com.videostore.videostore.integration.movie;

import com.videostore.videostore.integration.AbstractIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MovieControllerIntegrationTest extends AbstractIntegrationTest {

    private String adminToken;

    @BeforeEach
    void setUp() throws Exception {
        adminToken = registerAndLoginAdmin();
    }

    @Test
    void addMovie_shouldWorkForAdmin() throws Exception {
        String body = movieBody("Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isCreated());
    }

    @Test
    void addMovie_shouldFailForNonAdmin() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        String body = movieBody("Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isForbidden());
    }

    @Test
    void addMovie_shouldFailWithInvalidTitle() throws Exception {
        String body = movieBody("", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addMovie_shouldFailWithInvalidYear() throws Exception {
        String body = movieBody("Movie 1", -1, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addMovie_shouldFailWithInvalidGenre() throws Exception {
        String body = movieBody("Movie 1", 2000, "_genre_", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addMovie_shouldFailWithInvalidDuration() throws Exception {
        String body = movieBody("Movie 1", 2000, "Action", -1, "Director A", "Synopsis 1", 2);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addMovie_shouldFailWithInvalidDirector() throws Exception {
        String body = movieBody("Movie 1", 2000, "Action", 120, "Di/rector", "Synopsis 1", 2);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addMovie_shouldFailWithInvalidSynopsis() throws Exception {
        String body = movieBody("Movie 1", 2000, "Action", 120, "Director A", "", 2);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void addMovie_shouldFailWithInvalidNumberOfCopies() throws Exception {
        String body = movieBody("Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", -1);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateMovieInfo_shouldWorkForAdmin() throws Exception {
        Long movieId = addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        String body = updateMovieInfoBody("Movie 2", 2000, "Drama", 120, "Director A", "Synopsis 1");

        mockMvc.perform(put("/movies/{movieId}", movieId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Movie 2"))
                .andExpect(jsonPath("$.genre").value("Drama"));
    }

    @Test
    void updateMovieInfo_shouldFailForNonAdmin() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        Long movieId = addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        String body = updateMovieInfoBody("Movie 2", 2000, "Drama", 120, "Director A", "Synopsis 1");

        mockMvc.perform(put("/movies/{movieId}", movieId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isForbidden());
    }

    @Test
    void updateMovieInfo_shouldFailWhenMovieDoesNotExist() throws Exception {
        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        String body = updateMovieInfoBody("Movie 2", 2010, "Drama", 100, "Director B", "Synopsis 2");

        mockMvc.perform(put("/movies/{movieId}", 999L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateMovieInfo_shouldFailWithInvalidData() throws Exception {
        Long movieId = addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        String body = updateMovieInfoBody("", 2010, "Action", 100, "Director B", "Synopsis 2");

        mockMvc.perform(put("/movies/{movieId}", movieId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void removeMovie_shouldWorkForAdmin() throws Exception {
        Long movieId = addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(delete("/movies/{movieId}", movieId)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNoContent());
    }

    @Test
    void removeMovie_shouldFailForNonAdmin() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        Long movieId = addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(delete("/movies/{movieId}", movieId)
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isForbidden());
    }

    @Test
    void removeMovie_shouldFailWhenMovieDoesNotExist() throws Exception {
        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(delete("/movies/{movieId}", 999L)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void removeMovie_shouldFailWhenMovieHasActiveRentals() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        Long movieId = addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        rentMovie(userToken, movieId);

        mockMvc.perform(delete("/movies/{movieId}", movieId)
                        .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isConflict());
    }

    @Test
    void getMovie_shouldReturnMovie() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        Long movieId = addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(get("/movies/{movieId}", movieId)
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Movie 1"));
    }

    @Test
    void getMovie_shouldFailWhenMovieDoesNotExist() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        mockMvc.perform(get("/movies/{movieId}", 999L)
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllMovies_shouldReturnPagedList() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "2")
                        .param("sortBy", "TITLE")
                        .param("ascending", "true")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getAllMovies_shouldReturnEmptyListWhenNoMovies() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");


        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "2")
                        .param("sortBy", "TITLE")
                        .param("ascending", "true")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void getAllMovies_shouldFilterByGenre() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "10")
                        .param("genre", "action")
                        .param("sortBy", "TITLE")
                        .param("ascending", "true")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getAllMovies_shouldFilterByTitle() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "10")
                        .param("title", "1")
                        .param("sortBy", "TITLE")
                        .param("ascending", "true")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void getAllMovies_shouldFilterOnlyAvailableMovies() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        Long movie1Id = addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 1);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        rentMovie(userToken, movie1Id);

        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "10")
                        .param("onlyAvailable", "true")
                        .param("sortBy", "TITLE")
                        .param("ascending", "true")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getAllMovies_shouldApplyMultipleFilters() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "10")
                        .param("genre", "action")
                        .param("title", "1")
                        .param("sortBy", "TITLE")
                        .param("ascending", "true")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void getAllMovies_shouldSortAscending() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sortBy", "TITLE")
                        .param("ascending", "true")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].title").value("Movie 1"))
                .andExpect(jsonPath("$[2].title").value("Movie 3"));
    }

    @Test
    void getAllMovies_shouldSortDescending() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sortBy", "TITLE")
                        .param("ascending", "false")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].title").value("Movie 3"))
                .andExpect(jsonPath("$[2].title").value("Movie 1"));
    }

    @Test
    void getAllMovies_shouldSortByRating() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);

        Long movie2Id = addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        rentMovie(userToken, movie2Id);
        addReview(userToken, movie2Id, 5, "Comment 1");

        Long movie3Id = addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);
        rentMovie(userToken, movie3Id);
        addReview(userToken, movie3Id, 4, "Comment 2");

        mockMvc.perform(get("/movies")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sortBy", "RATING")
                        .param("ascending", "true")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].title").value("Movie 3"))
                .andExpect(jsonPath("$[2].title").value("Movie 1"));
    }

    @Test
    void getAllMovies_shouldFailWithInvalidPaginationParameters() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        mockMvc.perform(get("/movies")
                        .param("page", "-1")
                        .param("size", "10")
                        .param("sortBy", "TITLE")
                        .param("ascending", "false")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllMovies_shouldFailWithInvalidSortBy() throws Exception {
        String userToken = registerAndLoginUser("User", "Example", "user1", "user1@test.com", "Password12345");

        addMovie(adminToken, "Movie 1", 2000, "Action", 120, "Director A", "Synopsis 1", 2);
        addMovie(adminToken, "Movie 2", 2004, "Action", 110, "Director B", "Synopsis 2", 2);
        addMovie(adminToken, "Movie 3", 2010, "Drama", 100, "Director C", "Synopsis 3", 2);

        mockMvc.perform(get("/movies")
                        .param("page", "1")
                        .param("size", "10")
                        .param("sortBy", "invalid")
                        .param("ascending", "false")
                        .header("Authorization", "Bearer " + userToken))
                .andExpect(status().isBadRequest());
    }
}
