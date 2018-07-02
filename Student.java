import java.util.ArrayList;
import java.util.List;

public class Student {
	private String ID;
	
	public Student(String SID) {
		ID = SID;
	}
	
	public static List<Student> newList(String ... SIDs) {
		List<Student> list = new ArrayList<>();
		for(String SID: SIDs) {
			list.add(new Student(SID));
		}
		
		return list;
	}
	
	public String GetID() {
		return ID;
	}
	
}
