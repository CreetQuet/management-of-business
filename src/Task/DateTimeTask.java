package Task;

import java.util.Date;  
import java.text.SimpleDateFormat;
import java.util.TimerTask;

import View.BuyPointView;

public class DateTimeTask extends TimerTask{

	private Date date;
	private Date time;
	private String strDate;
	private String strTime;
	
	private SimpleDateFormat timeFormat;
	private SimpleDateFormat day, month, year;
	private BuyPointView view;
	
	public DateTimeTask(BuyPointView v) {
		view = v;
		date = new Date();  
		day = new SimpleDateFormat("dd");
		month = new SimpleDateFormat("MM");
		year = new SimpleDateFormat("yyy");
		
		timeFormat = new SimpleDateFormat("HH:mm");
		//strDate = formatter.format(date);
		strDate = day.format(date) + "/" + monthString(month.format(date)) + "/" + year.format(date);
	}
	
	@Override
	public void run() {
		 time = new Date();
		 strTime = timeFormat.format(time);
		// System.out.println(strTime);
		 view.lblDate.setText(strDate);
		 view.lblTime.setText(strTime);
	}
	
	public String monthString(String mont) {
		int m = Integer.parseInt(mont);
		String month = "";
		
		switch(m) {
			case 1:
				month = "Ene";
				break;
			case 2:
				month = "Feb";
				break;
			case 3:
				month = "Mzo";
				break;
			case 4:
				month = "Abr";
				break;
			case 5:
				month = "May";
				break;
			case 6:
				month = "Jun";
				break;
			case 7:
				month = "Jul";
				break;
			case 8:
				month = "Ago";
				break;
			case 9:
				month = "Sep";
				break;
			case 10:
				month = "Oct";
				break;
			case 11:
				month = "Nov";
				break;
			case 12:
				month = "Dic";
				break;
			default:
				month = "Uknow";
				break;
		}
		return month;
	}
}
