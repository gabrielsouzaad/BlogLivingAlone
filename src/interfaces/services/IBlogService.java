package interfaces.services;

import model.Post;
import model.Usuario;

public interface IBlogService {

    void adicionarComentario(String tituloPost, String texto, Usuario usuario);

    void adicionarPostagem(String titulo, String conteudo, String categoria, Usuario usuario);

    void avaliarPostagens(String tituloPost, int nota, String comentarioAvaliacao, Usuario usuario);

    Post buscarPostagensPorTitulo(String titulo);

    void desfazerUltimaPostagem();

    String listarCategorias();

    String listarPostagens();

    String listarPostagensPorCategoria(String categoria);

    String listarPostagensPorAutor(String autor);

    void removerPostagem(String titulo, Usuario usuario);
}