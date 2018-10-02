package ui.windows;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import tp0.CargadorAlumnosTp0;
import tp1.CargadorAlumnos;
import model.Alumno;
import model.Repositories.AlumnosRepository;

public class Main extends Application {

	

	public static void main(String[] args) {
		CargadorAlumnos cargador = new CargadorAlumnos();
		cargador.initialize();
		new Main().start();
	}

	@Override
	protected Window<?> createMainWindow() {

		MenuAlumnos menuAlumnos = new MenuAlumnos(this);

		return menuAlumnos;
	}
}
