package org.yyf.javase.reference;

import org.junit.Assert;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Created by @author yyf on 2019-03-22.
 */
public class WeakDemo {


    @Test
    public void weakTest() throws InterruptedException {
        DemoObject referent = new DemoObject();
        WeakReference<DemoObject> weakReference = new WeakReference<>(referent);
        DemoObject demoObject = weakReference.get();
        System.out.println(demoObject);
        demoObject = null;
        referent=null;
        System.gc();
        TimeUnit.SECONDS.sleep(4L);
        Assert.assertNull(weakReference.get());
    }
}
