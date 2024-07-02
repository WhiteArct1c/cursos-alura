package br.com.alura.cursospring.model;

import br.com.alura.cursospring.dto.EpisodeDTO;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer episodeNumber;
    private Double imdbRating;
    private LocalDate releasedAt;

    public Episode(Integer season, EpisodeDTO episodeDTO) {
        this.season = season;
        this.title = episodeDTO.title();
        this.episodeNumber = episodeDTO.episodeNumber();
        try{
            this.imdbRating = Double.parseDouble(episodeDTO.imdbRating());
        } catch (NumberFormatException e){
            this.imdbRating = 0.0;
        }
        try{
            this.releasedAt = LocalDate.parse(episodeDTO.releasedAt());
        } catch (DateTimeParseException e){
            this.releasedAt = null;
        }
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public LocalDate getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(LocalDate releasedAt) {
        this.releasedAt = releasedAt;
    }

    @Override
    public String toString() {
        return STR."Episode{season=\{season}, title='\{title}\{'\''}, episodeNumber=\{episodeNumber}, imdbRating=\{imdbRating}, releasedAt=\{releasedAt}\{'}'}";
    }
}
