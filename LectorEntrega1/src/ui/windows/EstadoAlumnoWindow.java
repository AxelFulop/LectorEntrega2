package ui.windows;

import model.Alumno;


import model.Asignacion;
import model.tipoNota.Nota;

import org.apache.commons.collections15.Transformer;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ui.vm.AsignacionViewModel;

@SuppressWarnings("serial")
public class EstadoAlumnoWindow extends Dialog<AsignacionViewModel> {
	public EstadoAlumnoWindow(WindowOwner owner, Alumno alu) {
		super(owner, new AsignacionViewModel(alu));

	}

	@Override
	protected void addActions(Panel panelActions) {
		new Button(panelActions).setCaption("Cancelar").onClick(this::cancel)
				.setWidth(100);

	}

	@Override
	protected void createFormPanel(Panel formPanel) {
		String leg = Integer.toString(getModelObject().getCode());
		this.setTitle("Estado del Alumno con leg  " + leg);

		/*new Label(formPanel).setText("Asignaciones");

		Selector<Asignacion> listasignaciones = new Selector<Asignacion>(
				formPanel);
		listasignaciones.bindItemsToProperty("asignaciones").adaptWith(
				Asignacion.class, "title");
		listasignaciones.bindValueToProperty("asignacion.title");*/

		new Label(formPanel).setText("Tareas");
		Selector<Asignacion> selectorPrenda = new Selector<Asignacion>(formPanel)
				.allowNull(true);
		selectorPrenda.bindItemsToProperty("alumno.assignments").adaptWith(
				Asignacion.class, "descripcion");
		selectorPrenda.bindValueToProperty("asignacion.descripcion");

		new Label(formPanel).setText("Ultima Nota");
		new Label(formPanel).bindValueToProperty("asignacion.ultimaNota");

		new Label(formPanel).setText("Estado");
		new Label(formPanel).bindValueToProperty("asignacion.estado");

	}

	// public void obtenerDatos() {
	// Dialog<?> dialog =
	// dialog.open();
	// dialog.onAccept(() -> {});
	// }

}
