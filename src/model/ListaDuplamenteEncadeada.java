package model;

import java.io.Serializable;

import exceptions.NaoEncontradoException;

public class ListaDuplamenteEncadeada implements Serializable {

    private static final long serialVersionUID = 1L;

    private static class No implements Serializable {

        private static final long serialVersionUID = 1L;

        Post post;
        No proximo;
        No anterior;

        No(Post post) {
            this.post = post;
        }
    }

    private No inicio;
    private No fim;

    public void adicionar(Post post) {
        No novo = new No(post);

        if (inicio == null) {
            inicio = fim = novo;
            return;
        }

        fim.proximo = novo;
        novo.anterior = fim;
        fim = novo;
    }

    public Post removerUltimo() {
        if (fim == null)
            throw new NaoEncontradoException("Não há postagens para remover!");

        Post removida = fim.post;

        if (inicio == fim) {
            inicio = fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }

        return removida;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public String listarComoTexto() {
        StringBuilder sb = new StringBuilder();
        No atual = inicio;

        while (atual != null) {
            sb.append(atual.post.toString()).append("\n");
            atual = atual.proximo;
        }

        return sb.toString();
    }
}
