
package com.emergentes.dao;

import com.emergentes.modelo.Posts;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostsDAOimpl extends ConexionDB implements PostsDAO{
     @Override
    public void insert(Posts posts) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO posts (fecha,titulo,contenido) values (?,?,?)");
            ps.setDate(1,   posts.getFecha());
            ps.setString(2, posts.getTitulo());
            ps.setString(3, posts.getContenido());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Posts posts) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE posts SET fecha = ?, titulo = ?, contenido = ? where id = ?");
            ps.setDate(1, posts.getFecha());
            ps.setString(2, posts.getTitulo());
            ps.setString(3, posts.getContenido());
            ps.setInt(4, posts.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM posts WHERE id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Posts getById(int id) throws Exception {
       Posts cli = new Posts();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM posts WHERE id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                cli.setId(rs.getInt("id"));
                cli.setFecha(rs.getDate("fecha"));
                cli.setTitulo(rs.getString("titulo"));
                cli.setContenido(rs.getString("contenido"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Posts> getAll() throws Exception {
        List<Posts> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT* FROM posts");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Posts>();
            while (rs.next()){
                Posts cli =  new Posts();
                
                cli.setId(rs.getInt("id"));
                cli.setFecha(rs.getDate("fecha"));
                cli.setTitulo(rs.getString("titulo"));
                cli.setContenido(rs.getString("contenido"));
                
                lista.add(cli);
            }
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
