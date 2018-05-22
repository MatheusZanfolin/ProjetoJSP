/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author u16189
 */
public class Espetaculo implements Cloneable, Comparable<Espetaculo> {
    private int         codEspetaculo;
    private String      nome;
    private int         classificacao;
    private ArrayList<Timestamp> datasApresentacao;
    
    public Espetaculo(){
        this.nome = "";
        this.datasApresentacao = new ArrayList<>();     
    }
    
    public Espetaculo(int codEspetaculo, String nome, int classificacao, ArrayList<Timestamp> datasApresentacao) throws Exception {
        if (codEspetaculo < 1)
            throw new Exception("Espetaculo: inicialização com código de estado inválido.");
        
        if (nome == null)
            throw new Exception("Espetaculo: inicialização com nome nulo.");
        
        if (classificacao < 10)
            throw new Exception("Espetaculo: inicializa��o com classifica��o indicativa inv�lida");
        
        if (datasApresentacao == null)
            throw new Exception("Espetaculo: inicialização com datas de espetáculo nulas.");
        
        this.codEspetaculo     = codEspetaculo;
        this.nome              = nome;
        this.classificacao     = classificacao;
        this.datasApresentacao = datasApresentacao;
    }
    
    public Espetaculo(Espetaculo original) throws Exception {
        if (original == null)
            throw new Exception("Espetáculo: cópia de objeto nulo.");
        
        this.codEspetaculo = original.codEspetaculo;
        this.nome          = original.nome;
        this.classificacao = original.classificacao;
    }
    
    public void setCodEstado(int codEspetaculo) throws Exception {
        if (codEspetaculo < 1)
            throw new Exception("Espetaculo: código de estado inválido.");
        
        this.codEspetaculo = codEspetaculo;
    }
    
    public void setNome(String nome) throws Exception {
        if (nome == null)
            throw new Exception("Espetaculo: inicialização com nome nulo.");
        
        this.nome = nome;
    }
    
    public void setClassificacao(int classificacao) throws Exception {
        if (classificacao < 1)
            throw new Exception("Espetaculo: código de estado inválido.");
        
        this.classificacao = classificacao;
    }
    
    public void setDatasApresentacao(ArrayList<Timestamp> datasApresentacao) throws Exception {
        if (datasApresentacao == null)
            throw new Exception("Espetaculo: datas de espetáculo nulas.");
        
        this.datasApresentacao = datasApresentacao;
    }
    
    public int getCodEspetaculo() {
        return this.codEspetaculo;
    }
    
    public String getNome() {
        return this.nome;
    }        

    public int getClassificacao() {
        return this.classificacao;
    }
    
    public ArrayList<Timestamp> getDatasApresentacao() {
        return this.datasApresentacao;
    }
    
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (obj == this)
            return true;
        
        if (obj.getClass() != this.getClass())
            return false;
        
        Espetaculo e = (Espetaculo) obj;
        
        if (e.codEspetaculo != this.codEspetaculo)
            return false;
        
        if (!e.nome.equals(this.nome))
            return false;
        
        if (e.classificacao != this.classificacao)
            return false;
        
        return true;
    }

    @Override
    public int compareTo(Espetaculo outro) {
        return this.codEspetaculo - outro.codEspetaculo;
    }
    
    public String toString() {
        return this.nome;
    }
}