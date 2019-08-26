package beans;

import models.CarrinhoCompras;
import models.CarrinhoItem;
import models.Livro;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class CarrinhoComprasBean {

    @Inject
    private CarrinhoCompras carrinhoCompras;


    public String adicionar(Livro livro) {

        CarrinhoItem item = CarrinhoItem.of(livro);
        carrinhoCompras.add(item);

        return "carrinho?faces-redirect=true";

    }

    public void remover(CarrinhoItem item) {
        carrinhoCompras.remover(item);
    }

}
