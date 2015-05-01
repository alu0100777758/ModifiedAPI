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
		ArrayList<LolTeam> badTeams = new ArrayList<LolTeam>();
		
//		OrderByPosition orderedTeams;
		ids = OrderByPosition.getMatchesId("res/matchIds/matchidALL.csv");
		for (int i = 0; i < 974; i++) {
			//System.out.println("iteracion:" + i);
			match = loadFromFile("res/serializedMatches/" + ids.get(i) + ".sav");
			LolTeam team = OrderByPosition.ordenPositions(match, OrderByPosition.BLUE_TEAM);
			if (!team.isWeirdCase())
				teams.add(team);
			else 
				badTeams.add(team);
			team = OrderByPosition.ordenPositions(match, OrderByPosition.RED_TEAM);
			if (!team.isWeirdCase())
				teams.add(team);
			else
				badTeams.add(team);
		}

		toCSV csvConverter = new toCSV();
		
		
		LOLFilter.filter(badTeams);
		for (int i = 0; i < badTeams.size(); i++) {
			if (!badTeams.get(i).isWeirdCase()) {
				teams.add(badTeams.get(i));
				badTeams.remove(i);
			}
		}
		
		csvConverter.teamToCsv(teams);
		int count = 0;
		for (int i = 0; i< badTeams.size(); i++) {
			System.out.println("Top: " + badTeams.get(i).getTopLane() + ", Mid: " +  badTeams.get(i).getMidLane() + ", Bot: " + badTeams.get(i).getBottomLane()+", Jungle: " + badTeams.get(i).getJungle() + " " + badTeams.get(i).isWinner());
			if (badTeams.get(i).isWinner())
				count++;
		}
		System.out.println(count);
	}
	
	static MatchDetail loadFromFile(String fileidname)throws IOException, RiotApiException, FileNotFoundException,ClassNotFoundException{
		ObjectInputStream save = new ObjectInputStream(new FileInputStream(fileidname));
		MatchDetail match = (MatchDetail) save.readObject();
		save.close();
		return match;
	}


}
