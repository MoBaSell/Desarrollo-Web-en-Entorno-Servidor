package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Integer>  {

}
