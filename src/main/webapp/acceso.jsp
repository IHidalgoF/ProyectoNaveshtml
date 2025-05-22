<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% if (request.getAttribute("mensajeError") != null) { %>
    <p style="color: red;"><%= request.getAttribute("mensajeError") %></p>
<% } %>

<meta charset="UTF-8">
<title>FORMULARIO DE ACCESO</title>
 <link rel="stylesheet" href="estilo.css">
</head>

<body>
<h1>FORMULARIO DE ACCESO</h1>
   <div class="form-container">
       <form action="accesoServlet" method="post">
           <label for="Usuario">Usuario:</label><br>
           <input type="text" id="usuario" name="usuario" maxlength="30" required><br><br>

           <label for="Contraseña">Contraseña:</label><br>
           <input type="text" id="contrasenya" name="contrasenya" maxlength="50" required><br><br>

           <button type="submit">Loggin</button>
       </form>
   </div>
</body>
</html>