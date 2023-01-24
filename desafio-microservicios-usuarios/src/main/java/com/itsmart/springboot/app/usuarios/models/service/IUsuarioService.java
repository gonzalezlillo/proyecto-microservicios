package com.itsmart.springboot.app.usuarios.models.service;

import java.util.List;
import java.util.Optional;

import com.itsmart.springboot.app.usuarios.models.entity.Usuario;

public interface IUsuarioService {

	public Optional<List<Usuario>> findAll();
	public Usuario findById(Long id);
	public List<Usuario> findFirstElements(Integer limite);
	public void deleteById(Long id);
	public Usuario create(Usuario usuario);
}
