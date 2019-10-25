/**
 * @author Jonathan Jordan <>ThinkingFork99@gmail.com</>
 */
public class Date {

	private int month;
	private int day;
	private int year;

	/**
	 *
	 * @param month
	 * @param day
	 * @param year
	 */
	Date(int year, int month, int day) {
		this.month = month;
		this.day = day;
		this.year = year;
	}


	void printLongDate() {
		System.out.printf("%s %d, %d", getCurrentMonthName(), this.day, this.year);
	}

	void printShortDate() {
		System.out.printf("%d/%d/%d", this.month, this.day, this.year);
	}



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

	public boolean isLeapYear() {
		return isLeapYear(this.year);
	}

	public boolean isLeapYear(int year) {
		return false;
	}

	int getCurrentMonth() {
		return this.month;
	}

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

	int getCurrentDayOfMonth() {
		return this.day;
	}

	int getCurrentYear() {
		return this.year;
	}

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
