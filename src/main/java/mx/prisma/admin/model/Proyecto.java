package mx.prisma.admin.model;

/*
 * Luis Gerardo Jiménez
 */

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import mx.prisma.util.Constantes;

/**
 * Proyecto generated by hbm2java
 */
@Entity
@Table(name = "Proyecto", catalog = "PRISMA", uniqueConstraints = {
		@UniqueConstraint(columnNames = "clave"),
		@UniqueConstraint(columnNames = "nombre") })
public class Proyecto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String clave;
	private String nombre;
	private Date fechaInicioProgramada;
	private Date fechaTerminoProgramada;
	private Date fechaInicio;
	private Date fechaTermino;
	private String descripcion;
	private Double presupuesto;
	private String contraparte;
	private EstadoProyecto estadoProyecto;
	private Set<ColaboradorProyecto> proyecto_colaboradores = new HashSet<ColaboradorProyecto>(0);

	public Proyecto() {
	}

	public Proyecto(String clave, String nombre, Date fechaInicioProgramada,
			Date fechaTerminoProgramada, String descripcion,
			String contraparte, EstadoProyecto estadoProyecto) {
		this.clave = clave;
		this.nombre = nombre;
		this.fechaInicioProgramada = fechaInicioProgramada;
		this.fechaTerminoProgramada = fechaTerminoProgramada;
		this.descripcion = descripcion;
		this.contraparte = contraparte;
		this.estadoProyecto= estadoProyecto;
	}

	public Proyecto(String clave, String nombre, Date fechaInicioProgramada,
			Date fechaTerminoProgramada, Date fechaInicio, Date fechaTermino,
			String descripcion, Double presupuesto, String contraparte,
			EstadoProyecto estadoProyecto) {
		this.clave = clave;
		this.nombre = nombre;
		this.fechaInicioProgramada = fechaInicioProgramada;
		this.fechaTerminoProgramada = fechaTerminoProgramada;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.descripcion = descripcion;
		this.presupuesto = presupuesto;
		this.contraparte = contraparte;
		this.estadoProyecto = estadoProyecto;
	}

	//@RequiredFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit = true)
	//@IntRangeFieldValidator(message = "%{getText('MSG14',{'El', 'identificador', '0', '2147483647'})}", shortCircuit = true, min = "0", max = "2147483647")
	//@RegexFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG5',{'un', 'número'})}", regex = Constantes.REGEX_CAMPO_NUMERICO_ENTERO, shortCircuit = true)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//@RequiredStringValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit= true)
	//@StringLengthFieldValidator(message = "%{getText('MSG6',{'10', 'caracteres'})}", trim = true, maxLength = "10", shortCircuit= true)
	//@RegexFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG5',{'un', 'caracter'})}", regex = Constantes.REGEX_CAMPO_ALFANUMERICO_MAYUSCULAS_SIN_ESPACIOS, shortCircuit = true)
	@Column(name = "clave", unique = true, nullable = false, length = 10)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave.trim();
	}

	//@RequiredStringValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit= true)
	//@StringLengthFieldValidator(message = "%{getText('MSG6',{'50', 'caracteres'})}", trim = true, maxLength = "50", shortCircuit= true)
	//@RegexFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG5',{'un', 'caracter'})}", regex = Constantes.REGEX_CAMPO_ALFANUMERICO, shortCircuit = true)
	@Column(name = "nombre", unique = true, nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//@RequiredFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit= true)
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaInicioProgramada", nullable = false, length = 10)
	public Date getFechaInicioProgramada() {
		return this.fechaInicioProgramada;
	}

	public void setFechaInicioProgramada(Date fechaInicioProgramada) {
		this.fechaInicioProgramada = fechaInicioProgramada;
	}

	//@RequiredFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit= true)
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaTerminoProgramada", nullable = false, length = 10)
	public Date getFechaTerminoProgramada() {
		return this.fechaTerminoProgramada;
	}

	public void setFechaTerminoProgramada(Date fechaTerminoProgramada) {
		this.fechaTerminoProgramada = fechaTerminoProgramada;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaInicio", length = 10)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaTermino", length = 10)
	public Date getFechaTermino() {
		return this.fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	//@RequiredStringValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit= true)
	//@StringLengthFieldValidator(message = "%{getText('MSG6',{'1000', 'caracteres'})}", trim = true, maxLength = "1000", shortCircuit= true)
	//@RegexFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG5',{'un', 'caracter'})}", regex = Constantes.REGEX_CAMPO_ALFANUMERICO, shortCircuit = true)
	@Column(name = "descripcion", nullable = false, length = 1000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "presupuesto", precision = 22, scale = 0)
	public Double getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	//@RequiredStringValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit= true)
	//@StringLengthFieldValidator(message = "%{getText('MSG6',{'100', 'caracteres'})}", trim = true, maxLength = "100", shortCircuit= true)
	//@RegexFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG5',{'un', 'caracter'})}", regex = Constantes.REGEX_CAMPO_ALFANUMERICO_CARACTERES_ESPECIALES, shortCircuit = true)
	@Column(name = "contraparte", nullable = false, length = 100)
	public String getContraparte() {
		return this.contraparte;
	}

	public void setContraparte(String contraparte) {
		this.contraparte = contraparte;
	}
	
	//@RequiredFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit= true)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EstadoProyectoid", nullable = false)
	public EstadoProyecto getEstadoProyecto() {
		return estadoProyecto;
	}

	public void setEstadoProyecto(EstadoProyecto estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<ColaboradorProyecto> getProyecto_colaboradores() {
		return proyecto_colaboradores;
	}

	public void setProyecto_colaboradores(
			Set<ColaboradorProyecto> proyecto_colaboradores) {
		this.proyecto_colaboradores = proyecto_colaboradores;
	}


}
