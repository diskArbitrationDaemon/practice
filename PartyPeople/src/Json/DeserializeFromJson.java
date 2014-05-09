package Json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import partyPeople.Person;

import com.google.gson.Gson;

public class DeserializeFromJson {
	
	private HashMap<String, Person> nameToPeople = new HashMap<>();

	/***
	 * deserialize from a given JSON file that contains staff details in an array,
	 * with fields:
	 * 
	 *  {
	 *      "name": "Soren de Kiester",
	 *      "boss": "Click N. Clack",
	 *      "party-animal-score": 25
	 *	}
	 *
	 * 
	 * @param file The path to where the file is
	 * @return Person objection 
	 */
	public Person deserialize(String file){
		
		Person ceo = null;
		Gson gson = new Gson();
		try {
			Scanner s =  new Scanner(new File(file));
			String content =s.useDelimiter("\\Z").next();
			JsonPerson[] jsonPersonArray = gson.fromJson(content, JsonPerson[].class);
			
			s.close();
			
			for (JsonPerson jsonPerson : jsonPersonArray){
				nameToPeople.put(jsonPerson.getName(), new Person(jsonPerson));
			}
			
			for (JsonPerson jsonPerson : jsonPersonArray){
				if (jsonPerson.getBossName() == null){
					ceo = nameToPeople.get(jsonPerson.getName());
				} else {
					nameToPeople.get(jsonPerson.getName()).setBoss(nameToPeople.get(jsonPerson.getBossName()));
				}
			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ceo;
	}
	
	public Map<String, Person> getNameToPersonMap(){
		return this.nameToPeople;
	}

}
