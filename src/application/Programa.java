package application;

import exceptions.NaoEncontradoException;
import exceptions.InvalidaException;
import model.Login;
import model.Usuario;
import model.MenuList;
import service.ServiceBlog;
import service.ServiceUsuario;
import interfaces.services.IBlogService;
import interfaces.services.IUsuarioService;
import util.InputReader;
import util.ConsolePrinter;

public class Programa {

    public static void main(String[] args) {
        InputReader input = new InputReader();
        ConsolePrinter out = new ConsolePrinter();

        IBlogService blog = new ServiceBlog();
        IUsuarioService usuarios = new ServiceUsuario();
        MenuList menu = new MenuList(input, out);
        Login login = new Login(usuarios, input);

        Usuario usuario = null;

        for (;;) {
            while (usuario == null) {
                out.println("----- LivingAlone -----");
                out.println("Escolha a opção:");
                out.println("1 - Logar");
                out.println("2 - Criar");
                out.println("3 - Sair");

                int menuInicial = input.readIntInRange("Opção: ", 1, 3);

                switch (menuInicial) {
                    case 1:
                        usuario = login.logar();
                        break;

                    case 2:
                        usuario = login.registrar();
                        break;

                    case 3:
                        out.println("Saindo da aplicação. Até logo!");
                        System.exit(0);
                        break;
                }
            }

            while (usuario != null) {
                out.println("\n----- Menu Principal -----");
                out.println("Usuário logado: " + usuario.getNome());
                out.println("1 - Adicionar postagem");
                out.println("2 - Remover postagem (apenas suas)");
                out.println("3 - Listar todas as postagens");
                out.println("4 - Listar postagens por categoria");
                out.println("5 - Listar minhas postagens");
                out.println("6 - Desfazer (última ação de postagem)");
                out.println("7 - Listar categorias");
                out.println("8 - Adicionar comentário a uma postagem");
                out.println("9 - Avaliar postagem");

                out.println("0 - Deslogar");

                int opcao = input.readIntInRange("Opção: ", 0, 9);

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
                            out.println("Deslogando...");
                            usuario = null;
                            break;

                        default:
                            out.println("Opção inválida.");
                    }

                } catch (RuntimeException e) {
                    out.println("ERRO: " + e.getMessage());
                }
            }
        }
    }
}
