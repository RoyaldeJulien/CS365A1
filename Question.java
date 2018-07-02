import java.util.List;

public class Question {
	private String question;
	private List<String> responses;
	
	public Question(String Q, List<String> R) {
		question = Q;
		responses = R;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public List<String> getResponses() {
		return responses;
	}
	
	public boolean hasResponse(String res) {
		return responses.contains(res);
	}
}
