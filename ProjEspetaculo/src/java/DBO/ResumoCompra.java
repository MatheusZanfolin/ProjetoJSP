/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

/**
 *
 * @author Work
 */
public class ResumoCompra {
    private String ingressoSetor = "";
    private int quantidade = 0;
    private double valor = 0;

    public String getIngressoSetor() {
        return ingressoSetor;
    }
    
    public String getValorFormatado(){
        return String.format("R$ %.2f", valor);
    }

    public void setIngressoSetor(String ingressoSetor) {
        this.ingressoSetor = ingressoSetor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
