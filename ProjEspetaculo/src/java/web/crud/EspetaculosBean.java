/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import DAO.Espetaculos;
import DAO.Ingressos;
import DBO.Compra;
import DBO.Espetaculo;
import DBO.TipoIngresso;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Work
 */
public class EspetaculosBean extends Crud{
    private int passo = 0;
    private List<Espetaculo> listaEspetaculos;
    private int codEspetaculoSelecionado = 0;
    private int qtdIngressosDisponiveis = 0;
    private TipoIngresso[] listaTipoIngresso = TipoIngresso.values();
    private Compra compra = new Compra();
    
    public EspetaculosBean(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);     
        try{
            this.listaEspetaculos = Espetaculos.getEspetaculos();
            this.compra.setEspetaculo(getEspetaculoSelecionado()); 
            this.codEspetaculoSelecionado = paramInt("formEspetaculo");
            this.qtdIngressosDisponiveis = paramInt("formQtdIngressosDisponiveis");            
            this.compra.setDataEspetaculo(paramTimestamp("dtEspetaculo"));
        }catch (Exception e){
            
        }
    }
    
    private Espetaculo getEspetaculoSelecionado(){
        List<Espetaculo> espetaculoSelecionado = listaEspetaculos.stream()
                .filter(esp -> esp.getCodEspetaculo() == paramInt("espetaculo"))
                .collect(Collectors.toList());
        if (espetaculoSelecionado.size() > 0){
            return espetaculoSelecionado.get(0);
        }
        
        return new Espetaculo();
    }
    public void selecionarEspetaculos(){
        if (compra.getEspetaculo().getCodEspetaculo() != 0){            
            passo = 1;
        } 
        saidaPadrao(null);
    }
    
    public void selecionarDtEspetaculo() throws Exception{
        passo = 1;
        
        if (compra.getDataEspetaculo() != null){
            passo = 2;        
            this.qtdIngressosDisponiveis = Ingressos.quantosIngressos(compra.getDataEspetaculo());            
        }

        saidaPadrao(null);
    }
    
    public void selecionarTipoIngresso() throws Exception{
        passo = 2;
        int qtdSelecionada = 0;
        for (TipoIngresso tipoIngresso : listaTipoIngresso){
            int qtd = paramInt("qtdIngressos" + tipoIngresso.getCodTipo());
            
            if (qtd < 0){
                throw new Exception("Não é possível selecionar valores negativos!");
            }
            else if (qtd > 0){
                compra.getTipoIngressoQuantidade().put(tipoIngresso, qtd);
                qtdSelecionada += qtd;
            }
        }
        if (qtdSelecionada > qtdIngressosDisponiveis)
            throw new Exception("Foram selecionados " + qtdSelecionada + " assentos! Selecione no máximo " + qtdIngressosDisponiveis);
        
        compra.setQtdAssentos(qtdSelecionada);
        request.setAttribute("compra", compra);
        request.getSession().setAttribute("compra", compra);
        encaminhar("/ServletAssentos?operation=selecionar");                    
    }

    @Override
    public void saidaPadrao(Exception ex) {
        if (ex != null){
            request.setAttribute("erro", ex.getCause().getMessage());            
        }
        request.setAttribute("bean", this);
        encaminhar("content/jsp/selecionar-espetaculo.jsp");
    }

    public int getPasso() {
        return passo;
    }

    public void setPasso(int passo) {
        this.passo = passo;
    }

    public List<Espetaculo> getListaEspetaculos() {
        return listaEspetaculos;
    }

    public int getCodEspetaculoSelecionado() {
        return codEspetaculoSelecionado;
    }

    public void setCodEspetaculoSelecionado(int codEspetaculoSelecionado) {
        this.codEspetaculoSelecionado = codEspetaculoSelecionado;
    }

    public void setListaEspetaculos(List<Espetaculo> listaEspetaculos) {
        this.listaEspetaculos = listaEspetaculos;
    }

    public int getQtdIngressosDisponiveis() {
        return qtdIngressosDisponiveis;
    }

    public void setQtdIngressosDisponiveis(int qtdIngressosDisponiveis) {
        this.qtdIngressosDisponiveis = qtdIngressosDisponiveis;
    }

    public TipoIngresso[] getListaTipoIngresso() {
        return listaTipoIngresso;
    }

    public void setListaTipoIngresso(TipoIngresso[] listaTipoIngresso) {
        this.listaTipoIngresso = listaTipoIngresso;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    
}
