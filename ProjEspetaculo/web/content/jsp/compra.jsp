<%-- 
    Document   : compra.jsp
    Created on : 05/05/2018, 11:26:51
    Author     : Work
--%>

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
                                    <td scope="col">Taxa de Conveniência</td>
                                    <td scope="col">
                                    </td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        IMPROVÁVEL com a Cia Barbixas - 14/04/2018 21:00 
                                        SAB - Inteira/Mezanino, Ingresso 0507
                                    </td>
                                    <td>1</td>
                                    <td>R$60,00</td>
                                    <td>R$15,00</td>
                                    <td>
                                        <button type="button" class="btn btn-link">
                                            Excluir
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                            <tfoot class="table-dark">
                                <tr>
                                    <td colspan="4"></td>      
                                    <td>Total: R$75,00</td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <br/>
                    <div class="row container">
                        <button type="submit" style="margin-left:-12pt" class="btn btn-dark" name="operation" value="voltar">Voltar</button>&nbsp
                        <button type="button"  class="btn btn-dark">Finalizar</button>
                    </div>               
                </div>
            </div>
        </div>
    </form>
</body>
</html>