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
	
//	public static int raro = 0;
//	private ArrayList<Integer>[] lineasErroneas;
//	private String[][] chamIds;
//	private ArrayList<Integer>[][] champsInpositions; 
//	private MatchDetail match;
	
	public static LolTeam ordenPositions(MatchDetail match, int teamColor) {
		int firstBottom = -1;
		int secondBottom = -1;
		int teamIndex = 0;
		PlayerEntity fBottom = null; 
		PlayerEntity sBottom = null;
		LolTeam team = new LolTeam();
		ArrayList<PlayerEntity> topLane = new ArrayList<PlayerEntity>();
		ArrayList<PlayerEntity> midLane = new ArrayList<PlayerEntity>();
		ArrayList<PlayerEntity> bottomLane = new ArrayList<PlayerEntity>();
		ArrayList<PlayerEntity> jungle = new ArrayList<PlayerEntity>();
				
		if (teamColor == RED_TEAM) teamIndex = 5;
		
		
		for (int i = 0 + teamIndex; i < 5 + teamIndex; i++) {
			if (match.getParticipants().get(i).getTimeline().getLane().equals("TOP")) {	
				topLane.add(new PlayerEntity(match.getParticipants().get(i).getParticipantId(), match.getParticipants().get(i).getChampionId(), PlayerEntity.ROL_TOP));
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("MIDDLE")  || 
					match.getParticipants().get(i).getTimeline().getLane().equals("MID")) {
				midLane.add(new PlayerEntity(match.getParticipants().get(i).getParticipantId(), match.getParticipants().get(i).getChampionId(), PlayerEntity.ROL_MID));
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("JUNGLE")) {
				jungle.add(new PlayerEntity(match.getParticipants().get(i).getParticipantId(), match.getParticipants().get(i).getChampionId(), PlayerEntity.ROL_JUNGLER));
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("BOTTOM")  || 
					match.getParticipants().get(i).getTimeline().getLane().equals("BOT")) {
				
				bottomLane.add(new PlayerEntity(match.getParticipants().get(i).getParticipantId(), match.getParticipants().get(i).getChampionId(), PlayerEntity.NONE));
				
				if (firstBottom == -1) {
					firstBottom = i;
					fBottom = bottomLane.get(bottomLane.size() - 1);
				}
				else if (secondBottom == -1) {
					secondBottom = i;			
					sBottom = bottomLane.get(bottomLane.size() - 1);
				}
			}
			
		}
		if (bottomLane.size() == 2) {
			if (match.getParticipants().get(secondBottom).getStats().getGoldEarned() > match.getParticipants().get(firstBottom).getStats().getGoldEarned()) {
				sBottom.setRol(PlayerEntity.ROL_CARRY);
				fBottom.setRol(PlayerEntity.ROL_SUPPORT);
			}
			else {
				fBottom.setRol(PlayerEntity.ROL_CARRY);
				sBottom.setRol(PlayerEntity.ROL_SUPPORT);
			}	
		}
		
		team.setBottomLane(bottomLane);
		team.setJungle(jungle);
		team.setMidLane(midLane);
		team.setTopLane(topLane);
		
		if (jungle.size() != 1 || topLane.size() != 1 || midLane.size() != 1 || bottomLane.size() != 2)
			team.setWeirdCase(true);
		
		return team;
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
	
	
/*	private int findCarry(int team) {
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
	}*/
}