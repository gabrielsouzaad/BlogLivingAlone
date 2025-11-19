package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AvaliacaoPost implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idAvaliacao;
    private String idPost;
    private String idUsuario;
    private int nota;
    private String comentarioAvaliacao;
    private LocalDateTime dataAvaliacao;

    public AvaliacaoPost(String idAvaliacao, String idPost, String idUsuario, int nota, String comentarioAvaliacao, LocalDateTime dataAvaliacao) {
        this.idAvaliacao = idAvaliacao;
        this.idPost = idPost;
        this.idUsuario = idUsuario;
        this.nota = nota;
        this.comentarioAvaliacao = comentarioAvaliacao;
        this.dataAvaliacao = dataAvaliacao;
    }


    @Override
    public String toString() {
        return "AvaliacaoPost{" +
                "idAvaliacao='" + idAvaliacao + '\'' +
                ", idPost='" + idPost + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", nota=" + nota +
                ", dataAvaliacao=" + dataAvaliacao +
                '}';
    }
}
