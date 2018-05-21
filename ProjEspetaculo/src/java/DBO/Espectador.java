/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import java.sql.Date;
import java.text.DateFormat;

/**
 *
 * @author u16189
 */
public class Espectador {
    private String  email = "";
    private String  senha = "";
    private String  nome = "";
    private String  cpf = "";
    private Date    nascimento;
    private boolean masculino;
    private String  telefone = "";
    private String  cep = "";
    private String  endereco = "";
    private String  numero = "";
    private String  complemento = "";
    private String  bairro = "";
    private String  cidade = "";
    private Estado  estado = new Estado();
    
    public Espectador(){
        
    }

    public Espectador(
            String email, 
            String senha, 
            String nome, 
            String cpf, 
            Date nascimento, 
            boolean masculino, 
            String telefone, 
            String cep, 
            String endereco, 
            String numero, 
            String complemento, 
            String bairro, 
            String cidade, 
            Estado estado
    ) throws Exception {
        this.email       = email;
        this.senha       = senha;
        this.nome        = nome;
        this.cpf         = cpf;
        this.nascimento  = nascimento;
        this.masculino   = masculino;
        this.telefone    = telefone;
        this.cep         = cep;
        this.endereco    = endereco;
        this.numero      = numero;
        this.complemento = complemento;
        this.bairro      = bairro;
        this.cidade      = cidade;
        this.estado      = estado;
    }
    
    public void validar() throws Exception{
        if (email == null)
            throw new Exception("e-mail nulo.");
        
        if (senha == null)
            throw new Exception("senha nula.");
        
        if (nome == null)
            throw new Exception("nome nulo.");
        
        if (cpf == null)
            throw new Exception("CPF nulo.");
        
        if (nascimento == null)
            throw new Exception("nascimento nula.");
        
        if (telefone == null)
            throw new Exception("telefone nulo.");
        
        if (cep == null)
            throw new Exception("CEP nulo.");
        
        if (endereco == null)
            throw new Exception("endereço nulo.");
        
        if (numero == null)
            throw new Exception("residência nulo.");
        
        if (bairro == null)
            throw new Exception("bairro nulo.");
        
        if (cidade == null)
            throw new Exception("cidade nula.");
        
        if (estado == null)
            throw new Exception("estado nulo.");
    }
    
    public Espectador(Espectador e) throws Exception {
        if (e == null)
            throw new Exception("Espectador: cópia de objeto nulo.");
        
        this.email       = e.email;
        this.senha       = e.senha;
        this.nome        = e.nome;
        this.cpf         = e.cpf;
        this.nascimento  = e.nascimento;
        this.masculino   = e.masculino;
        this.telefone    = e.telefone;
        this.cep         = e.cep;
        this.endereco    = e.endereco;
        this.numero      = e.numero;
        this.complemento = e.complemento;
        this.bairro      = e.bairro;
        this.cidade      = e.cidade;
        this.estado      = e.estado;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }
    
    public String getNascimentoFormatado(){
        if (nascimento == null){
            return null;
        }
        return nascimento.toString();
    }

    public boolean isMasculino() {
        return masculino;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setMasculino(boolean masculino) {
        this.masculino = masculino;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
    @Override
    public String toString() {
        return this.nome;
    }
}