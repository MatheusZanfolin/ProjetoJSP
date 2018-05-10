/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.beans.CadastroBean;

/**
 *
 * @author Work
 */
public class Cadastro extends Crud{
    CadastroBean bean = new CadastroBean();;
    
    public Cadastro(HttpServletRequest request, HttpServletResponse response){
        super(request, response);
        mountBean(bean);
    }
    
    public void salvar(){
        System.out.println("salvei " + bean);
    }

    @Override
    public void saidaPadrao() {
        System.out.println("olá mundo");
    }
}
