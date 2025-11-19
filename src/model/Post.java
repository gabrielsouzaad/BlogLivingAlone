package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String conteudo;
    private String autor;
    private String categoria;
    private List<Comentario> comentarios;
    private List<AvaliacaoPost> avaliacoes;

    public Post(String titulo, String conteudo, String autor, String categoria) {
        this.comentarios = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public List<AvaliacaoPost> getAvaliacoes() {
        return avaliacoes;
    }

    public void adicionarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public String listarComentarios() {
        StringBuilder sb = new StringBuilder();
        for (Comentario c : comentarios) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }

    public void adicionarAvaliacao(AvaliacaoPost avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public String listarAvaliacoes() {
        StringBuilder sb = new StringBuilder();
        for (AvaliacaoPost a : avaliacoes) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Titulo = " + titulo + ", Conteudo = " + conteudo + ", Autor = " + autor + ", Categoria = " + categoria;
    }
}
