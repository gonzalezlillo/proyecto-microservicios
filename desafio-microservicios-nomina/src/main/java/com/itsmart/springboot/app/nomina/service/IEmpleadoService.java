package com.itsmart.springboot.app.nomina.service;

import java.util.List;

import com.itsmart.springboot.app.nomina.models.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	public Empleado findById(Long id);
	public Empleado findByIdRate(Long id,Integer tasaReajuste);
}
