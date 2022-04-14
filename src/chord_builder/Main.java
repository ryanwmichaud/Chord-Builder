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
	
	
	
	public static ArrayList<Integer> backtrack(int currentNote, ArrayList<St> notes, ArrayList<Integer> sofar, int curr){ //curr is num string we're checking, currentNote is num note we're on
		if(sofar.size()==notes.size()) {  //if we found all the notes
			return sofar; 
		}
		
		
		return null;
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
		
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("C");
		notes.add("E");
		notes.add("G");
		notes.add("A");
		
		for (int start=0;start<12;start++) {
			
				for(St s:sts) {
					for (String note: notes) {
						System.out.print(note);
						System.out.print(s.getLocally(note,start));
				}
					System.out.println("\n");
			}
			System.out.println("\n");
		}
		
		
	}
	
	
}
