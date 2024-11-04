<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css' />"> 
</head>
<body>
    <h1>Iniciar Sesión</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="username">Nombre de Usuario:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required><br>

        <button type="submit">Iniciar Sesión</button>
    </form>
    <p>No tienes una cuenta? <a href="${pageContext.request.contextPath}/registro">Regístrate aquí</a>.</p>
</body>
</html>
