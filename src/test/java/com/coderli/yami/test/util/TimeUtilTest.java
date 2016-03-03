package com.coderli.yami.test.util;

import com.coderli.yami.common.constant.PostConstants;
import com.coderli.yami.common.util.TimeUtil;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import java.util.Locale;
import java.util.TimeZone;

/**
 * @author li.hzh
 * @date 16/3/3
 */
public class TimeUtilTest {

    @Test
    public void testGetCurrentTimeStr() {
        DateTime dateTime = new DateTime(System.currentTimeMillis(), DateTimeZone.getDefault());
        System.out.println(dateTime.toString(PostConstants.HEADER_DATE_PATTERN, Locale.CHINA));
    }
}
