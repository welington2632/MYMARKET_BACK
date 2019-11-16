/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

/**
 *
 * @author Everymind
 */
public class Usuario {
    private int id;
    private String nome;
    private String cnpj;
    private String senha;
    private String email;
    private TipoUsuario tipo;
    private Endereco endereco;
    private Comercio comercio;

    public Usuario(int id, String nome, String cnpj, String senha, String email, TipoUsuario tipo, Endereco endereco, Comercio comercio) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        this.endereco = endereco;
        this.comercio = comercio;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpnj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }
    
    
}
