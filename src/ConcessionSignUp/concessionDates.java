package ConcessionSignUp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Brady Trenary - bbtrenary CIS171 26847 Dec 3, 2021
 */
public class concessionDates {

	private LocalDate date;

	private LocalDate date1 = LocalDate.of(2022, 6, 10);
	private LocalDate date2 = LocalDate.of(2022, 6, 11);
	private LocalDate date3 = LocalDate.of(2022, 6, 12);
	private LocalDate date4 = LocalDate.of(2022, 6, 14);
	private LocalDate date5 = LocalDate.of(2022, 6, 16);
	private LocalDate date6 = LocalDate.of(2022, 6, 20);
	private LocalDate date7 = LocalDate.of(2022, 6, 21);
	private LocalDate date8 = LocalDate.of(2022, 6, 22);
	private LocalDate date9 = LocalDate.of(2022, 6, 23);
	private LocalDate date10 = LocalDate.of(2022, 6, 24);
	private LinkedList<LocalDate> initialDateList = new LinkedList<LocalDate>(Arrays.asList(date1, date2, date3, date4,
			date5, date6, date7, date8, date9, date10));
	private LinkedList<LocalDate> remainingDates = initialDateList;

	public concessionDates() {

	}

	public concessionDates(LocalDate date) {
		this.date = date;
	}

	/**
	 * Converts LocalDate into string to display
	 */
	public String displayDateAsString(LocalDate date) {
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();

		String monthString;
		switch (month) {
		case 1:
			monthString = "January";
			break;
		case 2:
			monthString = "February";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "June";
			break;
		case 7:
			monthString = "July";
			break;
		case 8:
			monthString = "August";
			break;
		case 9:
			monthString = "September";
			break;
		case 10:
			monthString = "October";
			break;
		case 11:
			monthString = "November";
			break;
		case 12:
			monthString = "December";
			break;
		default:
			monthString = "Invalid month";
			break;
		}
		String dateString = monthString + " " + day;

		return dateString;
	}
	/**
	 * Checks to see if date is still available
	 */
	public boolean checkDateAvailability(LocalDate date) {
		return remainingDates.contains(date);
	}
	/**
	 * removes the date from the list of remaining dates
	 */
	public void updateDatesRemaining(LocalDate date) {
		remainingDates.remove(date);
	}
	/**
	 * gets the list of remaining dates
	 */
	public LinkedList<LocalDate> getRemainingDates() {
		return remainingDates;
	}
	/**
	 * Converts string to LocalDate
	 */
	public LocalDate getDateFromString(String strDate) {
		LocalDate date = LocalDate.parse(strDate);
		return date;
	}

	/**
	 * gets initial date list
	 */
	public LinkedList<LocalDate> getInitialDateList() {
		return initialDateList;
	}
	/**
	 * returns date as a string
	 */
	public String getDateAsString(LocalDateTime date) {
		String StrDate = date.toString();
		return StrDate;
	}

	@Override
	public String toString() {
		return date.toString();
	}

}
