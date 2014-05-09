package Json;

import com.google.gson.annotations.SerializedName;


public class JsonPerson {

	@SerializedName("name")
	private String name;
	
	@SerializedName("boss")
	private String bossName;
	
	@SerializedName("party-animal-score")
	private double score;

	public String getName() {
		return name;
	}

	public String getBossName() {
		return bossName;
	}

	public double getScore() {
		return score;
	}
}
