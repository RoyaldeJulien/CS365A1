import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {

	public static void main(String[] args) {
		//create question and list of responses
		List<String> responses = newList("A", "B","C","D","E","F","G");
		Question question = new Question("Question?", responses);
		
		//create list of students to give responses
		List<Student> students = Student.newList("0", "1", "2","3","4","5","6");
		
		//create Ivote service object
		IVoteService IVS = new SRIVoteService(question);
		
		//each student submits a random response three times		
		for (Student person : students) {
			IVS.vote(person, rand(responses));
			IVS.vote(person, rand(responses));
			IVS.vote(person, rand(responses));
		}
		
		//print out results of the vote
		System.out.println(IVS.getResults());
		
		
	}

	
	
	//clean code function
	@SafeVarargs
	public static <T> List<T> newList(T... items) {
		List<T> list = new ArrayList<>();
		for(T item: items) {
			list.add(item);
		}
		
		return list;
	}
	
	//select a random item in a list
	public static <T> T rand(List<T> items) {
		Random rand = new Random();
		return items.get(rand.nextInt(items.size()));
	}
	
	
}
