package br.com.alura.cursospring.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeDTO(
        @JsonAlias("Title")
        String title,
        @JsonAlias("Episode")
        Integer episodeNumber,
        @JsonAlias("imdbRating")
        String imdbRating,
        @JsonAlias("Released")
        String releasedAt
) {
}
