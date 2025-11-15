package service;

import model.ListaDuplamenteEncadeada;
import model.Pilha;
import model.Post;
import model.Usuario;
import exceptions.NaoEncontradoException;

public class ServiceBlog {

    private ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
    private Pilha pilhaUndo = new Pilha();

    public void adicionarPostagem(String titulo, String conteudo, Usuario usuario) {
        Post postagem = new Post(titulo, conteudo, usuario.getNome());
        lista.adicionar(postagem);
        pilhaUndo.empilhar(postagem);
    }

    public void desfazer() {
        if (pilhaUndo.estaVazia())
            throw new NaoEncontradoException("Não há ações para desfazer.");

        pilhaUndo.desempilhar();
        lista.removerUltimo();
    }

    public String listarPostagens() {
        return lista.listarComoTexto();
    }
}
