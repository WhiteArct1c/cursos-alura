package br.com.alura.cursospring.utils;

public enum APIData {
    API_URI("https://www.omdbapi.com/?"),
    API_KEY("e004222");

    private final String value;

    APIData(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }
}
