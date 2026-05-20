package br.edu.ifpb.ads.padroes.atv1.search;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;

@FunctionalInterface
public interface CriterioBuscaDisco {
    boolean atende(Disco disco);
}
