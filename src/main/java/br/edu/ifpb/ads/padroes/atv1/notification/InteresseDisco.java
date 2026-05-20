package br.edu.ifpb.ads.padroes.atv1.notification;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;

@FunctionalInterface
public interface InteresseDisco {
    boolean corresponde(Disco disco);
}
