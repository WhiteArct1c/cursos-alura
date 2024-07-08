package br.com.whitearctic.screenmusicchallenge.model;

public enum Genre {
    ROCK("Rock"),
    POP("Pop"),
    MPB("MPB"),
    SERTANEJO("Sertanejo"),
    FUNK("Funk"),
    RAP("Rap"),
    REGGAE("Reggae"),
    PAGODE("Pagode"),
    AXE("Axé");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }
}
