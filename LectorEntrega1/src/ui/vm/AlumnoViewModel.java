package ui.vm;

import model.*;
import model.Repositories.AlumnosRepository;


import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class AlumnoViewModel

{

	private Alumno alumno;
	private String first_name;
	private String last_name;
	private int code;
	private String github_user;
	
	
	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getGithub_user() {
		return github_user;
	}



	public void setGithub_user(String github_user) {
		this.github_user = github_user;
	}

	public AlumnoViewModel(Alumno unAlumno) {
		this.alumno = unAlumno;
		this.last_name = this.alumno.getLast_name();
		this.code = alumno.getCode();
		this.github_user = alumno.getGithub_user();
		this.first_name = this.alumno.getFirst_name();

	}



	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
		
	}

	
	public Alumno getAlumno() {
		return alumno;
	}


}
