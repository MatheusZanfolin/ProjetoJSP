/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

/**
 *
 * @author u16189
 */
public class Estado implements Cloneable, Comparable<Estado> {
    private int    codEstado;
    private String nome;
    
    public Estado(int codEstado, String nome) throws Exception {
        if (codEstado < 1)
            throw new Exception("Estado: inicialização com código de estado inválido.");
        
        if (nome == null)
            throw new Exception("Estado: inicialização com nome nulo.");
        
        this.codEstado = codEstado;
        this.nome      = nome;
    }
    
    public Estado(Estado original) throws Exception {
        if (original == null)
            throw new Exception("Estado: cópia de objeto nulo.");
        
        this.codEstado = original.codEstado;
        this.nome      = original.nome;
    }
    
    public void setCodEstado(int codEstado) throws Exception {
        if (codEstado < 1)
            throw new Exception("Estado: código de estado inválido.");
        
        this.codEstado = codEstado;
    }
    
    public void setNome(String nome) throws Exception {
        if (nome == null)
            throw new Exception("Estado: inicialização com nome nulo.");
        
        this.nome = nome;
    }
    
    public int getCodEstado() {
        return this.codEstado;
    }
    
    public String getNome() {
        return this.nome;
    }        
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (obj == this)
            return true;
        
        if (obj.getClass() != this.getClass())
            return false;
        
        Estado e = (Estado) obj;
        
        if (e.codEstado != this.codEstado)
            return false;
        
        if (!e.nome.equals(this.nome))
            return false;
        
        return true;
    }
    
    @Override
    public int compareTo(Estado outro) {
        return this.codEstado - outro.codEstado;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
