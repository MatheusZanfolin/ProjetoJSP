<%-- 
    Document   : index.jsp
    Created on : 05/05/2018, 11:27:01
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
    <title>Ingressos</title>

    <script>
        const containers = [
            "container-espetaculo",
            "container-data",
            "container-horario",
            "container-ingresso"
        ];

        let contador = ${passo};

        anterior = () => {
            if (contador > 0){
                contador --;
            }
            mudarPagina();
        };
        proximo = () => {
            if (contador < (containers.length - 1)){
                contador ++;
            }
            mudarPagina();
        };

        mudarPagina = () => {
            for (i = 0; i < containers.length; i++){
                document.getElementById(containers[i]).style.display = 
                    i === contador ? 'block' : 'none';
            }
        };
    </script>
</head>

<body onload="mudarPagina()">
    <form action="/ProjEspetaculo/ServletAssentos">
        <div class="card" id="container-espetaculo">
            <div class="card-header">
                <span class="number-title">1</span>- Escolha uma Espetáculo
            </div>
            <div class="card-body">
                <select class="form-control">
                    <option>IMPROVÁVEL com a Cia Barbixas, 14 ANOS</option>
                    <option>ALICE NO PAÍS DAS MARAVILHAS, LIVRE</option>
                    <option>O QUEBRA NOZES, 10 ANOS</option>
                </select>
                <br/>
                <div class="row container">
                    <button type="button" onclick="anterior()" class="btn btn-dark" disabled>Anterior</button>&nbsp
                    <button type="button" onclick="proximo()" class="btn btn-dark" >Próximo</button>
                </div>  
            </div>

        </div>

        </div>
        <div class="card" id="container-data">
            <div class="card-header">
                <span class="number-title">2</span> - Escolha uma data abaixo
            </div>
            <div class="card-body">
                <input  class="form-control" type="date" />
                <br/>
                <div class="row container">
                    <button type="button" onclick="anterior()" class="btn btn-dark">Anterior</button>&nbsp
                    <button type="button" onclick="proximo()" class="btn btn-dark">Próximo</button>
                </div> 
            </div>
        </div>
        <div class="card"  id="container-horario">
            <div class="card-header">
                <span class="number-title">3</span> - Escolha o horário
            </div>
            <div class="card-body">
                <div class="form-check">
                    <input name="horario1" class="form-check-input" type="radio" value="14/04/2018 19:00 SAB" />
                    <label class="form-check-label" for="horario1">14/04/2018 19:00 SAB</label>
                </div>
                <div class="form-check">
                    <input name="horario2" class="form-check-input" type="radio" value="14/04/2018 19:00 SAB" />
                    <label class="form-check-label" for="horario2">14/04/2018 21:00 SAB</label>
                </div>
                <br/>
                <div class="row container">
                    <button type="button" onclick="anterior()" class="btn btn-dark">Anterior</button>&nbsp
                    <button type="button" onclick="proximo()" class="btn btn-dark">Próximo</button>
                </div> 
            </div> 
        </div>
    <!--    <div class="card">
            <div class="card-header">
                <span class="number-title">4</span> - Escolha o setor
            </div>
            <div class="card-body">
                <select class=".form-control">
                    <option>SETOR A</option>
                    <option>SETOR B</option>
                    <option>MEZANINO</option>
                </select>
            </div>
        </div> -->
        <div class="card"  id="container-ingresso">
            <div class="card-header">
                <span class="number-title">4</span> - Escolha a quantidade de ingressos
            </div>
            <div class="card-body">
                <div>
                    Total de ingressos disponibilizados à venda no setor: 164
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
                        <tr>
                            <td>Inteira **Esgotado</td>
                            <td><input type="number"/></td>
                            <td>R$ 70,00</td>
                        </tr>
                        <tr>
                            <td>UFES **Esgotado</td>
                            <td><input type="number"/></td>
                            <td>R$ 35,00</td>
                        </tr>
                        <tr>
                            <td>Estudante **Esgotado</td>
                            <td><input type="number"/></td>
                            <td>R$ 35,00</td>
                        </tr>
                    </tbody>
                </table>

                <div class="row container">
                    <button type="button" onclick="anterior()" class="btn btn-dark">Anterior</button>&nbsp
                    <button type="submit" class="btn btn-dark" name="operation" value="selecionar">Selecionar Assentos</button>
                </div> 
            </div> 
        </div>
    </form>
</body>
</html>