package models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Informe o Título")
    private String titulo;

    @NotEmpty(message = "Informe a Descrição")
    @Size(min = 10, message = "Descrição muito curta")
    @Lob
    private String descricao;

    @NotEmpty(message = "Informe o preço")
    @Min(value = 20, message = "Preço abaixo do permitido")
    private BigDecimal preco;

    @Min(value = 2, message = "Número de Páginas abaixo do permitido")
    private Integer paginas;

    @NotEmpty(message = "Informe um autor")
    @ManyToMany
    private List<Autor> autores;

    public Livro() {
        autores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", paginas=" + paginas +
                ", autores=" + autores +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

}
