package fa.training.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.EntryTest;

public class EntryTestDao2 extends GenericDao<EntryTest> {
	
	private static Class<EntryTest> generic;
	private List<EntryTest> entryList;
	
	public EntryTestDao2() {
		super(generic);
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
	public EntryTest update(EntryTest entry) {
		entry.setTechnical_valuator("ok");
		return entry;
	}
	public List<EntryTest> getEntryList() {
		return entryList;
	}

}
