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
		ArrayList<Long> jungleItemsIDs = new ArrayList<Long>();
		jungleItemsIDs.add((long)1039);
		jungleItemsIDs.add((long) 3711);
		jungleItemsIDs.add((long)3713);
		jungleItemsIDs.add((long) 3715);
		jungleItemsIDs.add((long)3706);
		jungleItemsIDs.add((long)3719);
		jungleItemsIDs.add((long)3720);
		jungleItemsIDs.add((long)3721);
		jungleItemsIDs.add((long)3722);
		jungleItemsIDs.add((long)3723);
		jungleItemsIDs.add((long)3724);
		jungleItemsIDs.add((long)3725);
		jungleItemsIDs.add((long)3726);
		jungleItemsIDs.add((long)3714);
		jungleItemsIDs.add((long)3716);
		jungleItemsIDs.add((long)3717);
		jungleItemsIDs.add((long)3718);
		jungleItemsIDs.add((long)3707);
		jungleItemsIDs.add((long)3708);
		jungleItemsIDs.add((long)3709);
		jungleItemsIDs.add((long)3710);
		
//		OrderByPosition orderedTeams;
		ids = OrderByPosition.getMatchesId("res/matchIds/matchidALL.csv");
		for (int i = 0; i < 974; i++) {
			//System.out.println("iteracion:" + i);
			match = loadFromFile("res/serializedMatches/" + ids.get(i) + ".sav");
			LolTeam team = OrderByPosition.ordenPositions(match, OrderByPosition.BLUE_TEAM);
			teams.add(team);
			team = OrderByPosition.ordenPositions(match, OrderByPosition.RED_TEAM);
			teams.add(team);
		}
		boolean raro = true;
		//System.out.println("teams: \n" + teams);
		for (int i = 0; i < teams.size(); i++) {
			raro = true;
			for (int j = 0; j < jungleItemsIDs.size(); j++) {
				if (!teams.get(i).isWeirdCase() && teams.get(i).getJungle().get(0).getItems().contains(jungleItemsIDs.get(j))) {
					raro = false;
					break;
				}
			}
			if (raro && !teams.get(i).isWeirdCase())
				System.out.println("raro" + i);		
		}

//		System.out.println(error);
	}
	
	static MatchDetail loadFromFile(String fileidname)throws IOException, RiotApiException, FileNotFoundException,ClassNotFoundException{
		ObjectInputStream save = new ObjectInputStream(new FileInputStream(fileidname));
		MatchDetail match = (MatchDetail) save.readObject();
		save.close();
		return match;
	}


}
