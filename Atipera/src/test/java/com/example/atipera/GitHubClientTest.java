package com.example.atipera;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class GitHubClientTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldGetNonForkRepositoriesWithBranchesAndCommits(){
        //given
        String user = "Ser0G1t";
        // when & then
        webTestClient.get()
                .uri("/api/github/users/{username}/repositories", user)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$[0].name").isNotEmpty()
                .jsonPath("$[0].owner.login").isEqualTo(user)
                .jsonPath("$[0].branches").isArray()
                .jsonPath("$[0].branches[0].name").isNotEmpty()
                .jsonPath("$[0].branches[0].commit.sha").isNotEmpty();
    }
}
