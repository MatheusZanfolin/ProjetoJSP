<%-- 
    Document   : menu.jsp
    Created on : 03/06/2018, 11:21:09
    Author     : Work
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
         <span class="navbar-brand" href="#">Espetaculos</span>
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="/ProjEspetaculo/ServletMenu?operation=inicio">Início</a>
            </li>  
            <li class="nav-item active">
              <a class="nav-link" href="/ProjEspetaculo/ServletMenu?operation=sair">Sair</a>
            </li>  
          </ul>
        </nav>
        
    </body>
</html>
