package cn.edu.bitzh.tp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bitzh.tp.dao.INoteDao;
import cn.edu.bitzh.tp.model.Note;

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
	public List<Note> listBy(int type, Object value) {
		List<Note> notes;
		Query<Note> q;
		String typeStr = "";
		try {
			switch (type) {
			case ALL:
				session = sessionFactory.openSession();
				q = session.createQuery("select n from Note n where n.notePermission like 'public' order by notePostDate desc");
				notes = q.list();
				if (notes.isEmpty())
					return null;
				return notes;
			case AUTHOR:
				typeStr = "noteAuthor";
				break;
			case DATE:
				typeStr = "notePostDate";
				break;
			default:
				return null;
			}
			session = sessionFactory.openSession();
			q = session.createQuery("select n from Note n where " + typeStr + "=:value");
			q.setParameter("value", value);
			notes = q.list();
			if (notes.isEmpty())
				return null;
			return notes;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public Note get(int id) {
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
	public boolean update(Note note) {
		try {
			session = sessionFactory.openSession();
			Note noteT = session.get(Note.class, note.getNoteId());
			session.update(noteT);
			transaction.commit();
			return true;
		} catch (Exception x) {
			x.printStackTrace();
			return false;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public int insertOrUpdate(Note note) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Note noteT = session.load(Note.class, note.getNoteId());
			note.getNoteDtl().setNote(note);
			noteT.setNoteDtl(note.getNoteDtl());
			noteT.setApplicable(note.getApplicable());
			noteT.setCommentCount(note.getCommentCount());
			noteT.setEndDate(note.getEndDate());
			noteT.setFavoriteCount(note.getFavoriteCount());
			noteT.setLikeCount(note.getLikeCount());
			noteT.setNoteAuthor(note.getNoteAuthor());
			noteT.setNotePermission(note.getNotePermission());
			noteT.setNotePostDate(note.getNotePostDate());
			noteT.setPostDateStr(note.getPostDateStr());
			noteT.setRegions(note.getRegions());
			noteT.setTravelDate(note.getTravelDate());
//			int num = Integer.parseInt(session.save(note).toString());
			session.saveOrUpdate(noteT);
			session.clear();
			session.saveOrUpdate(noteT.getNoteDtl());
			transaction.commit();
			return note.getNoteId();
		} catch (Exception x) {
			x.printStackTrace();
			return -1;
		} finally {
			sessionFactory.close();
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Note> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> listHotestNotes() {
		List<Note> notes;
		Query<Note> q;
		try {
			session = sessionFactory.openSession();
			q = session.createQuery("select n from Note n where n.notePermission like 'public' order by (likeCount + favoriteCount + commentCount) desc");
			notes = q.list();
			if (notes.isEmpty())
				return null;
			return notes;
		} catch (Exception x) {
			x.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}

}
