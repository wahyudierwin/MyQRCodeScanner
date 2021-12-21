package com.example.myqrcodescanner;

public class QRCodeResult {
    private String qrCodeResult;
    public QRCodeResult(String _qrCodeResult){
        this.qrCodeResult = _qrCodeResult;
    }

    public String getResult(){
        return this.qrCodeResult;
    }

    public boolean isLink(){
        return this._isLink(this.qrCodeResult);
    }

    private boolean _isLink(String _qrCodeResult){
        return true;
    }
}
