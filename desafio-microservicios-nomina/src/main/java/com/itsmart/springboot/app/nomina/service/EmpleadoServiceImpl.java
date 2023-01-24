package com.itsmart.springboot.app.nomina.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.itsmart.springboot.app.nomina.models.Empleado;
import com.itsmart.springboot.app.nomina.models.Usuario;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private RestTemplate clienteRest;
	
	public EmpleadoServiceImpl(RestTemplate clienteRest) {
		this.clienteRest = clienteRest;
	}
	

	@Override
	public List<Empleado> findAll() {
		
		List<Usuario> nomina = listaUsuario();
		return nomina.stream().map(user -> new Empleado(user, 0))
				.collect(Collectors.toList());
	
		
	}
	
	public List<Usuario> listaUsuario() {
		return Arrays.asList(
				clienteRest.getForObject("http://SERVICIO-USUARIOS/listar", Usuario[].class));
	}
	

	@Override
	public Empleado findById(Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Usuario usuario = clienteRest.getForObject("http://SERVICIO-USUARIOS/ver/{id}", Usuario.class, pathVariables);
		return new Empleado(usuario);
	}

	@Override
	public Empleado findByIdRate(Long id, Integer tasaReajuste) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Usuario usuario = clienteRest.getForObject("http://SERVICIO-USUARIOS/ver/{id}", Usuario.class, pathVariables);
		return new Empleado(usuario,tasaReajuste);
	}
}
