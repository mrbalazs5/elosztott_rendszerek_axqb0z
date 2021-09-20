package com.example.demo;

import com.example.github.GitHubItemDTO;
import com.example.github.GitHubSearchResponseRoot;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


class GitHubRepoTest {
    @Test
    void test() {
        RestTemplate mockRestTemplate = mock(RestTemplate.class);
        GitHubRepo repo = new GitHubRepo(mockRestTemplate);
        String qs = "test";
        GitHubSearchResponseRoot mockRoot = new GitHubSearchResponseRoot();

        List<GitHubItemDTO> items = new ArrayList();
        GitHubItemDTO item = new GitHubItemDTO();
        item.setId(1);
        item.setName("test");
        item.setUrl("http://github.com/test");
        items.add(item);
        mockRoot.setItems(items);

        String url = repo.getGitHubSearchRepositoryBaseUrl() + "?q=" + qs;
        ResponseEntity<GitHubSearchResponseRoot> response;
        when(mockRestTemplate.getForEntity(url, GitHubSearchResponseRoot.class))
                .thenReturn(new ResponseEntity(mockRoot, HttpStatus.OK));

        try {
            List<String> repoResponse = repo.searchByText(qs);
            fail("Exception not thrown.");

            assertThat(repoResponse, hasSize(1));
        } catch (RestException e) {

        }

        verify(mockRestTemplate).getForEntity(url, GitHubSearchResponseRoot.class);
    }
}