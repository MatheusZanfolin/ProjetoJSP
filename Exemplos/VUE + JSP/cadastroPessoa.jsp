
<!DOCTYPE html>
<html>
<head>
	<title>Vue + Java El</title>
	<script>
		var app = new Vue({
		  el: '#app',
		  data: {
		  	cadastro: JSON.parse(${cadastro})
		  }
		});
	</script>
</head>
<body>
	<div id="app">
	  <input type="hidden" v-model="cadastro" name="cadastro">
	  <ol>
	    <li v-for="pessoa in cadastro.pessoas">
	      {{ pessoa.nome }} <br>
	      <input type="text" v-model="pessoa.nome">

	      {{ pessoa.idade }}<br>
	      <input type="number" v-model="pessoa.idade">
	    </li>
	  </ol>
	</div>
</body>
</html>


