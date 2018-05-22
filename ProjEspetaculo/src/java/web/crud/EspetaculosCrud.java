/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import DAO.Espetaculos;
import DBO.Espetaculo;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Work
 */
public class EspetaculosCrud extends Crud{
    int passo = 0;

    List<Espetaculo> listaEspetaculos;
    Espetaculo espetaculo = new Espetaculo();
    
    public EspetaculosCrud(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);     
        try{
            this.listaEspetaculos = Espetaculos.getEspetaculos();
            espetaculo = getEspetaculoSelecionado();
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
        if (espetaculo.getCodEspetaculo() != 0){            
            passo = 1;
        }
        
        
        
        saidaPadrao(null);
    }

    @Override
    public void saidaPadrao(Exception ex) {
        request.setAttribute("espetaculos", this);
        encaminhar("content/jsp/espetaculos.jsp");
    }

    public int getPasso() {
        return passo;
    }

    public void setPasso(int passo) {
        this.passo = passo;
    }

    public Espetaculo getEspetaculo() {
        return espetaculo;
    }

    public void setEspetaculo(Espetaculo espetaculo) {
        this.espetaculo = espetaculo;
    }


    public List<Espetaculo> getListaEspetaculos() {
        return listaEspetaculos;
    }

    public void setListaEspetaculos(List<Espetaculo> listaEspetaculos) {
        this.listaEspetaculos = listaEspetaculos;
    }
    
    
}
