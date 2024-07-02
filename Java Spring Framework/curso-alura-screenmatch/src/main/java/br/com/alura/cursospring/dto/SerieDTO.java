package br.com.alura.cursospring.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SerieDTO(
        @JsonAlias("Title")
        String title,
        @JsonAlias("totalSeasons")
        Integer totalSeasons,
        @JsonAlias("imdbRating")
        String imdbRating
) {
}
