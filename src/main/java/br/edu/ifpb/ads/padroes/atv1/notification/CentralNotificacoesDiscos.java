package br.edu.ifpb.ads.padroes.atv1.notification;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject do padrão Observer.
 */
public class CentralNotificacoesDiscos {

    private final List<ObservadorDisco> observadores = new ArrayList<>();

    public void adicionarObservador(ObservadorDisco observador) {
        if (observador == null) {
            throw new IllegalArgumentException("Observador não pode ser nulo.");
        }
        observadores.add(observador);
    }

    public boolean removerObservador(ObservadorDisco observador) {
        return observadores.remove(observador);
    }

    public void notificarNovoDisco(Disco disco) {
        observadores.forEach(observador -> observador.aoCadastrarNovoDisco(disco));
    }
}
