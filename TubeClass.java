public class TubeClass {
	public static void main(String[] args) {
		MyChannel myChannel[] = { null, null, null, null, null, null, null };
		myChannel[0] = new MyChannel("PT", "팜나무", 20210730, Classy.CF_CLASSY);
		myChannel[1] = new MyChannel("CF", "ClockFire", 20210804, Classy.CF_CLASSY);
		myChannel[2] = new MyChannel("PR", "맥동전파원", 20220511, Classy.PN_CLASSY);
		myChannel[3] = new MyChannel("PN", "행성상성운", 20220710, Classy.PN_CLASSY);
		myChannel[4] = new MyChannel("BK", "BMI KINGDOM", 20220720, Classy.CF_CLASSY);
		myChannel[5] = new MyChannel("EC", "Escape", 20230101, Classy.EC_CLASSY);
		myChannel[6] = new MyChannel("EN", "Entire", 20240229, Classy.EC_CLASSY);
		
		for(MyChannel aMyChannel : myChannel) {
			System.out.println(aMyChannel);
		}
	}
}

class MyChannel {
	private String code;
	private String name;
	private Date birth;
	private Classy classy;
	
	public MyChannel(String code, String name, int birth, Classy classy) {
		this.code = code;
		this.name = name;
		this.birth = new Date(birth);
		this.classy = classy;
	}
	
	@Override
	public String toString() {
		return code + " - " + name + " / " + birth + " - " + classy;
	}
}

class Date {
	private int year;
	private int month;
	private int day;
	
	@Override
	public String toString() {
		return year + "년 " + month + "월 " + day + "일";
	}
	
	public Date(int date) {
		year = Curring.curring(0, date / 10000, 3001, 0);
		month = Curring.curring(0, date / 100 % 100, 13, 0);
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = Curring.curring(0, date % 100, 32, 0);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = Curring.curring(0, date % 100, 31, 0);
				break;
			case 2:
				if(year % 400 == 0) {
					day = Curring.curring(0, date % 100, 30, 0);
					break;
				}
				if(year % 100 == 0) {
					day = Curring.curring(0, date % 100, 29, 0);
					break;
				}
				if(year % 4 == 0) {
					day = Curring.curring(0, date % 100, 30, 0);
					break;
				}
				day = Curring.curring(0, date % 100, 29, 0);
				break;
			default:
				day = 0;
		}
	}
}

class Curring {
	public static int curring(int sOut, int num, int bOut, int err) {
		return (num > sOut && num < bOut) ? num : err;
	}
}

enum Classy {
	CF_CLASSY,
	PN_CLASSY,
	EC_CLASSY
}