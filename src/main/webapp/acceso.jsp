<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FORMULARIO DE ACCESO</title>
    <link rel="stylesheet" href="estilo.css">

    <!-- Estilos específicos solo para esta página -->
    <style>
        body {
            background: url('imagenes/espacio.png') no-repeat center center fixed;
            background-size: cover;

            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background: rgba(255, 255, 255, 0.1);
            border: 1px solid rgba(0, 255, 255, 0.3);
            border-radius: 10px;
            padding: 30px 40px;
            backdrop-filter: blur(8px);
            box-shadow: 0 0 15px rgba(0, 255, 255, 0.4);
            width: 100%;
            max-width: 400px;
        }

        .form-container h1 {
            text-align: center;
        }
    </style>
</head>

<body>
    <% if (request.getAttribute("mensajeError") != null) { %>
        <p style="color: red;"><%= request.getAttribute("mensajeError") %></p>
    <% } %>

    <div class="form-container">
        <h1>Formulario de Acceso</h1>
        <form action="accesoServlet" method="post">
            <label for="usuario">Usuario:</label>
            <input type="text" id="usuario" name="usuario" maxlength="30" required>

            <label for="contrasenya">Contraseña:</label>
            <input type="password" id="contrasenya" name="contrasenya" maxlength="50" required>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>

