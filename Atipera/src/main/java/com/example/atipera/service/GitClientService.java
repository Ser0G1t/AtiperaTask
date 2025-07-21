package com.example.atipera.service;

import com.example.atipera.models.GitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitClientService implements IGitClientService{
    @Autowired
    private IGitHubApiClient client;
    public GitClientService(){

    }
    public List<GitRepository> getNonForkRepositories(String username) {
        return client.getUserRepos(username).stream()
                .filter(GitRepository::isNotFork)
                .map(repo -> {
                    var branches = client.getBranches(repo.owner().login(), repo.name());
                    return new GitRepository(repo.name(), repo.owner(), repo.fork(), branches);
                })
                .toList();
    }

}
