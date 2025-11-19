package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idPermissao;
    private String nome;
    private String descricao;
    private boolean podeCriarPost;
    private boolean podeEditarPost;
    private boolean podeDeletarPost;
    private boolean podeGerenciarUsuarios;
    private LocalDateTime dataCriacao;

    public Permissao(String idPermissao, String nome, String descricao, boolean podeCriarPost, boolean podeEditarPost, boolean podeDeletarPost, boolean podeGerenciarUsuarios, LocalDateTime dataCriacao) {
        this.idPermissao = idPermissao;
        this.nome = nome;
        this.descricao = descricao;
        this.podeCriarPost = podeCriarPost;
        this.podeEditarPost = podeEditarPost;
        this.podeDeletarPost = podeDeletarPost;
        this.podeGerenciarUsuarios = podeGerenciarUsuarios;
        this.dataCriacao = dataCriacao;
    }


    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Permissao{" +
                "idPermissao='" + idPermissao + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
