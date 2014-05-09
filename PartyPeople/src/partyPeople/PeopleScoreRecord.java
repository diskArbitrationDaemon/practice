package partyPeople;
import java.util.HashSet;
import java.util.Set;


public class PeopleScoreRecord {

	
	private Set<Person> people;
	private double score;
	
	public PeopleScoreRecord(){
		score = 0;
		people = new HashSet<Person>();
	}
	
	public void addPerson(Person person){
		people.add(person);
		score += person.getScore();
	}
	
	public double getScore(){
		return score;
	}
	
	public Set<Person> getPeople(){
		return this.people;
	}
	
	public void combine(PeopleScoreRecord psr){
		this.score += psr.getScore();
		people.addAll(psr.getPeople());
	}

}
