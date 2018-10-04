package ui.vm;

import java.util.List;

import model.Alumno;


import model.Asignacion;



import model.tipoTarea.Tarea;

import org.uqbar.commons.utils.Observable;

import com.google.gson.annotations.SerializedName;

@Observable
public class AsignacionViewModel {

	private int code;
	@SerializedName("assignments")
	private List<Asignacion> assignments;
	private Asignacion assignment;
	private List<Tarea> tareas;
	private Tarea tarea;

	
	public AsignacionViewModel(Alumno alumno) {
		this.code = alumno.getCode();
		this.assignments = alumno.getAssignments();

	}

	
	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Asignacion getAssignment() {
		return assignment;
	}

	public void setAssignment(Asignacion asignacion) {
		this.assignment = asignacion;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int legajo) {
		this.code = legajo;
	}

	public List<Asignacion> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Asignacion> asignaciones) {
		this.assignments = asignaciones;
	}

}
