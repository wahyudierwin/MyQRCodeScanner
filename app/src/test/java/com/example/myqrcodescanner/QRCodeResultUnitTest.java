package com.example.myqrcodescanner;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QRCodeResultUnitTest {
    @Test
    public void isLink_simpleLink() {
        QRCodeResult firstTest = new QRCodeResult("https://google.com");
        assertTrue(firstTest.isLink());
    }
}
