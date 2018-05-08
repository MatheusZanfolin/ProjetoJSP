/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Work
 */
public class Cadastro {
    private String nome = "";
    private String pais = "";
    private String cpf = "";
    private String dtNascimento;
    private char sexo;
    private String telefone = "";
    private String cep = "";
    private String endereco = "";
    private int numero;
    private String complemento = "";
    private String bairro = "";
    private String cidade = "";
    private String estado = "";
    private String email = "";
    private String senha = "";
    private String confirmacaoSenha = "";
    
    public Cadastro(HttpServletRequest request, HttpServletResponse response){
        nome = request.getParameter("nome");
        pais = request.getParameter("pais");
        cpf = request.getParameter("cpf");
        dtNascimento = request.getParameter("dtNascimento");
        sexo = request.getParameter("sexo").charAt(0);
        telefone = request.getParameter("telefone");
        cep = request.getParameter("cep");
        endereco = request.getParameter("endereco");
        numero = Integer.getInteger(request.getParameter("numero"));
        complemento = request.getParameter("complemento");
        bairro = request.getParameter("bairro");
        cidade = request.getParameter("cidade");
        estado = request.getParameter("estado");
        email = request.getParameter("email");
        senha = request.getParameter("senha");
        confirmacaoSenha = request.getParameter("confirmacaoSenha");  
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }   
}
