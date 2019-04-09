package mx.tesseract.editor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import mx.tesseract.admin.model.Proyecto;
import mx.tesseract.bs.ReferenciaEnum;
import mx.tesseract.bs.ReferenciaEnum.TipoReferencia;
import mx.tesseract.editor.model.Actualizacion;
import mx.tesseract.editor.model.Elemento;
import mx.tesseract.editor.model.Mensaje;
import mx.tesseract.editor.model.MensajeParametro;

public class MensajeDAO extends ElementoDAO {

	public MensajeDAO() {
		super();
	}

	public void registrarMensaje(Mensaje mensaje) throws Exception {

		try {
			session.beginTransaction();
			for (MensajeParametro parametro : mensaje.getParametros()) {
				session.saveOrUpdate(parametro.getParametro());
			}
			session.save(mensaje);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			throw he;
		}
	}

	public void modificarMensaje(Mensaje mensaje, Actualizacion actualizacion)
			throws Exception {
		try {
			session.beginTransaction();
			Query query1 = session
					.createQuery("DELETE FROM MensajeParametro WHERE mensaje.id = :id");
			query1.setParameter("id", mensaje.getId());
			query1.executeUpdate();

			for (MensajeParametro parametro : mensaje.getParametros()) {
				session.saveOrUpdate(parametro.getParametro());
			}
			session.update(mensaje);
			session.save(actualizacion);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			throw he;
		}
	}
	
	public void modificarMensaje(Mensaje mensaje)
			throws Exception {
		try {
			session.beginTransaction();
			Query query1 = session
					.createQuery("DELETE FROM MensajeParametro WHERE mensaje.id = :id");
			query1.setParameter("id", mensaje.getId());
			query1.executeUpdate();
			System.out.println("ENTRO AQUI");
			for (MensajeParametro parametro : mensaje.getParametros()) {
				System.err.println(parametro.getParametro().getNombre());
				System.err.println(parametro.getParametro().getDescripcion());
				session.saveOrUpdate(parametro.getParametro());
			}
			session.update(mensaje);
//			session.save(actualizacion);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
			throw he;
		}
	}

	public Mensaje consultarMensaje(int id) {
		return (Mensaje) super.consultarElemento(id);
	}

	public Mensaje consultarMensaje(String nombre, Proyecto proyecto) {
		return (Mensaje) super.consultarElemento(nombre, proyecto,
				ReferenciaEnum.getTabla(TipoReferencia.MENSAJE));
	}

	public List<Mensaje> consultarMensajes(int idProyecto) {
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		List<Elemento> elementos = super.consultarElementos(
				TipoReferencia.MENSAJE, idProyecto);
		for (Elemento elemento : elementos) {
			mensajes.add((Mensaje) elemento);
		}
		return mensajes;
	}

	public String siguienteNumero(int idProyecto) {
		return super.siguienteNumero(TipoReferencia.MENSAJE, idProyecto);
	}

}