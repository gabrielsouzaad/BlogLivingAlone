package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idCategoria;
    private String nome;
    private String descricao;
    private int totalPosts;
    private String slug;
    private String iconeUrl;
    private LocalDateTime dataCriacao;
    private boolean ativa;

    public String getNome() {
        return nome;
    }

    public Categoria(String idCategoria, String nome, String descricao, int totalPosts, String slug, String iconeUrl, LocalDateTime dataCriacao, boolean ativa) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.totalPosts = totalPosts;
        this.slug = slug;
        this.iconeUrl = iconeUrl;
        this.dataCriacao = dataCriacao;
        this.ativa = ativa;
    }


    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria='" + idCategoria + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", totalPosts=" + totalPosts +
                ", slug='" + slug + '\'' +
                ", iconeUrl='" + iconeUrl + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", ativa=" + ativa +
                '}';
    }
}
