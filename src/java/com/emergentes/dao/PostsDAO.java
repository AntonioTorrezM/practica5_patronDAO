
package com.emergentes.dao;

import com.emergentes.modelo.Posts;
import java.util.List;

public interface PostsDAO {
      public void insert(Posts posts) throws Exception;
    public void update(Posts posts) throws Exception;
    public void delete(int id) throws Exception;
    public Posts getById(int id) throws Exception;
    public List<Posts> getAll() throws Exception;
}