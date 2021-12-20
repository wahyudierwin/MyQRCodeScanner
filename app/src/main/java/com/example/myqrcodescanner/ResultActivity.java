package com.example.myqrcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView;
    private Button goToLinkButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);

        try {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String qrCodeResult = extras.getString("qrCodeResult");
                resultTextView.setText((CharSequence) qrCodeResult);
            }
            else{

            }
        }
        catch (Exception e){
            resultTextView.setText("Failed to get QR code result " + e);
        }

    }
}