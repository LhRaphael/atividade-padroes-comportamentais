package br.edu.ifpb.ads.padroes.atv1.service;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;
import br.edu.ifpb.ads.padroes.atv1.notification.CentralNotificacoesDiscos;
import br.edu.ifpb.ads.padroes.atv1.repository.RepositorioDiscos;
import br.edu.ifpb.ads.padroes.atv1.search.CriterioBuscaDisco;

import java.util.List;

/**
 * Serviço de aplicação: coordena cadastro, remoção, busca e notificação.
 */
public class CatalogoDiscosService {

    private final RepositorioDiscos repositorio;
    private final CentralNotificacoesDiscos centralNotificacoes;

    public CatalogoDiscosService(RepositorioDiscos repositorio, CentralNotificacoesDiscos centralNotificacoes) {
        if (repositorio == null) {
            throw new IllegalArgumentException("Repositório é obrigatório.");
        }
        if (centralNotificacoes == null) {
            throw new IllegalArgumentException("Central de notificações é obrigatória.");
        }
        this.repositorio = repositorio;
        this.centralNotificacoes = centralNotificacoes;
    }

    public void cadastrar(Disco disco) {
        repositorio.salvar(disco);
        centralNotificacoes.notificarNovoDisco(disco);
    }

    public boolean remover(Disco disco) {
        return repositorio.remover(disco);
    }

    public List<Disco> listarTodos() {
        return repositorio.listarTodos();
    }

    public List<Disco> buscar(CriterioBuscaDisco criterio) {
        return repositorio.buscar(criterio);
    }
}
