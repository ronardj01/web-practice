
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container mt-5">
            <jsp:include page="IncludeNav.jsp"/>
            <p class="text-danger text-center fs-2">Estas seguro que deseas eliminar al personaje <Strong class="text-primary">${nombre}</Strong></p>
            <form class="text-center" action="DeletePersonajeController" method="POST" >
                <input type="hidden" value="${id}" name="id">
                <button class="btn btn-danger fs-3">Confirmar</button>
            </form>
        </div>
    </body>
</html>
