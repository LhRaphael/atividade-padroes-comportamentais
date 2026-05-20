package br.edu.ifpb.ads.padroes.atv1.repository;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;
import br.edu.ifpb.ads.padroes.atv1.search.CriterioBuscaDisco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Implementação em memória do repositório.
 */
public class RepositorioDiscosEmMemoria implements RepositorioDiscos {

    private final List<Disco> discos = new ArrayList<>();

    @Override
    public void salvar(Disco disco) {
        if (disco == null) {
            throw new IllegalArgumentException("Disco não pode ser nulo.");
        }
        discos.add(disco);
    }

    @Override
    public boolean remover(Disco disco) {
        return discos.remove(disco);
    }

    @Override
    public List<Disco> listarTodos() {
        return Collections.unmodifiableList(discos);
    }

    @Override
    public List<Disco> buscar(CriterioBuscaDisco criterio) {
        if (criterio == null) {
            return listarTodos();
        }
        return discos.stream()
                .filter(criterio::atende)
                .toList();
    }

    @Override
    public Optional<Disco> buscarExato(String titulo, String artista, int anoLancamento) {
        return discos.stream()
                .filter(disco -> disco.getTitulo().equalsIgnoreCase(titulo))
                .filter(disco -> disco.getArtista().equalsIgnoreCase(artista))
                .filter(disco -> disco.getAnoLancamento() == anoLancamento)
                .findFirst();
    }
}
