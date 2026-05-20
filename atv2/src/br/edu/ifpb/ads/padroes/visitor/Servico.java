package br.edu.ifpb.ads.padroes.visitor;

public class Servico implements Item {

    private final String descricao;
    private final double valor;

    public Servico(String descricao, double valor) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição do serviço não pode ser vazia.");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do serviço não pode ser negativo.");
        }

        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public void aceitar(ItemVisitor visitor) {
        visitor.visitar(this);
    }
}
