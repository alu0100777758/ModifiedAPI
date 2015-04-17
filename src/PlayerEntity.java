import java.util.ArrayList;

import main.java.riotapi.RiotApiException;


/**
 * @author Eldon
 * Clase encargada de representar los datos de un individuo de una partida.
 * Se define el individuo como el conjunto formado por parte de cada jugador y las respectivas opciones seleccionadas a lo largo de la partida.
 *
 */
public class PlayerEntity {
	public static final int NONE = 0;
	public static final int ROL_TOP = 1;
	public static final int ROL_MID = 2;
	public static final int ROL_CARRY = 3;
	public static final int ROL_SUPPORT = 4;
	public static final int ROL_JUNGLER = 5;
	public static final String [] ROL_NAME = {"NONE","TOP","MID","CARRY","SUPPORT","JUNGLER"};
	private int champID;
	private int playerID;
	private int rol;
	private ArrayList<Integer> items = new ArrayList<Integer>();
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
	public PlayerEntity(int playerid, int champid , int rolid){
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
	public void addItem(int itemid){
		getItems().add(itemid);
	}
	public ArrayList<Integer> getItems() {
		return items;
	}
	public void setItems(ArrayList<Integer> items) {
		this.items = items;
	}
	public String toString(){
		try {
			return "" + S_Api.getInstance().getDataChampion(getChampID()).getName() + "," + ROL_NAME[getRol()];
		} catch (RiotApiException e) {
			return "" + getChampID() + "," + ROL_NAME[getRol()];
		}
	}
	
	

}
