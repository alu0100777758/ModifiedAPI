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
		PlayerEntity analyzedPlayer = null;
		LolTeam team = new LolTeam();
		ArrayList<PlayerEntity> topLane = new ArrayList<PlayerEntity>();
		ArrayList<PlayerEntity> midLane = new ArrayList<PlayerEntity>();
		ArrayList<PlayerEntity> bottomLane = new ArrayList<PlayerEntity>();
		ArrayList<PlayerEntity> jungle = new ArrayList<PlayerEntity>();
				
		if (teamColor == RED_TEAM) teamIndex = 5;
		
		
		for (int i = 0 + teamIndex; i < 5 + teamIndex; i++) {
			analyzedPlayer = null;
			if (match.getParticipants().get(i).getTimeline().getLane().equals("TOP")) {	
				analyzedPlayer = new PlayerEntity(match.getParticipants().get(i).getParticipantId(), match.getParticipants().get(i).getChampionId(), PlayerEntity.ROLE_TOP);
				topLane.add(analyzedPlayer);
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("MIDDLE")  || 
					match.getParticipants().get(i).getTimeline().getLane().equals("MID")) {
				analyzedPlayer = new PlayerEntity(match.getParticipants().get(i).getParticipantId(), match.getParticipants().get(i).getChampionId(), PlayerEntity.ROLE_MID);
				midLane.add(analyzedPlayer);
				
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("JUNGLE")) {
				analyzedPlayer = new PlayerEntity(match.getParticipants().get(i).getParticipantId(), match.getParticipants().get(i).getChampionId(), PlayerEntity.ROLE_JUNGLER);
				jungle.add(analyzedPlayer);
			}
			else if (match.getParticipants().get(i).getTimeline().getLane().equals("BOTTOM")  || 
					match.getParticipants().get(i).getTimeline().getLane().equals("BOT")) {
				analyzedPlayer = new PlayerEntity(match.getParticipants().get(i).getParticipantId(), match.getParticipants().get(i).getChampionId(), PlayerEntity.NONE);
				bottomLane.add(analyzedPlayer);
				
				if (firstBottom == -1) {
					firstBottom = i;
					fBottom = bottomLane.get(bottomLane.size() - 1);
				}
				else if (secondBottom == -1) {
					secondBottom = i;			
					sBottom = bottomLane.get(bottomLane.size() - 1);
				}
			}
			assignItems(match, i, analyzedPlayer);
		}
		if (bottomLane.size() == 2) {
			if (match.getParticipants().get(secondBottom).getStats().getGoldEarned() > match.getParticipants().get(firstBottom).getStats().getGoldEarned()) {
				sBottom.setRole(PlayerEntity.ROLE_CARRY);
				fBottom.setRole(PlayerEntity.ROLE_SUPPORT);
			}
			else {
				fBottom.setRole(PlayerEntity.ROLE_CARRY);
				sBottom.setRole(PlayerEntity.ROLE_SUPPORT);
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
	
	private static void assignItems(MatchDetail match, int index, PlayerEntity player) {
		player.addItem(match.getParticipants().get(index).getStats().getItem0());
		player.addItem(match.getParticipants().get(index).getStats().getItem1());
		player.addItem(match.getParticipants().get(index).getStats().getItem2());
		player.addItem(match.getParticipants().get(index).getStats().getItem3());
		player.addItem(match.getParticipants().get(index).getStats().getItem4());
		player.addItem(match.getParticipants().get(index).getStats().getItem5());
		player.addItem(match.getParticipants().get(index).getStats().getItem6());
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