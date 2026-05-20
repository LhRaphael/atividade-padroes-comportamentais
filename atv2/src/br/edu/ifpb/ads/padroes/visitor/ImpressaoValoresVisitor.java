package br.edu.ifpb.ads.padroes.visitor;

public class ImpressaoValoresVisitor implements ItemVisitor {

    @Override
    public void visitar(ProdutoFisico produto) {
        System.out.println("Produto físico: " + produto.getNome());
        System.out.printf("Valor: R$ %.2f%n", produto.getValor());
        System.out.println();
    }

    @Override
    public void visitar(Servico servico) {
        System.out.println("Serviço: " + servico.getDescricao());
        System.out.printf("Valor: R$ %.2f%n", servico.getValor());
        System.out.println();
    }
}
