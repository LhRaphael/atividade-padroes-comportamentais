package br.edu.ifpb.ads.padroes.visitor;

public class RelatorioImpostosVisitor implements ItemVisitor {

    private double totalImpostos;

    @Override
    public void visitar(ProdutoFisico produto) {
        double imposto = produto.getValor() * 0.10;
        totalImpostos += imposto;

        System.out.println("Produto físico: " + produto.getNome());
        System.out.printf("Valor: R$ %.2f%n", produto.getValor());
        System.out.printf("Imposto: R$ %.2f%n", imposto);
        System.out.println();
    }

    @Override
    public void visitar(Servico servico) {
        double imposto = servico.getValor() * 0.15;
        totalImpostos += imposto;

        System.out.println("Serviço: " + servico.getDescricao());
        System.out.printf("Valor: R$ %.2f%n", servico.getValor());
        System.out.printf("Imposto: R$ %.2f%n", imposto);
        System.out.println();
    }

    public double getTotalImpostos() {
        return totalImpostos;
    }
}
