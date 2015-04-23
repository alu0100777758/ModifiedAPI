import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import main.java.riotapi.RiotApiException;
import dto.Match.MatchDetail;

public class Main {
	public static final int TOP = 0;
	public static final int MIDDLE = 1;
	public static final int JUNGLE = 2;
	public static final int SUPP = 3;
	public static final int CARRY = 4;
	
	public static void main(String[] args) throws Exception{
		MatchDetail match = null;
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<LolTeam> teams = new ArrayList<LolTeam>();

		ids = OrderByPosition.getMatchesId("res/matchIds/matchid3.csv");
		int error = 0;
		for (int i = 0; i < 100; i++) {
			//System.out.println("iteracion:" + i);
			match = loadFromFile("res/serializedMatches/" + ids.get(i) + ".sav");
			LolTeam team = OrderByPosition.ordenPositions(match, OrderByPosition.BLUE_TEAM);
			teams.add(team);
			team = OrderByPosition.ordenPositions(match, OrderByPosition.RED_TEAM);
			teams.add(team);
		}
		for (int i = 0; i < teams.size(); i++) {
			System.out.println(teams.get(i).getJungle().get(0));
		}
		//System.out.println("teams: \n" + teams);

		//System.out.println(error);
	}
	
	static MatchDetail loadFromFile(String fileidname)throws IOException, RiotApiException, FileNotFoundException,ClassNotFoundException{
		ObjectInputStream save = new ObjectInputStream(new FileInputStream(fileidname));
		MatchDetail match = (MatchDetail) save.readObject();
		save.close();
		return match;
	}


}
