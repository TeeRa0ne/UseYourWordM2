package use_your_words.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	List<Player> player = new ArrayList<Player>();
	
	List<Answer> answer = new ArrayList<Answer>();
	
	private String idManche;

	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public String getIdManche() {
		return idManche;
	}

	public void setIdManche(String idManche) {
		this.idManche = idManche;
	}
	
	

}
