import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import main.java.riotapi.RiotApi;
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
		OrderByPosition orderedTeams;
		ids = OrderByPosition.getMatchesId("res/matchIds/matchid3.csv");
		int error = 0;
		for (int i = 0; i < 100; i++) {
			match = loadFromFile("res/serializedMatches/" + ids.get(i) + ".sav");
			orderedTeams = new OrderByPosition(match);
			if (!orderedTeams.isCorrect(OrderByPosition.BLUE_TEAM)) {
				System.out.println("Blue team weird: ");
				System.out.println(orderedTeams.getChampsInpositions()[OrderByPosition.BLUE_TEAM][OrderByPosition.TOP].size() + " Tops");
				System.out.println(orderedTeams.getChampsInpositions()[OrderByPosition.BLUE_TEAM][OrderByPosition.MIDDLE].size() + " Middles");
				System.out.println(orderedTeams.getChampsInpositions()[OrderByPosition.BLUE_TEAM][OrderByPosition.JUNGLE].size() + " Junglers");
				System.out.println(orderedTeams.getChampsInpositions()[OrderByPosition.BLUE_TEAM][OrderByPosition.BOTTOM].size() + " Bottoms");
				error ++;
			}
			if (!orderedTeams.isCorrect(OrderByPosition.RED_TEAM)) {
				System.out.println("Red team weird: ");
				System.out.println(orderedTeams.getChampsInpositions()[OrderByPosition.RED_TEAM][OrderByPosition.TOP].size() + " Tops");
				System.out.println(orderedTeams.getChampsInpositions()[OrderByPosition.RED_TEAM][OrderByPosition.MIDDLE].size() + " Middles");
				System.out.println(orderedTeams.getChampsInpositions()[OrderByPosition.RED_TEAM][OrderByPosition.JUNGLE].size() + " Junglers");
				System.out.println(orderedTeams.getChampsInpositions()[OrderByPosition.RED_TEAM][OrderByPosition.BOTTOM].size() + " Bottoms");
				error++;
			}
		}
		System.out.println(error);
	}
	
	static MatchDetail loadFromFile(String fileidname)throws IOException, RiotApiException, FileNotFoundException,ClassNotFoundException{
		ObjectInputStream save = new ObjectInputStream(new FileInputStream(fileidname));
		MatchDetail match = (MatchDetail) save.readObject();
		save.close();
		return match;
	}


}
