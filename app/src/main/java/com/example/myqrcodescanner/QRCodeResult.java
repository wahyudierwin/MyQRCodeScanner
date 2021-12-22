package com.example.myqrcodescanner;

import android.webkit.URLUtil;

public class QRCodeResult {
    private String result;
    public QRCodeResult(String _result){
        this.result = _result;
    }

    public String getResult(){
        return this.result;
    }

    public boolean isLink(){
        return this._isLink(this.result);
    }

    private boolean _isLink(String _result) {
        if (URLUtil.isValidUrl(_result)) {
            return true;
        }
        return false;
    }
}
