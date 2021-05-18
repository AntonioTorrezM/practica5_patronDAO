package com.emergentes.dao;

import java.util.List;
import com.emergentes.modelo.Usuarios;
public interface UsuariosDAO {
      public Usuarios getById(int id) throws Exception;
    public List<Usuarios> getAll() throws Exception;
}

