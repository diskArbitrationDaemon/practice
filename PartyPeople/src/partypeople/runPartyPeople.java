package partypeople;
import Json.DeserializeFromJson;

public class runPartyPeople {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PeopleScoreRecord inviteCeo;
		Person ceo = DeserializeFromJson.deserialize("staff.json");
		inviteCeo = ceo.getMaxScore(true);
		
		for (Person person : inviteCeo.getPeople()){
			System.out.println(person.getName());
		}
	}

}
