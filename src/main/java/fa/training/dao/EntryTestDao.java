package fa.training.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import fa.training.entities.EntryTest;
import fa.training.utils.HibernateConnection;

public class EntryTestDao implements Dao<EntryTest>{
	
	private Session session = HibernateConnection.getSessionFactory().openSession();
	private List<EntryTest> entryList;
	
	public EntryTestDao() {
		entryList = new ArrayList<>();
		EntryTest entry1 = new EntryTest(LocalDate.parse("2020-10-01"),"pass");
		EntryTest entry2 = new EntryTest(LocalDate.parse("2020-10-01"),"fail");
		EntryTest entry3 = new EntryTest(LocalDate.parse("2022-09-15"),"pass");
		EntryTest entry4 = new EntryTest(LocalDate.parse("2022-09-15"),"fail");
		
		entryList.add(entry1);
		entryList.add(entry2);
		entryList.add(entry3);
		entryList.add(entry4);
	}
	@Override
	public void save(EntryTest entry) {
		session.beginTransaction();
		session.save(entry);
		session.getTransaction().commit();
	}

	@Override
	public EntryTest getById(int id) {
		return session.find(EntryTest.class, id);
	}

	@Override
	public List<EntryTest> getAll() {
		Query<EntryTest> query = session.createQuery("from EntryTest",EntryTest.class);
		List<EntryTest> lists = query.getResultList();
		return lists;
	}

	@Override
	public EntryTest updateById(int id) {
		session.beginTransaction();
		EntryTest entry = session.find(EntryTest.class, id);
		entry.setTechnical_valuator("ok");
		session.save(entry);
		session.getTransaction().commit();
		System.out.println("update successfully...");
		return entry;
	}

	@Override
	public void deleteById(int id) {
		session.beginTransaction();
		EntryTest entry = session.find(EntryTest.class, id);
		session.delete(entry);
		session.getTransaction().commit();
	}

	public List<EntryTest> getEntryList() {
		return entryList;
	}
}
