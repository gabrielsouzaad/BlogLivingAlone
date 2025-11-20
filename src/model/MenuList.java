package model;

import util.InputReader;
import util.ConsolePrinter;
import interfaces.services.IBlogService;

public class MenuList {
    private final InputReader input;
    private final ConsolePrinter out;

    public MenuList(InputReader input, ConsolePrinter out) {
        this.input = input;
        this.out = out;
    }

    public void adicionarPostagem(model.Usuario usuario, IBlogService blog) {
        String titulo = input.readLine("Título: ");
        String conteudo = input.readLine("Conteúdo: ");
        String categoria = input.readLine("Categoria: ");

        blog.adicionarPostagem(titulo, conteudo, categoria, usuario);
        out.println("Postagem adicionada com sucesso!");
    }

    public void removerPostagem(model.Usuario usuario, IBlogService blog) {
        String tituloRemover = input.readLine("Título da postagem a ser removida: ");
        blog.removerPostagem(tituloRemover, usuario);
        out.println("Postagem removida com sucesso!");
    }

    public void listarPostagens(IBlogService blog) {
        out.println("\n----- Todas as Postagens -----");
        out.println(blog.listarPostagens());
    }

    public void listarPostagensPorCategoria(IBlogService blog) {
        String cat = input.readLine("Digite a categoria: ");
        out.println("\n----- Postagens da Categoria: " + cat + " -----");
        out.println(blog.listarPostagensPorCategoria(cat));
    }

    public void listarMinhasPostagens(model.Usuario usuario, IBlogService blog) {
        out.println("\n----- Minhas Postagens -----");
        out.println(blog.listarPostagensPorAutor(usuario.getNome()));
    }

    public void desfazerUltimaPostagens(IBlogService blog) {
        blog.desfazerUltimaPostagem();
        out.println("Última postagem desfeita.");
    }

    public void listarCategorias(IBlogService blog) {
        out.println("\n----- Categorias Disponíveis -----");
        out.println(blog.listarCategorias());
    }

    public void adicionarComentario(model.Usuario usuario, IBlogService blog) {
        String tituloComentar = input.readLine("Título da postagem para comentar: ");
        blog.buscarPostagensPorTitulo(tituloComentar);
        String textoComentario = input.readLine("Seu comentário: ");
        blog.adicionarComentario(tituloComentar, textoComentario, usuario);
        out.println("Comentário adicionado com sucesso!");
    }

    public void avaliarPost(model.Usuario usuario, IBlogService blog) {
        String tituloAvaliar = input.readLine("Título da postagem para avaliar: ");
        blog.buscarPostagensPorTitulo(tituloAvaliar);
        int nota = input.readIntInRange("Nota (1 a 5): ", 1, 5);
        String comentarioAvaliacao = input.readLine("Comentário da avaliação (opcional): ");
        blog.avaliarPostagens(tituloAvaliar, nota, comentarioAvaliacao, usuario);
        out.println("Avaliação adicionada com sucesso!");
    }

}
