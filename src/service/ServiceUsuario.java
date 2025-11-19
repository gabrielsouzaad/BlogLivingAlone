package service;

import model.Usuario;
import exceptions.NaoEncontradoException;
import exceptions.InvalidaException;
import model.Permissao;

import java.util.HashMap;

public class ServiceUsuario {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
private HashMap<String, Permissao> permissoes = new HashMap<>();

public ServiceUsuario() {
    inicializarPermissoes();
    inicializarUsuariosDefault();
}

private void inicializarPermissoes() {
    Permissao admin = new Permissao("P001", "ADMIN", "Administrador do blog", true, true, true, true, java.time.LocalDateTime.now());
    Permissao autor = new Permissao("P002", "AUTOR", "Pode criar e editar posts", true, true, false, false, java.time.LocalDateTime.now());
    Permissao leitor = new Permissao("P003", "LEITOR", "Pode apenas ler e comentar", false, false, false, false, java.time.LocalDateTime.now());

    permissoes.put(admin.getNome(), admin);
    permissoes.put(autor.getNome(), autor);
    permissoes.put(leitor.getNome(), leitor);
}

private void inicializarUsuariosDefault() {
    // Criando alguns usuários padrão para facilitar testes
    Permissao admin = permissoes.get("ADMIN");
    Permissao autor = permissoes.get("AUTOR");
    Permissao leitor = permissoes.get("LEITOR");

    Usuario u1 = new Usuario("admin", "admin123", admin);
    Usuario u2 = new Usuario("autor1", "autor123", autor);
    Usuario u3 = new Usuario("leitor1", "leitor123", leitor);

    usuarios.put(u1.getNome(), u1);
    usuarios.put(u2.getNome(), u2);
    usuarios.put(u3.getNome(), u3);
}

public Permissao getPermissao(String nome) {
    return permissoes.get(nome);
}

    public Usuario registrar(String nome, String senha) {
        if (usuarios.containsKey(nome)) {
            throw new InvalidaException("Usuário já existe.");
        }
        // Todos os novos usuários são leitores por padrão
        Permissao leitor = permissoes.get("LEITOR");
        Usuario novo = new Usuario(nome, senha, leitor);
        usuarios.put(nome, novo);
        return novo;
    }

    public Usuario login(String nome, String senha) {
        Usuario usuario = usuarios.get(nome);

        if (usuario == null)
            throw new NaoEncontradoException("Usuário não encontrado.");

        if (!usuario.getSenha().equals(senha))
            throw new InvalidaException("Senha incorreta.");

        return usuario;
    }
}
