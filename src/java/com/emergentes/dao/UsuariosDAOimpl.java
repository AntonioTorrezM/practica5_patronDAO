package com.emergentes.dao;

import com.emergentes.modelo.Usuarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOimpl extends ConexionDB implements UsuariosDAO{
     @Override
    public Usuarios getById(int id) throws Exception {
        Usuarios cli = new Usuarios();
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                cli.setId(rs.getInt("id"));
                cli.setUsuario(rs.getString("usuario"));
                cli.setPassword(rs.getString("password"));
                
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Usuarios> getAll() throws Exception {
       List<Usuarios> lista = null;
        try {
            this.conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Usuarios>();
            while (rs.next()){
                Usuarios cli =  new Usuarios();
                
                cli.setId(rs.getInt("id"));
                cli.setUsuario(rs.getString("usuario"));
                cli.setPassword(rs.getString("password"));

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