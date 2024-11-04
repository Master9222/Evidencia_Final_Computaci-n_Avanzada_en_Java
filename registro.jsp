<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css' />"> <!-- Asegúrate de que la ruta sea correcta -->
</head>
<body>
    <h1>Registro</h1>
    <form action="${pageContext.request.contextPath}/registro" method="post">
        <label for="nombreCompleto">Nombre Completo:</label>
        <input type="text" id="nombreCompleto" name="nombreCompleto" required><br>

        <label for="edad">Edad:</label>
        <input type="number" id="edad" name="edad" required><br>

        <label for="sexo">Sexo:</label>
        <select id="sexo" name="sexo" required>
            <option value="masculino">Masculino</option>
            <option value="femenino">Femenino</option>
        </select><br>

        <label for="estatura">Estatura (en metros):</label>
        <input type="text" id="estatura" name="estatura" required><br>

        <label for="nombreUsuario">Nombre de Usuario:</label>
        <input type="text" id="nombreUsuario" name="nombreUsuario" required><br>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required><br>

        <button type="submit">Registrarse</button>
    </form>
    <p>Ya tienes una cuenta? <a href="${pageContext.request.contextPath}/login">Inicia sesión aquí</a>.</p>
</body>
</html>
