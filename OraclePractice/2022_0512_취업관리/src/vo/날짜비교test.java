package vo;

import java.time.LocalDate;

public class 날짜비교test {

	public static void main(String[] args) throws Exception{
		//https://hianna.tistory.com/611
		String[] dates = {"2022-04-22","2022-05-21"};
		
		LocalDate[] date = new LocalDate[2];
		
		for (int i = 0; i < 2; i++) {
			
			int year = Integer.parseInt(dates[i].substring(0,4));
			int month = Integer.parseInt(dates[i].substring(5,7));
			int day = Integer.parseInt(dates[i].substring(8,10));
			
			date[i] = LocalDate.of(year, month, day);
		}
		
		System.out.println(date[1].isAfter(date[0]));
	}

}
