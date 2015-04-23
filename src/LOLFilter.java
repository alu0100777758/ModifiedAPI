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
	 * El método para al encontrar el primer jugador que tenga un objeto jungla.
	 * @param players Array de jugadores donde se prevee que esté el jungla.
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
		jungleItemsIDs.add(3719);
		jungleItemsIDs.add(3720);
		jungleItemsIDs.add(3721);
		jungleItemsIDs.add(3722);
		jungleItemsIDs.add(3723);
		jungleItemsIDs.add(3724);
		jungleItemsIDs.add(3725);
		jungleItemsIDs.add(3726);
		jungleItemsIDs.add(3714);
		jungleItemsIDs.add(3716);
		jungleItemsIDs.add(3717);
		jungleItemsIDs.add(3718);
		jungleItemsIDs.add(3707);
		jungleItemsIDs.add(3708);
		jungleItemsIDs.add(3709);
		jungleItemsIDs.add(3710);
		
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
     * y todos los demas D:
	 */
	 
	
	/**
	 * El método para al encontrar el primer jugador que tenga un objeto support.
	 * @param players Array de jugadores donde se prevee que esté el support.
	 * @return Jugador que se ha identificado como support.
	 */
	public static PlayerEntity supportFilter(ArrayList<PlayerEntity> players) {
		ArrayList<Integer> supportItemsIds = new ArrayList<Integer>();
		supportItemsIds.add(3301);
		supportItemsIds.add(3302);
		supportItemsIds.add(3303);
		supportItemsIds.add(3069);
		supportItemsIds.add(3097);
		supportItemsIds.add(3401);
		supportItemsIds.add(3096);
		supportItemsIds.add(3098);
		supportItemsIds.add(3092);
		
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
