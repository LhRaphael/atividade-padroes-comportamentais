package br.edu.ifpb.ads.padroes.atv1.repository;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;
import br.edu.ifpb.ads.padroes.atv1.search.CriterioBuscaDisco;

import java.util.List;
import java.util.Optional;

public interface RepositorioDiscos {

    void salvar(Disco disco);

    boolean remover(Disco disco);

    List<Disco> listarTodos();

    List<Disco> buscar(CriterioBuscaDisco criterio);

    Optional<Disco> buscarExato(String titulo, String artista, int anoLancamento);
}
