package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by xue on 15/9/7.
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MessageUtilTest.class) ;
        for (Failure f: result.getFailures()){
            System.out.println(f.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
