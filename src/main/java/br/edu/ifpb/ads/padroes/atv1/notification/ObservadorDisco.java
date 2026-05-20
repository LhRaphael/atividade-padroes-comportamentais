package br.edu.ifpb.ads.padroes.atv1.notification;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;

/**
 * Observer interessado em novos discos cadastrados.
 */
public interface ObservadorDisco {
    void aoCadastrarNovoDisco(Disco disco);
}
