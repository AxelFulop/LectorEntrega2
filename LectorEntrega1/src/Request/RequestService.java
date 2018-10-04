package Request;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import model.Alumno;
import model.Asignacion;

public class RequestService {
	 

	 private static String API = "http://notitas.herokuapp.com/";
 	 private static String RECURSO_ALUMNO = "student";
 	 private static String RECURSO_ALUMNO_ASIGNACIONES = "student/assignments";
	 private static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
    
	 //FUNCIONA
	 public static Alumno getAlumno() {
	        Client client = Client.create();

	        ClientResponse response = client
	                .resource(API)
	                .path(RECURSO_ALUMNO)
	                .header("Authorization", "Bearer " + TOKEN)
	                .accept(MediaType.APPLICATION_JSON)
	                .get(ClientResponse.class);

	        if (response.getStatus() != 200) {
	            throw new RuntimeException("Error GET de alumno, error response : "
	                    + response.getStatus());
	        }

	        String output = response.getEntity(String.class);
	        System.out.println(output);
	        
	        Gson gson = new Gson();
	        Alumno alumno = gson.fromJson(output, Alumno.class);
	        return alumno;
	    }
	 
	 public static List<Asignacion> getAsignaciones() {
		 List<Asignacion> listaAsig = new ArrayList<Asignacion>();
		 
	        Client client = Client.create();
	        ClientResponse response = client
	                				  .resource(API)
	                				  .path(RECURSO_ALUMNO_ASIGNACIONES)
	                				  .header("Authorization", "Bearer " + TOKEN)
	                				  .accept(MediaType.APPLICATION_JSON_TYPE)
	                				  .get(ClientResponse.class);
	                				  //.get(new GenericType<List<Asignacion>>() {});

	        if (response.getStatus() != 200) {
	            throw new RuntimeException("Error GET de alumno, error response : "
	                    					+ response.getStatus());
	        }
	       
	        String output = response.getEntity(String.class);
	        System.out.println(output);
	        
	        //FALTA MAPEAR EL JSON A LA LISTA DE ASIGNACIONES
	       
	        return listaAsig;
	    }
	 
	


	 	//FUNCIONA
	    public static void putAlumno(Alumno alumno) {
	    	try {
	    		
	    		String body =  " {\"first_name\":\" "+alumno.getFirst_name()+" \","
	    						+" \"last_name\":\" "+alumno.getLast_name()+" \","
	    				        +" \"github_user\":\" " +alumno.getGithub_user() +"\" }";

	    	
	    		Client client = Client.create();
	    		WebResource web = client.resource(API).path(RECURSO_ALUMNO);
	    		ClientResponse response = web.header("Authorization", "Bearer " + TOKEN)
	    								 	 .accept(MediaType.APPLICATION_JSON_TYPE)
	    								 	 .put(ClientResponse.class,body); 
	    		if (response.getStatus() != 201) {
	    			throw new RuntimeException("Error PUT de alumno, error response : "
	    									   + response.getStatus());
	    		}
	    	
	    		String output = response.getEntity(String.class);
            
	    		System.out.println(output);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	         
	    }

}


