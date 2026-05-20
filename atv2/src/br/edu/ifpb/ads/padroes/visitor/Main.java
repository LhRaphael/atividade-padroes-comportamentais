package br.edu.ifpb.ads.padroes.visitor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Item> itens = List.of(
                new ProdutoFisico("Notebook", 3000.00),
                new ProdutoFisico("Mouse", 100.00),
                new Servico("Consultoria", 1500.00),
                new Servico("Manutenção", 500.00)
        );

        RelatorioImpostosVisitor relatorioImpostos = new RelatorioImpostosVisitor();
        ItemVisitor impressaoValores = new ImpressaoValoresVisitor();

        System.out.println("=== Relatório de Impostos ===");
        for (Item item : itens) {
            item.aceitar(relatorioImpostos);
        }

        System.out.printf("Total de impostos: R$ %.2f%n%n", relatorioImpostos.getTotalImpostos());

        System.out.println("=== Impressão de Valores ===");
        for (Item item : itens) {
            item.aceitar(impressaoValores);
        }
    }
}
