package partypeople;
import java.util.ArrayList;

import Json.JsonPerson;


public class Person {

	private String name;
	private Person boss;
	private ArrayList<Person> underlings;
	private double score;
	
	public Person(JsonPerson jsonPerson){
		this.name = jsonPerson.getName();
		this.score = jsonPerson.getScore();
		this.underlings = new ArrayList<>();
		this.boss = null;
	}
	
	public void setBoss(Person boss){
		this.boss = boss;
		boss.addUnderling(this);
	}

	public String getName() {
		return name;
	}
	
	public void addUnderling(Person person){
		underlings.add(person);
	}

	public Person getBoss() {
		return boss;
	}

	public double getScore() {
		return score;
	}
	
	public PeopleScoreRecord getMaxScore(boolean includeSelf){
		PeopleScoreRecord psrNoIncludeSelf = new PeopleScoreRecord();
		PeopleScoreRecord psrIncludeSelf = new PeopleScoreRecord();
		
		if (underlings.size() > 0){
			
			for (Person person: underlings){
				psrNoIncludeSelf.combine(person.getMaxScore(true));
			}
			if (includeSelf){
				psrIncludeSelf.addPerson(this);
				for (Person person: underlings){
					psrIncludeSelf.combine(person.getMaxScore(!includeSelf));
				}
			}
			
			if (includeSelf && this.boss == null){
				return psrIncludeSelf;
			} else {
				return psrIncludeSelf.getScore() > psrNoIncludeSelf.getScore() ? psrIncludeSelf : psrNoIncludeSelf;
			}
		} else {
			if(includeSelf && this.score > 0){
				psrIncludeSelf.addPerson(this);
				return psrIncludeSelf;
			} else {
				return psrNoIncludeSelf;
			}
		}
		
		
	}

}
