package com.ldrong.notepad.utils;

import android.text.TextUtils;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DisplayTimeUtil {

    public static String saveNoteCreateTime(long ml) {


        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String tsStr = sdf.format(ml);
            System.out.println(tsStr);
            return tsStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String displayTimeString(String time) throws Exception {
//		String displayTime = null;
//		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
//		Date postTime = fmt.parse(time);
////		Log.e("TIME", "post时间："+postTime.toString());
//
//		Date currentTime = fmt.parse(fmt.format(new Date(System.currentTimeMillis() - Constant.timecorrect)));
//		Calendar current = Calendar.getInstance();
//		Calendar c_postTime = Calendar.getInstance();
//        Calendar today = Calendar.getInstance();
//        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
//        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
//        today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
//        today.set( Calendar.HOUR_OF_DAY, 0);
//        today.set( Calendar.MINUTE, 0);
//        today.set(Calendar.SECOND, 0);
//        current.setTime(currentTime);
//        c_postTime.setTime(postTime);
//        if(c_postTime.after(today)){
//        	long current_time = currentTime.getTime();
//        	long post_time = postTime.getTime();
//        	long min = (current_time - post_time)/60000;
//        	System.out.println("分钟："+min);
//        	if(min>=5&&min<=60){
//        		displayTime = min+"分钟前";
//        	}else if(min<5){
//        		displayTime = "刚刚";
//        	}else{
//        		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//        		displayTime = format.format(postTime);
//        	}
//        	return displayTime;
//
//        }else{
//        	Calendar year = Calendar.getInstance();
//        	year.set(Calendar.YEAR, current.get(Calendar.YEAR));
//        	year.set(Calendar.MONTH, Calendar.JANUARY);
//        	year.set(Calendar.DAY_OF_MONTH, 1);
//        	year.set(Calendar.HOUR_OF_DAY, 0);
//        	year.set( Calendar.MINUTE, 0);
//            year.set(Calendar.SECOND, 0);
//            if(c_postTime.after(year)){
//            	SimpleDateFormat format = new SimpleDateFormat("M月d日");
//            	displayTime = format.format(postTime);
//            }else{
//            	SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
//            	displayTime = format.format(postTime);
//            }
//        	return displayTime;
//        }
        return "";
    }

    public static String displayDetailTimeString(String time) throws Exception {
        String displayTime = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date postTime = fmt.parse(time);
//		Log.e("TIME", "post时间："+postTime.toString());
        Date currentTime = fmt.parse(fmt.format(new Date()));
        Calendar current = Calendar.getInstance();
        Calendar c_postTime = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        current.setTime(currentTime);
        c_postTime.setTime(postTime);
        if (c_postTime.after(today)) {
            long current_time = currentTime.getTime();
            long post_time = postTime.getTime();
            long min = (current_time - post_time) / 60000;
            System.out.println("分钟：" + min);
            if (min >= 5 && min <= 60) {
                displayTime = min + "分钟前";
            } else if (min < 5) {
                displayTime = "刚刚";
            } else {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                displayTime = format.format(postTime);
            }
            return displayTime;

        } else {
            Calendar year = Calendar.getInstance();
            year.set(Calendar.YEAR, current.get(Calendar.YEAR));
            year.set(Calendar.MONTH, Calendar.JANUARY);
            year.set(Calendar.DAY_OF_MONTH, 1);
            year.set(Calendar.HOUR_OF_DAY, 0);
            year.set(Calendar.MINUTE, 0);
            year.set(Calendar.SECOND, 0);
            if (c_postTime.after(year)) {
                SimpleDateFormat format = new SimpleDateFormat("M月d日  HH:mm");
                displayTime = format.format(postTime);
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日  HH:mm");
                displayTime = format.format(postTime);
            }
            return displayTime;
        }
    }

    public static String displayDateString(String time) throws Exception {
        String displayDate = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date newsTime = fmt.parse(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
        displayDate = format.format(newsTime);
        return displayDate;
    }

    public static String displayTimeStringt2message(String time) throws Exception {
        String displayTime = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date postTime = fmt.parse(time);
//		Log.e("TIME", "post时间："+postTime.toString());
        Date currentTime = fmt.parse(fmt.format(new Date()));
        Calendar current = Calendar.getInstance();
        Calendar c_postTime = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        current.setTime(currentTime);
        c_postTime.setTime(postTime);
        if (c_postTime.after(today)) {
            long current_time = currentTime.getTime();
            long post_time = postTime.getTime();
            long min = (current_time - post_time) / 60000;
            System.out.println("分钟：" + min);
            if (min >= 5 && min <= 60) {
                displayTime = min + "分钟前";
            } else if (min < 5) {
                displayTime = "刚刚";
            } else {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                displayTime = format.format(postTime);
            }
            return displayTime;

        } else {
            Calendar year = Calendar.getInstance();
            year.set(Calendar.YEAR, current.get(Calendar.YEAR));
            year.set(Calendar.MONTH, 1);
            year.set(Calendar.DAY_OF_MONTH, Calendar.JANUARY);
            year.set(Calendar.HOUR_OF_DAY, 0);
            year.set(Calendar.MINUTE, 0);
            year.set(Calendar.SECOND, 0);
            if (c_postTime.after(year)) {
                SimpleDateFormat format = new SimpleDateFormat("M月d日");
                displayTime = format.format(postTime);
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
                displayTime = format.format(postTime);
            }
            return displayTime;
        }
    }

    /**
     * Createtime:2016-1-20 16:55:54
     *
     * @param time 时间格式：2016-1-20 16:55:26
     * @return 返回  2016年1月20日1
     * @throws Exception 格式转换异常
     */
    public static String displayTimeYMD(String time) throws Exception {
        String displayTime = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date postTime = fmt.parse(time);
//		Log.e("TIME", "post时间："+postTime.toString());
        Date currentTime = fmt.parse(fmt.format(new Date()));
        Calendar current = Calendar.getInstance();
        Calendar c_postTime = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        current.setTime(currentTime);
        c_postTime.setTime(postTime);
        Calendar year = Calendar.getInstance();
        year.set(Calendar.YEAR, current.get(Calendar.YEAR));
        year.set(Calendar.MONTH, Calendar.JANUARY);
        year.set(Calendar.DAY_OF_MONTH, 1);
        year.set(Calendar.HOUR_OF_DAY, 0);
        year.set(Calendar.MINUTE, 0);
        year.set(Calendar.SECOND, 0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
        displayTime = format.format(postTime);
        return displayTime;
    }

    public static String displayTimeString(Date date) throws Exception {
        String displayTime = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
//		Log.e("TIME", "post时间："+postTime.toString());
        Date currentTime = fmt.parse(fmt.format(new Date()));
        Calendar current = Calendar.getInstance();
        Calendar c_postTime = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        current.setTime(currentTime);
        c_postTime.setTime(date);
        if (c_postTime.after(today)) {
            long current_time = currentTime.getTime();
            long post_time = date.getTime();
            long min = (current_time - post_time) / 60000;
            System.out.println("分钟：" + min);
            if (min >= 5 && min <= 60) {
                displayTime = min + "分钟前";
            } else if (min < 5) {
                displayTime = "刚刚";
            } else {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                displayTime = format.format(date);
            }
            return displayTime;

        } else {
            Calendar year = Calendar.getInstance();
            year.set(Calendar.YEAR, current.get(Calendar.YEAR));
            year.set(Calendar.MONTH, Calendar.JANUARY);
            year.set(Calendar.DAY_OF_MONTH, 1);
            year.set(Calendar.HOUR_OF_DAY, 0);
            year.set(Calendar.MINUTE, 0);
            year.set(Calendar.SECOND, 0);
            if (c_postTime.after(year)) {
                SimpleDateFormat format = new SimpleDateFormat("M月d日");
                displayTime = format.format(date);
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
                displayTime = format.format(date);
            }
            return displayTime;
        }
    }

    /**
     * 订单详情时间
     *
     * @param time
     * @return
     * @throws Exception
     */
    public static String displayConsultDateString(String time) throws Exception {
        String displayDate = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date newsTime = fmt.parse(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日 HH:mm");
        displayDate = format.format(newsTime);
        return displayDate;
    }

    /**
     * 工作室主页评价item时间
     *
     * @param time
     * @return
     * @throws Exception
     */
    public static String displayEvaluateDateString(String time) throws Exception {
        String displayDate = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date newsTime = fmt.parse(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        displayDate = format.format(newsTime);
        return displayDate;
    }


//	/**
//	 * 判断是否在今天
//	 * @param time
//	 * @return
//	 * @throws Exception
//     */
//	public static boolean isToday(String time)throws Exception {
//		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
//		Date postTime = fmt.parse(time);
//		Date currentTime = fmt.parse(fmt.format(new Date(System.currentTimeMillis() - Constant.timecorrect)));
//		Calendar current = Calendar.getInstance();
//		Calendar c_postTime = Calendar.getInstance();
//		Calendar today = Calendar.getInstance();
//		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
//		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
//		today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
//		today.set( Calendar.HOUR_OF_DAY, 0);
//		today.set( Calendar.MINUTE, 0);
//		today.set(Calendar.SECOND, 0);
//		current.setTime(currentTime);
//		c_postTime.setTime(postTime);
//		if(c_postTime.after(today)){
//			return true;
//		}else{
//			return false;
//		}
//	}

    public static boolean isInOneMin(String time, String last_time) throws Exception {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date postTime = fmt.parse(time);
        Date lastTime = fmt.parse(last_time);
        long post_time = postTime.getTime();
        long d_last_time = lastTime.getTime();
        long min = (d_last_time - post_time) / 60000;
        Log.e("DisplayTime", "post_time：" + post_time);
        Log.e("DisplayTime", "last_time：" + last_time);
        Log.e("DisplayTime", "分钟：" + min);
        if (min > 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否同一天
     *
     * @param time
     * @param last_time
     * @return
     * @throws Exception
     */
    public static boolean isSameDay(String time, String last_time) throws Exception {
        if (last_time != null && time != null) {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            String d_time = fmt.format(fmt.parse(time));
            String d_last_time = fmt.format(fmt.parse(last_time));
            Log.e("DisplayTime", "现在时间：" + d_time);
            Log.e("DisplayTime", "上一条时间：" + d_last_time);
            if (d_time.equals(d_last_time)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 获取传入时间的那周的周一到周日的日期
     * @param time
     */
//	public static String[] convertWeekByDate(Date time) {
//
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(time);
//		//判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
//		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
//		if(1 == dayWeek) {
//			cal.add(Calendar.DAY_OF_MONTH, -1);
//		}
//		L.e("DisplayTimeUtil","要计算日期为:" + sdf.format(cal.getTime())); //输出要计算日期
//		cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
//		int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
//		cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
//		String imptimeMonday = sdf.format(cal.getTime());
//		L.e("DisplayTimeUtil","所在周星期一的日期："+imptimeMonday);
//		cal.add(Calendar.DATE, 1);
//		String imptimeTuesday = sdf.format(cal.getTime());
//		L.e("DisplayTimeUtil","所在周星期二的日期："+imptimeTuesday);
//		cal.add(Calendar.DATE, 1);
//		String imptimeWednesday = sdf.format(cal.getTime());
//		L.e("DisplayTimeUtil","所在周星期三的日期："+imptimeWednesday);
//		cal.add(Calendar.DATE, 1);
//		String imptimeThursday = sdf.format(cal.getTime());
//		L.e("DisplayTimeUtil","所在周星期四的日期："+imptimeThursday);
//		cal.add(Calendar.DATE, 1);
//		String imptimeFriday= sdf.format(cal.getTime());
//		L.e("DisplayTimeUtil","所在周星期五的日期："+imptimeFriday);
//		cal.add(Calendar.DATE, 1);
//		String imptimeSaturday = sdf.format(cal.getTime());
//		L.e("DisplayTimeUtil","所在周星期六的日期："+imptimeSaturday);
//		cal.add(Calendar.DATE, 1);
//		String imptimeSunday = sdf.format(cal.getTime());
//		L.e("DisplayTimeUtil","所在周星期日的日期："+imptimeSunday);
//		String[] result = new String[]{imptimeMonday,imptimeTuesday,imptimeWednesday,imptimeThursday,imptimeFriday,imptimeSaturday,imptimeSunday};
//		return result;
//	}

    /**
     * 将时间转换为MM-dd
     *
     * @return
     */
    public static String changeTimeFormatToStyle1(String time, Date date) {
        try {
            if (!TextUtils.isEmpty(time)) {
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                Date old_time = fmt.parse(time);
                SimpleDateFormat format = new SimpleDateFormat("MM-dd");
                return format.format(old_time);
            } else if (date != null) {
                SimpleDateFormat format = new SimpleDateFormat("MM-dd");
                return format.format(date);
            } else {
                return "";
            }
        } catch (Exception e) {
            Log.e("Error", e.toString(), e);
            return "";
        }
    }

    /**
     * 获取昨日的date值，传入时间格式  yyyy-MM-dd
     *
     * @param time
     * @return
     */
    public static Date getLastDay(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(time));
            cal.add(Calendar.DATE, -1);
            return cal.getTime();
        } catch (Exception e) {
            Log.e("Error", e.toString(), e);
            return null;
        }
    }


    /**
     * 获取下一天的date值，传入时间格式： yyyy-MM-dd
     *
     * @param time
     * @return
     */
    public static Date getNextDay(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(time));
            cal.add(Calendar.DATE, 1);
            return cal.getTime();
        } catch (Exception e) {
            Log.e("Error", e.toString(), e);
            return null;
        }
    }

    /**
     * 是否在早上前     13点前为早上
     * @return
     */
//	public static boolean isBeforeMorning(){
//		try {
//			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
//			Date currentTime = fmt.parse(fmt.format(new Date(System.currentTimeMillis() - Constant.timecorrect)));
//			Calendar current = Calendar.getInstance();
//			Calendar morning = Calendar.getInstance();
//			current.setTime(currentTime);
//			morning.set(Calendar.YEAR, current.get(Calendar.YEAR));
//			morning.set(Calendar.MONTH, current.get(Calendar.MONTH));
//			morning.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
//			morning.set( Calendar.HOUR_OF_DAY, 12);
//			morning.set( Calendar.MINUTE, 0);
//			morning.set(Calendar.SECOND, 0);
//			if(current.after(morning)){
//				return false;
//			}else{
//				return true;
//			}
//		}catch (Exception e){
//			Log.e("Error",e.toString(),e);
//			return false;
//		}
//	}

    /**
     * 是否在下午前     18点前为下午
     * @return
     */
//	public static boolean isBeforeAfternoon(){
//		try {
//			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
//			Date currentTime = fmt.parse(fmt.format(new Date(System.currentTimeMillis() - Constant.timecorrect)));
//			Calendar current = Calendar.getInstance();
//			Calendar afternoon = Calendar.getInstance();
//			current.setTime(currentTime);
//			afternoon.set(Calendar.YEAR, current.get(Calendar.YEAR));
//			afternoon.set(Calendar.MONTH, current.get(Calendar.MONTH));
//			afternoon.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
//			afternoon.set( Calendar.HOUR_OF_DAY, 18);
//			afternoon.set( Calendar.MINUTE, 0);
//			afternoon.set(Calendar.SECOND, 0);
//			if(current.after(afternoon)){
//				return false;
//			}else{
//				return true;
//			}
//		}catch (Exception e){
//			Log.e("Error",e.toString(),e);
//			return false;
//		}
//	}

    /**
     * 判断是否同一天     返回：1 比今天前    2  相等     3  比今天后
     * @param date
     * @return
     */
//	public static int isSameDay(String date){
//		try{
//			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
//			Date currentTime = fmt.parse(fmt.format(new Date(System.currentTimeMillis() - Constant.timecorrect)));
//			Date d = fmt.parse(date);
//			Calendar current = Calendar.getInstance();
//			Calendar d_calendar = Calendar.getInstance();
//			current.setTime(currentTime);
//			d_calendar.setTime(d);
//			if(d_calendar.after(current)){
//				return 3;
//			}else if(d_calendar.equals(current)){
//				return 2;
//			}else{
//				return 1;
//			}
//		}catch (Exception e){
//			Log.e("Error",e.toString(),e);
//			return 1;
//		}
//	}

    /**
     * 把yyyy-MM-dd转yyyy年M月dd日
     *
     * @param date
     * @return
     */
    public static String changeTimeFormatToStyle2(String date) {
        try {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            DateFormat fmt2 = new SimpleDateFormat("yyyy年M月dd日", Locale.CHINA);
            Date old_time = fmt.parse(date);
            return fmt2.format(old_time);
        } catch (Exception e) {
            Log.e("Error", e.toString(), e);
            return null;
        }

    }

    /**
     * 把long时间值转为 HH
     *
     * @param date
     * @return
     */
    public static String changeTimeFormatToStyle3(String date) {
        try {
            DateFormat fmt = new SimpleDateFormat("HH", Locale.CHINA);
            Date d = new Date(Long.valueOf(date));
            return fmt.format(d);
        } catch (Exception e) {
            LogUtils.e("Error", e.toString(), e);
            return "";
        }
    }

    /**
     * 把yyyyMMdd格式时间值转为 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String changeTimeFormatToStyle4(String date) {
        try {
            DateFormat fmt = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
            Date d = fmt.parse(date);
            DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            return fmt2.format(d);
        } catch (Exception e) {
            LogUtils.e("Error", e.toString(), e);
            return "";
        }
    }

    /**
     * 将yyyyMMdd转为yyyy年MM月dd日
     *
     * @param date
     * @return
     */
    public static String changeTimeFormatToStyle5(String date) {
        try {
            DateFormat fmt = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
            DateFormat fmt2 = new SimpleDateFormat("yyyy年M月dd日", Locale.CHINA);
            Date old_time = fmt.parse(date);
            return fmt2.format(old_time);
        } catch (Exception e) {
            LogUtils.e("Error", e.toString(), e);
            return "";
        }
    }

    public static String changeTimeFormatToStyle6(String date) {
        try {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
            Date d = fmt.parse(date);
            return String.valueOf(d.getTime());
        } catch (Exception e) {
            LogUtils.e("Error", e.toString(), e);
            return "";
        }
    }

    /**
     * 把yyyy-MM-dd HH：mm 转化为 M月dd日 HH：mm
     *
     * @param date
     * @return
     */
    public static String changeTimeFormatToStyle7(String date) {
        try {
            String displayDate = null;
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
            Date newsTime = fmt.parse(date);
            SimpleDateFormat format = new SimpleDateFormat("M月dd日 HH:mm", Locale.CHINA);
            displayDate = format.format(newsTime);
            return displayDate;
        } catch (Exception e) {
            LogUtils.e("Error", e.toString(), e);
            return "";
        }
    }

    /**
     * 把Long转化为 H：ss
     *
     * @param date
     * @return
     */
    public static String changeTimeFormatToStyle8(String date) {
        try {
            DateFormat fmt = new SimpleDateFormat("H:ss", Locale.CHINA);
            Date d = new Date(Long.valueOf(date));
            return fmt.format(d);
        } catch (Exception e) {
            LogUtils.e("Error", e.toString(), e);
            return "";
        }
    }

}
