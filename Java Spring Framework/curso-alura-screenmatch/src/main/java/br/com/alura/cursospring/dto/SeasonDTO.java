package br.com.alura.cursospring.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonDTO(
        @JsonAlias("Season")
        Integer seasonNumber,
        @JsonAlias("Episodes")
        List<EpisodeDTO> episodes
) {
}
