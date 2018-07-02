import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Multi-Response IVote Service
public class MRIVoteService implements IVoteService {

	//the question to be voted on
	private Question question;
	//maps the people who voted to what their responses were
	private Map<Student, Set<String>> Votes;
	//maps each response to the number of times it was voted for
	private Map<String, Integer> numOfEachResponse;
	
	public MRIVoteService(Question Q) {
		question = Q;
		Votes = new HashMap<>();
		numOfEachResponse = new HashMap<>();
		//set the number of each response to zero
		for(String response: question.getResponses()) {
			numOfEachResponse.put(response, 0);
		}
	}
	
	@Override
	public void vote(Student stu, String response) {
		//is the response valid?
		if (question.hasResponse(response)) {
			//if the student has never voted before
			if (!Votes.containsKey(stu)) {
				//create a set to hold their votes
				Votes.put(stu, new HashSet<>());
			}
			//did the student already vote for that response?
			if (!Votes.get(stu).contains(response)) {
				//add this new response to the set of responses the student gave
				Votes.get(stu).add(response);
				//increment the number of times this response was given
				numOfEachResponse.put(response, numOfEachResponse.get(response).intValue() + 1);
			}
			//if the student already voted for that response, do nothing		
		}
		//do nothing if response is invalid
	}

	@Override
	public String getResults() {
		StringBuilder results = new StringBuilder();
		results.append(question.getQuestion() + ":\n");
		for (String response : question.getResponses()) {
			results.append("\t" + response + ": " + numOfEachResponse.get(response).toString() + "\n");
		}
		
		return results.toString();
	}
	
	
	
}
