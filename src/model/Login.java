package model;

import exceptions.InvalidaException;
import model.Usuario;
import interfaces.services.IUsuarioService;
import util.InputReader;
import util.ConsolePrinter;

public class Login {
    private final InputReader input;
    private final IUsuarioService usuarios;
    private final ConsolePrinter out = new ConsolePrinter();

    public Login(IUsuarioService usuarios, InputReader input) {
        this.usuarios = usuarios;
        this.input = input;
    }

    public Usuario logar() {
        String nome = input.readLine("Digite seu nome: ");
        if (nome == null || nome.isEmpty()) {
            throw new InvalidaException("Por favor digite um nome.");
        }
        String senha = input.readLine("Digite sua senha: ");
        if (senha == null || senha.isEmpty()) {
            throw new InvalidaException("Por favor digite uma senha.");
        }
        Usuario usuario = usuarios.login(nome, senha);
        out.println("Login realizado com sucesso!");
        return usuario;
    }

    public Usuario registrar() {
        String nome = input.readLine("Digite seu nome: ");
        if (nome == null || nome.isEmpty()) {
            throw new InvalidaException("Por favor digite um nome.");
        }
        String senha = input.readLine("Digite sua senha: ");
        if (senha == null || senha.isEmpty()) {
            throw new InvalidaException("Por favor digite uma senha.");
        }
        Usuario usuario = usuarios.registrar(nome, senha);
        out.println("Usuário criado com sucesso!");
        return usuario;
    }
}
