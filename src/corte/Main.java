package corte;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
   	 Scanner sc = new Scanner(new File("2.csv"));
   	 String line = "";
   	 PrintWriter writer = new PrintWriter("matchid2.csv", "UTF-8");
   	 String matchid = "";
   	 
   	 sc.nextLine();
   	 while (sc.hasNext()) {
   		 line = sc.nextLine();
   		 matchid = line.substring(0, line.indexOf(","));
   		 writer.println(matchid);
   	 }   	 
   	 sc.close();
   	 writer.close();
    }

}