package com.example.myqrcodescanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class QRCodeResultUnitTest {
    @Test
    public void test_getResult() {
        QRCodeResult theTest = new QRCodeResult("https://www.google.com");
        assertEquals("https://www.google.com", theTest.getResult());
    }

    @Test
    public void test_isLink_simpleLink() {
        QRCodeResult theTest = new QRCodeResult("https://www.google.com");
        assertTrue(theTest.isLink());
    }
}
