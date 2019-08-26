package models;

import java.util.Objects;

public class CarrinhoItem {


    private Livro livro;

    private Integer quantidade;


    public CarrinhoItem(Livro livro) {
        this.livro = livro;
        this.quantidade = 1;
    }

    public static CarrinhoItem of(Livro livro) {
        return new CarrinhoItem(livro);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoItem that = (CarrinhoItem) o;
        return Objects.equals(livro, that.livro) &&
                Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {

        return Objects.hash(livro);
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
