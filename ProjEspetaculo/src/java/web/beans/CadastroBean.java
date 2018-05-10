/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author u14187
 */
public class CadastroBean {
    public String[] nomes;
    public String nome = "";
    public String pais = "";
    public String cpf = "";
    public String dtNascimento;
    public String sexo;
    public String telefone = "";
    public String cep = "";
    public String endereco = "";
    public int numero;
    public String complemento = "";
    public String bairro = "";
    public String cidade = "";
    public String estado = "";
    public String email = "";
    public String senha = "";
    public String confirmacaoSenha = "";   

    @Override
    public String toString() {
        return "" + "nomes=" + nomes + ", nome=" + nome + ", pais=" + pais + ", cpf=" + cpf + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", telefone=" + telefone + ", cep=" + cep + ", endereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", email=" + email + ", senha=" + senha + ", confirmacaoSenha=" + confirmacaoSenha + "";
    }
    
    

}
