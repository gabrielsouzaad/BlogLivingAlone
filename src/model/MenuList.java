package model;

import java.util.Scanner;

import service.ServiceBlog;

public class MenuList {
    Scanner sc = new Scanner(System.in);

    public void adicionarPostagem(Usuario usuario, ServiceBlog blog) {
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Conteúdo: ");
        String conteudo = sc.nextLine();

        System.out.print("Categoria: ");
        String categoria = sc.nextLine();

        blog.adicionarPostagem(titulo, conteudo, categoria, usuario);
        System.out.println("Postagem adicionada com sucesso!");
    }

    public void removerPostagem(Usuario usuario, ServiceBlog blog) {
        System.out.print("Título da postagem a ser removida: ");
        String tituloRemover = sc.nextLine();

        blog.removerPostagem(tituloRemover, usuario);
        System.out.println("Postagem removida com sucesso!");
    }

    public void listarPostagens(ServiceBlog blog) {
        System.out.println("\n----- Todas as Postagens -----");
        System.out.println(blog.listarPostagens());
    }

    public void listarPostagensPorCategoria(ServiceBlog blog) {
        System.out.print("Digite a categoria: ");
        String cat = sc.nextLine();
        System.out.println("\n----- Postagens da Categoria: " + cat + " -----");
        System.out.println(blog.listarPorCategoria(cat));
    }

    public void listarMinhasPostagens(Usuario usuario, ServiceBlog blog) {
        System.out.println("\n----- Minhas Postagens -----");
        System.out.println(blog.listarPorAutor(usuario.getNome()));
    }

    public void desfazerUltimaPostagens(ServiceBlog blog) {
        blog.desfazer();
        System.out.println("Última postagem desfeita.");
    }

    public void listarCategorias(ServiceBlog blog) {
        System.out.println("\n----- Categorias Disponíveis -----");
        System.out.println(blog.listarCategorias());
    }

    public void adicionarComentario(Usuario usuario, ServiceBlog blog) {
        System.out.print("Título da postagem para comentar: ");
        String tituloComentar = sc.nextLine();
        blog.BuscarPorTitulo(tituloComentar);
        System.out.print("Seu comentário: ");
        String textoComentario = sc.nextLine();
        blog.adicionarComentario(tituloComentar, textoComentario, usuario);
        System.out.println("Comentário adicionado com sucesso!");
    }

    public void avaliarPost(Usuario usuario, ServiceBlog blog) {
        System.out.print("Título da postagem para avaliar: ");
        String tituloAvaliar = sc.nextLine();
        blog.BuscarPorTitulo(tituloAvaliar);
        System.out.print("Nota (1 a 5): ");
        int nota = Integer.parseInt(sc.nextLine());
        System.out.print("Comentário da avaliação (opcional): ");
        String comentarioAvaliacao = sc.nextLine();
        blog.avaliarPost(tituloAvaliar, nota, comentarioAvaliacao, usuario);
        System.out.println("Avaliação adicionada com sucesso!");
    }

}
