<%-- 
    Document   : cadastro.jsp
    Created on : 05/05/2018, 11:26:35
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
    <title>Cadastro</title>

    <script>
        const containers = [
            "container-pessoal",
            "container-endereco",
            "container-conta",
        ];

        let contador = 0;

        anterior = () => {
            if (contador > 0){
                contador --;
            }
            mudarPagina();
        }
        proximo = () => {
            if (contador < (containers.length - 1)){
                contador ++;
            }
            mudarPagina();
        }

        mudarPagina = () => {
            for (i = 0; i < containers.length; i++){
                document.getElementById(containers[i]).style.display = 
                    i == contador ? 'block' : 'none';
            }
        }
    </script>
</head>
<body onload="mudarPagina();">
    <div  id="container-pessoal" class="card">
        <div class="card-header">
            Dados pessoais
        </div>
        <div class="card-body">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome"/>
                    </div>
                    <div class="col-sm">
                        <label for="pais">País*</label>
                        <select id="pais" name="pais" class="form-control">
                            <option>Brasil</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <label for="">CPF</label>
                        <input type="text" class="form-control" id="" name="cpf"/>
                    </div>
                    <div class="col-sm">
                        <label for="">Sexo</label><br/>
                        <div class="form-check" style="display:inline-block">
                            <input name="sexo" class="form-check-input" type="radio" value="M" />
                            <label class="form-check-label" for="">Masculino</label>
                        </div>
                        <div class="form-check" style="display:inline-block">
                            <input name="" class="form-check-input" type="radio" value="F" />
                            <label class="form-check-label" for="">Feminino</label>
                        </div>
                    </div>    
                </div>
                <div class="row">
                    <div class="col-sm">
                        <label for="">Data de Nascimento*</label>
                        <input type="date"  name="dtNascimento" class="form-control" id=""/>
                    </div>
                    <div class="col-sm">
                        <label for="">Telefone*</label>
                        <input type="number"  name="telefone" class="form-control" id=""/>
                    </div>
                </div>
                <br/>
                <div class="row container">
                    <button type="button" onclick="anterior()" class="btn btn-dark" disabled>Anterior</button>&nbsp
                    <button type="button" onclick="proximo()" class="btn btn-dark">Próximo</button>
                </div>
            </div>
        </div>
    </div>
    <div id="container-endereco" class="card">
        <div class="card-header">
            Dados do Endereço
        </div>
        <div class="card-body">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl">
                        <label for="">CEP*</label>
                        <input type="text" class="form-control" id=""  name="cep"/>
                    </div>
                    <div class="col-md">
                        <label for="">Endereço*</label>
                        <input type="text" class="form-control" id=""  name="endereco"/>
                    </div>
                    <div class="col-sm">
                        <label for="">Número*</label>
                        <input type="number"  class="form-control" id=""  name="numero"/>
                    </div>
                    <div class="col-xl">
                        <label for="">Complemento</label>
                        <input type="text" class="form-control" id=""  name="complemento"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <label for="">Bairro*</label>
                        <input type="text" class="form-control" id="" name="bairo"/>
                    </div>
                    <div class="col">
                        <label for="">Cidade*</label>
                        <input type="text" class="form-control" id="" name="cidade"/>
                    </div>
                    <div class="col">
                        <label for="estado">Estado*</label>
                        <select id="estado" class="form-control" name="estados">
                            <option>São Paulo</option>
                            <option>Mato Grosso</option>
                            <option>Bahia</option>
                        </select>
                    </div>
                </div>   
                <br/>
                <div class="row container">
                    <button type="button" onclick="anterior()" class="btn btn-dark">Anterior</button>&nbsp
                    <button type="button" onclick="proximo()" class="btn btn-dark">Próximo</button>
                </div>                         
            </div>
        </div>
    </div>

    <div id="container-conta" class="card">
        <div class="card-header">
            Dados da conta
        </div>
        <div class="card-body">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl">
                        <label for="">Email*</label>
                        <input type="email" class="form-control" id="" name="email"/>
                    </div>
                    <div class="col-md-6">
                        <label for="">Senha*</label>
                        <input type="password" class="form-control" id="" name="senha"/>
                    </div>
                    <div class="col-md-6">
                        <label for="">Confirmar senha*</label>
                        <input type="password" class="form-control" id="" name="confirmacaoSenha"/>
                    </div>
                </div> 
                <br/>
                <div class="row container">
                    <button type="button" onclick="anterior()" class="btn btn-dark">Anterior</button>&nbsp
                    <button type="button" onclick="proximo()" class="btn btn-dark">Finalizar</button>
                </div>               
            </div>
        </div>
    </div>
</body>

</html>