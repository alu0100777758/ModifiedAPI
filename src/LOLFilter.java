import java.util.ArrayList;
import java.util.Arrays;

public class LOLFilter {
	public static void filter(ArrayList<LolTeam> teams) {

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

	public static ArrayList<PlayerEntity> findSmite(
			ArrayList<PlayerEntity> players) {
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