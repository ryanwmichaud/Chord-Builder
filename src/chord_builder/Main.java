package chord_builder;

import java.util.ArrayList;



public class Main {

	
	public enum NoteNames{
		C,Db,D,Eb,E,F,Gb,G,Ab,A,Bb,B
	}
	
	public static void printSts(ArrayList<St> sts) {
		for(St s:sts) {
			s.printSt();
		}
		System.out.println("\n");
	}
	public static void main(String args[]) {
		
		
		
		ArrayList<St> sts= new ArrayList<St>();  //make the strings 
		
		
		St firstSt = new St(NoteNames.A,5);
		St secondSt = new St(NoteNames.D,5);
		St thirdSt = new St(NoteNames.G,4);
		St fourthSt = new St(NoteNames.C,4);
		
		sts.add(firstSt);
		sts.add(secondSt);
		sts.add(thirdSt);
		sts.add(fourthSt);	
		
		
		printSts(sts);
		}
}
