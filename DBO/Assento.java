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
public class Assento {
    private int codAssento;
    private Setor setor;
    private Map<Timestamp, Boolean> ocupado;
    
    public Assento(int codAssento, Setor s, Map<Timestamp, Boolean> ocupado) throws Exception{
        if (codAssento < 1)
            throw new Exception("Assento: inicialização com código inválido.");
        
        if (s == null)
            throw new Exception("Assento: inicialização com setor nulo.");
        
        if (ocupado == null)
            throw new Exception("Assento: inicialização com indicações de ocupação nulas.");
        
        this.codAssento = codAssento;
        this.setor      = s;
        this.ocupado    = new HashMap<>(ocupado);
    }

    public int getCodAssento() {
        return codAssento;
    }

    public Setor getSetor() throws Exception {
        return new Setor(this.setor);
    }
    
    public boolean isOcupado(Timestamp data) {
        return this.ocupado.get(data);
    }
    
    public void setCodAssento(int codAssento) throws Exception {
        if (codAssento < 1)
            throw new Exception("Assento: código inválido.");
        
        this.codAssento = codAssento;
    }
    
    public void setSetor(Setor s) throws Exception {
        if (s == null)
            throw new Exception("Assento: inicialização com setor nulo.");
        
        this.setor = new Setor(s);
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
        
        if (!a.setor.equals(this.setor))
            return false;
        
        return true;
    }
}
