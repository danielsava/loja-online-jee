package beans;

import models.Livro;

import javax.inject.Named;

@Named
public class AdminLivrosBean {

    private Livro livro;

    public void salvar() {
        System.out.println("Livro Cadastrado: " + livro);
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
