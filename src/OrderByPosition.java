import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import dto.Match.MatchDetail;


public class OrderByPosition {
	public static final int TOP = 0;
	public static final int MIDDLE = 1;
	public static final int JUNGLE = 2;
	public static final int SUPP = 3;
	public static final int CARRY = 4;
	public static final int BLUE_TEAM = 0;
	public static final int RED_TEAM = 1;
	public static final int BOTTOM = 3;
	
	public static int raro = 0;
	private ArrayList<Integer>[] lineasErroneas;
	private String[][] chamIds;
	private ArrayList<Integer>[][] champsInpositions; 
	private MatchDetail match;
	
	public  OrderByPosition(MatchDetail nmatch) {
		match = nmatch;
		chamIds = new String[2][5];
		champsInpositions = new ArrayList[2][4];
		champsInpositions[0][TOP] = new ArrayList<Integer>();
		champsInpositions[0][MIDDLE] = new ArrayList<Integer>();
		champsInpositions[0][JUNGLE] = new ArrayList<Integer>();
		champsInpositions[0][BOTTOM] = new ArrayList<Integer>();
		champsInpositions[1][TOP] = new ArrayList<Integer>();
		champsInpositions[1][MIDDLE] = new ArrayList<Integer>();
		champsInpositions[1][JUNGLE] = new ArrayList<Integer>();
		champsInpositions[1][BOTTOM] = new ArrayList<Integer>();
		lineasErroneas = new ArrayList[2];
		lineasErroneas[BLUE_TEAM] = new ArrayList<Integer>();
		lineasErroneas[RED_TEAM] = new ArrayList<Integer>();
		
		int firstBottom = -1;
		
		for (int i = 0; i < 5; i++) {
			if (match.getParticipants().get(i).getTimeline().getLane().equals("TOP")) {
				chamIds[0][TOP] = "" + match.getParticipants().get(i).getChampionId();
				champsInpositions[0][TOP].add(match.getParticipants().get(i).getChampionId());
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("MIDDLE")  || 
					match.getParticipants().get(i).getTimeline().getLane().equals("MID")) {
				chamIds[0][MIDDLE] = "" + match.getParticipants().get(i).getChampionId();
				champsInpositions[0][MIDDLE].add(match.getParticipants().get(i).getChampionId());
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("JUNGLE")) {
				chamIds[0][JUNGLE] = "" + match.getParticipants().get(i).getChampionId();
				champsInpositions[0][JUNGLE].add(match.getParticipants().get(i).getChampionId());
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("BOTTOM")  || 
					match.getParticipants().get(i).getTimeline().getLane().equals("BOT")) {
				champsInpositions[0][BOTTOM].add(match.getParticipants().get(i).getChampionId());
				if (firstBottom == -1) {
					firstBottom = i;
				}
				else {
					
					//champsInpositions[0][BOTTOM].add(match.getParticipants().get(firstBottom).getChampionId());
					if (match.getParticipants().get(i).getStats().getGoldEarned() > match.getParticipants().get(firstBottom).getStats().getGoldEarned()) {
						chamIds[0][CARRY] = "" + match.getParticipants().get(i).getChampionId();
						chamIds[0][SUPP] = "" + match.getParticipants().get(firstBottom).getChampionId();
					}
					else {
						chamIds[0][SUPP] = "" + match.getParticipants().get(i).getChampionId();
						chamIds[0][CARRY] = "" + match.getParticipants().get(firstBottom).getChampionId();
					}
				}
			}
			
		}
		setErrorLines(BLUE_TEAM);
		firstBottom = -1;
		for (int i = 5; i < 10; i++) {
			if (match.getParticipants().get(i).getTimeline().getLane().equals("TOP")) {
				chamIds[1][TOP] = "" + match.getParticipants().get(i).getChampionId();
				champsInpositions[1][TOP].add(match.getParticipants().get(i).getChampionId());
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("MIDDLE")  || 
					match.getParticipants().get(i).getTimeline().getLane().equals("MID")) {
				chamIds[1][MIDDLE] = "" + match.getParticipants().get(i).getChampionId();
				champsInpositions[1][MIDDLE].add(match.getParticipants().get(i).getChampionId());
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("JUNGLE")) {
				chamIds[1][JUNGLE] = "" + match.getParticipants().get(i).getChampionId();
				champsInpositions[1][JUNGLE].add(match.getParticipants().get(i).getChampionId());
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("BOTTOM")  || 
					match.getParticipants().get(i).getTimeline().getLane().equals("BOT")) {
				champsInpositions[1][BOTTOM].add(match.getParticipants().get(i).getChampionId());
				if (firstBottom == -1) {
					firstBottom = i;
				}
				else {
					
					//champsInpositions[1][BOTTOM].add(match.getParticipants().get(firstBottom).getChampionId());
					if (match.getParticipants().get(i).getStats().getGoldEarned() > match.getParticipants().get(firstBottom).getStats().getGoldEarned()) {
						chamIds[1][CARRY] = "" + match.getParticipants().get(i).getChampionId();
						chamIds[1][SUPP] = "" + match.getParticipants().get(firstBottom).getChampionId();
					}
					else {
						chamIds[1][SUPP] = "" + match.getParticipants().get(i).getChampionId();
						chamIds[1][CARRY] = "" + match.getParticipants().get(firstBottom).getChampionId();
					}
				}
			}
			
		}
		setErrorLines(RED_TEAM);
	}
	
	public void setErrorLines(int team) {
		if (champsInpositions[team][TOP].size() != 1)
			lineasErroneas[team].add(TOP);
		if (champsInpositions[team][MIDDLE].size() != 1) 
			lineasErroneas[team].add(MIDDLE);
		if (champsInpositions[team][JUNGLE].size() != 1) 
			lineasErroneas[team].add(JUNGLE);
		if (champsInpositions[team][BOTTOM].size() != 2)
			lineasErroneas[team].add(BOTTOM);
	}
	
	public static ArrayList<String> getMatchesId(String filename) throws FileNotFoundException {
		Scanner sc = new Scanner (new FileReader(filename));
		ArrayList<String> ids = new ArrayList<String>();
		
		while (sc.hasNext()) {
			ids.add(sc.nextLine());
		}
		sc.close();
		return ids;
	}

	public boolean isCorrect(int team) {
		if (lineasErroneas[team].size() == 0)
			return true;
		return false;
	}

	public String[][] getChamIds() {
		return chamIds;
	}

	public void setChamIds(String[][] chamIds) {
		this.chamIds = chamIds;
	}

	public ArrayList<Integer>[][] getChampsInpositions() {
		return champsInpositions;
	}

	public void setChampsInpositions(ArrayList<Integer>[][] champsInpositions) {
		this.champsInpositions = champsInpositions;
	}
	
	public boolean reOrderTeam(int team) {
		if (lineasErroneas[team].contains(BOTTOM))
			reOrderBottom(team);
		
		
		
		return false;
	}
	
	public void reOrderBottom(int team) {
		
	}
	
	private int findCarry(int team) {
		int maxdmg = -1;
		int t = 0;
		int carry = 0;
		if (team == RED_TEAM)
			t = 5;
		for (int i = 0 + t; i < 5 + t; i++) {
			if (maxdmg < match.getParticipants().get(i).getStats().getPhysicalDamageDealt())
				carry = match.getParticipants().get(i).getChampionId();
		}
		return carry;
	}
}