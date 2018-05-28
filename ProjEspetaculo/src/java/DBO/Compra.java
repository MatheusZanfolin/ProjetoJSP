/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Work
 */
public class Compra implements Serializable{
    private double taxaDeConveniencia = 15d;
    private Timestamp dataEspetaculo;
    private Espetaculo espetaculo = new Espetaculo();
    private HashMap<TipoIngresso, Integer> tipoIngressoQuantidade = new HashMap();
    private int qtdAssentos = 0;
    private ArrayList<Integer> assentosSelecionados = new ArrayList();
    private double total = 0f;
    
    public List<ResumoCompra> getListaResumoCompra(){
        ArrayList<ResumoCompra> listaResumoCompras = new ArrayList();
        tipoIngressoQuantidade.forEach((tipoIngresso, quantidade) -> {
            ResumoCompra resumoCompra = new ResumoCompra();
            resumoCompra.setIngressoSetor(
                espetaculo.getNome() + " - " + 
                dataEspetaculo.toString() + " - " +
                tipoIngresso.getLabel()
            );
            resumoCompra.setQuantidade(quantidade);
            resumoCompra.setValor(tipoIngresso.getValor() * quantidade);
            
            listaResumoCompras.add(resumoCompra);
        });
        
        return listaResumoCompras;
    }
    
    public double getTotal(){            
        total = taxaDeConveniencia;
        tipoIngressoQuantidade.forEach((tipo, qtd) -> total += tipo.getValor() * qtd);
        return total;
    }
    
    public String getTotalFormatado(){
        return String.format("R$ %.2f", getTotal());
    }
    
    public Timestamp getDataEspetaculo() {
        return dataEspetaculo;
    }        

    public void setDataEspetaculo(Timestamp dataEspetaculo) {
        this.dataEspetaculo = dataEspetaculo;
    }

    public Espetaculo getEspetaculo() {
        return espetaculo;
    }

    public void setEspetaculo(Espetaculo espetaculo) {
        this.espetaculo = espetaculo;
    }

    public HashMap<TipoIngresso, Integer> getTipoIngressoQuantidade() {
        return tipoIngressoQuantidade;
    }

    public void setTipoIngressoQuantidade(HashMap<TipoIngresso, Integer> tipoIngressoQuantidade) {
        this.tipoIngressoQuantidade = tipoIngressoQuantidade;
    }

    public double getTaxaDeConveniencia() {
        return taxaDeConveniencia;
    }

    public void setTaxaDeConveniencia(double taxaDeConveniencia) {
        this.taxaDeConveniencia = taxaDeConveniencia;
    }
    

    public int getQtdAssentos() {
        return qtdAssentos;
    }

    public void setQtdAssentos(int qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }

    public ArrayList<Integer> getAssentosSelecionados() {
        return assentosSelecionados;
    }

    public void setAssentosSelecionados(ArrayList<Integer> assentosSelecionados) {
        this.assentosSelecionados = assentosSelecionados;
    }
    
    public String getConvenienciaFormatado(){
        return String.format("R$ %.2f", taxaDeConveniencia);
    }
    
    
}
