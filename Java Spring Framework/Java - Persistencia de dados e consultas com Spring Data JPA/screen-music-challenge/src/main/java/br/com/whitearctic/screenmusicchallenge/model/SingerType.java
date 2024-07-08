package br.com.whitearctic.screenmusicchallenge.model;

public enum SingerType {
    SOLO("Solo"),
    DUO("Duo"),
    BANDA("Banda");

    private final String singerType;

    SingerType(String singerType) {
        this.singerType = singerType;
    }
}
