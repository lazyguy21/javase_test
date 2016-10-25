package org.yyf.javase.guava.range;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;

import org.junit.Test;
import org.yyf.javase.domain.Status;

import static org.yyf.javase.domain.Status.S0;
import static org.yyf.javase.domain.Status.S1;
import static org.yyf.javase.domain.Status.S2;
import static org.yyf.javase.domain.Status.S3;

/**
 * Created by tobi on 16-10-20.
 */
public class RangeTest {
    @Test
    public void tRange() {
        Range<Status> statusRange = Range.lessThan(S2);
        System.out.println(statusRange.contains(S1));
        System.out.println(statusRange.contains(S3));
        System.out.println(statusRange.contains(S2));

    }

    @Test
    public void testRange() throws Exception {

        Range<Status> statusRange = Range.lessThan(S2);
    }

    @Test
    public void testRangeSet() throws Exception {


    }
}
