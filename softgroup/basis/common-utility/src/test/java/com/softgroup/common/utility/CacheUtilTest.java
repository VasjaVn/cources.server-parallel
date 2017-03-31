package com.softgroup.common.utility;

import com.softgroup.common.utility.cache.CacheUtil;
import org.junit.Test;

public class CacheUtilTest {
    @Test
    public void test() {
        CacheUtil.put("test", "1111");
        String value = (String)CacheUtil.get("test");
        int r = 0;
    }
}
