package com.epam.mentoring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class GitHubUserDto {

    @JsonProperty("avatar_url")
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GitHubUserDto that = (GitHubUserDto) o;

        return Objects.equals(avatarUrl, that.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avatarUrl);
    }
}
