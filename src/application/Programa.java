package application;

import java.util.Scanner;

import exceptions.NaoEncontradoException;
import model.Usuario;
import service.ServiceBlog;
import service.ServiceUsuario;

public class Programa {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            ServiceBlog blog = new ServiceBlog();
            ServiceUsuario usuarios = new ServiceUsuario();

            System.out.println("----- LivingAlone -----");

            System.out.print("Digite seu nome de usuário: ");
            String nome = sc.nextLine();

            Usuario usuario;

            try {
                usuario = usuarios.login(nome);
            } catch (NaoEncontradoException e) {
                System.out.println("Usuário não encontrado. Criando novo usuário...");
                usuario = usuarios.registrar(nome);
            }

            while (true) {
                System.out.println("\n1 - Adicionar postagem");
                System.out.println("2 - Desfazer");
                System.out.println("3 - Listar postagens");
                System.out.println("0 - Sair");
                System.out.print("Opção: ");

                int opcao = Integer.parseInt(sc.nextLine());

                try {

                    switch (opcao) {

                        case 1:
                            System.out.print("Título: ");
                            String titulo = sc.nextLine();

                            System.out.print("Conteúdo: ");
                            String conteudo = sc.nextLine();

                            blog.adicionarPostagem(titulo, conteudo, usuario);
                            break;

                        case 2:
                            blog.desfazer();
                            System.out.println("Última postagem removida.");
                            break;

                        case 3:
                            System.out.println(blog.listarPostagens());
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
