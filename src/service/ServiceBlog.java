package service;

import model.ListaDuplamenteEncadeada;
import model.Pilha;
import model.Post;
import model.Usuario;
import model.Comentario;
import model.AvaliacaoPost;
import java.time.LocalDateTime;
import exceptions.NaoEncontradoException;
import model.Categoria;
import exceptions.InvalidaException;
import java.util.List;
import java.util.ArrayList;

public class ServiceBlog {

    private ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
    private Pilha pilhaUndo = new Pilha();
    private List<Categoria> categorias = new ArrayList<>();

    public ServiceBlog() {
        inicializarCategorias();
        inicializarPostsDefault();
    }

    private void inicializarCategorias() {
        categorias.add(new Categoria("C001", "Culinária", "Dicas de cozinha para solteiros", 0, "culinaria",
                "url_icone_culinaria", java.time.LocalDateTime.now(), true));
        categorias.add(new Categoria("C002", "Finanças", "Como economizar morando sozinho", 0, "financas",
                "url_icone_financas", java.time.LocalDateTime.now(), true));
        categorias.add(new Categoria("C003", "Limpeza", "Organização e limpeza da casa", 0, "limpeza",
                "url_icone_limpeza", java.time.LocalDateTime.now(), true));
    }

    public String listarCategorias() {
        StringBuilder sb = new StringBuilder();
        for (Categoria c : categorias) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }

    public Post BuscarPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new InvalidaException("Título não pode ser nulo ou vazio.");
        }
        var listaDeCategoria = lista.buscarPorTitulo(titulo);
        if (listaDeCategoria == null) {
            throw new NaoEncontradoException("Nenhuma postagem encontrada com o título: " + titulo);
        }
        return listaDeCategoria;
    };

    public void adicionarPostagem(String titulo, String conteudo, String categoria, Usuario usuario) {
        // Validação de categoria (uso da classe Categoria)
        boolean categoriaExiste = categorias.stream().anyMatch(c -> c.getNome().equalsIgnoreCase(categoria));
        if (!categoriaExiste) {
            throw new InvalidaException("Categoria '" + categoria + "' não existe.");
        }
        Post postagem = new Post(titulo, conteudo, usuario.getNome(), categoria);
        lista.adicionar(postagem);
        pilhaUndo.empilhar(postagem);
    }

    public void adicionarComentario(String tituloPost, String texto, Usuario usuario) {
        Post postagem = lista.buscarPorTitulo(tituloPost);
        if (postagem == null)
            throw new NaoEncontradoException("Postagem não encontrada para comentar.");

        Comentario comentario = new Comentario(
                "C" + (postagem.getComentarios().size() + 1),
                texto,
                usuario.getNome(),
                LocalDateTime.now(),
                tituloPost,
                0, 0, true);

        postagem.adicionarComentario(comentario);
    }

    public void avaliarPost(String tituloPost, int nota, String comentarioAvaliacao, Usuario usuario) {
        Post postagem = lista.buscarPorTitulo(tituloPost);
        if (postagem == null)
            throw new NaoEncontradoException("Postagem não encontrada para avaliar.");

        AvaliacaoPost avaliacao = new AvaliacaoPost(
                "A" + (postagem.getAvaliacoes().size() + 1),
                tituloPost,
                usuario.getNome(),
                nota,
                comentarioAvaliacao,
                LocalDateTime.now());

        postagem.adicionarAvaliacao(avaliacao);
    }

    public void removerPostagem(String titulo, Usuario usuario) {
        Post postagem = lista.buscarPorTitulo(titulo);

        if (postagem == null)
            throw new NaoEncontradoException("Postagem não encontrada.");

        if (!postagem.getAutor().equals(usuario.getNome()))
            throw new InvalidaException("Você só pode remover suas próprias postagens.");

        lista.remover(postagem);
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

    public String listarPorCategoria(String categoria) {
        return lista.listarPorCategoriaComoTexto(categoria);
    }

    public String listarPorAutor(String autor) {
        return lista.listarPorAutorComoTexto(autor);
    }

    private void inicializarPostsDefault() {
        // Post 1 - Culinária por autor1
        Post p1 = new Post("Cozinha prática", "5 receitas rápidas para uma pessoa", "autor1", "Culinária");
        Comentario c1 = new Comentario("C001", "Adorei a receita 2! Funciona bem para minha rotina.", "leitor1", LocalDateTime.now(), p1.getTitulo(), 12, 0, true);
        AvaliacaoPost a1 = new AvaliacaoPost("A001", p1.getTitulo(), "leitor1", 5, "Muito útil", LocalDateTime.now());
        p1.adicionarComentario(c1);
        p1.adicionarAvaliacao(a1);
        lista.adicionar(p1);

        // Post 2 - Finanças por admin
        Post p2 = new Post("Economizando morando sozinho", "Como reduzir despesas fixas e variáveis em 6 passos", "admin", "Finanças");
        Comentario c2 = new Comentario("C002", "Ótimas dicas, já comecei a aplicar.", "leitor1", LocalDateTime.now(), p2.getTitulo(), 7, 0, true);
        AvaliacaoPost a2 = new AvaliacaoPost("A002", p2.getTitulo(), "autor1", 4, "Conselhos práticos", LocalDateTime.now());
        p2.adicionarComentario(c2);
        p2.adicionarAvaliacao(a2);
        lista.adicionar(p2);

        // Post 3 - Limpeza por autor1
        Post p3 = new Post("Rotina de limpeza rápida", "Checklist semanal para manter a casa limpa em 30 minutos", "autor1", "Limpeza");
        Comentario c3 = new Comentario("C003", "Ótimas ideias, principalmente o item 4.", "admin", LocalDateTime.now(), p3.getTitulo(), 3, 0, true);
        AvaliacaoPost a3 = new AvaliacaoPost("A003", p3.getTitulo(), "leitor1", 5, "Muito prático", LocalDateTime.now());
        p3.adicionarComentario(c3);
        p3.adicionarAvaliacao(a3);
        lista.adicionar(p3);
    }
}
