package Json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import partypeople.Person;

import com.google.gson.Gson;

public class DeserializeFromJson {
	
	private static HashMap<String, Person> nameToPeople = new HashMap<>();

	public static Person deserialize(){
		
		Person ceo = null;
		Gson gson = new Gson();
		try {
			Scanner s =  new Scanner(new File("staff.json"));
			String content =s.useDelimiter("\\Z").next();
			JsonPerson[] jsonPersonArray = gson.fromJson(content, JsonPerson[].class);
			
			s.close();
			
			for (JsonPerson jsonPerson : jsonPersonArray){
				nameToPeople.put(jsonPerson.getName(), new Person(jsonPerson));
			}
			
			for (JsonPerson jsonPerson : jsonPersonArray){
				if (jsonPerson.getBossName().equals("")){
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

}
