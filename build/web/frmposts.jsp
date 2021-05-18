<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
 
        <title>Blog de salud</title>
    </head>
    <body>
            <h1>Formulario de Blogs</h1>
           
            <br>
            <form action="Controlador" method="post" >
                Id:
                <input type="hidden" name="id" value="${posts.id}">
              
                <br>
                Fecha:
                    <input type="date"  name="fecha" value="${posts.fecha}" placeholder="Escriba fecha">                    
                <br>

                Titulo:
                    <input type="text"  name="titulo" value="${posts.titulo}">                    
                    <br> <br>
                
                Contenido:
                <textarea rows="5" cols="35" name="contenido">
                    ${posts.contenido}
                    </textarea>
                <br>
              
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
      
       
    </body>
</html>

