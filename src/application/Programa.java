package application;

import java.util.Scanner;

import exceptions.NaoEncontradoException;
import exceptions.InvalidaException;
import model.Usuario;
import model.MenuList;
import service.ServiceBlog;
import service.ServiceUsuario;

public class Programa {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            ServiceBlog blog = new ServiceBlog();
            ServiceUsuario usuarios = new ServiceUsuario();
            MenuList menu = new MenuList();

            System.out.println("----- LivingAlone -----");

            Usuario usuario = null;

            while (usuario == null) {
                System.out.print("Digite seu nome de usuário: ");
                String nome = sc.nextLine();

                System.out.print("Digite sua senha: ");
                String senha = sc.nextLine();

                try {
                    usuario = usuarios.login(nome, senha);
                    System.out.println("Login realizado com sucesso!");
                } catch (NaoEncontradoException e) {
                    System.out.println("Usuário não encontrado. Deseja criar um novo usuário? (s/n)");
                    String criar = sc.nextLine();
                    if (criar.equalsIgnoreCase("s")) {
                        try {
                            usuario = usuarios.registrar(nome, senha);
                            System.out.println("Usuário criado com sucesso!");
                        } catch (RuntimeException ex) {
                            System.out.println("ERRO ao registrar: " + ex.getMessage());
                        }
                    }
                } catch (InvalidaException e) {
                    System.out.println("ERRO de login: " + e.getMessage());
                }
            }

            while (true) {
                System.out.println("\n----- Menu Principal -----");
                System.out.println("Usuário logado: " + usuario.getNome());
                System.out.println("1 - Adicionar postagem");
                System.out.println("2 - Remover postagem (apenas suas)");
                System.out.println("3 - Listar todas as postagens");
                System.out.println("4 - Listar postagens por categoria");
                System.out.println("5 - Listar minhas postagens");
                System.out.println("6 - Desfazer (última ação de postagem)");
                System.out.println("7 - Listar categorias");
                System.out.println("8 - Adicionar comentário a uma postagem");
                System.out.println("9 - Avaliar postagem");

                System.out.println("0 - Sair");
                System.out.print("Opção: ");

                int opcao = Integer.parseInt(sc.nextLine());

                try {

                    switch (opcao) {

                        case 1:
                            menu.adicionarPostagem(usuario, blog);
                            break;

                        case 2:
                            menu.removerPostagem(usuario, blog);
                            break;

                        case 3:
                            menu.listarPostagens(blog);
                            break;

                        case 4:
                            menu.listarPostagensPorCategoria(blog);
                            break;

                        case 5:
                            menu.listarMinhasPostagens(usuario, blog);
                            break;

                        case 6:
                            menu.desfazerUltimaPostagens(blog);
                            break;

                        case 7:
                            menu.listarCategorias(blog);
                            break;

                        case 8:
                            menu.adicionarComentario(usuario, blog);
                            break;

                        case 9:
                            menu.avaliarPost(usuario, blog);
                            break;

                        case 0:
                            System.exit(0);

                        default:
                            System.out.println("Opção inválida.");
                    }

                } catch (RuntimeException e) {
                    System.out.println("ERRO: " + e.getMessage());
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
