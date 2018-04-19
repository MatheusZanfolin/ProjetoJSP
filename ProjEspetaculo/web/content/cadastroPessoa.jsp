<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Vue + Java El</title>
    <meta charset="UTF-8"/>
    <script src="content/js/vue/vue.js"></script>
</head>
<body>
    <div id="app">
        <form method="post" action="CadastroServlet">
            <input type="hidden" value="" name="cadastro" id="cadastro"/>
            <ol>
              <li v-for="pessoa in cadastro.pessoas">
                <input type="text" v-model="pessoa.nome">
                <input type="number" v-model="pessoa.idade">
              </li>
            </ol>

            <input type="button" name="operacao" value="alert">
            <input type="submit" name="operacao" value="salvar" >
         </form>
    </div>

    <script>
        var gerenciador =  <%= request.getAttribute("cadastro") %>
        var app = new Vue({
          el: '#app',
          data: {
            cadastro: gerenciador
          },
          updated: function(){doChange.bind(this)();},
          created: function(){doChange.bind(this)();}
        });
        
        function doChange(){
            document.getElementById("cadastro").value = JSON.stringify(this.cadastro);
        }
    </script>
</body>
</html>


