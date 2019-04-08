package mx.prisma.admin.model;

/*
 * Luis Gerardo Jiménez
 */

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Telefono generated by hbm2java
 */
@Entity
@Table(name = "Telefono", catalog = "PRISMA", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ColaboradorCURP", "lada", "numero" }))
public class Telefono implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Colaborador colaborador;
	private String lada;
	private String numero;

	public Telefono() {
	}

	public Telefono(Colaborador colaborador, String lada, String numero) {
		this.colaborador = colaborador;
		this.lada = lada;
		this.numero = numero;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ColaboradorCURP")
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@Column(name = "lada", unique = true, nullable = false, length = 5)
	public String getLada() {
		return this.lada;
	}

	public void setLada(String lada) {
		this.lada = lada;
	}

	@Column(name = "numero", unique = true, nullable = false, length = 10)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
