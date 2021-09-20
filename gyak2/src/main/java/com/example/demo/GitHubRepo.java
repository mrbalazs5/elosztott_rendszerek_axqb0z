package com.example.demo;

import com.example.github.GitHubItemDTO;
import com.example.github.GitHubSearchResponseRoot;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GitHubRepo implements RepoInterface {
    private final String gitHubSearchRepositoryBaseUrl = "https://api.github.com/search/repositories";
    private final RestTemplate restTemplate;

    @Override
    public List<String> searchByText(String queryString) throws RestException {
        String url = gitHubSearchRepositoryBaseUrl + "?q=" + queryString;
        ResponseEntity<GitHubSearchResponseRoot> response =
                restTemplate.getForEntity(url, GitHubSearchResponseRoot.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().getItems().stream()
                    .map(GitHubItemDTO::getName)
                    .collect(Collectors.toList());
        } else {
            throw new RestException("Bad request.");
        }
    }

    public String getGitHubSearchRepositoryBaseUrl() {
        return gitHubSearchRepositoryBaseUrl;
    }
}
