/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.crud;

import DAO.Espectadores;
import DAO.Estados;
import DBO.Espectador;
import DBO.Estado;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Work
 */
public class CadastroBean extends Crud{
    Espectador espectador = new Espectador();
    
    public CadastroBean(HttpServletRequest request, HttpServletResponse response){
        super(request, response, false);
        try{
            espectador = new Espectador(
                paramString("email"),
                paramString("senha") ,
                paramString("nome"),
                paramString("cpf"),
                paramDate("dtNascimento"),
                "M".equals(paramChar("sexo")),
                paramString("telefone"),
                paramString("cep"), 
                paramString("endereco"), 
                paramString("numero"),
                paramString("complemento"),
                paramString("bairro"),
                paramString("cidade"), 
                new Estado(paramInt("estados"), "")
            );
            
            List<Estado> listaEstados = Estados.getEstados();
            request.setAttribute("listaEstados", listaEstados);
            
        }catch(Exception e){
            encaminhar("login");
        }
    }    
    
    public void salvar() throws Exception{
        if (Espectadores.isCadastrado(espectador.getEmail()))
            throw new Exception ("Já existe um usuário para este email!");
        
        request.setAttribute("espectador", espectador);        
        Espectadores.inserirEspectador(this.espectador);
        encaminhar("/content/jsp/login.jsp");
    }
  

    @Override
    public void saidaPadrao(Exception e) {
        if (e != null){
            String msg = e.getCause().getMessage();
            request.setAttribute("erro", msg);
            
        }
        
        request.setAttribute("contador", 0);
        request.setAttribute("espectador", espectador);
        encaminhar("content/jsp/cadastro.jsp");
    }
    
}
