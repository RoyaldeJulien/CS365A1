import java.util.HashMap;
import java.util.Map;

//Single Response implementation of IVoteService
public class SRIVoteService implements IVoteService {
	
	//the question to be voted on
	private Question question;
	//maps who voted to what their response was
	private Map<Student, String> whoVoted;
	//maps each response to the number of times it was voted for
	private Map<String, Integer> numOfEachResponse;
	
	public SRIVoteService(Question Q) {
		question = Q;
		whoVoted = new HashMap<>();
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
			//has the student already voted?
			if (whoVoted.containsKey(stu)) {
				//yes?, then 
				//decrement the number of times the previous response was voted for
				String prevResponse = whoVoted.get(stu);
				numOfEachResponse.put(prevResponse, numOfEachResponse.get(prevResponse).intValue() - 1);
				
				//change the stored response for the student
				whoVoted.put(stu, response);
			}
			else {
				//no?, then 
				//add the students response
				whoVoted.put(stu, response);
			}
			//increase the number of times that response was voted for
			numOfEachResponse.put(response, numOfEachResponse.get(response).intValue() + 1);
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
