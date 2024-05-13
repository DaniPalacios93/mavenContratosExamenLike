package mavenContratosExamenLike.controllers;

import mavenContratosExamenLike.entities.Usuario;

public class ControladorUsuario extends SuperControladorJPA {
	
	private static ControladorUsuario instance = null;
	
	
	public ControladorUsuario() {
		super("usuario", Usuario.class); 
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControladorUsuario getInsctance() {
		if(instance == null) {
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	

}
