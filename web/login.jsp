<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{
                font-family: arial;
                font-size: 40px
            }
            th{
                font-size: 28px;
                font-family: calibri;
            }
        </style>
    </head>
    <body>
        <h1 align="center"><b>Login</b></h1>
        <form action="Controlador" method="POST">
            <table cellpadding="1" border="0" align="center">
                <tr>
                    <th>Usuario</th>
                    <th><input type="text" name="usuario"></th>
                </tr>
                <tr>
                    <th>Clave</th>
                    <th><input type="password" name="clave"></th>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        
                        <a href="Controlador">Ingresar</a>
                        
            </td>
            </tr>
            </table>
        </form>
    </body>
</html>
