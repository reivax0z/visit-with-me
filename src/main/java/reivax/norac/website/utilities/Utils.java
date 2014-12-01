package reivax.norac.website.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	public static String getStringDateFromDate(Date d){
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(d);
	}
	
	public static Date getDateFromStringDate(String d){
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		try {
			return df.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String []args) throws ParseException{
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		System.out.println(df.parse("2014-03-12"));
		System.out.println(df.parse("2014-01-12"));
		System.out.println(df.parse("2014-02-12"));
		System.out.println(df.parse("2014-11-12"));
	}
}
