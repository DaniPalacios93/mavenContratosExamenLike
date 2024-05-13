package mavenContratosExamenLike.controllers;


import mavenContratosExamenLike.entities.Contrato;


public class ControladorContrato extends SuperControladorJPA {
	
	private static ControladorContrato instance = null;
	
	
	public ControladorContrato() {
		super("contrato", Contrato.class); 
	}
	
	/**
	 * 
	 * @return
	 */
	public static ControladorContrato getInsctance() {
		if(instance == null) {
			instance = new ControladorContrato();
		}
		return instance;
	}
	

}
