<%-- 
    Document   : compra.jsp
    Created on : 05/05/2018, 11:26:51
    Author     : Work
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <title>Compra</title>

</head>
<body>
    <jsp:include page="./menu.jsp"/>
    <form action="/ProjEspetaculo/ServletCompra" method="POST">
        <div id="container-conta" class="card">
            <div class="card-header">
                Minha Compra
            </div>
            <div class="card-body">
                <div class="container-fluid">
                    <div class="row">
                        <span>Revise atentamente os dados do seu pedido.</span>
                    </div> 
                    <br/>
                    <div class="row">
                       <table class="table table-striped">
                            <thead class="table-dark">
                                <tr>
                                    <td scope="col">Ingresso/Setor</td>
                                    <td scope="col">Quantidade</td>
                                    <td scope="col">Valor</td>
                                </tr>
                            </thead>
                            <tbody>
                              <c:forEach items="${bean.compra.listaResumoCompra}" var="resumo">
                                    <tr>
                                        <td>
                                            ${resumo.ingressoSetor}
                                        </td>
                                        <td>
                                            ${resumo.quantidade}
                                        </td>
                                        <td>
                                            ${resumo.valorFormatado}
                                        </td>
                                    </tr>
                                </c:forEach>                               
                            </tbody>
                            <tfoot class="table-dark">
                                <tr>
                                    <td colspan="2">Taxa de Conveniência: ${bean.compra.convenienciaFormatado}</td>      
                                    <td colspan="2">Total: ${bean.compra.totalFormatado}</td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <br/>
                    <div class="row container">
                        <button type="submit"  name="operation" value="finalizar" class="btn btn-dark">Finalizar</button>
                    </div>               
                </div>
            </div>
        </div>
    </form>
</body>
</html>