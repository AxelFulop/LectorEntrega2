package model;


import java.util.ArrayList;
import java.util.List;

import model.tipoNota.Nota;



import model.tipoTarea.Tarea;

import org.uqbar.commons.utils.Observable;

import com.google.gson.annotations.SerializedName;

@Observable
public class Asignacion {

  private String nombre;
  private List<Tarea> tareas = new ArrayList<Tarea>();
	
  public Asignacion(String nombre,List<Tarea> tareas) {
		this.nombre = nombre;
		this.tareas = tareas;
	}

	public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public List<Tarea> getTareas() {
	return tareas;
}


public void setTareas(List<Tarea> tareas) {
	this.tareas = tareas;
}


}