/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
    public HttpServletRequest getRequest() {
        return request;
    }
    
    public void encaminhar(String url){
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        try {  
            dispatcher.forward(request, response);
        } catch(Exception e){
        }
    }
    public <T> T mountBean(T bean){
       try{
        Class<?> classe = bean.getClass();
        Field[] fields = classe.getDeclaredFields();

        for (Field field : fields){
            if (field.getName().equals("nomes")){
                String s;
                s = "";
            }
            if (field.getType().isInstance(ArrayList.class) || field.getType().isArray()){
                Gson gson = new Gson();
                String[] req = request.getParameterMap().get(field.getName());
     
                field.set(bean, gson.fromJson(req.toString(), field.getType()));            
            }
            else{
                Gson gson = new Gson();
                String req = request.getParameter(field.getName());        
                field.set(bean, gson.fromJson(req, field.getType()));
            }
        }
       }catch(Exception e){
           System.err.println(e.getMessage());
       } 
       return bean;
    }
    
    
    public void execute(String nomeMetodo){
        try {
            getClass().getMethod(nomeMetodo).invoke(this);
        } catch (Exception ex) {
            saidaPadrao();
        }         
    }
    
    public abstract void saidaPadrao();

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
