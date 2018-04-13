/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

/**
 *
 * @author Work
 */
public class Pessoa {
    private String nome = "";
    
    public Pessoa(){
        
    }
    
    public Pessoa(String nome){
        this.nome = nome;
    }
 
    public Pessoa filho(Pessoa parceiro){
       String nomeFilho = nome.substring(0, nome.length() / 2) + 
               parceiro.nome.substring(nome.length() /2 );
       
       return new Pessoa(nomeFilho);
    }
    
    public void salvar(){
        System.out.println("salvar");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static Pessoa get(String nome){
        return new Pessoa("");
    }
    @Override
    public String toString(){
        return this.nome;
    }
    
}
