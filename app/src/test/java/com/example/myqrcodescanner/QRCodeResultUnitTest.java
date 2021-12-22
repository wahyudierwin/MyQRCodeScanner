package com.example.myqrcodescanner;

import org.junit.Test;

public class QRCodeResultUnitTest {
    @Test
    public void isLink_simpleLink() {
        QRCodeResult firstTest = new QRCodeResult("https://www.google.com");
        System.out.println(firstTest.getResult());
        System.out.println(firstTest.isLink());
//        assertTrue(firstTest.isLink());
    }
}
