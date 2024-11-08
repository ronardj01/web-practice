
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
        <div class="container-md mt-5 w-75 mx-auto">
            <h1 class="h1 mb-5 text-center">Modificar Personaje</h1>
            <div class="mb-5">
                <h3 class="h3 text-center"><strong>${nombre}</strong> será modificado</h2>
                    <form class="border p-3 mt-3 text-end w-50 mx-auto" action="ModificarPersonajesController" method="POST">
                        <div class="form-floating m-3">
                            <input type="text" class="form-control pt-4 fs-3" id="floatingInput" name="nombre">
                            <label for="floatingInput">Nuevo Nombre</label>
                        </div>
                        <button class="btn btn-primary ms-3" type="submit">Insertar</button>
                    </form>
            </div>
        </div>
    </body>
</html>
