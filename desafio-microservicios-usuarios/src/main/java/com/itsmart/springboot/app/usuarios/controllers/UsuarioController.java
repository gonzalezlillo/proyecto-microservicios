package com.itsmart.springboot.app.usuarios.controllers;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itsmart.springboot.app.usuarios.models.entity.Usuario;
import com.itsmart.springboot.app.usuarios.models.service.IUsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping({"/listar","/listar/"})
	public Optional<List<Usuario>> listar() {
		return usuarioService.findAll();
	}
	
	@GetMapping({"/listar/{limite}","/listar/{limite}/"})
	public List<Usuario> listarPrimeros(@PathVariable Integer limite) {
		return usuarioService.findFirstElements(limite);
	}
	
	@GetMapping({"/ver/{id}","/ver/{id}/"})
	public Usuario listarPorId(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	@DeleteMapping({"/borrar/{id}","/borrar/{id}/"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarPorId(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}
	
	@PostMapping({"/crear","/crear/"})
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) {
		if(usuario.getCreatedAt() == null) { 
			usuario.setCreatedAt(LocalDate.now().toString());
		}
		return usuarioService.create(usuario);
	}
}
