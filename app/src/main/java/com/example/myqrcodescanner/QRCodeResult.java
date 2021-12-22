package com.example.myqrcodescanner;


import androidx.core.util.PatternsCompat;

public class QRCodeResult {
    private String result;
    public QRCodeResult(String _result){
        this.result = _result;
    }

    public String getResult(){
        return this.result;
    }

    public boolean isLink() {
        if (PatternsCompat.WEB_URL.matcher(this.result).matches()) return true;
        else return false;
    }
}
