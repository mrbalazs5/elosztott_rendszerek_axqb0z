package com.iit.elasticsearchgyak;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FindByDTO {
    @NotBlank
    private String query;

    public String getQuery() {
        return query;
    }
}
