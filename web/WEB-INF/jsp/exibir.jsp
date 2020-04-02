<%-- 
    Document   : exibir
    Created on : 16/03/2020, 17:07:01
    Author     : raphael.brangioni
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Cadastros</title>
</head>
<section style="background: #117a8b" class="chamado">
    <h1>Cadastros já Efetuados</h1>
</section>

<body>
    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>E-mail</th>
                </tr>
            </thead>

            <c:forEach items="${lista}" var="atributo">
                <tr>
                    <td>${atributo.id}</td>
                    <td>${atributo.nome}</td>
                    <td>${atributo.endereco}</td>
                    <td>${atributo.telefone}</td>
                    <td>${atributo.email}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="col-md-6 cadastro">
         <a href="bem-vindo" class="btn-primary" value="Consultar">Voltar</a>
    </div>
</body>

