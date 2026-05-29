import java.util.List;
import java.util.ArrayList;

public class TubeClass {
	public static void main(String[] args) {
		List<MyChannel> myChannel = new ArrayList<>();
		myChannel.add(new MyChannel("PT", "팜나무", new IntDate(20210730), Classy.CF_CLASSY, "팜나무"));
		myChannel.add(new MyChannel("CF", "ClockFire", new IntDate(20210804), Classy.CF_CLASSY, "OTL-3"));
		myChannel.add(new MyChannel("PR", "맥동전파원", new IntDate(20220511), Classy.PN_CLASSY, "맥동전파원"));
		myChannel.add(new MyChannel("PN", "행성상성운", new IntDate(20220710), Classy.PN_CLASSY, "오정민"));
		myChannel.add(new MyChannel("BK", "BMI KINGDOM", new IntDate(20220720), Classy.CF_CLASSY, "지방"));
		myChannel.add(new MyChannel("EC", "Escape", new IntDate(20230101), Classy.EC_CLASSY, "Escape_Cosmos"));
		myChannel.add(new MyChannel("EN", "Entire", new IntDate(20240229), Classy.EC_CLASSY, "Entire_Neuron"));
		
		for(MyChannel aMyChannel : myChannel) {
			System.out.println(aMyChannel);
		}
	}
}

class MyChannel {
	private final String code;
	private String name;
	private String handle;
	private final IntDate birth;
	private Classy classy;
	
	public MyChannel(String code, String name, IntDate birth, Classy classy, String handle) {
		this.code = code;
		this.name = name;
		this.handle = handle;
		this.birth = birth;
		this.classy = classy;
	}
	
	@Override
	public String toString() {
		return code + " - " + name + " - @" + handle + " / " + birth + " - " + classy;
	}
	
	public String getStringData(getThisString dataType) {
		switch(dataType) {
			case CODE:
				return code;
			case NAME:
				return name;
			case HANDLE:
				return handle;
			case BIRTH:
				return birth.toString();
			case CLASSY:
				return classy.toString();
			default:
				return "ERROR_" + dataType.toString();
		}
	}
	
	public boolean setStringData(getThisString dataType, String setData) {
		switch(dataType) {
			case NAME:
				name = setData;
				return true;
			case HANDLE:
				handle = setData;
				return true;
			default:
				return false;
		}
	}
	
	public boolean setClassyData(Classy setData) {
		classy = setData;
		return true;
	}
}

class IntDate {
	private static final int[] daysOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int THE_LAST_YEAR = 3000;
	private static final int LEAP_YEAR_FEBRUARY = 29;
	
	public final int year;
	public final int month;
	public final int day;
	
	@Override
	public String toString() {
		return year + "년 " + month + "월 " + day + "일";
	}
	
	public IntDate(int date) {
		year = RangeCheck.rangeCheck(0, date / 10000, THE_LAST_YEAR + 1, 0);
		month = RangeCheck.rangeCheck(0, date / 100 % 100, 12 + 1, 0);
		day = month != 2 ? RangeCheck.rangeCheck(0, date % 100, daysOfMonth[month] + 1, 0)
			: year % 400 == 0 ? RangeCheck.rangeCheck(0, date % 100, LEAP_YEAR_FEBRUARY + 1, 0)
			: year % 100 == 0 ? RangeCheck.rangeCheck(0, date % 100, daysOfMonth[month] + 1, 0)
			: year % 4 == 0 ? RangeCheck.rangeCheck(0, date % 100, LEAP_YEAR_FEBRUARY + 1, 0)
			: RangeCheck.rangeCheck(0, date % 100, daysOfMonth[month] + 1, 0);
	}
}

class RangeCheck {
	private RangeCheck() {};
	
	public static int rangeCheck(int sOut, int num, int bOut, int err) {
		return (num > sOut && num < bOut) ? num : err;
	}
}

enum Classy {
	CF_CLASSY,
	PN_CLASSY,
	EC_CLASSY
}

enum getThisString {
	CODE,
	NAME,
	HANDLE,
	BIRTH,
	CLASSY
}