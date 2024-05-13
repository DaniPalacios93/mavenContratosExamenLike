package mavenContratosExamenLike.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contrato database table.
 * 
 */
@Entity
@Table(name="contrato")
@NamedQuery(name="Contrato.findAll", query="SELECT c FROM Contrato c")
public class Contrato extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTRATO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTRATO_ID_GENERATOR")
	private int id;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFirma;

	private int limite;

	private int saldo;

	//bi-directional many-to-one association to Tipocontrato
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTipoContrato")
	private Tipocontrato tipocontrato;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Contrato() {
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

	public Date getFechaFirma() {
		return this.fechaFirma;
	}

	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public int getLimite() {
		return this.limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Tipocontrato getTipocontrato() {
		return this.tipocontrato;
	}

	public void setTipocontrato(Tipocontrato tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}