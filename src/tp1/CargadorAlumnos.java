package tp1;

import model.Alumno;
import model.Asignacion;
import model.Repositories.AlumnosRepository;

import java.util.List;

import Request.RequestService;
public class CargadorAlumnos {

	public static void initialize() {
		//prueba PUT y GET alumno
		
			Alumno alu1 = RequestService.getAlumno();
			List<Asignacion> asignaciones = RequestService.getAsignaciones();
			alu1.setAssignments(asignaciones);
			AlumnosRepository.getInstance().agregar(alu1);
			//alu1.setFirst_name("Fernando");
			//alu1.setLast_name("Casillas");
			//RequestService.putAlumno(alu1); 
		
		//prueba GET asignaciones
			/*List<Asignacion> asig = RequestService.getAsignaciones();	
			for(Asignacion a:asig) {
				System.out.println(a.toString());
			}*/
		
	}

}
