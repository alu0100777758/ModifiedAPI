import java.util.ArrayList;
import java.util.Arrays;

public class LOLFilter {
	public static void filter(ArrayList<LolTeam> teams) {
		int i = 0;
		for (LolTeam team : teams) {
			if (team.getJungle().size() == 0) {
				if (team.getBottomLane().size() == 3) {
					ArrayList<PlayerEntity> possibleJunglers = jungleFilter(team.getBottomLane());
					if (possibleJunglers.size() == 1) {
						team.getJungle().add(possibleJunglers.get(0));
						team.getBottomLane().remove(possibleJunglers.get(0));
						supportFilter(team.getBottomLane());
						setNoneToCarry(team.getBottomLane());
						team.setWeirdCase(false);
						OrderByPosition.checkWeird(team);
						if (!team.isWeirdCase()) {
							i++;
							System.out.println("Arreglao :D " + i);
						}
					}
				}
			}
		}
	}

	/*
	 * Va a revisar cual de los jugadores de un equipo es jungle, se va a mirar
	 * a traves de los objetos que tenga: -Hunter's Machete ID 1039 -Poacher's
	 * Knife ID 3711 -Ranger's Trailblaze 3713 -Skirmisher's Sabre 3715
	 * -Stalker's Blade 3706
	 */

	/**
	 * El m�todo para al encontrar el primer jugador que tenga un objeto jungla.
	 * 
	 * @param players
	 *            Array de jugadores donde se prevee que est� el jungla.
	 * @return Jugador que se ha identificado como jungla.
	 */
	public static ArrayList<PlayerEntity> jungleFilter(ArrayList<PlayerEntity> players) {
		final ArrayList<Long> jungleItemsIDs = new ArrayList<Long>(
				Arrays.asList((long) 1039, (long) 3711, (long) 3713,
						(long) 3715, (long) 3706, (long) 3719, (long) 3720,
						(long) 3721, (long) 3722, (long) 3723, (long) 3724,
						(long) 3725, (long) 3726, (long) 3714, (long) 3716,
						(long) 3717, (long) 3718, (long) 3707, (long) 3708,
						(long) 3709, (long) 3710));
		ArrayList<PlayerEntity> result = new ArrayList<PlayerEntity>();
		for (PlayerEntity player : players) {
			for (int i = 0; i < jungleItemsIDs.size(); i++) {
				if (player.getItems().contains(jungleItemsIDs.get(i))) {
					player.setRole(PlayerEntity.ROLE_JUNGLER);
					result.add(player);
				}
			}

		}
		return result;
	}

	/*
	 * Va a revisar cual de los jugadores de un equipo es support, se va a mirar
	 * a traves de los objetos que tenga: Id = 3301, Id = 3303, Id = 3302 y
	 * todos los demas D:
	 */

	/**
	 * El m�todo para al encontrar el primer jugador que tenga un objeto
	 * support.
	 * 
	 * @param players
	 *            Array de jugadores donde se prevee que est� el support.
	 * @return Jugador que se ha identificado como support.
	 */
	public static ArrayList<PlayerEntity> supportFilter(ArrayList<PlayerEntity> players) {
		ArrayList<Long> supportItemsIds = new ArrayList<Long>();
		ArrayList<PlayerEntity> result = new ArrayList<PlayerEntity>();
		supportItemsIds.add((long) 3301);
		supportItemsIds.add((long) 3302);
		supportItemsIds.add((long) 3303);
		supportItemsIds.add((long) 3069);
		supportItemsIds.add((long) 3097);
		supportItemsIds.add((long) 3401);
		supportItemsIds.add((long) 3096);
		supportItemsIds.add((long) 3098);
		supportItemsIds.add((long) 3092);

		for (PlayerEntity player : players) {
			for (int i = 0; i < supportItemsIds.size(); i++) {
				if (player.getItems().contains(supportItemsIds.get(i))) {
					player.setRole(PlayerEntity.ROLE_SUPPORT);
					result.add(player);
				}
			}
		}
		return result;
	}
	
	public static void setNoneToCarry(ArrayList<PlayerEntity> players) {
		for(PlayerEntity player : players) {
			if (player.getRole() == PlayerEntity.NONE) {
				player.setRole(PlayerEntity.ROLE_CARRY);
				break;
			}
		}
	}
	public static ArrayList<PlayerEntity> findSmite(ArrayList<PlayerEntity> players) {
		ArrayList<PlayerEntity> result = new ArrayList<PlayerEntity>();
		for (PlayerEntity player : players) {
			if (player.getSpell1() == 11 || player.getSpell2() == 11) {
				player.setRole(PlayerEntity.ROLE_JUNGLER);
				result.add(player);
			}
		}
		return result;
	}
}