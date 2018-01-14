package com.xc.basic.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
	public  final static String datePatten1 = "yyyy-MM-dd";
	    public  final static String datePatten2 = "yyyy-MM-dd HH:mm";
	    public  final static String datePatten3 = "yyyy-MM-dd HH:mm:ss";
	    
		// DATE，日期 DATE_TIME，时间
		public final static SimpleDateFormat dateFormat = new SimpleDateFormat(datePatten1);
		public final static SimpleDateFormat timeFormat = new SimpleDateFormat(datePatten3);
		public final static SimpleDateFormat otherFormat = new SimpleDateFormat("yyyy/MM/dd");
		public final static SimpleDateFormat chineseFormat = new SimpleDateFormat("yyyy年MM月dd日");

		// private final static SimpleDateFormat yearFormat=new
		// SimpleDateFormat("yyyy");

		public static Timestamp getOtherFormatTime(String date) {
			if (date != null && !"".equals(date)) {
				try {
					Date dateTime = dateFormat.parse(date);
					Timestamp timestamp = new Timestamp(dateTime.getTime());
					return timestamp;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		
		 
	    public static java.sql.Date formateSqlDate(java.sql.Date date){
	        try {
	            java.util.Date d1 = dateFormat.parse(getTimeString(date));
	            java.sql.Date d = new java.sql.Date(d1.getTime());
	            return d;
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
		
		
		public static String getDateString(Date date, String format) {
			if (date == null) {
				return null;
			}
			SimpleDateFormat df = new SimpleDateFormat(format);
			return df.format(date);
		}

		public static String getDateString(Date date) {
			if (date == null) {
				return null;
			}
			String time = dateFormat.format(date);
			return time;
		}
		
		public static String getDateString(Timestamp time) {
			if (time == null) {
				return null;
			}
			Date date = new Date(time.getTime());
			return dateFormat.format(date);
		}

		public static String getTimeString(Date date) {
			if (date == null) {
				return null;
			}
			String time = timeFormat.format(date);
			return time;
		}

		public static String getTimeString(Timestamp time) {
			if (time == null) {
				return null;
			}
			Date date = new Date(time.getTime());
			return timeFormat.format(date);
		}

		public static String getTimeString(Timestamp time, String format) {
			if (time == null) {
				return null;
			}
			SimpleDateFormat df = new SimpleDateFormat(format);
			Date date = new Date(time.getTime());
			return df.format(date);
		}

		public static Date getDate(String dateStr) {
			if (StringUtils.isNll(dateStr)) {
				return null;
			}
			Date time = null;
			try {
				time = dateFormat.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return time;
		}

		public static Date getDate(String dateStr,String pattern) throws ParseException {
	        if (StringUtils.isNll(dateStr)) {
	            return null;
	        }
	        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
	        return dateFormat.parse(dateStr);
	    }
		
		public static Timestamp getTime(String timeStr) {
			if (StringUtils.isNll(timeStr)) {
				return null;
			}
			Timestamp ts = null;
			try {
				ts = Timestamp.valueOf(timeStr);
			} catch (Exception e) {
				try {
					ts = Timestamp.valueOf(timeStr + " 00:00:00");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			return ts;
		}

		public static String getDateYYYYMMDD(Date date) {
			return getDateString(date).replaceAll("-", "");
		}
		
		public static String getTimeStampString(Timestamp time) {
			if (time == null) {
				return null;
			}
			Date date = new Date(time.getTime());
			return dateFormat.format(date);
		}

		public static java.sql.Date getCurrentSqlDate() {

			Date date = new Date();
//			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
			try {
				java.util.Date d1 = timeFormat.parse(getTimeString(date));
				java.sql.Date d = new java.sql.Date(d1.getTime());
				return d;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static java.sql.Date getCurrentDate() {
			/**
			 * 获取存的路径 保存到数据库中的路径 调用上传FTP方法 获取访问路径
			 * */
			Date date = new Date();
//			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");// 24小时制
			try {
				java.util.Date d1 = timeFormat.parse(getTimeString(date));
				java.sql.Date d = new java.sql.Date(d1.getTime());
				return d;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		public static java.sql.Timestamp getCurrentTimestamp() {
			Date date = new Date();
			return new java.sql.Timestamp(date.getTime());

		}

		public static java.sql.Date getCurrentAddSqlDate(int days) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, days);
			return new java.sql.Date(calendar.getTime().getTime());
		}

		// 获取

		public static String formatSqlDate(java.sql.Date date) {
			if (date != null)
				return dateFormat.format(date);
			return null;
		}

		public static java.sql.Date getStringSqlDate(String dateStr) {
			return getStringSqlDate(dateStr, dateFormat);
		}

		public static java.sql.Date getStringSqlDate(String dateStr, SimpleDateFormat dateFormat) {

			if (null != dateStr && !"".equals(dateStr)) {
				try {
					java.util.Date utilDate = dateFormat.parse(dateStr);
					return new java.sql.Date(utilDate.getTime());
				} catch (ParseException e) { }
			}
			return null;
		}

		public static String getChineseDate(java.sql.Date date) {
			if (date != null)
				return chineseFormat.format(date);
			return null;
		}

		public static String timeFormatSqlDate(java.sql.Date date) {
			if (date != null) {
				return timeFormat.format(date);
			}
			return null;
		}

		public static String getCurrentYear() {
			Calendar cal = Calendar.getInstance();
			String year = cal.get(Calendar.YEAR) + "";
			return year;
		}
		public static String getCurrentMonth(boolean flagZero) {
			Calendar cal = Calendar.getInstance();
			int m = cal.get(Calendar.MONTH) + 1;
			String month = m + "";
			if (flagZero && m < 10) {
				month = "0" + month;
			}
			return month;
		}

		public static String getCurrentDay(boolean flagZero) {
			Calendar cal = Calendar.getInstance();
			int d = cal.get(Calendar.DAY_OF_MONTH);
			String day = d + "";
			if (flagZero && d < 10) {
				day = "0" + day;
			}
			return day;
		}

		public static String getDateByAfterYear(Date date, int yeas) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + yeas);
			return getDateString(calendar.getTime());
		}

		public static java.sql.Date getDateByAfterDays(Date date, BigDecimal days) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + days.intValue());
			return new java.sql.Date(calendar.getTime().getTime());
		}

		public static BigDecimal getDatesIntervalByDay(Date startDate, Date endDate) {
			return new BigDecimal((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000));
		}

		public static Date getDayAfter(int days) {
			Calendar calendar = Calendar.getInstance();
			// 获取当前时间的前months个月
			calendar.add(Calendar.DAY_OF_YEAR, days * 1);
			Date date = calendar.getTime();
			return date;
		}

		public static String getOneMonthBeforeDate() {
			// Date date = new Date();
			// long beforeMon = (date.getTime() / 1000) - (30 * 24 * 60 * 60);
			// date.setTime(beforeMon * 1000);
			// 2015-2-9修改获得上月当前日期
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1);
			return dateFormat.format(c.getTime());
		}

		public static String getYesDate() {
			Date date = new Date();
			long beforeMon = date.getTime() - (24 * 60 * 60 * 1000);
			date.setTime(beforeMon);
			return dateFormat.format(date);
		}

		/**
		 * @desc 根据数值取相对于当前日期的日期数据
		 * @param i
		 *            :0:当天，-1：昨天，1：明天
		 * @param modle
		 *            :yyyyMM;yyyyMMdd;yyyy-MM-dd HH:mm:ss;
		 * @return date
		 */
		public static String getDayByNum(String model, int i) {
			Calendar calendar = Calendar.getInstance();
			if (i != 0) {
				calendar.add(Calendar.DATE, i);
			}
			SimpleDateFormat df = new SimpleDateFormat(model);
			df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			String s = df.format(calendar.getTime());
			return s;
		}

		@SuppressWarnings("static-access")
		public static String getDateByStrNum(String strDate, String model, String temp, int i) {
			SimpleDateFormat formatter = new SimpleDateFormat(model);
			formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			ParsePosition pos = new ParsePosition(0);
			Date strtodate = formatter.parse(strDate, pos);
			Calendar cal = Calendar.getInstance();
			cal.setTime(strtodate);
			if (temp.equals("year")) {
				cal.add(cal.YEAR, i);
			} else if (temp.equals("month")) {
				cal.add(cal.MONTH, i);
			} else if (temp.equals("day")) {
				cal.add(cal.DATE, i);
			}
			return formatter.format(cal.getTime());
		}

		public static int compareSqlDate(java.sql.Date beforedate, java.sql.Date afterdate) {
			return beforedate.equals(afterdate) ? 0 : beforedate.before(afterdate) ? 1 : -1;
		}

		public static String getCurrentDateStr() {
			 Date date = new Date();
			 String str = null;
//			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 str = timeFormat.format(date);
			 return str;
	    }
		/**
		 * 获取当前月第一天
		 * @return
		 */
		public static String getFirstDay(){
			Calendar calendar=Calendar.getInstance();//获取当前日期 
			//calendar.add(Calendar.MONTH, -1);
			calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			String firstDay=dateFormat.format(calendar.getTime());
			return firstDay;
		}
}
