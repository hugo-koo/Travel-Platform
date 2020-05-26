package cn.edu.bitzh.tp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bitzh.tp.dao.INoteDao;
import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.model.NoteDtl;
import cn.edu.bitzh.tp.util.HibernateSessionFactory;

/**
* @author 古学懂_Victor
*/
@Repository
public class NoteDao implements INoteDao {
	Session session = null;
	Transaction transaction = null;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Note> listNotesBy(int type, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note getNoteById(int id) {
		try {
			session = sessionFactory.openSession();
			Note note = session.get(Note.class, id);
			return note;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public boolean updateNote(Note note) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertNote(Note note) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		note.getNoteDtl().setNote(note);
		int num = Integer.parseInt(session.save(note).toString());
		session.save(note.getNoteDtl());
		transaction.commit();
		return num;
	}

	@Override
	public int deleteNote(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
