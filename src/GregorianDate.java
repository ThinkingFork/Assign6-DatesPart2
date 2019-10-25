public class GregorianDate extends Date {

	GregorianDate() {
		super(1970,1,1);

		long currentMillis = System.currentTimeMillis();
		long timeZoneMillis = java.util.TimeZone.getDefault().getRawOffset();
		long realMillis = currentMillis + timeZoneMillis;
		long daysSince = realMillis / 86400000;

		addDays((int)daysSince);
	}

	GregorianDate(int year, int month, int day) {
		super(year, month, day);
	}

	@Override
	public boolean isLeapYear(int year) {
		return (year % 4 == 0) || (year % 100 != 0 && year % 400 == 0);
	}

}
