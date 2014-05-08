package partypeople;
import java.util.ArrayList;
import java.util.List;


public class PeopleScoreRecord {

	
	private ArrayList<Person> people;
	private double score;
	
	public PeopleScoreRecord(){
		score = 0;
		people = new ArrayList<Person>();
	}
	
	public void addPerson(Person person){
		people.add(person);
		score += person.getScore();
	}
	
	public double getScore(){
		return score;
	}
	
	public List<Person> getPeople(){
		return this.people;
	}
	
	public void combine(PeopleScoreRecord psr){
		this.score += psr.getScore();
		people.addAll(psr.getPeople());
	}

}
