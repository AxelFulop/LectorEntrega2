package ui.vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Alumno;
import model.Repositories.AlumnosRepository;

@Observable
public class BuscadorAlumnoModel {

	private int code;
	private Alumno resultado;
	private List<Alumno> alumnos;

	public BuscadorAlumnoModel() {

		this.alumnos = AlumnosRepository.getInstance().all();
	}

	public int getLegajo() {
		return code;
	}

	public void setLegajo(int legajo) {
		this.code = legajo;
	}

	public void setResultado(Alumno resultado) {
		this.resultado = resultado;
	}

	public Alumno getResultado() {
		return resultado;
	}

	public void search() {
		this.resultado = AlumnosRepository.getInstance().search(this.code);
	}

}
