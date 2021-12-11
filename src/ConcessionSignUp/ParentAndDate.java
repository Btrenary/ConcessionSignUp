package ConcessionSignUp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**  
* Brady Trenary - bbtrenary  
* CIS171 26847  
* Dec 6, 2021  
*/
public class ParentAndDate {
	ParentVolunteer pv = new ParentVolunteer();
	concessionDates cd = new concessionDates();

	private HashMap<ParentVolunteer, LocalDate> ParentAndDate = new HashMap<ParentVolunteer, LocalDate>();
	
	// No arg constructor
	public ParentAndDate() {
		
	}
	//Displays the finalized schedule in the text area of the gui
	public void displayMap(JTextArea ta) {	
		for (HashMap.Entry<ParentVolunteer, LocalDate> entry : ParentAndDate.entrySet()) {
		    ta.append("Name: " + entry.getKey().getName() + " ----- Date to Work:  " + cd.displayDateAsString(entry.getValue()) + "\n");
		}
		
	}
	//prints contents of map to the console
	public void printMap() {
		for (HashMap.Entry<ParentVolunteer, LocalDate> entry : ParentAndDate.entrySet()) {
		    System.out.println(("Key = " + entry.getKey().getName() + ", Value = " + entry.getValue()));
		}
	}
	//adds parent and date to the HashMap
	public void addParentAndDate(ParentVolunteer parent, LocalDate date) {
		ParentAndDate.put(parent, date);
	}
	//returns the HashMap
	public HashMap<ParentVolunteer, LocalDate> getParentAndDate() {
		return ParentAndDate;
	}
}
