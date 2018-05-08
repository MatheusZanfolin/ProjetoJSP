/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import java.sql.Date;

/**
 *
 * @author u16189
 */
public class Espectador {
    private String  email;
    private String  senha;
    private String  nome;
    private String  cpf;
    private Date    nascimento;
    private boolean masculino;
    private String  telefone;
    private String  cep;
    private String  endereco;
    private String  numero;
    private String  complemento;
    private String  bairro;
    private String  cidade;
    private Estado  estado;

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
        if (email == null)
            throw new Exception("Espectador: inicialização com e-mail nulo.");
        
        if (senha == null)
            throw new Exception("Espectador: inicialização com senha nula.");
        
        if (nome == null)
            throw new Exception("Espectador: inicialização com nome nulo.");
        
        if (cpf == null)
            throw new Exception("Espectador: inicialização com CPF nulo.");
        
        if (nascimento == null)
            throw new Exception("Espectador: inicialização com data de nascimento nula.");
        
        if (telefone == null)
            throw new Exception("Espectador: inicialização com telefone nulo.");
        
        if (cep == null)
            throw new Exception("Espectador: inicialização com CEP nulo.");
        
        if (endereco == null)
            throw new Exception("Espectador: inicialização com endereço nulo.");
        
        if (numero == null)
            throw new Exception("Espectador: inicialização com número da residência nulo.");
        
        if (bairro == null)
            throw new Exception("Espectador: inicialização com bairro nulo.");
        
        if (cidade == null)
            throw new Exception("Espectador: inicialização com cidade nula.");
        
        if (estado == null)
            throw new Exception("Espectador: inicialização com estado nulo.");
        
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
    
    @Override
    public String toString() {
        return this.nome;
    }
}