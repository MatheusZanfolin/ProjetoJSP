package web;

import com.google.gson.Gson;
import web.Cadastro;
// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Extend HttpServlet class
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
   

   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // bean de gerenciamento
      Cadastro cadastro;

      // setta o response content type
      response.setContentType("text/html; charset=UTF-8");

      // pega qual operacao executar
      String operacao = request.getParameter("operacao"); 

      // recebe o gerenciador na forma de uma string json
      String atributo = request.getParameter("cadastro");

      // se for nulo recebe cadeia vazia
      atributo = atributo == null ? "" : atributo;

      // converte para o objeto java
      cadastro = new Gson().fromJson(atributo,  Cadastro.class);

      // executa a regra de negócio
      cadastro = Cadastro.executar(cadastro, operacao);

      // setta o gerenciador no attributo da requisição em formado de uma string json
      String ret = new Gson().toJson(cadastro);
      request.setAttribute("cadastro", ret);
      
      // manda para o jsp
      RequestDispatcher dispatcher = request.getRequestDispatcher("/content/cadastroPessoa.jsp");
      dispatcher.forward(request,response);
   }
   
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
       doPost(request, response);
   }
}