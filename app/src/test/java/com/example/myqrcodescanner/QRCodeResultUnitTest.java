package com.example.myqrcodescanner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class QRCodeResultUnitTest {
    @Test
    public void test_getResult() {
        QRCodeResult theTest = new QRCodeResult("https://www.google.com");
        assertEquals("https://www.google.com", theTest.getResult());
    }

    @Test
    public void test_isLink_firstLink() {
        QRCodeResult theTest = new QRCodeResult("ugm");
        assertTrue(theTest.isLink());
    }

    @Test
    public void test_isLink_secondLink() {
        QRCodeResult theTest = new QRCodeResult("https://www.google.com");
        assertTrue(theTest.isLink());
    }

    @Test
    public void test_isLink_thirdLink() {
        QRCodeResult theTest = new QRCodeResult("https://ugm.ac.id");
        assertTrue(theTest.isLink());
    }

    @Test
    public void test_isLink_fourthLink() {
        QRCodeResult theTest = new QRCodeResult("http://google.com");
        assertTrue(theTest.isLink());
    }

    @Test
    public void test_isLink_notLink() {
        QRCodeResult theTest = new QRCodeResult("Department of Computer Science and Electronics");
        assertFalse(theTest.isLink());
    }
}
