package tp1;

import java.util.ArrayList;
import java.util.List;
import model.Alumno;
import model.Asignacion;
import model.Repositories.AlumnosRepository;

import Request.RequestService;
public class CargadorAlumnos {

	public static void initialize() {
		
		//obtengo el alumno del server y lo agrego al repo
		Alumno alu1 = RequestService.getAlumno();
		 // no serializa las notas...
		Asignacion asignacion = RequestService.getAsignacion();
		List<Asignacion> asignaciones = new ArrayList<Asignacion>();
		asignaciones.add(asignacion);
		alu1.setAssignments(asignaciones);
		AlumnosRepository.getInstance().agregar(alu1);
		 
		//RequestService.putAlumno("first_name","Antonio"); // me tira error 500
		
	}

}
