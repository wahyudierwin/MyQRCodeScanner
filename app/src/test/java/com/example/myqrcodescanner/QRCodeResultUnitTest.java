package com.example.myqrcodescanner;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class QRCodeResultUnitTest {
    @Test
    public void isLink_simpleLink() {
        QRCodeResult firstTest = new QRCodeResult("https://google.com");
        assertThat(firstTest.isLink()).isTrue();
    }
}
