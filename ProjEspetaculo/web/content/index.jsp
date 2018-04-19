<%-- 
    Document   : index
    Created on : 12/04/2018, 20:37:48
    Author     : Work
--%>

<%@page import="web.Pessoa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    pageContext.setAttribute("matheus", new Pessoa("matheus"));
    pageContext.setAttribute("michelle", new Pessoa("michelle"));
    pageContext.setAttribute("ola", "ola");
    pageContext.setAttribute("celio", new Pessoa("celio"));
%>
<!DOCTYPE html>
<html>   
        <c:set scope="page" var="dois" value="2"/>
        <c:set var="soma" value="${(x,y)-> x + y}"/>
        <c:set var="pessoas" value="${['matheus', 'joao','maria']}"/>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    
    <body>
        <h1>
            ${soma(2, 3)}
            ${pessoas.stream().filter(p -> p.charAt(0) eq 'j').toList()}
            ${dois}
            ${ola}
            ${matheus}
            ${matheus.filho(michelle)}
            ${matheus.setNome("gatão")}
            ${matheus.filho(michelle)}
        </h1>
        <input type="button" value="salvar" onclick="() -> ${matheus.salvar}"/>
    </body>
</html>
