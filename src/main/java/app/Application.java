package app;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import entities.Evento;
import entities.TipoEvento;

public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = util.JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();

		EventoDAO ed = new EventoDAO(em);

		// ************************ SAVE *********************

		Evento e1 = new Evento("Concerto Pink Floyd", LocalDate.now(), "STUPENDO!", TipoEvento.PRIVATO, 6000);
		ed.save(e1);

		// ************************ FIND BY ID *********************
		UUID uuid = UUID.fromString("da3c78b9-ce1a-41db-89c5-fa0deddf937c");
		System.out.println(ed.getById(uuid));

		// ************************ DELETE *********************
		// ed.findByIdAndDelete(uuid);

		// ************************ REFRESH ********************
		ed.refresh(uuid);

		em.close();
		emf.close();
	}

}
