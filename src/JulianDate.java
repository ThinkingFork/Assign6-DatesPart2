
public class JulianDate extends Date {

	private int month = getCurrentMonth();
	private int day = getCurrentDayOfMonth();
	private int year = getCurrentYear();

	JulianDate() {
		super(1,1,1);
		long currentMillis = System.currentTimeMillis();
		long timeZoneMillis = java.util.TimeZone.getDefault().getRawOffset();
		long realMillis = currentMillis + timeZoneMillis;
		long daysSince = realMillis / 86400000;

		addDays(719164);
		addDays((int)daysSince);
	}

	JulianDate(int year, int month, int day) {
		super(year, month, day);
	}

	@Override
	public boolean isLeapYear(int year) {
		return (year % 4 == 0);
	}
	
}
