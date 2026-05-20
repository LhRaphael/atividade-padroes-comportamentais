package br.edu.ifpb.ads.padroes.atv1.app;

import br.edu.ifpb.ads.padroes.atv1.domain.Disco;
import br.edu.ifpb.ads.padroes.atv1.notification.AssinanteNotificacaoDisco;
import br.edu.ifpb.ads.padroes.atv1.notification.CanalEmail;
import br.edu.ifpb.ads.padroes.atv1.notification.CanalPush;
import br.edu.ifpb.ads.padroes.atv1.notification.CentralNotificacoesDiscos;
import br.edu.ifpb.ads.padroes.atv1.notification.InteressesDisco;
import br.edu.ifpb.ads.padroes.atv1.repository.RepositorioDiscos;
import br.edu.ifpb.ads.padroes.atv1.repository.RepositorioDiscosEmMemoria;
import br.edu.ifpb.ads.padroes.atv1.search.CriteriosBuscaDisco;
import br.edu.ifpb.ads.padroes.atv1.service.CatalogoDiscosService;

public class Main {

    public static void main(String[] args) {
        RepositorioDiscos repositorio = new RepositorioDiscosEmMemoria();
        CentralNotificacoesDiscos central = new CentralNotificacoesDiscos();

        central.adicionarObservador(new AssinanteNotificacaoDisco(
                "Rafael",
                InteressesDisco.porArtista("Daft Punk"),
                new CanalEmail()
        ));

        central.adicionarObservador(new AssinanteNotificacaoDisco(
                "Ana",
                InteressesDisco.porGenero("Rock"),
                new CanalPush()
        ));

        CatalogoDiscosService catalogo = new CatalogoDiscosService(repositorio, central);

        catalogo.cadastrar(new Disco("Daft Punk", "Discovery", "Electronic", 2001));
        catalogo.cadastrar(new Disco("Pink Floyd", "The Dark Side of the Moon", "Rock", 1973));

        System.out.println("\nBusca por gênero Rock:");
        catalogo.buscar(CriteriosBuscaDisco.porGenero("Rock"))
                .forEach(System.out::println);
    }
}
