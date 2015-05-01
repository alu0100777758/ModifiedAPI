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
            fichero = new FileWriter("Pairs.csv");
            pw = new PrintWriter(fichero);
            pw.println("TOP,MID,JUNGLE,ADC, SUPPORT, IsWinner");
            PlayerEntity adc;
            PlayerEntity supp;
            
            for (int i = 0; i < team.size(); i++){
            	if(team.get(i).getBottomLaneArray()[0].getRole() == team.get(i).getBottomLaneArray()[0].ROLE_CARRY){
            		adc = team.get(i).getBottomLaneArray()[0];
            		supp = team.get(i).getBottomLaneArray()[1];
            	}
            	else{
            		adc = team.get(i).getBottomLaneArray()[1];
            		supp = team.get(i).getBottomLaneArray()[0];
            	}
            	
                pw.println(team.get(i).getTopLaneArray()[0] + "," + team.get(i).getmidLaneArray()[0] + "," + team.get(i).getJungleArray()[0] +
                		 "," + adc + "," + supp + ", " + team.get(i).isWinner());
            }
 
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
		

	
	
