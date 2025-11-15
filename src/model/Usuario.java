package model;

public class Usuario {

    private String nome;
    private String senha;
    private ListaDuplamenteEncadeada lista;
    private Pilha pilha;

    public Usuario(String nome) {
        this.nome = nome;
        this.senha = ""; // ou crie lógica para solicitar senha
        this.lista = new ListaDuplamenteEncadeada();
        this.pilha = new Pilha();
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionarPost(Post post) {
        lista.adicionar(post);
        pilha.empilhar(post);
    }

    public void desfazer() {
        if (!pilha.estaVazia()) {
            pilha.desempilhar();
            lista.removerUltimo();
        }
    }

    public String obterPosts() {
        return lista.listarComoTexto();
    }
}
