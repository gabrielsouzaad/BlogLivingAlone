package model;
import exceptions.InvalidaException;
import model.Usuario;
import service.ServiceUsuario;

import java.util.Scanner;

public class Login {
    Scanner sc = new Scanner(System.in);
    Usuario usuario = null;
    ServiceUsuario usuarios = new ServiceUsuario();


    public Usuario logar()
    {
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();
        if(nome == null || nome.isEmpty())
        {
            throw new InvalidaException(" por favor digite um nome ");
        }
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
        if(senha == null || senha.isEmpty())
        {
            throw new InvalidaException(" por favor digite um nome ");
        }
        usuario = usuarios.login(nome, senha);
        System.out.println("Login realizado com sucesso!");

        return usuario;
    }

    public Usuario registrar(){
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();
        if(nome == null || nome.isEmpty())
        {
            throw new InvalidaException(" por favor digite um nome ");
        }
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
        if(senha == null || senha.isEmpty())
        {
            throw new InvalidaException(" por favor digite um nome ");
        }
        usuario = usuarios.registrar(nome, senha);
        System.out.println("Usuário criado com sucesso!");

        return usuario;
    }
}
