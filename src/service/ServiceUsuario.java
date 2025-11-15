package service;

import model.Usuario;
import exceptions.NaoEncontradoException;

import java.util.HashMap;

public class ServiceUsuario {
    private HashMap<String, Usuario> usuarios = new HashMap<>();

    public Usuario registrar(String nome) {
        if (!usuarios.containsKey(nome)) {
            Usuario novo = new Usuario(nome);
            usuarios.put(nome, novo);
            return novo;
        }
        return usuarios.get(nome);
    }

    public Usuario login(String nome) {
        Usuario usuario = usuarios.get(nome);

        if (usuario == null)
            throw new NaoEncontradoException("Usuário não encontrado.");

        return usuario;
    }
}
