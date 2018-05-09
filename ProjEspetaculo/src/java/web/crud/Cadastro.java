/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import com.google.gson.Gson;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.beans.CadastroBean;

/**
 *
 * @author Work
 */
public class Cadastro extends Crud{
    CadastroBean bean;
    
    public Cadastro(HttpServletRequest request, HttpServletResponse response){
        super(request, response);
        bean = new CadastroBean();
        mountBean(bean);
    }

    @Override
    public void saidaPadrao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
