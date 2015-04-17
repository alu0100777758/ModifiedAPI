import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class toCSV {
	toCSV(){
		
	}
	
	public FileWriter teamToCsv(ArrayList<LolTeam> team){
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("teams.csv");
            pw = new PrintWriter(fichero);
            pw.println("TOP,MID,JUNGLE,BOTTOM");
            for (int i = 0; i < team.size(); i++)
                pw.println(team.get(i).getTopLaneArray() + "," + team.get(i).getmidLaneArray() + "," + team.get(i).getJungleArray() +
                		 "," + team.get(i).getBottomLaneArray());
 
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
           try {
           if (null != fichero)
              fichero.close();
           } 
           catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		return fichero;
	}
	
}
		

	
	
