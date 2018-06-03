<%-- 
    Document   : index.jsp
    Created on : 05/05/2018, 11:27:01
    Author     : Work
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/ProjEspetaculo/content/css/comum.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        <title>Ingressos</title>

    </head>

    <body>
        <jsp:include page="./menu.jsp"/>
        <form action="/ProjEspetaculo/ServletEspetaculos" method="POST">
            <c:if test="${not empty bean}">
                <input type="hidden" value="${bean.passo}" id="input-passo"/>
                <input type="hidden" name="formEspetaculo" value="${bean.compra.espetaculo.codEspetaculo}"/>
                <input type="hidden" name="formQtdIngressosDisponiveis" value="${bean.qtdIngressosDisponiveis}"/>

                <div class="card" style="display: ${empty erro ? 'none' : 'block'}">
                    <div class="alert alert-danger">
                        <strong>Erro!</strong> ${erro}
                    </div>
                </div>
                <c:if test="${bean.passo >= 0}">
                    <div class="card" id="container-espetaculo">
                        <div class="card-header">
                            <span class="number-title">1</span>- Escolha uma Espetáculo
                        </div>
                        <div class="card-body">
                            
                            <div style="display: ${bean.passo == 0 ? 'block' : 'none'}">
                                <select class="form-control" name="espetaculo" value="${empty bean.compra.espetaculo ? 0 : bean.compra.espetaculo.codEspetaculo}">
                                    <option value="${bean.codEspetaculoSelecionado}">Selecione um Espetáculo</option>
                                    <c:forEach items="${bean.listaEspetaculos}" var="item">
                                        <option value="${item.codEspetaculo}">${item.nome}</option>
                                    </c:forEach>
                                </select>
                                <br/>
                                <div class="row container">               
                                    <button type="submit" class="btn btn-dark" name="operation" value="selecionarEspetaculos">Próximo</button>
                                </div>  
                            </div>
                            <c:if test="${bean.passo != 0}">
                                ${bean.compra.espetaculo}
                            </c:if>                       
                        </div>
                    </div>
                </c:if>                        
                <c:if test="${bean.passo >= 1}">
                    <div class="card" id="container-data">
                        <div class="card-header">
                            <span class="number-title">2</span> - Escolha uma data abaixo
                        </div>
                        <div class="card-body">
                            <div style="display: ${bean.passo == 1 ? 'block' : 'none'}">
                                <select class="form-control" name="dtEspetaculo" value="${bean.compra.dataEspetaculo}" >
                                    <option value="${bean.compra.dataEspetaculo}">Selecione uma Data</option>
                                    <c:forEach items="${bean.compra.espetaculo.datasApresentacao}" var="data">
                                        <option value="${data.toString()}">${data.toString()}</option>
                                    </c:forEach>
                                </select>
                                <br/>
                                <div class="row container">                    
                                    <button type="submit" name="operation" value="selecionarDtEspetaculo" class="btn btn-dark">Próximo</button>
                                </div> 
                            </div>
                            <c:if test="${bean.passo != 1}">
                                ${bean.compra.dataEspetaculo}
                            </c:if>
                        </div>
                    </div>
                </c:if>
                <c:if test="${bean.passo >= 2}">
                    <div class="card"  id="container-ingresso">
                        <div class="card-header">
                            <span class="number-title">3</span> - Escolha a quantidade de ingressos
                        </div>
                        <div class="card-body">
                            <div>
                                Total de ingressos disponíveis: ${bean.qtdIngressosDisponiveis}
                            </div>
                            <br/>
                            <table class="table table-striped">
                                <thead class="table-dark">
                                    <tr>
                                        <td scope="col">Tipo</td>
                                        <td scope="col">Quantidade</td>
                                        <td scope="col">Total</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${bean.listaTipoIngresso}" var="tipoIngresso">
                                        <tr>
                                            <td>${tipoIngresso.label}</td>
                                            <td><input name="qtdIngressos${tipoIngresso.codTipo}" type="number"/></td>
                                            <td>${tipoIngresso.valorFormatado}</td>
                                        </tr>
                                    </c:forEach>                       
                                </tbody>
                            </table>

                            <div class="row container">
                                <!--<button type="button" onclick="anterior()" class="btn btn-dark">Anterior</button>&nbsp-->
                                <button type="submit" class="btn btn-dark" name="operation" value="selecionarTipoIngresso">Selecionar Assentos</button>
                            </div> 
                        </div> 
                    </div>
                </c:if>
            </c:if>
        </form>
    </body>
</html>