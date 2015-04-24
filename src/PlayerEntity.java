import java.util.ArrayList;


/**
 * @author Eldon
 * Clase encargada de representar los datos de un individuo de una partida.
 * Se define el individuo como el conjunto formado por parte de cada jugador y las respectivas opciones seleccionadas a lo largo de la partida.
 *
 */
public class PlayerEntity {
	public static final int NONE = 0;
	public static final int ROLE_TOP = 1;
	public static final int ROLE_MID = 2;
	public static final int ROLE_CARRY = 3;
	public static final int ROLE_SUPPORT = 4;
	public static final int ROLE_JUNGLER = 5;
	public static final String [] ROLE_NAME = {"NONE","TOP","MID","CARRY","SUPPORT","JUNGLER"};
	private int champID;
	private int playerID;
	private int role;
	private int spell1;
	private int spell2;
	private ArrayList<Long> items = new ArrayList<Long>();
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
		setRole(rolid);
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	public int getSpell1() {
		return spell1;
	}
	public void setSpell1(int spell1) {
		this.spell1 = spell1;
	}
	public int getSpell2() {
		return spell2;
	}
	public void setSpell2(int spell2) {
		this.spell2 = spell2;
	}
	public void addItem(long itemid){
		getItems().add(itemid);
	}
	public ArrayList<Long> getItems() {
		return items;
	}
	public void setItems(ArrayList<Long> items) {
		this.items = items;
	}
	public String toString(){
			return "" + GetChampNameBy.id(getChampID()) + "," + ROLE_NAME[getRole()];
//			return "" + getChampID() + "," + ROL_NAME[getRol()];
	}
	public String getName(){
		return "" + GetChampNameBy.id(getChampID());
	}
	
	

}
