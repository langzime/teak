package im.dadoo.teak.util;

import org.jsoup.Jsoup;

public final class Util {

	public static final String MENU_SESSION_NAME = "menu";
	
	public static String parse(String html) {
		String result = Jsoup.parse(html).text().replaceAll("&nbsp;", " ");
		System.out.println(result);
		return result;
	}
}
