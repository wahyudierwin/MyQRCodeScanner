package com.example.myqrcodescanner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class QRCodeResultUnitTest {

    @Test
    public void isLink_should_return_true_for_ugm() {
        boolean result = ResultActivity.isLink("ugm.ac.id");

        assertTrue(result);
    }

    @Test
    public void test_isLink_firstLink() {
        assertTrue(ResultActivity.isLink("ugm.ac.id"));
    }

    @Test
    public void test_isLink_secondLink() {
        assertTrue(ResultActivity.isLink("https://www.google.com"));
    }

    @Test
    public void test_isLink_thirdLink() {
        assertTrue(ResultActivity.isLink("https://ugm.ac.id"));
    }

    @Test
    public void test_isLink_fourthLink() {
        assertTrue(ResultActivity.isLink("http://google.com"));
    }

    @Test
    public void test_isLink_notLink() {
        assertFalse(ResultActivity.isLink("Department of Computer Science and Electronics"));
    }
}
