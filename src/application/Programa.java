package application;

import java.sql.SQLOutput;
import java.util.Scanner;

import exceptions.NaoEncontradoException;
import exceptions.InvalidaException;
import model.Login;
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
            Login login = new Login();


            System.out.println("----- LivingAlone -----");
            System.out.println("Escolha a opção:");
            System.out.println("1 - Logar");
            System.out.println("2 - Criar");
            System.out.println("3 - Sair");

            Usuario usuario = null;

            int menuInicial = Integer.parseInt(sc.nextLine());


            switch (menuInicial) {
                case 1:
                    var logar = login.logar();
                    usuario = logar;
                    break;

                case 2:
                    var registrar = login.registrar();
                    usuario = registrar;
                    break;

                case 3:
                    System.exit(0);
                    break;

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
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
