package com.itsmart.springboot.app.usuarios.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.itsmart.springboot.app.usuarios.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
