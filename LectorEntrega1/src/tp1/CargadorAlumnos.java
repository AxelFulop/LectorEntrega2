package tp1;

import java.util.ArrayList;
import java.util.List;
import model.Alumno;
import model.Asignacion;
import model.Repositories.AlumnosRepository;

import Request.RequestService;
public class CargadorAlumnos {

	public static void initialize() {
		//prueba PUT y GET alumno
		
			Alumno alu1 = RequestService.getAlumno();
			alu1.setFirst_name("Fernando");
			alu1.setLast_name("Casillas");
			RequestService.putAlumno(alu1); 
		
		//prueba GET asignaciones
			//RequestService.getAsignaciones();	
		
	}

}
