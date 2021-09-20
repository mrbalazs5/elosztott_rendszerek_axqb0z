package com.example.github;

import lombok.Data;

import java.util.List;

@Data
public class GitHubSearchResponseRoot {
    private int total_count;
    private boolean incomplete_results;
    private List<GitHubItemDTO> items;

    public int getTotal_count() {
        return total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public List<GitHubItemDTO> getItems() {
        return items;
    }
}
