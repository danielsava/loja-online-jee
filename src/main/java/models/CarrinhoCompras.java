package models;

import dao.CompraDao;
import dao.UsuarioDao;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
@SessionScoped
public class CarrinhoCompras implements Serializable {

    @Inject
    private CompraDao compraDao;

    private Set<CarrinhoItem> itens = new HashSet<>();


    @Transactional
    public void finalizar(Usuario usuario) {

        Compra compra = new Compra();

        compra.setUsuario(usuario);
        compra.setItens(toJson());

        compraDao.salvar(compra);

    }

    public String toJson() {
        return "{}";
    }


    public void add(CarrinhoItem item) {
        itens.add(item);
    }

    public Integer getQuantidadeTotal() {
        return itens.stream().mapToInt(CarrinhoItem::getQuantidade).sum();
    }

    public List<CarrinhoItem> getItens() {
        return new ArrayList<>(itens);
    }

    public void remover(CarrinhoItem item) {
        itens.remove(item);
    }

    public BigDecimal getTotal(CarrinhoItem item) {
        return item.getLivro().getPreco().multiply(new BigDecimal(item.getQuantidade()));
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (CarrinhoItem item : itens) {
            total = total.add(item.getLivro().getPreco().multiply(new BigDecimal(item.getQuantidade())));
        }
        return total;
    }

}
