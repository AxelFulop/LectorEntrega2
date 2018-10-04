package ui.vm;

import java.util.List;

import model.Alumno;


import model.Asignacion;



import org.uqbar.commons.utils.Observable;

@Observable
public class AsignacionViewModel {

	private int code;
	private List<Asignacion> asignaciones;
	private Asignacion asignacion;
	private Alumno alumno;


	public Alumno getAlumno() {
		return alumno;
	}



	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}



	public AsignacionViewModel(Alumno alumno) {
		this.alumno = alumno;
		this.code = alumno.getCode();
		this.asignaciones = alumno.getAssignments();

	}



	public Asignacion getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int legajo) {
		this.code = legajo;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
