/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import DAO.Assentos;
import DBO.Assento;
import DBO.Compra;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Work
 */
public class AssentosBean extends Crud{
    private Compra compra; 
    public static final String ASSENTO_OCUPADO = "assento-ocupado";
    public static final String ASSENTO_SELECIONADO = "assento-selecionado";
    
    private HashMap<String, String> mapaAssentos = new HashMap();
    public AssentosBean(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp, true);
        try{
            compra = (Compra) req.getSession().getAttribute("compra");
            ArrayList<Assento> listaAssentos = Assentos.getAssentos();
            
            for(Assento assento : listaAssentos){
                if (assento.isOcupado(compra.getDataEspetaculo())){
                    mapaAssentos.put(assento.getCodAssento() + "", ASSENTO_OCUPADO);
                }
            }
                   
        }catch (Exception e){
            saidaPadrao(e);
        }
    }

    public Compra getCompra() {
        return compra;
    }

    public HashMap<String, String> getMapaAssentos() {
        return mapaAssentos;
    }
    
    public String getMapaAssentosJson(){
        return new Gson().toJson(mapaAssentos);
    }
    
    public void selecionar(){
        saidaPadrao(null);
    }
    
    public void comprar(){
        mapaAssentos = new Gson().fromJson(paramJson("mapaAssentos"), HashMap.class);
        if (mapaAssentos == null)
            saidaPadrao(null);
        
        for (String chave : mapaAssentos.keySet())
        {           
            if (ASSENTO_SELECIONADO.equals(mapaAssentos.get(chave)))
                compra.getAssentosSelecionados().add(Integer.valueOf(chave));
        }
        
        request.getSession().setAttribute("compra", compra);
        encaminhar("/ServletCompra");
    }

    @Override
    public void saidaPadrao(Exception ex) {
        request.setAttribute("bean", this);
        encaminhar("/content/jsp/selecionar-assentos.jsp");
    }
    
}
