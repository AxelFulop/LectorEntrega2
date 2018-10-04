package model.tipoTarea;

	import java.util.ArrayList;
import java.util.List;

import model.tipoNota.Nota;

import org.uqbar.commons.utils.Observable;

import com.google.gson.annotations.SerializedName;

	@Observable
	public class Tarea {

		@SerializedName("id")
		private int id;
		@SerializedName("title")
		private String title;
		@SerializedName("description")
		private String descripcion;
		@SerializedName("grades")
		private List<Nota> grades = new ArrayList<Nota>();
		private String estado;
		
		public String getTitle() {
			return title;
		}



		public void setTitle(String title) {
			this.title = title;
		}



		public String getDescripcion() {
			return descripcion;
		}



		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}



		public List<Nota> getGrades() {
			return grades;
		}



		public void setGrades(List<Nota> grades) {
			this.grades = grades;
		}


		

		public String getEstado() {
			validarEstado();
			return estado;
		}

	

		public void  validarEstado() {
			
			 if(this.grades.get(grades.size() - 1).aprobada())
			 {
			  setEstado("Aprobado");
			 }
			 else
			 {
			 setEstado("No Aprobado"); 
			 }
			}
			
			
			private void setEstado(String string) {
			this.estado = string;
			
		}


			public String getUltimaNota() {
				if(this.grades.isEmpty())
				{
				throw new RuntimeException("No hay notas cargadas");
				}
				else
				{
				return  this.grades.get(grades.size() - 1).value();
				}
			}
		
		
		
	
}
