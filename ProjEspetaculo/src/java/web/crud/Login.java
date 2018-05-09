/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author u14187
 */
public class Login extends Crud{
    
    public Login(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);
    }
    
    public void cadastrar(){
        encaminhar("ServletCadastro");
    }
    
    public void entrar(){
        request.setAttribute("passo", 0);
        encaminhar("content/jsp/index.jsp");
    }
    


    @Override
    public void saidaPadrao() {
        encaminhar("content/jsp/login.jsp");
    }
}
