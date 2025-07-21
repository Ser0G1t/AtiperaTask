package com.example.atipera.service;

import com.example.atipera.models.GitBranch;
import com.example.atipera.models.GitRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("https://api.github.com")
public interface IGitHubApiClient {
    @GetExchange("/users/{username}/repos")
    List<GitRepository> getUserRepos(@PathVariable String username);

    @GetExchange("/repos/{owner}/{repo}/branches")
    List<GitBranch> getBranches(@PathVariable String owner, @PathVariable String repo);
}
