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
		 RequestService service =  new RequestService();
		 Alumno alu1 = service.getAlumno();
		 // no serializa las notas...
		 Asignacion asignacion = service.getAsignacion();
		 List<Asignacion> asignaciones = new ArrayList<Asignacion>();
		 asignaciones.add(asignacion);
		 alu1.setAssignments(asignaciones);
		 AlumnosRepository docente = new AlumnosRepository();
		 docente.getInstance().agregar(alu1);
		 
		 
		
	}

}
