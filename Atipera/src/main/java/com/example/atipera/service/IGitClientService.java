package com.example.atipera.service;

import com.example.atipera.models.GitRepository;

import java.util.List;

public interface IGitClientService {
    List<GitRepository> getNonForkRepositories(String username);
}
