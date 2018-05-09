/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author u16189
 */
public class Assento implements Comparable<Assento> {
    private int codAssento;
    private Map<Timestamp, Boolean> ocupado;
    
    public Assento(int codAssento, Map<Timestamp, Boolean> ocupado) throws Exception{
        if (codAssento < 1)
            throw new Exception("Assento: inicialização com código inválido.");
        
        if (ocupado == null)
            throw new Exception("Assento: inicialização com indicações de ocupação nulas.");
        
        this.codAssento = codAssento;
        this.ocupado    = new HashMap<>(ocupado);
    }

    public int getCodAssento() {
        return codAssento;
    }
    
    public boolean isOcupado(Timestamp data) {
        return this.ocupado.get(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (obj == this)
            return true;
        
        if (obj.getClass() != this.getClass())
            return false;
        
        Assento a = (Assento) obj;
        
        if (a.codAssento != this.codAssento)
            return false;
        
        if (!a.ocupado.equals(this.ocupado))
            return false;
        
        return true;
    }

    @Override
    public int compareTo(Assento outro) {
        return this.codAssento - outro.codAssento; 
    }
    
    
    @Override
    public String toString() {
        return "Assento nº" + this.codAssento;
    }
}