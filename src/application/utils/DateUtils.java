package application.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.control.DatePicker;

public class DateUtils {

	public static String converterData(DatePicker data) {
		LocalDate ld = data.getValue();
		Calendar c = Calendar.getInstance();
		c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
		Date dataConvertida = c.getTime();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(dataConvertida);
	}
}
