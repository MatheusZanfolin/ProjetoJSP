import exemplo.Cadastro;
// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
   

   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // bean de gerenciamento
      Cadastro cadastro;

      // setta o response content type
      response.setContentType("text/html");

      // pega qual operacao executar
      String operacao = request.getParameter("operacao"); 

      // recebe o gerenciador na forma de uma string json
      String atributo = (String) request.getAttribute("cadastro");

      // se for nulo recebe cadeia vazia
      atributo = atributo == null ? "" : atributo;

      // converte para o objeto java
      cadastro = new Gson().fromJson(atributo,  Cadastro.class);

      // executa a regra de negócio
      Cadastro.executar(cadastro, operacao);

      // setta o gerenciador no attributo da requisição em formado de uma string json
      request.setAttribute("cadastro", new Gson().parse(cadastro));
      
      // manda para o jsp
      RequestDispatcher dispatcher = context.getRequestDispatcher("/cadastroPessoa.jsp");
      dispatcher.forward(request,response);
   }
}