package ui.windows;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import ui.vm.AlumnoViewModel;
import ui.vm.BuscadorAlumnoModel;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuAlumnos extends SimpleWindow<BuscadorAlumnoModel> {

	public MenuAlumnos(WindowOwner parent) {
		super(parent, new BuscadorAlumnoModel());

	}

	@Override
	public void createFormPanel(Panel mainPanel) {

		this.setTitle("Menu Alumno");

		new org.uqbar.arena.widgets.Label(mainPanel)
				.setText("Ingrese su Legajo");
		new NumericField(mainPanel).bindValueToProperty("legajo");
		mainPanel.setWidth(200);

	}

	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Actualizar Datos")
				.onClick(this::actualizar).setAsDefault();

		new Button(actionsPanel).setCaption("Ver Notas").onClick(this::estado)
				.setAsDefault();
	}

	public void actualizar() {
		try {
			getModelObject().search();
			Dialog<?> dialog = new ActualizarDatos(this, new AlumnoViewModel(
					getModelObject().getResultado()));
			dialog.open();
			dialog.onAccept(getModelObject()::search);
		}catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}

	}

	public void estado() {
		try{
			getModelObject().search();
			Dialog<?> dialog = new EstadoAlumnoWindow(this, this.getModelObject()
					.getResultado());
			dialog.open();
			dialog.onAccept(getModelObject()::search);
		}catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());

		}

		
		
	}

}
