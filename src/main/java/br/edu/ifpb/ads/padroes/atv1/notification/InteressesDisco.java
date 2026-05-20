package br.edu.ifpb.ads.padroes.atv1.notification;

public final class InteressesDisco {

    private InteressesDisco() {
    }

    public static InteresseDisco porTitulo(String titulo) {
        return disco -> contem(disco.getTitulo(), titulo);
    }

    public static InteresseDisco porArtista(String artista) {
        return disco -> contem(disco.getArtista(), artista);
    }

    public static InteresseDisco porGenero(String genero) {
        return disco -> contem(disco.getGenero(), genero);
    }

    private static boolean contem(String texto, String termo) {
        if (termo == null || termo.isBlank()) {
            return true;
        }
        return texto.toLowerCase().contains(termo.toLowerCase().trim());
    }
}
