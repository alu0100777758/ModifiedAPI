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
						setNoneTo(team.getBottomLane(), PlayerEntity.ROLE_CARRY);
						team.setWeirdCase(false);
						OrderByPosition.checkWeird(team);
						if (!team.isWeirdCase()) {
							i++;
							//System.out.println("Arreglao :D " + i);
						}
					}
				}
				if (team.getTopLane().size() == 2) {
					ArrayList<PlayerEntity> possibleJunglers = jungleFilter(team.getTopLane());
					if (possibleJunglers.size() == 1) {
						team.getJungle().add(possibleJunglers.get(0));
						team.getTopLane().remove(possibleJunglers.get(0));
						setNoneTo(team.getTopLane(), PlayerEntity.ROLE_TOP);
						team.setWeirdCase(false);
						OrderByPosition.checkWeird(team);
						if (!team.isWeirdCase()) {
							i++;
							//System.out.println("Arreglao" + i);
						}
					}
				}
				if (team.getMidLane().size() == 2) {
					ArrayList<PlayerEntity> possibleJunglers = jungleFilter(team.getMidLane());
					if (possibleJunglers.size() == 1) {
						team.getJungle().add(possibleJunglers.get(0));
						team.getMidLane().remove(possibleJunglers.get(0));
						setNoneTo(team.getMidLane(), PlayerEntity.ROLE_MID);
						team.setWeirdCase(false);
						OrderByPosition.checkWeird(team);
						if (!team.isWeirdCase()) {
							i++;
							//System.out.println("Arreglao :D!! " + i);
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
	public static ArrayList<PlayerEntity> jungleFilter(
			ArrayList<PlayerEntity> players) {
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
	public static ArrayList<PlayerEntity> supportFilter(
			ArrayList<PlayerEntity> players) {
		ArrayList<Long> supportItemsIds = new ArrayList<Long>(Arrays.asList(
				(long) 3301, (long) 3302, (long) 3303, (long) 3069,
				(long) 3097, (long) 3096, (long) 3098, (long) 3092,
				(long) 3301, (long) 3401));
		ArrayList<PlayerEntity> result = new ArrayList<PlayerEntity>();

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
	
	public static void setNoneTo(ArrayList<PlayerEntity> players, int role) {
		for(PlayerEntity player : players) {
			if (player.getRole() == PlayerEntity.NONE) {
				player.setRole(role);
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