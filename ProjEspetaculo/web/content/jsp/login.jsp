<%-- 
    Document   : login.jsp
    Created on : 05/05/2018, 11:27:11
    Author     : Work
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: rgb(53, 119, 54);
    color: white;
    padding: 10px 18px;
    width: auto;
    border: 0;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    background-color: #8b2921;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: block; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.2); /* Black w/ opacity */
    padding-top: 60px;
    
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid ;
    width: 80%; /* Could be more or less, depending on screen size */
    max-width: 400px;
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.container-button {
    right: 0;
    background-color: #32383e;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    button {
       width: 100%;
    }
    
}
</style>
</head>
<body>

<div id="id01" class="modal">
    <form class="modal-content animate" action="/ProjEspetaculo/ServletLogin" method="POST">
    <div class="container">
      <label for="uname"><b>Usuário</b></label>
      <input type="text" placeholder="Digite seu usuário" name="uname" required>

      <label for="psw"><b>Senha</b></label>
      <input type="password" placeholder="Digite sua senha" name="psw" required>
        
    </div>

    <div class="container container-button" >
     <!-- <button type="button" class="cancelbtn">Voltar</button>-->
      <button type="submit" class="loginbtn" name="operation" value="entrar">Entrar</button>
      <button type="submit" style="color:#111111; background-color: #dddddd" name="operation" value="cadastrar">Cadastrar</button>
    </div>
  </form>
</div>
</body>
</html>