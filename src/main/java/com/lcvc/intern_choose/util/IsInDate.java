package com.lcvc.intern_choose.util;

import java.text.ParseException;
import java.util.Date;

/**
 * @author 张峰
 */
public class IsInDate {

    public static boolean judge(Date nowDate,Date startTime, Date endTime) throws ParseException {
        if (nowDate.after(startTime)&&nowDate.before(endTime)){
            return true;
        }
        return false;
    }
}
