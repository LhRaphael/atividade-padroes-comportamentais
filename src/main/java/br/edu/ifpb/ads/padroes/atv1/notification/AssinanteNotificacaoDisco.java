package br.edu.ifpb.ads.padroes.atv1.notification;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;

public class AssinanteNotificacaoDisco implements ObservadorDisco {

    private final String nome;
    private final InteresseDisco interesse;
    private final CanalNotificacao canalNotificacao;

    public AssinanteNotificacaoDisco(String nome, InteresseDisco interesse, CanalNotificacao canalNotificacao) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do assinante é obrigatório.");
        }
        if (interesse == null) {
            throw new IllegalArgumentException("Interesse é obrigatório.");
        }
        if (canalNotificacao == null) {
            throw new IllegalArgumentException("Canal de notificação é obrigatório.");
        }
        this.nome = nome.trim();
        this.interesse = interesse;
        this.canalNotificacao = canalNotificacao;
    }

    @Override
    public void aoCadastrarNovoDisco(Disco disco) {
        if (interesse.corresponde(disco)) {
            canalNotificacao.enviar(nome + ", novo disco encontrado: " + disco);
        }
    }
}
