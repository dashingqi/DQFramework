package com.dashingqi.framework.utils

import java.text.DateFormat
import java.text.ParseException
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

/**
 * @author : zhangqi
 * @time : 2020/9/2
 * desc : 日期工具类
 */
object DateUtils {

    private const val defaultDateFormatStr = "yyyy-MM-dd" // 系统默认的格式化字符串
    private const val defaultTimeFormatStr = "yyyy-MM-dd HH:mm:ss" // 系统默认的格式化字符串

    /**
     * 日期转字符串
     */
    fun dateToString(date: Date, formatStr: String): String {
        val df: DateFormat = SimpleDateFormat(formatStr)
        return df.format(date)
    }

    /**
     * 字符串转换到时间格式，自定义日期格式
     */
    fun stringToDate(dateStr: String, formatStr: String): Date? {
        val sdf: DateFormat = SimpleDateFormat(formatStr)
        var date: Date? = null
        try {
            date = sdf.parse(dateStr)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return date
    }

    /**
     * 取得系统时间，格式为yyyy-MM-dd HH:mm:ss
     */
    fun getSystemTime(): String {
        val df: DateFormat = SimpleDateFormat(defaultTimeFormatStr)
        var strTime = df.format(Date())
        return strTime
    }

    /**
     * 取得系统日期，格式为yyyy-MM-dd
     */
    fun getSystemDate(): String {
        val df = SimpleDateFormat(defaultDateFormatStr)
        val strDate = df.format(Date())
        return strDate
    }

    /**
     * 取得系统时间，日期格式为yyyyMMddHHmmss
     */
    fun getShortSystemTime(): String {
        val df: DateFormat = SimpleDateFormat("yyyyMMddHHmmss")
        val strTime = df.format(Date())
        return strTime
    }

    /**
     * 取得系统短日期，yyyyMMdd
     */
    fun getShortSystemDate(): String {
        var strTime = ""
        val df: DateFormat = SimpleDateFormat("yyyyMMdd")
        strTime = df.format(Date())
        return strTime
    }

    /**
     * 系统时间加减，自定义日期格式
     */
    fun getOperaDate(date: String, dayNum: Int, formatStr: String): String {
        var dt: Date? = null
        val df = SimpleDateFormat(formatStr)
        try {
            dt = df.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val gc = GregorianCalendar()
        assert(dt != null)
        gc.setTime(dt)
        gc.add(Calendar.DATE, dayNum)
        return df.format(gc.getTime())
    }

    /**
     * 系统时间加减，默认日期格式
     */
    fun getOperaDate(date: String, dayNum: Int): String {
        return getOperaDate(date, dayNum, defaultDateFormatStr)
    }

    /**
     * 系统月份加减，自定义日期格式
     */
    fun getOperaMonth(
            date: String,
            monthNum: Int,
            formatStr: String
    ): String {
        var dt: Date? = null
        val df = SimpleDateFormat(formatStr)
        try {
            dt = df.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val gc = GregorianCalendar()
        assert(dt != null)
        gc.time = dt
        gc.add(Calendar.MONTH, monthNum)
        return df.format(gc.getTime())
    }

    /**
     * 系统月份加减，默认日期格式
     */
    fun getOperaMonth(date: String, monthNum: Int): String {
        return getOperaMonth(date, monthNum, defaultDateFormatStr)
    }

    /**
     * 取得两个日期的时间差（天数），两个都是字符串，格式自定义
     */
    fun getDateDifference(
            date1: String,
            date2: String,
            formatStr: String
    ): Int {
        val formatter = SimpleDateFormat(formatStr)
        val pos = ParsePosition(0)
        val pos1 = ParsePosition(0)
        val dt1: Date = formatter.parse(date1, pos)
        val dt2: Date = formatter.parse(date2, pos1)
        return (dt2.time - dt1.time) as Int / (3600 * 24 * 1000)
    }

    /**
     * 取得两个日期的时间差（天数），两个都是字符串，格式为 yyyy-MM-dd
     */
    fun getDateDifference(date1: String, date2: String): Int {
        return getDateDifference(date1, date2, defaultDateFormatStr)
    }

    /**
     * 取得两个日期的时间差（小时）,两个都是日期型
     */
    fun getHourDifference(date1: Date, date2: Date): Int {
        return (date2.time - date1.time) as Int / (3600 * 1000)
    }

    /**
     * 取得两个日期的月份差
     */
    fun getMonthDifference(
            date1: String,
            date2: String,
            formatStr: String
    ): Int {
        var result = 0
        val sdf = SimpleDateFormat(formatStr)
        val c1: Calendar = Calendar.getInstance()
        val c2: Calendar = Calendar.getInstance()
        try {
            c1.time = sdf.parse(date1)
            c2.time = sdf.parse(date2)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH)
        return if (result == 0) 1 else abs(result)
    }

    /**
     * 取得两个日期的月份差
     */
    fun getMonthDifference(date1: String, date2: String): Int {
        var result = 0
        val sdf = SimpleDateFormat(defaultDateFormatStr)
        val c1: Calendar = Calendar.getInstance()
        val c2: Calendar = Calendar.getInstance()
        try {
            c1.time = sdf.parse(date1)
            c2.time = sdf.parse(date2)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH)
        return result
    }

    /**
     * 取得当月最后一天
     */
    fun getLastDayOfMonth(): String {
        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)) // 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)) // 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1) // 日，设为一号
        cal.add(Calendar.MONTH, 1) // 月份加一，得到下个月的一号
        cal.add(Calendar.DATE, -1) // 下一个月减一为本月最后一天
        return SimpleDateFormat(defaultDateFormatStr).format(cal.time)
    }

    /**
     * 取得当月第一天
     */
    fun getFirstDayOfMonth(): String {
        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)) // 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)) // 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1) // 日，设为一号
        return SimpleDateFormat(defaultDateFormatStr).format(cal.getTime()) // 获得月初是几号
    }

    /**
     * 取得上个月的第一天
     */
    fun getFirstDayOfLastMonth(): String {
        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)) // 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)) // 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1) // 日，设为一号
        cal.add(Calendar.MONTH, -1) // 月份减一，得到上个月的一号
        return SimpleDateFormat(defaultDateFormatStr).format(cal.time) // 获得月初是几号
    }

    /**
     * 取得下个月的最后一天
     */
    fun getLastDayOfNextMonth(): String {
        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)) // 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)) // 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1) // 日，设为一号
        cal.add(Calendar.MONTH, 2) // 月份加一，得到下下个月的一号
        cal.add(Calendar.DATE, -1) // 下下一个月减一为下个月最后一天
        return SimpleDateFormat(defaultDateFormatStr).format(cal.time) // 获得月末是几号
    }

    /**
     * 取得当月最后一天
     */
    fun getLastDayOfMonth(date: String): String {
        var dt: Date? = null
        val df = SimpleDateFormat(defaultDateFormatStr)
        try {
            dt = df.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val cal: Calendar = Calendar.getInstance()
        assert(dt != null)
        cal.time = dt
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)) // 年
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)) // 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1) // 日，设为一号
        cal.add(Calendar.MONTH, 1) // 月份加一，得到下个月的一号
        cal.add(Calendar.DATE, -1) // 下一个月减一为本月最后一天
        return df.format(cal.time) // 获得月末是几号
    }

    /**
     * 获取某个时间段的所有天数集合(包含起始日期与终止日期)
     */
    fun getDayList(
            starDate: String,
            endDate: String
    ): List<String> {
        var starDate = starDate
        val format = SimpleDateFormat(defaultDateFormatStr)
        val dayList: MutableList<String> = ArrayList()
        if (starDate == endDate) {
            dayList.add(starDate)
        } else if (starDate < endDate) {
            while (starDate <= endDate) {
                dayList.add(starDate)
                val l: Long = stringToDate(starDate, "yyyy-MM-dd")!!.getTime()
                starDate = format.format(l + 3600 * 24 * 1000)
            }
        } else {
            dayList.add(endDate)
        }
        return dayList
    }
}