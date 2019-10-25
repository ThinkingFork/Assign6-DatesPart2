/**
 * This Class Lays the frame work for calculating Dates in any calendar
 *
 * @author Jonathan Jordan <>ThinkingFork99@gmail.com</>
 */
public class Date {

	private int month;
	private int day;
	private int year;

	/**
	 * Overloaded Constructor Used to find a specified date
	 *
	 * @param month the month
	 * @param day the day
	 * @param year the year
	 */
	Date(int year, int month, int day) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	/**
	 *Prints the Date in: Month D, YYYY Format to the Console
	 */
	void printLongDate() {
		System.out.printf("%s %d, %d", getCurrentMonthName(), this.day, this.year);
	}

	/**
	 * Prints the Date in: MM/DD/YYYY Format to the console
	 */
	void printShortDate() {
		System.out.printf("%d/%d/%d", this.month, this.day, this.year);
	}


	/**
	 * Adds Days to the current Day
	 *
	 * @param days How many days to add (int)
	 */
	void addDays(int days) {
		for (int i = 0; i < days; i++) {
			this.day += 1;
			if (this.day > getNumberOfDaysInMonth(this.year, this.month)) {
				this.day = 1;
				this.month++;
			}
			if (month > 12) {
				this.month = 1;
				this.year++;
			}
		}
	}

	/**
	 * Subtracts Days from the current day
	 *
	 * @param days How Many Day to subtract (int)
	 */
	void subtractDays(int days) {

		for (int i = 0; i < days; i++) {
			this.day -= 1;
			if (this.day < 1) {
				this.month--;
				if (this.month < 1){
					this.year--;
					this.month = 12;
				}
				this.day = getNumberOfDaysInMonth(this.year, this.month);
			}
		}
	}

	/**
	 * Check if it is a leap year
	 *
	 * @return true if it is a leap year, false otherwise
	 */
	public boolean isLeapYear() {
		return isLeapYear(this.year);
	}


	/**
	 * Checks if a year is a leap year
	 *
	 * @param year integer value of a year
	 * @return true if the year is a leap year, otherwise false
	 */
	public boolean isLeapYear(int year) {
		return false;
	}

	/**
	 * Give the integer value of the month
	 *
	 * @return an int of the current month
	 */
	int getCurrentMonth() {
		return this.month;
	}

	/**
	 * Gives the Full Month Name
	 *
	 * @return A String of the Month Provided
	 */
	String getCurrentMonthName() {
		String monthName = "";
		switch (month) {
			case 1:
				monthName = "January";
				break;
			case 2:
				monthName = "February";
				break;
			case 3:
				monthName = "March";
				break;
			case 4:
				monthName = "April";
				break;
			case 5:
				monthName = "May";
				break;
			case 6:
				monthName = "June";
				break;
			case 7:
				monthName = "July";
				break;
			case 8:
				monthName = "August";
				break;
			case 9:
				monthName = "September";
				break;
			case 10:
				monthName = "October";
				break;
			case 11:
				monthName = "November";
				break;
			case 12:
				monthName = "December";
				break;
			default:
				monthName = "Not a Valid Month";
				break;
		}
		return monthName;
	}

	/**
	 * Give the integer value of the day
	 *
	 * @return an int of the current day
	 */
	int getCurrentDayOfMonth() {
		return this.day;
	}

	/**
	 * Give the integer value of the year
	 *
	 * @return an int of the current year
	 */
	int getCurrentYear() {
		return this.year;
	}

	/**
	 * Determines How many days are in a specific month
	 *
	 * @param year the year in integer form
	 * @param month	the month in integer form
	 * @return	31 When month is 1,3,5,7,8,10,12. 30 when month 4,6,9,11. 29 or 28 for month 2 based of it being a leap year
	 */
	private int getNumberOfDaysInMonth(int year, int month){
		int numberOfDays = 0;
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				numberOfDays = 31;
				break;
			case 2:
				if (isLeapYear(year)) {
					numberOfDays = 29;
				}
				else {
					numberOfDays = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				numberOfDays = 30;
				break;
			default:
				break;
		}
		return numberOfDays;
	}
}
