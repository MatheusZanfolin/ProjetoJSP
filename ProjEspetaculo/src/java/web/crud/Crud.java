/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;


import java.lang.reflect.Method;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author u14187
 */
public abstract class Crud {
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public Crud(HttpServletRequest req, HttpServletResponse resp){
        this.request = req;
        this.response = resp;
    }
    
    protected String paramString(String nome){
        String valor = request.getParameter(nome);
        return valor == null ? "" : valor;
    }
    
    protected int paramInt(String nome){
        try{
            String valor = request.getParameter(nome);
            valor = valor == null ? "" : valor;
            int ret = Integer.valueOf(valor);
            return ret;
        }catch(NumberFormatException ne){
            return 0;
        }
    }
    
    protected Date paramDate(String nome){
        String valor = request.getParameter(nome);
        return valor == null ? null : Date.valueOf(valor);
    }
    
    protected char paramChar(String nome){
        String valor = request.getParameter(nome);
        return valor == null ? ' ' : (valor.length() == 0 ? ' ' : valor.charAt(0));
    }
    public HttpServletRequest getRequest() {
        return request;
    }
    
    public void encaminhar(String url){
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);

        try {  
            dispatcher.include(request, response);

        } catch(Exception e){
        }
    }
      
    public void execute(String nomeMetodo){
        Method metodo = null;
        try {
            if (nomeMetodo != null){
                metodo = getClass().getMethod(nomeMetodo);
            }
            else{
                throw new Exception();
            }
        } catch (Exception ex) {
            saidaPadrao(null);
        }
        
        try {
            if (metodo != null){
                metodo.invoke(this);
            }
            else{
                throw new Exception("Erro Interno");
            }
        } catch (Exception e){
            saidaPadrao(e);
        }
        
    }
    
    public abstract void saidaPadrao(Exception ex);

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
    
    
}
