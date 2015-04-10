
/**
 * @author Eldon
 * Clase encargada de representar los datos de un individuo de una partida.
 * Se define el individuo como el conjunto formado por parte de cada jugador y las respectivas opciones seleccionadas a lo largo de la partida.
 *
 */
public class PlayerEntity {
	public static int NONE = 0;
	public static int ROL_TOP = 1;
	public static int ROL_MID = 2;
	public static int ROL_CARRY = 3;
	public static int ROL_SUPPORT = 4;
	private int champID;
	private int playerID;
	private int rol;
	public PlayerEntity(){
		this(NONE,NONE,NONE);
	}
	public PlayerEntity(int champid){
		setChampID(champid);
	}
	public PlayerEntity(int champid, int playerid){
		this(champid);
		setPlayerID(playerid);
	}
	public PlayerEntity(int champid, int playerid,int rolid){
		this(champid,playerid);
		setRol(rolid);
	}
	public int getChampID() {
		return champID;
	}
	public void setChampID(int champID) {
		this.champID = champID;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	
	

}
