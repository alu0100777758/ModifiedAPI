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
	
	/**
	 * El m�todo para al encontrar el primer jugador que tenga un objeto jungla.
	 * @param players Array de jugadores donde se prevee que est� el jungla.
	 * @return Jugador que se ha identificado como jungla.
	 */
	public static PlayerEntity jungleFilter(ArrayList<PlayerEntity> players)
	{
		ArrayList<Integer> jungleItemsIDs = new ArrayList<Integer>();
		jungleItemsIDs.add(1039);
		jungleItemsIDs.add(3711);
		jungleItemsIDs.add(3713);
		jungleItemsIDs.add(3715);
		jungleItemsIDs.add(3706);
		
		for(PlayerEntity player : players)
		{
			if(player.getItems().contains(jungleItemsIDs))
			{
				player.setRol(PlayerEntity.ROL_JUNGLER);
				return player;
			}
			
		}
			
		return null;
	}
	
	/*
	 * Va a revisar cual de los jugadores de un equipo es support, se va a mirar a traves de los objetos que tenga: 
     * Id = 3301,
     * Id = 3303, 
     * Id = 3302
	 */
	 
	
	/**
	 * El m�todo para al encontrar el primer jugador que tenga un objeto support.
	 * @param players Array de jugadores donde se prevee que est� el support.
	 * @return Jugador que se ha identificado como support.
	 */
	public static PlayerEntity supportFilter(ArrayList<PlayerEntity> players) {
		ArrayList<Integer> supportItemsIds = new ArrayList<Integer>();
		supportItemsIds.add(3301);
		supportItemsIds.add(3302);
		supportItemsIds.add(3303);
		
		for(PlayerEntity player : players)
		{
			if(player.getItems().contains(supportItemsIds))
			{
				player.setRol(PlayerEntity.ROL_SUPPORT);
				return player;
			}
			
		}
			
		return null;
	}
}
