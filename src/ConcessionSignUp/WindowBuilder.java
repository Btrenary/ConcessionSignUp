package ConcessionSignUp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonListener;


import java.awt.TextField;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;

/**
 * Brady Trenary - bbtrenary CIS171 26847 Dec 3, 2021
 */
public class WindowBuilder {
	ParentVolunteer pv = new ParentVolunteer();
	ParentVolunteer parentToUpdate = new ParentVolunteer();
	concessionDates cd = new concessionDates();
	ParentAndDate parentAndDate = new ParentAndDate();
	private JFrame frame;
	private JLabel gradeSelectLabel = new JLabel("Child's grade");//label for grade selection ComboBox
	private JLabel nameSelectLabel = new JLabel("Parent's Name");//Label for Parent selection ComboBox
	private JLabel lblNewLabel = new JLabel("Chariton Baseball Concessions Schedule Creator");//Label at the top of the program
	private JLabel nameAndDateText = new JLabel("Parent's desired dates");//label for date selection ComboBoxes
	private JComboBox<String> gradeComboBox = new JComboBox<String>();//ComboBox containing grade selection options
	private JComboBox<String> parentComboBox = new JComboBox<String>();//ComboBox containing parent names
	private JComboBox<String> dateComboBox1 = new JComboBox<String>();//first date selection ComboBox
	private JComboBox<String> dateComboBox2 = new JComboBox<String>();//second date selection ComboBox
	private JComboBox<String> dateComboBox3 = new JComboBox<String>();//third date selections ComboBox
	private JButton nameAndGradeSubmit = new JButton("Next");//button for name and grade submission
	private JButton createScheduleButton = new JButton("Finalize Schedule");//button for creating the final schedule
	private JButton date1SelectButton = new JButton("Submit");//button for first date selection
	private JButton date2SelectButton = new JButton("Submit");//button for second date selection
	private JButton date3SelectButton = new JButton("Submit");//button for third date selection
	private JButton finalSubmitButton = new JButton("Submit");//button for finalizing the parents grade selection and date choices
	private JTextArea textArea = new JTextArea();//text area that displays schedule
	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder window = new WindowBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBuilder() {
			initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ParentVolunteer parent1 = pv.newParent("John Smith");
		ParentVolunteer parent2 = pv.newParent("Jane Jones");
		ParentVolunteer parent3 = pv.newParent("Brad Johnson");
		ParentVolunteer parent4 = pv.newParent("Pam Davis");
		ParentVolunteer parent5 = pv.newParent("Jodi Anderson");
		ParentVolunteer parent6 = pv.newParent("Phil Turner");
		ParentVolunteer parent7 = pv.newParent("Albert Rios");
		ParentVolunteer parent8 = pv.newParent("Kellie Curtis");
		ParentVolunteer parent9 = pv.newParent("Bob Rivers");
		ParentVolunteer parent10 = pv.newParent("Allan McGee");


		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 957, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		//MAIN LABEL TOP OF PROGRAM
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblNewLabel.setBounds(0, 0, 943, 66);
		frame.getContentPane().add(lblNewLabel);

		
		//COMBO BOX FOR GRADE SELECTION
		gradeComboBox.setBounds(632, 76, 158, 21);
		frame.getContentPane().add(gradeComboBox);
		gradeComboBox.addItem(pv.getFreshmanText());
		gradeComboBox.addItem(pv.getSophomoreText());
		gradeComboBox.addItem(pv.getJuniorText());
		gradeComboBox.addItem(pv.getSeniorText());

		//COMBO BOX FOR PARENT NAMES
		parentComboBox.setBounds(220, 76, 250, 21);
		frame.getContentPane().add(parentComboBox);
		generateParentComboBox();

		
		//LABEL FOR GRADES
		gradeSelectLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gradeSelectLabel.setBounds(516, 76, 106, 21);
		frame.getContentPane().add(gradeSelectLabel);

		
		//LABEL FOR NAME SELECT COMBO BOX
		nameSelectLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameSelectLabel.setBounds(10, 76, 150, 21);
		frame.getContentPane().add(nameSelectLabel);


		//SUBMIT BUTTON FOR PARENT NAME AND CHILD'S GRADE
		NameAndGradeButtonListener nameAndGradeButtonListener = new NameAndGradeButtonListener();
		nameAndGradeSubmit.addActionListener(nameAndGradeButtonListener);
		nameAndGradeSubmit.setBounds(826, 76, 85, 21);
		frame.getContentPane().add(nameAndGradeSubmit);
		
		//LABEL FOR DATE SELECTION ROW
		nameAndDateText.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameAndDateText.setBounds(10, 107, 212, 21);
		frame.getContentPane().add(nameAndDateText);

		//COMBO BOX FOR FIRST DATE SELECTION
		dateComboBox1.setBounds(220, 107, 174, 21);

		//COMBO BOX FOR SECOND DATE SELECTION
		dateComboBox2.setBounds(416, 107, 174, 21);
		
		//COMBO BOX FOR THIRD DATE SELECTION
		dateComboBox3.setBounds(616, 109, 174, 21);
		
		//BUTTON FOR FIRST DATE SELECTION
		date1SelectButton.setVisible(false);
		
		//BUTTON LISTENER FOR FIRST DATE SELECTION BOX
		FirstDateSelectionButtonListener date1Listener = new FirstDateSelectionButtonListener();
		date1SelectButton.addActionListener(date1Listener);
		date1SelectButton.setBounds(259, 138, 85, 21);
		frame.getContentPane().add(date1SelectButton);
		generateFirstDateBox();
			
		//BUTTON LISTENER FOR SECOND DATE SELECTION
		SecondDateSelectionButtonListener date2Listener = new SecondDateSelectionButtonListener();
		date2SelectButton.addActionListener(date2Listener);
		dateComboBox2.setVisible(false);//sets the second ComboBox to not visible
		frame.getContentPane().add(dateComboBox2);
		date2SelectButton.setVisible(false);//sets second select button to not visible
		date2SelectButton.setBounds(462, 138, 85, 21);
		frame.getContentPane().add(date2SelectButton);
		generateSecondDateBox();
		
		//BUTTON FOR THIRD DATE SELECTION
		frame.getContentPane().add(dateComboBox3);
		dateComboBox3.setVisible(false);
		date3SelectButton.setVisible(false);
		ThirdDateSelectionButtonListener date3Listener = new ThirdDateSelectionButtonListener();
		date3SelectButton.addActionListener(date3Listener);
		date3SelectButton.setBounds(666, 140, 85, 21);
		frame.getContentPane().add(date3SelectButton);
		generateThirdDateBox();
		
		//BUTTON TO FINALIZE SCHEDULES AFTER PARENTS HAVE SELECTED
		createScheduleButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		createScheduleButton.setBounds(380, 593, 194, 57);
		frame.getContentPane().add(createScheduleButton);
		createScheduleButtonListener finalizeSubmitListener = new createScheduleButtonListener();
		createScheduleButton.addActionListener(finalizeSubmitListener);

		
		//FINAL SUBMISSOIN BUTTON
		finalSubmitButton.setVisible(false);
		FinalSubmitButtonListener finalSubmitListener = new FinalSubmitButtonListener();
		finalSubmitButton.addActionListener(finalSubmitListener);
		finalSubmitButton.setBounds(419, 191, 158, 66);
		frame.getContentPane().add(finalSubmitButton);
	
		//TEXT AREA FOR SCHEDULE DISPLAY
		textArea.setEditable(false);
		textArea.setFont(new Font("Calibri", Font.BOLD, 20));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(212, 169, 556, 380);
		frame.getContentPane().add(textArea);
		

	}

	/**
	 * 
	 */
	public void updateCurrentDateBox(String strDate, JComboBox dateBox) {
		dateBox.removeItem(strDate);
	}
	/**
	 * creates the ComboBox for parent name selection
	 */
	public void generateParentComboBox() {

		for (ParentVolunteer parent : pv.getParentsRemaining()) {
			parentComboBox.addItem(parent.getName());
		}
	}
	/**
	 * Create the application.
	 */
	public void updateDateBox(JComboBox dateBox, String strDate) {
		dateBox.removeItem(strDate);
	}
	/**
	 * Creates the first date ComboBox
	 */
	public void generateFirstDateBox() {

		for (LocalDate dates : cd.getInitialDateList()) {
			dateComboBox1.addItem(dates.toString());
		}
	}
	/**
	 * Creates the second date ComboBox
	 */
	public void generateSecondDateBox() {
		for (LocalDate dates : cd.getInitialDateList()) {
			dateComboBox2.addItem(dates.toString());
		}

	}
	/**
	 * Creates the third date ComboBox
	 */
	public void generateThirdDateBox() {
		for (LocalDate dates : cd.getInitialDateList()) {
			dateComboBox3.addItem(dates.toString());
		}
	}
	/**
	 * Hides the second and third date boxes so that the first date box is the only one visible
	 */
	public void resetDateBoxes() {
		dateComboBox2.setVisible(false);
		dateComboBox3.setVisible(false);
	}
	/**
	 * Iterates through the list of senior parents and assigns dates to them if selected dates are available
	 */
	public void assignDatesToSeniorParents() {
		for(ParentVolunteer parent : pv.getSeniorParents()) {
			LocalDate firstChoice = parent.getChoice1();
			LocalDate secondChoice = parent.getChoice2();
			LocalDate thirdChoice = parent.getChoice3();
			LocalDate dateAssigned = null;
			
			if(cd.checkDateAvailability(firstChoice)) {
				dateAssigned = firstChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else if(cd.checkDateAvailability(secondChoice)) {
				dateAssigned = secondChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else if(cd.checkDateAvailability(thirdChoice)) {
				dateAssigned = thirdChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else {
				parent.addToReSelect(parent);
			}
		}
	}
	/**
	 * Iterates through the list of junior parents and assigns dates to them if selected dates are available
	 */
	public void assignDatesToJuniorParents() {
		for(ParentVolunteer parent : pv.getJuniorParents()) {
			LocalDate firstChoice = parent.getChoice1();
			LocalDate secondChoice = parent.getChoice2();
			LocalDate thirdChoice = parent.getChoice3();
			LocalDate dateAssigned = null;
			
			if(cd.checkDateAvailability(firstChoice)) {
				dateAssigned = firstChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else if(cd.checkDateAvailability(secondChoice)) {
				dateAssigned = secondChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else if(cd.checkDateAvailability(thirdChoice)) {
				dateAssigned = thirdChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else {
				parent.addToReSelect(parent);
			}
		}
	}
	/**
	 * Iterates through the list of sophomore parents and assigns dates to them if selected dates are available
	 */
	public void assignDatesToSophomoreParents() {
		for(ParentVolunteer parent : pv.getSophomoreParents()) {
			LocalDate firstChoice = parent.getChoice1();
			LocalDate secondChoice = parent.getChoice2();
			LocalDate thirdChoice = parent.getChoice3();
			LocalDate dateAssigned = null;
			
			if(cd.checkDateAvailability(firstChoice)) {
				dateAssigned = firstChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else if(cd.checkDateAvailability(secondChoice)) {
				dateAssigned = secondChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else if(cd.checkDateAvailability(thirdChoice)) {
				dateAssigned = thirdChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else {
				parent.addToReSelect(parent);
			}
		}
	}
	/**
	 * Iterates through the list of freshman parents and assigns dates to them if selected dates are available
	 */
	public void assignDatesToFreshmanParents() {

		for(ParentVolunteer parent : pv.getFreshmanParents()) {
			LocalDate firstChoice = parent.getChoice1();
			LocalDate secondChoice = parent.getChoice2();
			LocalDate thirdChoice = parent.getChoice3();
			LocalDate dateAssigned = null;
			
			if(cd.checkDateAvailability(firstChoice)) {
				dateAssigned = firstChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else if(cd.checkDateAvailability(secondChoice)) {
				dateAssigned = secondChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else if(cd.checkDateAvailability(thirdChoice)) {
				dateAssigned = thirdChoice;
				parent.setDateAssigned(dateAssigned);
				cd.updateDatesRemaining(dateAssigned);
				addToMap(parent);
			}
			else {
				parent.addToReSelect(parent);
			}
		}
	}
	/**
	 * Iterates through the list of parents with no assigned date and assigns dates to them from remaining date list
	 */
	public void assignRemainingParents() {
		for(ParentVolunteer parent : pv.getParentsRemaining()) {	
			LocalDate dateAssigned = cd.getRemainingDates().poll();
			parent.setDateAssigned(dateAssigned);
			addToMap(parent);
		}
	}
	/**
	 * Adds the parent and date to the HashMap
	 */
	public void addToMap(ParentVolunteer parent) {
		LocalDate date = parent.getDateAssigned();
		parentAndDate.addParentAndDate(parent, date);
	}
	/**
	 * Hides all components used for selecting names and dates
	 */
	public void clearSelectionBoxes() {
		nameAndGradeSubmit.setVisible(false);
		gradeComboBox.setVisible(false);
		parentComboBox.setVisible(false);
		dateComboBox1.setVisible(false);
		dateComboBox2.setVisible(false);
		dateComboBox3.setVisible(false);
		nameSelectLabel.setVisible(false);
		gradeSelectLabel.setVisible(false);
		nameAndDateText.setVisible(false);
		createScheduleButton.setVisible(false);
		finalSubmitButton.setVisible(false);
	}
	/**
	 * Class used to perform action when finalize schedule button is clicked.
	 * Assigns dates as available in order of child's grade, then assigns parents who either did not get
	 * their original selections or did not request dates.
	 * Clears components used for selection and displays final schedule
	 */
	class createScheduleButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			assignDatesToSeniorParents();
			assignDatesToJuniorParents();
			assignDatesToSophomoreParents();
			assignDatesToFreshmanParents();
			assignRemainingParents();
			clearSelectionBoxes();
			parentAndDate.displayMap(textArea);	
		}
		
	}
	/**
	 * Class used for setting the parent selected to be updated
	 * 
	 */
	class FinalSubmitButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			pv.updateParentsRemaining(parentToUpdate);//removes parent from the remaining parents list
			String nameToRemove = parentToUpdate.getName();
			pv.addToPQueue(parentToUpdate);
			parentComboBox.removeItem(nameToRemove);//removes parents name from the comboBox
			nameAndGradeSubmit.setVisible(true);
			finalSubmitButton.setVisible(false);
			pv.addParentByGrade(parentToUpdate);//adds parent to appropriate list according to child's grade
			resetDateBoxes();//resets date boxes so that the first selection box is the only one visible

		}
	}
	/**
	 * Class used for submit button on third date comboBox
	 */
	class ThirdDateSelectionButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String dateString = dateComboBox3.getSelectedItem().toString();
			LocalDate date = cd.getDateFromString(dateString);
			parentToUpdate.setChoice3(date);//sets third date choice
			date3SelectButton.setVisible(false);
			finalSubmitButton.setVisible(true);
		}
	}
	/**
	 * Class used for submit button on second date comboBox
	 */
	class SecondDateSelectionButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {		
			String dateString = dateComboBox2.getSelectedItem().toString();
			LocalDate date = cd.getDateFromString(dateString);
			parentToUpdate.setChoice2(date);//sets second date choice
			dateComboBox3.setVisible(true);
			date3SelectButton.setVisible(true);
			date2SelectButton.setVisible(false);

		}
	}
	/**
	 * Class used for submit button on first date comboBox
	 */
	class FirstDateSelectionButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String dateString = dateComboBox1.getSelectedItem().toString();
			LocalDate date = cd.getDateFromString(dateString);
			parentToUpdate.setChoice1(date);//sets first date choice
			dateComboBox2.setVisible(true);
			date2SelectButton.setVisible(true);
			date1SelectButton.setVisible(false);
			
		}
	}
	/**
	 * Class used for submit button on name and grade comboBoxes
	 */
	class NameAndGradeButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().add(dateComboBox1);
			parentToUpdate = pv;
			String parentName = parentComboBox.getSelectedItem().toString();
			parentToUpdate = pv.getSelectedParent(parentName);
			parentToUpdate.setGradePriority(gradeComboBox.getSelectedItem().toString());
			dateComboBox1.setVisible(true);
			nameAndGradeSubmit.setVisible(false);
			date1SelectButton.setVisible(true);
			
		}
		
	}
}








