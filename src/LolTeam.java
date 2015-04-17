import java.io.Serializable;
import java.util.ArrayList;


public class LolTeam implements Serializable{
	private static final long serialVersionUID = 2499613110111010001L;
	private ArrayList<PlayerEntity> topLane = new ArrayList<PlayerEntity>();
	private ArrayList<PlayerEntity> midLane = new ArrayList<PlayerEntity>();
	private ArrayList<PlayerEntity> BottomLane = new ArrayList<PlayerEntity>();
	private ArrayList<PlayerEntity> Jungle = new ArrayList<PlayerEntity>();
	private boolean weirdCase = false;
	private TeamData data;
	
	public PlayerEntity[] getTopLaneArray(){
		return LaneToArray(getTopLane());
	}
	public PlayerEntity[] getmidLaneArray(){
		return LaneToArray(getMidLane());
	}
	public PlayerEntity[] getBottomLaneArray(){
		return LaneToArray(getBottomLane());
	}
	public PlayerEntity[] getJungleArray(){
		return LaneToArray(getJungle());
	}
	private PlayerEntity[] LaneToArray(ArrayList<PlayerEntity> line) {
		return line.toArray(new PlayerEntity[line.size()]);
	}
	private ArrayList<PlayerEntity> getTopLane() {
		return topLane;
	}
	public void setTopLane(ArrayList<PlayerEntity> topLane) {
		this.topLane = topLane;
	}
	private ArrayList<PlayerEntity> getMidLane() {
		return midLane;
	}
	public void setMidLane(ArrayList<PlayerEntity> midLane) {
		this.midLane = midLane;
	}
	private ArrayList<PlayerEntity> getBottomLane() {
		return BottomLane;
	}
	public void setBottomLane(ArrayList<PlayerEntity> bottomLane) {
		BottomLane = bottomLane;
	}
	public ArrayList<PlayerEntity> getJungle() {
		return Jungle;
	}
	public void setJungle(ArrayList<PlayerEntity> jungle) {
		Jungle = jungle;
	}
	public boolean isWeirdCase() {
		return weirdCase;
	}
	public void setWeirdCase(boolean weirdCase) {
		this.weirdCase = weirdCase;
	}
	public TeamData getData() {
		return data;
	}
	public void setData(TeamData data) {
		this.data = data;
	}
	public String toString(){
		return ("top: " + getTopLane() + " mid: " + getMidLane() + " Bottom: " + getBottomLane() + " Jungler: " + getJungle() + "\n");
	}
	
}
