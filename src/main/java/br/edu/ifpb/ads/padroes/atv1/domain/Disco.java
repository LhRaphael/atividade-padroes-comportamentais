package br.edu.ifpb.ads.padroes.atv1.domain;

import java.util.Objects;

/**
 * Entidade de domínio que representa um disco musical.
 */
public class Disco {

    private final String artista;
    private final String titulo;
    private final String genero;
    private final int anoLancamento;

    public Disco(String artista, String titulo, String genero, int anoLancamento) {
        this.artista = validarTexto(artista, "artista");
        this.titulo = validarTexto(titulo, "titulo");
        this.genero = validarTexto(genero, "genero");
        this.anoLancamento = validarAno(anoLancamento);
    }

    public String getArtista() {
        return artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("O campo " + campo + " é obrigatório.");
        }
        return valor.trim();
    }

    private static int validarAno(int ano) {
        if (ano <= 0) {
            throw new IllegalArgumentException("O ano de lançamento deve ser positivo.");
        }
        return ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disco disco)) return false;
        return anoLancamento == disco.anoLancamento
                && artista.equalsIgnoreCase(disco.artista)
                && titulo.equalsIgnoreCase(disco.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artista.toLowerCase(), titulo.toLowerCase(), anoLancamento);
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + anoLancamento + ")";
    }
}
