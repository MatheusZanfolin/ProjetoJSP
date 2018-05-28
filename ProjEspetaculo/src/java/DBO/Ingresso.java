/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import java.sql.Timestamp;

/**
 *
 * @author u16189
 */
public class Ingresso {
    private Espectador   espectador;
    private TipoIngresso tipo;
    private Timestamp    dataEspetaculo;
    private Timestamp    dataEmissao;
    
    public Ingresso(Espectador e, TipoIngresso t, Timestamp dataEspetaculo, Timestamp dataEmissao) throws Exception {
        if (espectador == null)
            throw new Exception("Ingresso: inicialização com espectador nulo.");
        
        if (dataEspetaculo == null)
            throw new Exception("Ingresso: inicialização com data do espetáculo nula.");
        
        if (dataEmissao == null)
            throw new Exception("Ingresso: inicialização com data de emissão nula.");
        
        this.espectador     = e;
        this.tipo           = t;
        this.dataEspetaculo = dataEspetaculo;
        this.dataEmissao    = dataEmissao;
    }

    public void setEspectador(Espectador espectador) throws Exception {
        if (espectador == null)
            throw new Exception("Ingresso: espectador nulo.");
        
        this.espectador = espectador;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }

    public void setDataEspetaculo(Timestamp dataEspetaculo) throws Exception {
        if (dataEspetaculo == null)
            throw new Exception("Ingresso: data do espetáculo nula.");
        
        this.dataEspetaculo = dataEspetaculo;
    }

    public void setDataEmissao(Timestamp dataEmissao) throws Exception {
        if (dataEmissao == null)
            throw new Exception("Ingresso: data de emissão nula.");
        
        this.dataEmissao = dataEmissao;
    }

    public Espectador getEspectador() throws Exception {
        return new Espectador(espectador);
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public Timestamp getDataEspetaculo() {
        return (Timestamp) dataEspetaculo.clone();
    }

    public Timestamp getDataEmissao() {
        return (Timestamp) dataEmissao.clone();
    }
    
    public double getValor() {
        switch (this.tipo) {
            case INTEIRA:
                return 70;
                
            default:
                return 35;
        }
    }
    
    public static double getValor(TipoIngresso t) {
        switch (t) {
            case INTEIRA:
                return 70;
                
            default:
                return 35;
        }
    }
    
    public String toString() {
        return this.espectador + "(" + this.tipo.toString()  + ")";
    }
}