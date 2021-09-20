package com.example.demo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RepoSearchDTO {
    @NotNull
    @Size(min = 3)
    private String queryString;

    public String getQueryString() {
        return queryString;
    }
}
