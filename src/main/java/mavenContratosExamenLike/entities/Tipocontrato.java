package mavenContratosExamenLike.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipocontrato database table.
 * 
 */
@Entity
@Table(name="tipocontrato")
@NamedQuery(name="Tipocontrato.findAll", query="SELECT t FROM Tipocontrato t")
public class Tipocontrato extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOCONTRATO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOCONTRATO_ID_GENERATOR")
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Contrato
	@OneToMany(mappedBy="tipocontrato")
	private List<Contrato> contratos;

	
	// CONSTRUCTORES
	
	public Tipocontrato() {
	}

	
	
	// GETTERS & SETTERS
	
	@Override
	public String toString() {
		return  id + " " + descripcion;
	}
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setTipocontrato(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setTipocontrato(null);

		return contrato;
	}

}