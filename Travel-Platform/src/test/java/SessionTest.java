import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.jupiter.api.Test;

import cn.edu.bitzh.tp.model.*;
import cn.edu.bitzh.tp.util.HibernateSessionFactory;

/**
 * @author 古学懂_Victor
 * @date 2020年5月7日
 */
class SessionTest {
	Session session = null;
	Transaction transaction = null;

	@Test
	void test() {
		System.out.println("Junit Test: Hibernate Session Test");
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		Note note = new Note();
		NoteDtl noteDtl=new NoteDtl();
		note.setNoteAuthor(1000);
		note.setNotePermission(1);
		note.setNotePostDate(new Date());
		noteDtl.setNote(note);
		noteDtl.setNoteHeader("Test");
		note.setNoteDtl(noteDtl);
		int num = Integer.parseInt(session.save(note).toString());
		session.save(noteDtl);
		transaction.commit();
		System.out.println(num);
//		fail("Not yet implemented");
	}
	@After
	void after() {
		 HibernateSessionFactory.closeSession();
	}	
}
