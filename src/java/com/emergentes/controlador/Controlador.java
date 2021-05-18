
package com.emergentes.controlador;

import com.emergentes.dao.PostsDAO;
import com.emergentes.dao.PostsDAOimpl;
import com.emergentes.modelo.Posts;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Posts cli = new Posts();
            int id;
            PostsDAO dao = new PostsDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("posts", cli);
                    request.getRequestDispatcher("frmposts.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli =  dao.getById(id);
                    request.setAttribute("posts", cli);
                    request.getRequestDispatcher("frmposts.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Controlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Posts> lista = dao.getAll();
                    request.setAttribute("posts",lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                    
                default:
                    break;
            }
            
        }catch(Exception ex){
            System.out.println("Error en doget" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SimpleDateFormat forma= new SimpleDateFormat("yyyy-MM-dd");
        
        int id = Integer.parseInt(request.getParameter("id"));
        Date fecha;
        Posts cli = new Posts();
        try{
        fecha = forma.parse(request.getParameter("fecha"));
        
        cli.setFecha((java.sql.Date) fecha);
        }catch(Exception ex)
        { 
            System.out.println("Error al editar "+ex.getMessage());
        }
        String titulo =  request.getParameter("titulo");
        String contenido =  request.getParameter("contenido");
        
        
        cli.setId(id);
        
        cli.setTitulo(titulo);
        cli.setContenido(contenido);
        
        
        PostsDAO dao = new PostsDAOimpl();
        if (id == 0){
            try {
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        response.sendRedirect("Controlador");
    }
 
}
