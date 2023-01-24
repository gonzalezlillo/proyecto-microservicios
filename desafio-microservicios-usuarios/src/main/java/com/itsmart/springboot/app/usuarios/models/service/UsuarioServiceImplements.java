package com.itsmart.springboot.app.usuarios.models.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itsmart.springboot.app.usuarios.models.dao.IUsuarioDao;
import com.itsmart.springboot.app.usuarios.models.entity.Usuario;

@Service
public class UsuarioServiceImplements implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public Optional<List<Usuario>> findAll() {
		return Optional.ofNullable((List<Usuario>) usuarioDao.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findFirstElements(Integer limite) {
		return ((Collection<Usuario>) usuarioDao.findAll())
				.stream().limit(limite)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
	}
	
	@Override
	@Transactional
	public Usuario create(Usuario usuario) {
		return usuarioDao.save(usuario);
	}
}
