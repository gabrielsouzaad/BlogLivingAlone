package model;

import java.io.Serializable;

public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String conteudo;
    private String autor;

    public Post(String titulo, String conteudo, String autor) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Titulo = " + titulo + ", Conteudo = " + conteudo + ", Autor = " + autor;
    }
}
