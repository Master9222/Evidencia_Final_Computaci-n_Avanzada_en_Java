<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado del IMC</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css' />"> <!-- Asegúrate de que la ruta sea correcta -->
</head>
<body>
    <h1>Resultado del IMC</h1>
    <p>Tu IMC es: ${imc}</p>

    <c:choose>
        <c:when test="${imc < 18.5}">
            <p>Estás bajo de peso.</p>
        </c:when>
        <c:when test="${imc >= 18.5 && imc < 24.9}">
            <p>Tienes un peso normal.</p>
        </c:when>
        <c:when test="${imc >= 25 && imc < 29.9}">
            <p>Tienes sobrepeso.</p>
        </c:when>
        <c:otherwise>
            <p>Estás obeso.</p>
        </c:otherwise>
    </c:choose>

    <a href="${pageContext.request.contextPath}/calculo">Calcular nuevamente</a>
</body>
</html>
