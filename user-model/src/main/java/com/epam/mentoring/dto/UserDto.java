package com.epam.mentoring.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserDto {

    private List<GitHubUserDto> items;

    @JsonProperty("total_count")
    private int total_count;

    @JsonProperty("incomplete_results")
    private boolean resultComplete;

    public List<GitHubUserDto> getItems() {
        return items;
    }

    public void setItems(List<GitHubUserDto> items) {
        this.items = items;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isResultComplete() {
        return resultComplete;
    }

    public void setResultComplete(boolean resultComplete) {
        this.resultComplete = resultComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        return items.equals(userDto.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }
}
