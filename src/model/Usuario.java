package model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Permissao permissao;

    private String nome;
    private String senha;


    public Usuario(String nome, String senha, Permissao permissao) {
        this.permissao = permissao;
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String getSenha() {
        return senha;
    }




}
