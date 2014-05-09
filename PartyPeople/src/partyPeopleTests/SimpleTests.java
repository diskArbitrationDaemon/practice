package partyPeopleTests;

import java.util.Map;
import java.util.Set;

import partyPeople.PeopleScoreRecord;
import partyPeople.Person;
import Json.DeserializeFromJson;

public class SimpleTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testInviteCeo();
		testNotInviteCeo();
		testOnlyInviteCeo();
		testInviteOnlyBottomStaff();
		testJsonOrderIrrelevant();
		System.out.println("All tests passed!");

	}
	
	private static void testInviteCeo(){
	
		PeopleScoreRecord inviteCeoList;
		DeserializeFromJson deserializeFromJson = new DeserializeFromJson();
		Person ceo = deserializeFromJson.deserialize("staff.json");
		boolean inviteCeo = true;
		inviteCeoList = ceo.getMaxScore(inviteCeo);
		
		Set<Person> invitees = inviteCeoList.getPeople();
		Map<String, Person> nameToPersonMap = deserializeFromJson.getNameToPersonMap();
		
		try {
			assert(invitees.contains(nameToPersonMap.get("Al Buquerque")));
			assert(invitees.contains(nameToPersonMap.get("Moe Shroom")));
			assert(invitees.contains(nameToPersonMap.get("Howard M. Burgers")));
			assert(invitees.contains(nameToPersonMap.get("Soren de Kiester")));
			assert(invitees.size() == 4);
		} catch (AssertionError ae){
			printSet(invitees);
			throw new AssertionError();
		}
		
		
	}
	
	private static void testNotInviteCeo(){
		
		{
			PeopleScoreRecord inviteCeoList;
			DeserializeFromJson deserializeFromJson = new DeserializeFromJson();
			Person ceo = deserializeFromJson.deserialize("staff.json");
			boolean inviteCeo = false;
			inviteCeoList = ceo.getMaxScore(inviteCeo);
			
			Set<Person> invitees = inviteCeoList.getPeople();
			Map<String, Person> nameToPersonMap = deserializeFromJson.getNameToPersonMap();
			
			try{
				assert(invitees.contains(nameToPersonMap.get("Ferb Jinglemore")));
				assert(invitees.contains(nameToPersonMap.get("Moe Shroom")));
				assert(invitees.contains(nameToPersonMap.get("Howard M. Burgers")));
				assert(invitees.contains(nameToPersonMap.get("Soren de Kiester")));
				assert(invitees.size() == 4);

			}catch (AssertionError ae){
					printSet(invitees);
					throw new AssertionError();
				}
		}

	}
	
	private static void testOnlyInviteCeo(){
		
		{
			PeopleScoreRecord inviteCeoList;
			DeserializeFromJson deserializeFromJson = new DeserializeFromJson();
			Person ceo = deserializeFromJson.deserialize("onlyCeo.json");
			boolean inviteCeo = true;
			inviteCeoList = ceo.getMaxScore(inviteCeo);
			
			Set<Person> invitees = inviteCeoList.getPeople();
			Map<String, Person> nameToPersonMap = deserializeFromJson.getNameToPersonMap();
			
			try{
				assert(invitees.contains(nameToPersonMap.get("Al Buquerque")));
				assert(invitees.size() == 1);

			}catch (AssertionError ae){
					printSet(invitees);
					throw new AssertionError();
				}
		}

	}
	
	private static void testInviteOnlyBottomStaff(){
		
		{
			PeopleScoreRecord inviteCeoList;
			DeserializeFromJson deserializeFromJson = new DeserializeFromJson();
			Person ceo = deserializeFromJson.deserialize("onlyBottom.json");
			boolean inviteCeo = false;
			inviteCeoList = ceo.getMaxScore(inviteCeo);
			
			Set<Person> invitees = inviteCeoList.getPeople();
			Map<String, Person> nameToPersonMap = deserializeFromJson.getNameToPersonMap();
			
			try{
				assert(invitees.contains(nameToPersonMap.get("Soren de Kiester")));
				assert(invitees.contains(nameToPersonMap.get("Howard M. Burgers")));
				assert(invitees.contains(nameToPersonMap.get("Jerky CleansUpYourFridgeAndReplacesBeer")));
				assert(invitees.contains(nameToPersonMap.get("Moe Shroom")));

				assert(invitees.size() == 4);

			}catch (AssertionError ae){
				ae.printStackTrace();
				printSet(invitees);
				throw new AssertionError();
			}
		}

	}
	
	private static void testJsonOrderIrrelevant(){
		
		PeopleScoreRecord inviteCeoList;
		DeserializeFromJson deserializeFromJson = new DeserializeFromJson();
		Person ceo = deserializeFromJson.deserialize("irrelevantOrder.json");
		boolean inviteCeo = true;
		inviteCeoList = ceo.getMaxScore(inviteCeo);
		
		Set<Person> invitees = inviteCeoList.getPeople();
		Map<String, Person> nameToPersonMap = deserializeFromJson.getNameToPersonMap();
		
		try {
			assert(invitees.contains(nameToPersonMap.get("Al Buquerque")));
			assert(invitees.contains(nameToPersonMap.get("Moe Shroom")));
			assert(invitees.contains(nameToPersonMap.get("Howard M. Burgers")));
			assert(invitees.contains(nameToPersonMap.get("Soren de Kiester")));
			assert(invitees.size() == 4);
		} catch (AssertionError ae){
			printSet(invitees);
			throw new AssertionError();
		}
		
		
	}
	
	private static void printSet(Set<Person> set){
		for (Person p : set){
			System.out.println(p.getName());
		}
	}

}
