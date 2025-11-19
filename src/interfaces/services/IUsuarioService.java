package interfaces.services;

import model.Usuario;
import model.Permissao;

public interface IUsuarioService {

    Usuario registrar(String nome, String senha);

    Usuario login(String nome, String senha);

    Permissao getPermissao(String nome);
}
