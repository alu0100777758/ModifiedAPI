import java.util.ArrayList;


public class LOLFilter {
	public static void filter(ArrayList<LolTeam> teams){
		
	}
	
	/*
	 * Va a revisar cual de los jugadores de un equipo es jungle, se va a mirar a traves de los objetos que tenga: 
	 * -Hunter's Machete ID 1039
	 * -Poacher's Knife ID 3711
	 * -Ranger's Trailblaze 3713
	 * -Skirmisher's Sabre 3715
	 * -Stalker's Blade 3706
	 */
	public static void jungleFilter(LolTeam singleTeam)
	{
		ArrayList<Integer> jungleItemsIDs = new ArrayList<Integer>();
		jungleItemsIDs.add(1039);
		jungleItemsIDs.add(3711);
		jungleItemsIDs.add(3713);
		jungleItemsIDs.add(3715);
		jungleItemsIDs.add(3706);
		for(PlayerEntity player : singleTeam.getmidLaneArray())
		{
			if(player.getItems().contains(jungleItemsIDs))
			{
				player.setRol(PlayerEntity.ROL_JUNGLER);
			}
			
		}
			
	}
	
}
