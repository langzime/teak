package im.dadoo.teak.util;

import org.jsoup.Jsoup;

public final class Util {

	public static final String MENU_SESSION_NAME = "menu";
	
	public static final String LINK_SESSION_NAME = "sessionLinks";
	
	public static final String ROLL_SESSION_NAME = "roll";
	
	public static final Integer STATE_NORMAL = 0;
	public static final Integer STATE_DELETE = 1;
	
	public static final Integer MAX_RESULT = 15;
	
	public static String parse(String html) {
		String result = Jsoup.parse(html).text();
		System.out.println(result);
		return result;
	}
}
