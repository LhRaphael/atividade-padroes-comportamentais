package br.edu.ifpb.ads.padroes.atv1.search;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;

public final class CriteriosBuscaDisco {

    private CriteriosBuscaDisco() {
    }

    public static CriterioBuscaDisco porTitulo(String titulo) {
        return disco -> contem(disco.getTitulo(), titulo);
    }

    public static CriterioBuscaDisco porArtista(String artista) {
        return disco -> contem(disco.getArtista(), artista);
    }

    public static CriterioBuscaDisco porGenero(String genero) {
        return disco -> contem(disco.getGenero(), genero);
    }

    public static CriterioBuscaDisco porAno(int ano) {
        return disco -> disco.getAnoLancamento() == ano;
    }

    public static CriterioBuscaDisco combinarComE(CriterioBuscaDisco primeiro, CriterioBuscaDisco segundo) {
        return disco -> primeiro.atende(disco) && segundo.atende(disco);
    }

    private static boolean contem(String texto, String termo) {
        if (termo == null || termo.isBlank()) {
            return true;
        }
        return texto.toLowerCase().contains(termo.toLowerCase().trim());
    }
}
