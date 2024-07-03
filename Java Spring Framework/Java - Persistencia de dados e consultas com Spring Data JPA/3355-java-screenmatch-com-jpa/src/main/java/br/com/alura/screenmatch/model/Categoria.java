package br.com.alura.screenmatch.model;

import java.util.ArrayList;
import java.util.List;

public enum Categoria {
    ACAO("Action"),
    AVENTURA("Adventure"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    FANTASIA("Fantasy"),
    FICCAO("Sci-Fi"),
    MUSICAL("Musical"),
    SUSPENSE("Thriller"),
    TERROR("Horror"),
    ROMANCE("Romance"),
    CRIME("Crime");

    private final String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public static List<Categoria> fromString(List<String> categorias) {
        List<Categoria> categoriasEncontradas = new ArrayList<>();
        for (String cat : categorias) {
            for (Categoria categoria : Categoria.values()) {
                if (categoria.categoriaOmdb.equalsIgnoreCase(cat.trim())) {
                    categoriasEncontradas.add(categoria);
                    break;
                }
            }
        }
        return categoriasEncontradas;
    }

}
