package model;

import exceptions.InvalidaException;

import java.io.Serializable;

public class Pilha implements Serializable {


    private static final long serialVersionUID = 1L;

    private static class NoPilha implements Serializable {

        private static final long serialVersionUID = 1L;
        Post post;
        NoPilha proximo;

        NoPilha(Post postagem) {
            this.post = postagem;
        }
    }

    private NoPilha topo;

    public void empilhar(Post post) {
        NoPilha novo = new NoPilha(post);
        novo.proximo = topo;
        topo = novo;
    }

    public Post desempilhar() {
        if (topo == null)
            throw new InvalidaException("Nada para desfazer");

        Post removida = topo.post;
        topo = topo.proximo;

        return removida;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}
