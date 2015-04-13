package galv.utilities;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.TimeZone;


/**
 * Date utility class to manage date operations.
 * @author Talan Tunisia : imed.adalla.
 * @version 1.0 <br>
 *          Creation Date : 25 nov. 2010 <br>
 *          Modification Date : 25 nov. 2010 <br>
 */
public class DateUtility {

	/** The Constant AFTER. */
	public static final String AFTER = "after";

	/** The Constant BEFORE. */
	public static final String BEFORE = "before";

	/** The Constant BETWEEN. */
	public static final String BETWEEN = "between";

	/** La constante ONE_HOUR. */
	public static final long ONE_HOUR = 60 * 60 * 1000L;

	/** pattern Month-yyyy. */
	public static final String MONTH_AAAA_PATTERN = "MMM-yyyy";

	/** pattern Month-yyyy. */
	public static final String MM_YYYY_PATTERN = "MM-yyyy";

	/** The Constant dd_MMM_YY_PATTERN. */
	public static final String DD_MMM_YY_PATTERN = "dd-MMM-yy";

	/**
	 * pattern yyyyMMdd.
	 */
	public static final String AAAAMMJJ_PATTERN = "yyyyMMdd";

	/**
	 * pattern yyyy/MM/dd.
	 */
	public static final String AAAA_MM_JJ_PATTERN = "yyyy/MM/dd";

	/**
	 * Pattern dd-MM-yyyy.
	 */
	public static final String DD_MM_YYYY_DASH_SEP_PATTERN = "dd-MM-yyyy";

	/**
	 * pattern dd/MM/yyyy.
	 */
	public static final String JJ_MM_AAAA_PATTERN = "dd/MM/yyyy";

	/** The Constant MM_JJ_AAAA_PATTERN. */
	public static final String MM_JJ_AAAA_PATTERN = "MM/dd/yyyy";

	/**
	 * pattern yyyy/MM/dd HH:mm:ss,SSSS.
	 */
	public static final String AAAA_MM_JJ_HH_MM_SS_SSSS_PATTERN = "yyyy/MM/dd HH:mm:ss,SSSS";

	/**
	 * pattern yyyyMMddHHmmss.
	 */
	public static final String AAAA_MM_JJ_HH_MM_SS_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * pattern dd/MM/yyyy HH:mm:ss.
	 */
	public static final String JJ_MM_AAAA_HH_MM_SS_PATTERN = "dd/MM/yyyy HH:mm:ss";

	/**
	 * pattern dd/MM/yyyy \n HH:mm:ss.
	 */
	public static final String JJ_MM_AAAA_HH_N_MM_SS_PATTERN = "dd/MM/yyyy\nHH:mm:ss";

	/** The Constant MM_PATTERN. */
	public static final String MMM_PATTERN = "MMM";

	/** The Constant YY_PATTERN. */
	public static final String YY_PATTERN = "yy";

	/** The Constant MONTH_YY_PATTERN. */
	public static final String MONTH_YY_PATTERN = "MMMMMMMMM yyyy";

	/**
	 * Trois milles six cent.
	 */
	public static final int TROIS_MILLE_SIX_CENT = 3600;

	/**
	 * Vinght quatre.
	 */
	public static final int VINGHT_QUATRE = 24;

	/**
	 * Mille.
	 */
	public static final int MILLE = 1000;

	/**
	 * Nano utile à la convertion d'un timestamp en une date.
	 */
	private static final Integer NANO = 1000000;

	/** La constante HOURS_PER_DAY. */
	private static final long HOURS_PER_DAY = 24;

	/** The Constant MILLIS_IN_DAY. */
	public static final Integer MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

	/**
	 * Constructeur de la classe DateUtility.
	 */
	protected DateUtility() {
		super();
	}

	/**
	 * Get the today date (now).
	 * @return the today date
	 */
	public static Date now() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * Retourne la date du systeme sous format Timestamp.
	 * @return timestamp
	 */
	public static Timestamp getTimeStampDateSystem() {
		return getTimeStampDate(now());
	}

	/**
	 * Retourne la date sous format Timestamp.
	 * @param date
	 *            date
	 * @return timestamp
	 */
	public static Timestamp getTimeStampDate(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * Create the specified date.
	 * @param year
	 *            year
	 * @param month
	 *            month
	 * @param day
	 *            day
	 * @return the date corresponding to the parameters
	 */
	public static Date makeDate(int year, int month, int day) {
		Calendar cal = initCalandar(year, month, day);
		return cal.getTime();
	}

	/**
	 * Inits the calandar.
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param day
	 *            the day
	 * @return the calendar
	 */
	private static Calendar initCalandar(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal;
	}

	/**
	 * Transform the date to have informations about the date only and not the time.
	 * @param date
	 *            date to transform
	 * @return a date without time information
	 */
	public static Date dateAsDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		return cal.getTime();
	}

	/**
	 * Add some days to a date.
	 * @param date
	 *            date to add some days
	 * @param days
	 *            number of days to add
	 * @return date added of some days
	 */
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * Adds the minutes.
	 * @param date
	 *            the date
	 * @param minute
	 *            the minute
	 * @return the date
	 */
	public static Date addMinutes(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}

	/**
	 * Adds the months.
	 * @param date
	 *            the date
	 * @param month
	 *            the month
	 * @return date
	 */
	public static Date addMonths(Date date, int month) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	/**
	 * Adds the years.
	 * @param date
	 *            the date
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date addYears(Date date, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	/**
	 * Return the number of days between two dates.
	 * @param startDate
	 *            start date
	 * @param endDate
	 *            end date
	 * @return difference between the two dates
	 */
	public static int getDuration(Date startDate, Date endDate) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		return (int) ((endTime - startTime) / (VINGHT_QUATRE * TROIS_MILLE_SIX_CENT * MILLE));
	}

	/**
	 * Get the number of years between two date.
	 * @param birthDate
	 *            date of birth
	 * @param nowDate
	 *            actual date
	 * @return the age
	 */
	public static int getAge(Date birthDate, Date nowDate) {
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthDate);
		// Create a calendar object with today's date
		Calendar now = Calendar.getInstance();
		now.setTime(nowDate);
		// Get age based on year
		int age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		// Add the tentative age to the date of birth to get this year's
		// birthday
		birth.add(Calendar.YEAR, age);
		// If this year's birthday has not happened yet, subtract one from age
		if (now.before(birth)) {
			age--;
		}
		return age;
	}

	/**
	 * Return an iterator to iterate day by day between two date.
	 * @param startDate
	 *            start date
	 * @param endDate
	 *            end date
	 * @return the iterator
	 */
	public static Iterator<Object> iterator(final Date startDate, final Date endDate) {
		return new Iterator<Object>() {

			private Date currentDate = startDate;

			public boolean hasNext() {
				return (!currentDate.after(endDate));
			}

			public Object next() {
				if (hasNext()) {
					return addDays(currentDate, 1);
				} else {
					throw new NoSuchElementException(currentDate + " is after " + endDate);
				}
			}

			public void remove() {
				throw new UnsupportedOperationException("Date iterator is read only");
			}
		};
	}

	/**
	 * Return string formated of the date.
	 * @param date
	 *            date to format as string
	 * @return string representation of the date
	 */
	public static String format(Date date) {
		DateFormat formatter;
		if (date != null) {
			formatter = DateFormat.getDateInstance();
			return formatter.format(date);
		} else {
			return "Date n'est pas disponible.";
		}
	}


	/**
	 * Format date to string.
	 * @param pattern
	 *            the pattern
	 * @param date
	 *            the date
	 * @param language
	 *            the language
	 * @return the string
	 */
	public static String formatDateToString(String pattern, Date date, String language) {
		if (date != null) {
			DateFormat dateFormat = new SimpleDateFormat(pattern, new Locale(language));
			return (dateFormat.format(date));
		} else {
			return null;
		}
	}



	/**
	 * Convertir un timestamp en date.
	 * @param timestamp
	 *            timestamp à convertir
	 * @return date
	 */
	public static java.util.Date toDate(java.sql.Timestamp timestamp) {
		long milliseconds = timestamp.getTime() + (timestamp.getNanos() / NANO);
		return new java.util.Date(milliseconds);
	}

	/**
	 * Retourne true si la date est paire.
	 * @param date
	 *            date
	 * @return return true si la date est paire
	 */
	public static Boolean isPairDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return (day % 2 == 0);
	}


	/**
	 * Fonction for getting the month name.
	 * @param date
	 *            Current date
	 * @param locale
	 *            Locale
	 * @return name of month
	 */
	public static String getMonthNameFromDate(Date date, Locale locale) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
	}

	/**
	 * Gets the month name from date pattern.
	 * @param date
	 *            the date
	 * @param locale
	 *            the locale
	 * @param pattern
	 *            the pattern
	 * @return the month name from date pattern
	 */
	public static String getMonthNameFromDatePattern(Date date, Locale locale, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		DateFormat formatter = new SimpleDateFormat("MMM");
		return formatter.format(calendar.getTime());
	}

	/**
	 * Retrancher une année de la date.
	 * @param date
	 *            date
	 * @return date - 1 année
	 */
	public static Date getDateOneYearBefore(Date date) {
		Calendar cal = Calendar.getInstance();
		if (cal != null && date != null) {
			cal.setTime(date);
			// supprimer une année
			cal.add(Calendar.YEAR, -1);
			return cal.getTime();
		}
		return null;
	}

	/**
	 * Gets the date one month before.
	 * @param date
	 *            the date
	 * @return the date one month before
	 */
	public static Date getDateOneMonthBefore(Date date) {
		Calendar cal = Calendar.getInstance();
		if (cal != null && date != null) {
			cal.setTime(date);
			if (cal.get(Calendar.MONTH) == 0) {
				cal.add(Calendar.YEAR, -1);
				cal.set(Calendar.MONTH, Calendar.MONTH);
			} else {
				// supprimer un mois
				cal.add(Calendar.MONTH, -1);
			}
			return cal.getTime();
		}
		return null;
	}

	/**
	 * Retourne la date en lui ajoutant ou retranchant des années.
	 * @param date
	 *            date
	 * @param nbAnnees
	 *            nombre des années a ajouter si positif , a retrancher si négatif.
	 * @return date + nbAnnees
	 */
	public static Date getDateMoreOrLessYears(Date date, int nbAnnees) {
		Calendar cal = Calendar.getInstance();
		if (cal != null && date != null) {
			cal.setTime(date);
			// ajouter les mois
			cal.add(Calendar.YEAR, nbAnnees);
			return cal.getTime();
		}
		return null;
	}


	/**
	 * Différence de date en jours.
	 * @param startDate
	 *            debut
	 * @param endDate
	 *            fin
	 * @return diff
	 */
	public static int getDaysDifference(Date startDate, Date endDate) {
		Calendar date = Calendar.getInstance();
		date.setTime(startDate);
		int daysBetween = 0;
		while (date.getTime().before(endDate)) {
			date.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		return daysBetween + 1;
	}


	/**
	 * Neutralise une date en mettant hh:ss:mm à zero.
	 * @param date
	 *            date
	 * @return date neutralisée
	 */
	public static Date neutralise(Date date) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime();
		}
		return null;
	}

	/**
	 * Neutralise une date en mettant hh:ss:mm à zero.
	 * @param date
	 *            date
	 * @return date neutralisée
	 */
	public static Date neutraliseComplete(Date date) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime();
		}
		return null;
	}

	/**
	 * Neutralise une date en mettant hh:ss:mm à zero.
	 * @param date
	 *            date
	 * @return date neutralisée
	 */
	public static Date neutralise24h(Date date) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			return cal.getTime();
		}
		return null;
	}

	/**
	 * Lastday on year.
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date firstdayOnYear(Date date) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.MONTH, Calendar.JANUARY);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			return neutralise24h(cal.getTime());
		}
		return null;
	}

	/**
	 * compare de date sans tenu compte de heurs et minute te second.
	 * @param date1
	 *            Date
	 * @param date2
	 *            Date
	 * @return boolean
	 */
	public static boolean equalDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		return equalCalDate(cal1, cal2);
	}

	/**
	 * Equal cal date.
	 * @param cal1
	 *            the cal1
	 * @param cal2
	 *            the cal2
	 * @return true, if successful
	 */
	public static boolean equalCalDate(Calendar cal1, Calendar cal2) {
		if (cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
			&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
			&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))
			return true;
		return false;
	}

	/**
	 * compare de date sans tenu compte de jour et heurs et minute te second.
	 * @param date1
	 *            Date
	 * @param date2
	 *            Date
	 * @return boolean
	 */
	public static boolean equalDateWithoutDay(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		if (date1 != null && date2 != null) {
			cal1.setTime(date1);
			cal2.setTime(date2);
			if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Date1 after or equal date2.
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return true, if successful
	 */
	public static boolean date1AfterOrEqualDate2(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		if (date1 != null && date2 != null) {
			cal1.setTime(date1);
			cal2.setTime(date2);
			if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)) {
				return true;
			}
			if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.MONTH) >= cal2.get(Calendar.MONTH)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Date 1 After or equal date 2.
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return true, if successful
	 */
	public static boolean afterOrEqual(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		if (date1 != null && date2 != null) {
			cal1.setTime(date1);
			cal2.setTime(date2);
			if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)) {
				return true;
			}
			if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.MONTH) > cal2.get(Calendar.MONTH)) {
				return true;
			}
			if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.DAY_OF_MONTH) >= cal2.get(Calendar.DAY_OF_MONTH)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * compare de date sans tenu compte minute te second.
	 * @param date1
	 *            Date
	 * @param date2
	 *            Date
	 * @return boolean
	 */
	public static boolean equalDateHour(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		if (cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
			&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
			&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
			&& cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY))
			return true;
		return false;
	}

	/**
	 * vérifie si holiday.
	 * @param holidays
	 *            the holidays
	 * @param date
	 *            the date
	 * @return true, si c'est holiday
	 */
	public static boolean containsDateInList(List<Date> holidays, Date date) {
		if (holidays != null && !holidays.isEmpty()) {
			Calendar calendar1 = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			calendar1.setTime(date);
			for (Date holiday : holidays) {
				calendar2.setTime(holiday);
				if (calendar1.get(Calendar.DATE) == calendar2.get(Calendar.DATE)
					&& calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
					&& calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if is weekend.
	 * @param date
	 *            the date
	 * @return true, if is weekend
	 */
	public static boolean isWeekend(Date date) {
		Calendar cal = Calendar.getInstance();
		if (cal != null) {
			cal.setTime(date);
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is weekend.
	 * @param cal
	 *            the cal
	 * @return true, if is weekend
	 */
	public static boolean isWeekend(Calendar cal) {
		return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
	}

	/**
	 * Checks if is sunday.
	 * @param cal
	 *            the cal
	 * @return true, if is sunday
	 */
	public static boolean isSunday(Calendar cal) {
		return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}

	/**
	 * Checks if is saturday.
	 * @param cal
	 *            the cal
	 * @return true, if is saturday
	 */
	public static boolean isSaturday(Calendar cal) {
		return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
	}

	/**
	 * Checks if is weekend.
	 * @param cal
	 *            the cal1
	 * @return true, if is weekend
	 */
	public static boolean isNotWeekend(Calendar cal) {
		if (cal == null) {
			return true;
		}
		return (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
				&& (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY);
	}

	/**
	 * retourne le duration in is o8601.
	 * @param begin
	 *            the begin
	 * @param end
	 *            the end
	 * @return le duration in is o8601
	 */
	public static final String getDurationInISO8601Days(Date begin, Date end) {
		if (end == null)
			return "P400YT1S";
		long days = ((end.getTime() - begin.getTime() + ONE_HOUR) / (ONE_HOUR * HOURS_PER_DAY));
		if (days <= 0)
			return "PT1S";
		// In days
		return "P" + days + "DT1S";
		// In Minutes
		// return "PT" + days + "S";
	}

	/**
	 * retourne le duration in is o8601 days.
	 * @param begin
	 *            the begin
	 * @param end
	 *            the end
	 * @param moinsDate
	 *            the moins date
	 * @return le duration in is o8601 days
	 */
	public static final String getDurationInISO8601Days(Date begin, Date end, Integer moinsDate) {
		if (end == null)
			return "P400YT1S";
		long days = ((end.getTime() - begin.getTime() + ONE_HOUR) / (ONE_HOUR * HOURS_PER_DAY));
		if (days == 0 || (days - moinsDate) <= 0)
			return "PT1S";
		// In Days
		return "P" + (days - moinsDate) + "DT1S";
		// In Minutes
		// return "PT"+ (days - moinsDate) +"M";
	}

	/**
	 * Load to day.
	 * @return date
	 */
	public static final Date loadToDay() {
		return new Date();
	}

	/**
	 * Load to day.
	 * @param time
	 *            the time
	 * @return date
	 */
	public static final Date loadNewDate(Long time) {
		return new Date(time);
	}

	/**
	 * Load string date.
	 * @param date
	 *            the date
	 * @return string
	 */
	public static final String loadStringDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = "";
		if (date != null) {
			dateString = sdf.format(date);
		}
		return dateString;
	}


	/**
	 * load Enhanced Date format For Filter
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static final String loadEnhancedDateForFilter(Date date) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (date != null) {
			String dateFormat = "dd/MM/yyyy - kk:mm";
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			String s = sdf.format(date);
			s = s.replace("24:", "00:");
			stringBuilder.append(s);
		}
		return stringBuilder.toString();
	}

	/**
	 * Load start day on month.
	 * @param date
	 *            the date
	 * @return date
	 */
	public static final Date loadStartDayOnMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date startDate = cal.getTime();
		return startDate;
	}

	/**
	 * Load start day on year.
	 * @param date
	 *            the date
	 * @return date
	 */
	public static final Date loadStartDayOnYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		Date startDate = cal.getTime();
		return startDate;
	}

	/**
	 * Load start day on year.
	 * @param year
	 *            the year
	 * @return date
	 */
	public static final Date loadStartDayOnYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date lastDate = cal.getTime();
		return lastDate;
	}



	/**
	 * Le nombre de mois entre deux dates données.
	 * @param debut
	 *            the debut
	 * @param fin
	 *            the fin
	 * @return int
	 */
	public static int getNumberOfMonthsBeetweenTwoDates(Date debut, Date fin) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(debut);
		int minuendMonth = cal.get(Calendar.MONTH);
		int minuendYear = cal.get(Calendar.YEAR);
		cal.setTime(fin);
		int subtrahendMonth = cal.get(Calendar.MONTH);
		int subtrahendYear = cal.get(Calendar.YEAR);
		return ((minuendYear - subtrahendYear) * (cal.getMaximum(Calendar.MONTH) + 1))
				+ (minuendMonth - subtrahendMonth);
	}

	/**
	 * retourne le daysin is o8601.
	 * @param days
	 *            the days
	 * @return le daysin is o8601
	 */
	public static String getDaysinISO8601(Integer days) {
		if (days == null || days <= 0) {
			return "PT1S";
		}
		// days
		return "P" + days + "DT1S";
		// minutes
		// return "PT"+days+"S";
	}

	/**
	 * Date to iso.
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String dateToIso(Date date) {
		DateFormat ISO_8601_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
		ISO_8601_DATE_TIME.setTimeZone(TimeZone.getTimeZone("UTC"));
		String string = "1305637849064";
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(Long.parseLong(string));
		String outDate = ISO_8601_DATE_TIME.format(date);
		return outDate;
	}

	/**
	 * Gets the secsin is o8601.
	 * @param sec
	 *            the sec
	 * @return the secsin is o8601
	 */
	public static String getSecsinISO8601(Integer sec) {
		if (sec == null || sec <= 0) {
			return "PT1S";
		}
		// days
		return "PT" + sec + "S";
		// minutes
		// return "PT"+days+"S";
	}

	/**
	 * Extract value.
	 * @param date
	 *            the date
	 * @param type
	 *            the type
	 * @return int
	 */
	public static int extractValue(Date date, int type) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(type);
	}

	/**
	 * Gets the year from date.
	 * @param date
	 *            the date
	 * @return the year from date
	 */
	public static long getYearFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * Gets the hour from date.
	 * @param date
	 *            the date
	 * @return the hour from date
	 */
	public static long getHourFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Gets the month from date.
	 * @param date
	 *            the date
	 * @return the mont from date
	 */
	public static int getMonthFromDate(Date date) {
		if (date == null) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * retourne l'intervalle en nombre de jours.
	 * @param beginDate
	 *            beginDate
	 * @param endDate
	 *            endDate
	 * @param holidays
	 *            the holidays
	 * @return diference
	 */
	public static int getWorkingDaysPeriod(Date beginDate, Date endDate, List<Date> holidays) {
		int dayNumber = 0;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(beginDate);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(endDate);
		while (!neutralise24h(cal2.getTime()).before(neutralise24h(cal1.getTime()))) {
			if (!containsDateInList(holidays, neutralise24h(cal1.getTime()))) {
				if ((cal1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
					&& (cal1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
					dayNumber++;
				}
			}
			cal1.add(Calendar.DATE, 1);
		}
		return dayNumber;
	}

	/**
	 * Gets the next working day by date.
	 * @param holidays
	 *            the holidays
	 * @param date
	 *            the date
	 * @return the next working day by date
	 */
	public static Date getNextWorkingDay(List<Date> holidays, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		while (true) {
			if (!holidays.contains(neutraliseComplete(calendar.getTime()))) {
				if ((calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
					&& (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
					break;
				}
			}
			calendar.add(Calendar.DATE, 1);
		}
		return calendar.getTime();
	}

	/**
	 * retourne le nombre de jours sans compter les weekend.
	 * @param holidays
	 *            the holidays
	 * @return daysNumber
	 */
	public static int getHolidaysNotWeekendDays(List<Date> holidays) {
		int dayNumber = 0;
		for (Date date : holidays) {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date);
			if ((cal1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
				&& (cal1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
				dayNumber++;
			}
		}
		return dayNumber;
	}

	/**
	 * retourne le nombre de jours weekend.
	 * @param beginDate
	 *            the beginDate
	 * @param endDate
	 *            the endDate
	 * @return diference
	 */
	public static int getWeekendDays(Date beginDate, Date endDate) {
		int dayNumber = 0;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(beginDate);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(endDate);
		while (!neutralise24h(cal2.getTime()).before(neutralise24h(cal1.getTime()))) {
			if ((cal1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
				|| (cal1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				dayNumber++;
			}
			cal1.add(Calendar.DATE, 1);
		}
		return dayNumber;
	}

	/**
	 * Load calendar by date.
	 * @param date
	 *            the date
	 * @return the calendar
	 */
	public static Calendar loadCalendarByDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * Load calendar by date and neutralise.
	 * @param date
	 *            the date
	 * @return the calendar
	 */
	public static Calendar loadCalendarByDateAndNeutralise(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal;
	}


	/**
	 * Gets the date by year and month.
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the date by year and month
	 */
	public static Date getBeforDateByYearAndMonthForPayRolls(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 2);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * Gets the date by year and month.
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the date by year and month
	 */
	public static Date getDateByYearAndMonthForPayRolls(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * Gets the nbr week on month.
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the nbr week on month
	 */
	public static int getNbrWeekOnMonth(int year, int month) {
		Calendar cal = initCalandar(year, month, 1);
		cal.setMinimalDaysInFirstWeek(1);
		return cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * Return formatted duration between two dates
	 * @param debut
	 *            : date de début
	 * @param fin
	 *            : date de fin
	 * @param resources
	 *            : resource bundle
	 * @return X year(s) andLabel X month(s) andLabel X day(s)
	 */
	public static String calculDuree(Date debut, Date fin, ResourceBundle resources) {
		if (null == fin || null == debut) {
			return "";
		}
		String yearLabel = resources.getString("duree.label.oneyear");
		String yearsLabel = resources.getString("duree.label.years");
		String monthLabel = resources.getString("duree.label.onemonth");
		String monthsLabel = resources.getString("duree.label.months");
		String dayLabel = resources.getString("duree.label.oneday");
		String daysLabel = resources.getString("duree.label.days");
		String andLabel = resources.getString("duree.label.and");
		if (fin.before(debut)) {
			return "";
		}
		String space = " ";
		String yearFinalLabel = "";
		String dayFinalLabel = "";
		String monthFinalLabel = "";
		StringBuilder duree = new StringBuilder();
		int years;
		int months;
		int days;
		final int joursNegligeables = 15;
		years = (int) (getYearFromDate(fin) - getYearFromDate(debut));
		months = getMonthFromDate(fin) - getMonthFromDate(debut);
		days = getDuration(debut, fin);
		if (days > joursNegligeables && months != 0) {
			months = months + 1;
		}
		// Get the label to show
		if (years == 1) {
			yearFinalLabel = yearLabel;
		} else {
			yearFinalLabel = yearsLabel;
		}
		if (days == 1) {
			dayFinalLabel = dayLabel;
		} else {
			dayFinalLabel = daysLabel;
		}
		if (months == 1) {
			monthFinalLabel = monthLabel;
		} else {
			monthFinalLabel = monthsLabel;
		}
		// Switch month/year/day label according to result
		if (months == 0) {
			if (years == 0) {
				duree.append(days).append(space).append(dayFinalLabel);
			} else {
				duree.append(years).append(space).append(yearFinalLabel);
			}
		} else {
			if (years == 0) {
				duree.append(Math.abs(months)).append(space).append(monthFinalLabel);
			} else {
				duree.append(years).append(space).append(yearFinalLabel).append(space).append(andLabel).append(space)
						.append(Math.abs(months)).append(space).append(monthFinalLabel);
			}
		}
		String dureeValue = duree.toString();
		return dureeValue;
	}

	/**
	 * Gets the day of month from date.
	 * @param date
	 *            the date
	 * @return the day of month from date
	 */
	public static int getDayOfMonthFromDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Counts the working days including public holidays
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @return the business days count
	 */
	public static int getBusinessDaysCount(Date startDate, Date endDate) {
		Calendar calendar = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date start = null;
		Date end = null;
		try {
			start = formatter.parse(formatter.format(startDate));
			end = formatter.parse(formatter.format(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(start.after(end)){
			return -1;
		}
		int businessDaysCount = 0;
		calendar.setTime(start);
		do {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			if (isWorkingDay(calendar.getTime())) {
				businessDaysCount++;
			}
		} while (calendar.getTime().before(end) || calendar.getTime().equals(end));
		return businessDaysCount;
	}

	/**
	 * Checks if Date is working day including public holidays
	 * @param date
	 *            the date
	 * @return true, if is working day
	 */
	public static boolean isWorkingDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
			return false;
		}
		return true;
	}
}
