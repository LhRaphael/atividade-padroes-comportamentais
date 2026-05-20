package br.edu.ifpb.ads.padroes.visitor;

public interface ItemVisitor {
    void visitar(ProdutoFisico produto);
    void visitar(Servico servico);
}
