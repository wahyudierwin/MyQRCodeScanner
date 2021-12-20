package com.example.myqrcodescanner;

public class QRCodeResultAnalyzer {
    private String qrCodeResult;
    public QRCodeResultAnalyzer(String _qrCodeResult){
        this.qrCodeResult = _qrCodeResult;
    }

    public boolean isLink(){
        return this._isLink(this.qrCodeResult);
    }

    private boolean _isLink(String _qrCodeResult){
        return false;
    }
}
