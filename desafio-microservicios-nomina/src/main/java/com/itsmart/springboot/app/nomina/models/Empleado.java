package com.itsmart.springboot.app.nomina.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Empleado {

	private Usuario usuario;
	private Integer tasaReajuste;
	
	public Empleado() {	}
	
	public Empleado(Usuario usuario) {
		this.usuario = usuario;
		this.tasaReajuste = 0;
	}

	public Empleado(Usuario usuario, Integer tasaReajuste) {
		this.usuario = usuario;
		this.tasaReajuste = tasaReajuste;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getTasaReajuste() {
		return tasaReajuste;
	}

	public void setTasaReajuste(Integer tasaReajuste) {
		this.tasaReajuste = tasaReajuste;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(usuario, other.usuario);
	}

	private Period periodAntiguedad() {
		LocalDate fechaActual = LocalDate.now();
		LocalDate ingreso = LocalDate.parse(usuario.getCreatedAt());
		return Period.between(ingreso, fechaActual);
	}
	
	public String getAntiguedad() {
		Period p = periodAntiguedad();
		return p.getYears()+" años, "+p.getMonths()+" meses y "+p.getDays()+" días";
	}
	
	public Float getFactorReajuste() {
		return  1F + (float) periodAntiguedad().getYears() * tasaReajuste / 100;
	}
	
	
}
