package Request;


import java.lang.reflect.Type;
import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.research.ws.wadl.Response;
import com.google.gson.Gson;



import com.google.gson.reflect.TypeToken;



import javax.ws.rs.core.MediaType;



import model.Alumno;
import model.Asignacion;

public class RequestService {
	 

	 private static String API = "http://notitas.herokuapp.com/";
 	 private static String RECURSO_ALUMNO = "student";
 	 private static String RECURSO_ALUMNO_ASIGNACIONES = "student/assignments";
	 private static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
    
	 public Alumno getAlumno() {
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

	        Gson gson = new Gson();
	        Alumno alumno = gson.fromJson(output, Alumno.class);
	        return alumno;
	    }
	 
	 
	 //Por mas que le pase un parametro trae siempre al mismo alumno...
	 
	 public Alumno getAlumnoConFiltro(String param,String value ){
        Client client = Client.create();
		WebResource web = client.resource(API).path(RECURSO_ALUMNO);
        ClientResponse clientWithParameter =                web.queryParam(param, value).
				                                            header("Authorization", "Bearer " + TOKEN).
	    		                                            accept(MediaType.APPLICATION_JSON).
	    		                                            get(ClientResponse.class);
	        
	        if ( clientWithParameter.getStatus() != 200) {
	            throw new RuntimeException("Error GET de alumno, error response : "
	                    +  clientWithParameter.getStatus());
	        }

	     
	     String output = clientWithParameter.getEntity(String.class);
	     
	     System.out.println(output);
	     Gson gson = new Gson();
	     Alumno alumno = gson.fromJson(output, Alumno.class);
	     return alumno;
	        
	 }
	 
	 
	 public Asignacion getAsignacion() {
	        Client client = Client.create();

	        ClientResponse response = client
	                .resource(API)
	                .path(RECURSO_ALUMNO_ASIGNACIONES)
	                .header("Authorization", "Bearer " + TOKEN)
	                .accept(MediaType.APPLICATION_JSON)
	                .get(ClientResponse.class);

	        if (response.getStatus() != 200) {
	            throw new RuntimeException("Error GET de alumno, error response : "
	                    + response.getStatus());
	        }

	        
	        String output = response.getEntity(String.class);
            
	        System.out.print(output);
	        
	        Gson gson = new Gson();
	        
	        Asignacion asignacion = gson.fromJson(output,Asignacion.class);
	        return asignacion;
	    }
	 
	



	    public void putAlumno(Alumno alumno) {
	    
	    }
	}


