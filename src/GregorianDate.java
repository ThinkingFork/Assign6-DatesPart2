public class GregorianDate extends Date {

	/**
	 * Default constructor, Uses the Super overloaded constructor to calculate todays date
	 */
	GregorianDate() {
		super(1970,1,1);

		long currentMillis = System.currentTimeMillis();
		long timeZoneMillis = java.util.TimeZone.getDefault().getRawOffset();
		long realMillis = currentMillis + timeZoneMillis;
		long daysSince = realMillis / 86400000;

		addDays((int)daysSince);
	}

	/**
	 * Overloaded Constructor, Uses a specified date & uses the gregorian calendar
	 *
	 * @param year the specified year
	 * @param month	the specified month
	 * @param day the specified day
	 */
	GregorianDate(int year, int month, int day) {
		super(year, month, day);
	}

	/**
	 * Checks if a year is a leap year on the gregorian calendar
	 *
	 * @param year integer value of a year
	 * @return true if the year is a leap year, otherwise false
	 */
	@Override
	public boolean isLeapYear(int year) {
		return (year % 4 == 0) || (year % 100 != 0 && year % 400 == 0);
	}

}
