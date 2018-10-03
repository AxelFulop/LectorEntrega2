package ui.windows;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import tp1.CargadorAlumnos;

public class Main extends Application {

	

	public static void main(String[] args) {
		CargadorAlumnos.initialize();
		//new Main().start();
	}

	@Override
	protected Window<?> createMainWindow() {

		MenuAlumnos menuAlumnos = new MenuAlumnos(this);

		return menuAlumnos;
	}
}
