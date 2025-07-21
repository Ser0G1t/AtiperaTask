package com.example.atipera.controllers;

import com.example.atipera.models.GitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.atipera.service.GitClientService;
import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GitClientController {
    private final GitClientService gitClientService;

    public GitClientController(GitClientService gitClientService) {
        this.gitClientService = gitClientService;
    }

    @GetMapping("/users/{username}/repositories")
    public ResponseEntity<List<GitRepository>> getNonForkRepositories(@PathVariable String username) {
        List<GitRepository> repositories = gitClientService.getNonForkRepositories(username);
        if (repositories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repositories);
    }
}