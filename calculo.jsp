<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Cálculo de IMC</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css' />">
</head>
<body>
    <h1>Cálculo de IMC</h1>
    <form action="${pageContext.request.contextPath}/api/calculo" method="post">
        <label for="estatura">Estatura (en metros):</label>
        <input type="text" id="estatura" name="estatura" required><br>

        <label for="masaCorporal">Masa Corporal (en kg):</label>
        <input type="text" id="masaCorporal" name="masaCorporal" required><br>

        <button type="submit">Calcular IMC</button>
    </form>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
</body>
</html>
