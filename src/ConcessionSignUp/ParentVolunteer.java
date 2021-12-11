package ConcessionSignUp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Iterator;

/**  
* Brady Trenary - bbtrenary  
* CIS171 26847  
* Dec 3, 2021  
*/
public class ParentVolunteer implements Comparable<ParentVolunteer>{

	private String name;
	private int gradeNum;
	private int gradePriority;
	private int freshmanNum = 1;
	private int sophomoreNum = 2;
	private int juniorNum = 3;
	private int seniorNum = 4;
	private String gradeText;
	private String freshmanText = "freshman";
	private String sophomoreText = "sophomore";
	private String juniorText = "junior";
	private String seniorText = "senior";
	private LocalDate choice1;
	private LocalDate choice2;
	private LocalDate choice3;
	private LocalDate dateAssigned;
	
	private PriorityQueue<ParentVolunteer> pQueue = new PriorityQueue<ParentVolunteer>();
	Iterator<ParentVolunteer> iterator = pQueue.iterator();
	private LinkedList<LocalDate> parentDateSelections = new LinkedList<LocalDate>();
	private Queue<ParentVolunteer> finishedSelecting = new LinkedList<ParentVolunteer>();
	private Queue<ParentVolunteer> parentsRemaining = new LinkedList<ParentVolunteer>();
	private Queue<ParentVolunteer> seniorParents = new LinkedList<ParentVolunteer>();
	private Queue<ParentVolunteer> juniorParents = new LinkedList<ParentVolunteer>();
	private Queue<ParentVolunteer> sophomoreParents = new LinkedList<ParentVolunteer>();
	private Queue<ParentVolunteer> freshmanParents = new LinkedList<ParentVolunteer>();
	private Queue<ParentVolunteer> initialParentList = new LinkedList<ParentVolunteer>();
	private Queue<ParentVolunteer> needToReSelect = new LinkedList<ParentVolunteer>();

	
	
	/**
	 * no arg constructor
	 */
	public ParentVolunteer() {
	}

	public ParentVolunteer(String name) {
		this.name = name;
		gradeNum = freshmanNum;
		gradeText = null;
		dateAssigned = null;
		choice1 = null;
		choice2 = null;
		choice3 = null;
		
	}
	public ParentVolunteer(String name, LocalDate choice1, LocalDate choice2, LocalDate choice3) {
		this.name = name;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
	}
	
	public void addToReSelect(ParentVolunteer parent) {
		needToReSelect.add(parent);
	}
	/**
	 * Adds parent to appropriate list by grade
	 */
	public void addParentByGrade(ParentVolunteer parent) {
		int grade = parent.getGradeNum();
		if(grade == freshmanNum) {
			freshmanParents.add(parent);
		}
		else if(grade == sophomoreNum) {
			sophomoreParents.add(parent);
		}
		else if(grade == juniorNum) {
			juniorParents.add(parent);
		}
		else seniorParents.add(parent);
	}
	/**
	 * Creates new parent and adds parent to initialParentList and parentsRemaining list
	 */
	public ParentVolunteer newParent(String name, LocalDate choice1, LocalDate choice2, LocalDate choice3) {

		ParentVolunteer newParent = new ParentVolunteer(name, choice1, choice2, choice3);
		initialParentList.add(newParent);
		parentsRemaining.add(newParent);
		return newParent;
	}
	public ParentVolunteer newParent(String name) {
		ParentVolunteer newParent = new ParentVolunteer(name);
		initialParentList.add(newParent);
		parentsRemaining.add(newParent);
		return newParent;
	}
	/**
	 * searches initialParent list by name and returns the parent
	 */
	public ParentVolunteer getSelectedParent(String name) {
		for(ParentVolunteer parent : initialParentList) {
			if (name == parent.getName()) {
				return parent;
			}
		}
		return null;
	}
	
	public int getGradePriority() {
		return gradePriority;
	}
	/**
	 * Sets priority by child's grade
	 */
	public void setGradePriority(String gradeText) {
		gradeText.toLowerCase();
		if(gradeText == freshmanText) {
			gradeNum = freshmanNum;
		}
		else if(gradeText == sophomoreText) {
			gradeNum = sophomoreNum;
		}
		else if(gradeText == juniorText) {
			gradeNum = juniorNum;
		}
		else gradeNum = seniorNum;
	}
	/**
	 * returns name of the selected parent
	 */
	public String getSelectedParentName(ParentVolunteer parent) {
		return parent.getName();
	}
	public String getFreshmanText() {
		return freshmanText;
	}

	public String getSophomoreText() {
		return sophomoreText;
	}

	public String getJuniorText() {
		return juniorText;
	}

	public String getSeniorText() {
		return seniorText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGradeNum() {
		return gradeNum;
	}

	/**
	 * Adds parent to finishedSelecting list
	 */
	public void addToFinishedSelecting(ParentVolunteer parent) {
		finishedSelecting.add(parent);
	}
	/**
	 * removes the parent from the ParentsRemaining list
	 */
	public void updateParentsRemaining(ParentVolunteer parent) {
		parentsRemaining.remove(parent);
	}
	public LocalDate getChoice1() {
		return choice1;
	}

	public void setChoice1(LocalDate choice1) {
		this.choice1 = choice1;
	}

	public LocalDate getChoice2() {
		return choice2;
	}

	public void setChoice2(LocalDate choice2) {
		this.choice2 = choice2;
	}

	public LocalDate getChoice3() {
		return choice3;
	}

	public void setChoice3(LocalDate choice3) {
		this.choice3 = choice3;
	}

	public LocalDate getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(LocalDate dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public LinkedList<LocalDate> getParentDateSelections() {
		return parentDateSelections;
	}

	public Queue<ParentVolunteer> getInitialParentList() {
		return initialParentList;
	}

	public Queue<ParentVolunteer> getParentsRemaining() {
		return parentsRemaining;
	}

	public Queue<ParentVolunteer> getFinishedSelecting() {
		return finishedSelecting;
	}

	public PriorityQueue<ParentVolunteer> getpQueue() {
		return pQueue;
	}
	public Queue<ParentVolunteer> getSeniorParents() {
		return seniorParents;
	}

	public Queue<ParentVolunteer> getJuniorParents() {
		return juniorParents;
	}

	public Queue<ParentVolunteer> getSophomoreParents() {
		return sophomoreParents;
	}

	public Queue<ParentVolunteer> getFreshmanParents() {
		return freshmanParents;
	}
	public void addToPQueue(ParentVolunteer parent) {
		pQueue.add(parent);
	}
	
	public Queue<ParentVolunteer> getNeedToReSelect() {
		return needToReSelect;
	}
	/**
	 * checks to see if the parents are equal priority
	 */
	public boolean equals(ParentVolunteer p) {
		return this.getGradeNum() == p.getGradeNum();
	}
	
	@Override
	public int compareTo(ParentVolunteer p) {
		if(this.equals(p)) {
			return 0;
		}
		else if(getGradeNum() < p.getGradeNum()) {
			return 1;
		}
		else return -1;
	}
	public void printParentByPriority() {
		while (pQueue.peek() != null) {
			System.out.println(pQueue.poll());
		}
	}

	@Override
	public String toString() {
		return "ParentVolunteer [name=" + name + ", gradeNum=" + gradeNum + ", choice1=" + choice1 + ", choice2=" + choice2 + ", choice3=" + choice3 + "]";
	}

}
