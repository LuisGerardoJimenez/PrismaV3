package mx.tesseract.editor.model;

// Generated 07-jun-2015 17:10:34 by Hibernate Tools 4.0.0

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import mx.tesseract.admin.model.Proyecto;
import mx.tesseract.util.Constantes;

/**
 * TerminoGlosario generated by hbm2java
 */
@Entity
@Table(name = "TerminoGlosario", catalog = "TESSERACT")
@PrimaryKeyJoinColumn(name = "Elementoid", referencedColumnName = "id")
public class TerminoGlosario extends Elemento implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TerminoGlosario(){
		
	}
	public TerminoGlosario(String clave, String numero, String nombre,
			Proyecto proyecto, String descripcion, EstadoElemento estadoElemento) {
		super(clave, numero, nombre, proyecto, descripcion, estadoElemento);
	}
	
	@Override
	@Transient
	@StringLengthFieldValidator(message = "%{getText('MSG6',{'100', 'caracteres'})}", trim = true, maxLength = "100", shortCircuit= true)
	@RegexFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG50')}", regex = Constantes.REGEX_CAMPO_ALFABETICO_CARACTERES_ESPECIALES, shortCircuit = true)
	public String getNombre() {
		return super.getNombre();
	}
	
	@Override
	@Transient
	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}
	
	@Override
	@Transient
	@RequiredStringValidator(type = ValidatorType.FIELD, message = "%{getText('MSG4')}", shortCircuit= true)
	@RegexFieldValidator(type = ValidatorType.FIELD, message = "%{getText('MSG50')}", regex = Constantes.REGEX_CAMPO_ALFANUMERICO_CARACTERES_ESPECIALES, shortCircuit = true)
	public String getDescripcion() {
		return super.getDescripcion();
	}
	
	@Override
	@Transient
	public void setDescripcion(String descripcion) {
		super.setDescripcion(descripcion);
	}
}
