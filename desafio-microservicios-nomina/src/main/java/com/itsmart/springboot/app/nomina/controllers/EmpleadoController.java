package com.itsmart.springboot.app.nomina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itsmart.springboot.app.nomina.models.Empleado;
import com.itsmart.springboot.app.nomina.service.IEmpleadoService;

@RestController
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping({"/listar","/listar/"})
	public List<Empleado> listar() {
		return empleadoService.findAll();
	}
	
	@GetMapping({"/ver/{id}","/ver/{id}/"})
	public Empleado verEmpleado(@PathVariable Long id) {
		return empleadoService.findById(id);
	}
	
	@GetMapping({"/ver/{id}/tasa/{tasaReajuste}","/ver/{id}/tasa/{tasaReajuste}/"})
	public Empleado probarTasa(@PathVariable Long id, @PathVariable Integer tasaReajuste) {
		return empleadoService.findByIdRate(id,tasaReajuste);
	}
}
