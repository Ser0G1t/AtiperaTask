package com.example.atipera.models;

import java.util.List;

public record GitRepository(
        String name,
        Owner owner,
        boolean fork,
        List<GitBranch> branches
) {
    public boolean isNotFork() {
        return !fork;
    }
}
