package ConcessionSignUp;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**  
* Brady Trenary - bbtrenary  
* CIS171 26847  
* Dec 3, 2021  
*/
class concessionSignUpTest {
	static ParentVolunteer pv = new ParentVolunteer();
	static concessionDates cd = new concessionDates();
	static ParentAndDate pd = new ParentAndDate();
	static WindowBuilder wb = new WindowBuilder();
	LocalDate date1 = LocalDate.of(2022, 6, 10);
	LocalDate date2 = LocalDate.of(2022, 6, 11);
	LocalDate date3 = LocalDate.of(2022, 6, 12);
	LocalDate date4 = LocalDate.of(2022, 6, 14);
	LocalDate date5 = LocalDate.of(2022, 6, 16);
	LocalDate date6 = LocalDate.of(2022, 6, 20);
	LocalDate date7 = LocalDate.of(2022, 6, 21);
	LocalDate date8 = LocalDate.of(2022, 6, 22);
	LocalDate date9 = LocalDate.of(2022, 6, 23);
	LocalDate date10 = LocalDate.of(2022, 6, 24);
	
	ParentVolunteer parent1 = pv.newParent("John Smith", date1, date2, date3);
	ParentVolunteer parent2 = pv.newParent("Jane Jones", date1, date2, date3);
	ParentVolunteer parent3 = pv.newParent("Brad Johnson", date1, date2, date5);
	ParentVolunteer parent4 = pv.newParent("Pam Davis", null, null, null);
	ParentVolunteer parent5 = pv.newParent("Jodi Anderson", date7, date2, date3);
	ParentVolunteer parent6 = pv.newParent("Phil Turner", date1, date2, date3);
	ParentVolunteer parent7 = pv.newParent("Albert Rios", null, null, null);
	ParentVolunteer parent8 = pv.newParent("Kellie Curtis", date1, date2, date3);
	ParentVolunteer parent9 = pv.newParent("Bob Rivers", date1, date2, date3);
	ParentVolunteer parent10 = pv.newParent("Allan McGee", null, null, null);

	@Test
	public void testGetName() {
		String actual, expected;
		actual = parent1.getName();
		expected = "John Smith";
		
		assertEquals(actual,expected);
	}
	@Test
	public void testGetGradeNumFreshman() {
		parent1.setGradePriority("freshman");
		int actual, expected;
		actual = parent1.getGradeNum();
		expected = 1;
		
		assertEquals(actual,expected);
	}
	@Test
	public void testGetGradeNumSophomore() {
		parent1.setGradePriority("sophomore");
		int actual, expected;
		actual = parent1.getGradeNum();
		expected = 2;
		
		assertEquals(actual,expected);
	}
	@Test
	public void testGetGradeNumJunior() {
		parent1.setGradePriority("junior");
		int actual, expected;
		actual = parent1.getGradeNum();
		expected = 3;
		
		assertEquals(actual,expected);
	}
	@Test
	public void testGetGradeNumSenior() {
		parent1.setGradePriority("senior");
		int actual, expected;
		actual = parent1.getGradeNum();
		expected = 4;
		
		assertEquals(actual,expected);
	}
	@Test
	public void testGetDateAssigned() {
		parent1.setDateAssigned(date1);
		LocalDate actual, expected;
		actual = parent1.getDateAssigned();
		expected = LocalDate.of(2022, 6, 10);
		
		assertEquals(actual,expected);
	}
	@Test
	public void testUpdateParentsRemainingFalse() {
		boolean expected, actual;
		pv.updateParentsRemaining(parent1);
		pv.updateParentsRemaining(parent2);
		pv.updateParentsRemaining(parent3);
		pv.updateParentsRemaining(parent4);
		expected = false;
		actual = pv.getParentsRemaining().contains(parent1);
		assertEquals(actual,expected);
	}
	@Test
	public void testUpdateParentsRemainingTrue() {
		boolean expected, actual;
		pv.updateParentsRemaining(parent1);
		pv.updateParentsRemaining(parent2);
		pv.updateParentsRemaining(parent3);
		pv.updateParentsRemaining(parent4);
		expected = true;
		actual = pv.getParentsRemaining().contains(parent6);
		assertEquals(actual,expected);
	}
	@Test
	public void testProperDateAssigned() {
		LocalDate expected, actual;
		parent1.setGradePriority("freshman");
		parent2.setGradePriority("senior");
		parent3.setGradePriority("junior");
		parent4.setGradePriority("sophomore");
		parent5.setGradePriority("freshman");
		parent6.setGradePriority("senior");
		parent7.setGradePriority("junior");
		parent8.setGradePriority("sophomore");
		parent9.setGradePriority("senior");
		parent10.setGradePriority("sophomore");
		
		pv.addToPQueue(parent1);
		pv.addToPQueue(parent2);
		pv.addToPQueue(parent3);
		pv.addToPQueue(parent4);
		pv.addToPQueue(parent5);
		pv.addToPQueue(parent6);
		pv.addToPQueue(parent7);
		pv.addToPQueue(parent8);
		pv.addToPQueue(parent9);
		pv.addToPQueue(parent10);
		
		
		wb.assignDatesToSeniorParents();
		wb.assignDatesToJuniorParents();
		wb.assignDatesToSophomoreParents();
		wb.assignDatesToFreshmanParents();
		
		expected = LocalDate.of(2022, 6, 10);
		actual = parent2.getDateAssigned();
	}
}
