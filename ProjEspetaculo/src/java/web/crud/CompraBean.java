/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import DAO.Ingressos;
import DBO.Compra;
import DBO.Espectador;
import DBO.TipoIngresso;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Work
 */
public class CompraBean extends Crud{
    private Compra compra;
    
    public CompraBean(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);
        compra = (Compra) req.getSession().getAttribute("compra");
    }
    
    public void finalizar(){
        Espectador espectador = (Espectador) request.getSession().getAttribute("espectador");
        compra.getAssentosSelecionados().stream().forEach(cod -> {   
            try {
                Ingressos.registrarIngresso(espectador.getEmail(), compra.getDataEspetaculo(), TipoIngresso.INTEIRA, cod);
            } catch (SQLException ex) {
                saidaPadrao(ex);
            }
        });
        
        encaminhar("/content/jsp/finalizado.jsp");
    }

    @Override
    public void saidaPadrao(Exception ex) {       
        request.setAttribute("bean", this);
        encaminhar("/content/jsp/compra.jsp");
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    
    
}
