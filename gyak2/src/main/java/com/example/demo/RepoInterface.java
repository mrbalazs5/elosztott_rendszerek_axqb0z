package com.example.demo;

import java.util.List;

public interface RepoInterface {
    public List<String> searchByText(String queryString) throws RestException;
}
