/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import DAO.Espectadores;
import DBO.Espectador;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author u14187
 */
public class Login extends Crud{
    private Espectador espectador = new Espectador();
    public Login(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);

    }
    
    public void cadastrar(){
        encaminhar("ServletCadastro");
    }
    
    public void entrar() throws SQLException{
        request.setAttribute("passo", 0);
        if (Espectadores.isCadastrado(paramString("email"), paramString("senha"))){
            encaminhar("content/jsp/index.jsp");
        }
        else{
            request.setAttribute("erro", "Usuário ou senha inválido(s)!");
            encaminhar("content/jsp/login.jsp");
        }
    }
    


    @Override
    public void saidaPadrao(Exception e) {
        encaminhar("content/jsp/login.jsp");
    }
}
