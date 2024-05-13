package mavenContratosExamenLike.controllers;

import mavenContratosExamenLike.entities.Tipocontrato;

public class ControladorTipoContrato extends SuperControladorJPA {

	private static ControladorTipoContrato instance = null;
	
	
	
	public ControladorTipoContrato() {
		super("tipocontrato", Tipocontrato.class); 
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static ControladorTipoContrato getInsctance() {
		if(instance == null) {
			instance = new ControladorTipoContrato();
		}
		return instance;
	}
	
}
