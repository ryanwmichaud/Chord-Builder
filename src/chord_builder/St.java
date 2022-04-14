package chord_builder;




import java.util.ArrayList;
import java.util.HashMap;

import chord_builder.Main.NoteNames;



public class St {
	
	protected HashMap<String,Integer> map = new HashMap<String,Integer>();  
	String stringRep="";
	int octave;
	NoteNames open;
	String tab = "";
	int capo=-1;

		
	public St(NoteNames d, int octaveGiven) {
		map.put(d+String.valueOf(octaveGiven), 0);
		stringRep= stringRep.concat(d.toString()+octaveGiven+" ");
		this.octave=octaveGiven;
		this.open = d;
		this.tab = this.tab.concat(this.open.toString()+" |");
		buildFretBoard();
		
	}
	
	public St(NoteNames d, int octaveGiven, int capo) {
		map.put(d+String.valueOf(octaveGiven), 0);
		stringRep= stringRep.concat(d.toString()+octaveGiven+" ");
		this.octave=octaveGiven;
		this.open = d;
		this.tab = this.tab.concat(this.open.toString()+" |");
		this.capo=capo;
		buildFretBoard();
	}
	
	private void buildFretBoard() {
		//build the rest of the fret board  
				int fret = 1;
				int currentOctave = this.octave;
				int currentNoteNum = this.open.ordinal() + 1;   //change? to enum hashmap thing? 
				
				if(capo!=-1) {
					for(int i =0;i<capo-1;i++) { 	//we want to leave orig string name at bottom if capo,dif from retuning. so put new "open" up the neck
						if (i%2==0) {
							stringRep= stringRep.concat("   ");
						}else {
							stringRep= stringRep.concat("    ");

						}
					}
					currentNoteNum = this.open.ordinal()  + capo-5; 	//change starting note and fret
					if (currentNoteNum>=12) {
						currentNoteNum%=12;
					}
										
					fret=capo;
				}

				while(fret<22) {
					if(currentNoteNum==12) {
						currentNoteNum=0;
						currentOctave++;
					}
					//Note current = new Note(NoteNames.values()[currentNoteNum],currentOctave);
					
					stringRep= stringRep.concat(NoteNames.values()[currentNoteNum]+String.valueOf(currentOctave)+" ");
					
					if(fret==capo) {
						map.remove(this.open+String.valueOf(this.octave));
						map.put(NoteNames.values()[currentNoteNum]+String.valueOf(currentOctave), 0);					
					}else {
						map.put(NoteNames.values()[currentNoteNum]+String.valueOf(currentOctave), fret);
					}
					fret++;
					currentNoteNum++;
				}
			//System.out.println(map.toString());	
				
	}
	
	
	public void printSt(){
		/*for(Note current:map.keySet()) {
			System.out.printf("%d for %s\n",map.get(current), current.getName());
		}*/
		System.out.println(this.stringRep);
	}

	
	public int getFret(String n) throws NullPointerException {
		
		int ret = -1;
		try{
			ret = map.get(n);
		}catch(NullPointerException e) {
			//System.out.printf("%s was not found on this string\n",n);
		}
		return ret;
	}
public ArrayList<Integer> getFretAnyOct(String n) throws NullPointerException {
//this can be super improved
	ArrayList<Integer> frets = new ArrayList<Integer>();
		for(int i = 0; i<10;i++) {
			String note = n+String.valueOf(i);
			if(map.containsKey(note)){
				frets.add(map.get(note));
			}
		}
		return frets;
	}
	
}
	

