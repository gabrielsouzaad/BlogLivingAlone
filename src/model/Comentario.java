package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String idComentario;
    private String texto;
    private String autor;
    private LocalDateTime dataHora;
    private String idPost;
    private int likes;
    private int dislikes;
    private boolean aprovado;

    public Comentario(String idComentario, String texto, String autor, LocalDateTime dataHora, String idPost, int likes, int dislikes, boolean aprovado) {
        this.idComentario = idComentario;
        this.texto = texto;
        this.autor = autor;
        this.dataHora = dataHora;
        this.idPost = idPost;
        this.likes = likes;
        this.dislikes = dislikes;
        this.aprovado = aprovado;
    }


    @Override
    public String toString() {
        return "Comentario{" +
                "idComentario='" + idComentario + '\'' +
                ", texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", dataHora=" + dataHora +
                ", idPost='" + idPost + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", aprovado=" + aprovado +
                '}';
    }
}
