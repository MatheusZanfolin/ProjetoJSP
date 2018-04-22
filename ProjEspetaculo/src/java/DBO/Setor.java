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
public class Setor implements Cloneable, Comparable<Setor>{
    private int codSetor;
    private String nome;
    
    public Setor(int codSetor, String nome) throws Exception {
        if (codSetor < 1)
            throw new Exception("Setor: inicialização com código inválido.");
        
        if (nome == null)
            throw new Exception("Setor: inicialização com nome vazio.");
        
        this.codSetor = codSetor;
        this.nome     = nome;
    }
    
    public Setor(Setor original) throws Exception {
        if (original == null)
            throw new Exception("Setor: cópia de objeto nulo.");
        
        this.codSetor = original.codSetor;
        this.nome     = original.nome;
    }
    
    public void setCodSetor(int codSetor) throws Exception {
        if (codSetor < 1)
            throw new Exception("Setor: código inválido.");
        
        this.codSetor = codSetor;
    }
    
    public void setNome(String nome) throws Exception {
        if (nome == null)
            throw new Exception("Setor: inicialização com nome vazio.");
        
        this.nome = nome;
    }
    
    public int getCodSetor() {
        return this.codSetor;
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
        
        Setor s = (Setor) obj;
        
        if (s.codSetor != this.codSetor)
            return false;
        
        if (!s.nome.equals(this.nome))
            return false;
        
        return true;
    }
    
    @Override
    public int compareTo(Setor outro) {
        return this.codSetor - outro.codSetor;
    }
    
}
