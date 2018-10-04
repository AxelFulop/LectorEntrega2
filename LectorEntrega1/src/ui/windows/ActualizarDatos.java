	new Button(actions).setCaption("Actualizar").onClick(this::crearAlumno)
				.setAsDefault().setWidth(150);
 		new Button(actions) //
				.setCaption("Cancelar").onClick(this::cancel).setWidth(150);
 	}
 	@Override
	protected void createFormPanel(Panel formPanel) {
		formPanel.setLayout(new VerticalLayout());
 		new org.uqbar.arena.widgets.Label(formPanel).setText("Nombre");
		TextBox box = new TextBox(formPanel);
		box.setWidth(200).bindValueToProperty(
				"alumno.first_name");
		
 		new org.uqbar.arena.widgets.Label(formPanel).setText("Apellido");
		new TextBox(formPanel).setWidth(200).bindValueToProperty(
				"alumno.last_name");
 		new org.uqbar.arena.widgets.Label(formPanel).setText("Legajo");
		new Label(formPanel).setWidth(200).bindValueToProperty(
				"alumno.code");
 		new org.uqbar.arena.widgets.Label(formPanel).setText("Git User");
		new TextBox(formPanel).setWidth(200).bindValueToProperty(
		"alumno.github_user");
	}
	
	public void crearAlumno(){
		try{
		Alumno alu = this.getModelObject().getAlumno();
		RequestService.putAlumno(alu);
		}
		catch (Exception e)
		{
		JOptionPane.showMessageDialog(null,e.getMessage());
		}
finally{
	JOptionPane.showMessageDialog(null,"Alumno modificado correctamente");
	}
		
	}
 }
