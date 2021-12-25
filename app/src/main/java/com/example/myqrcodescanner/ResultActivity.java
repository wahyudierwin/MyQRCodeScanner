package com.example.myqrcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView;
    private Button openLinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);
        openLinkButton = findViewById(R.id.openLinkButton);

        loadTheAd();

        try {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String qrCodeResult = extras.getString("qrCodeResult");
                resultTextView.setText(qrCodeResult);

                analyze(qrCodeResult);
            }
        }
        catch (Exception e) {
            resultTextView.setText("Failed to get QR code result " + e);
        }
    }

    private void loadTheAd(){
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private void analyze(String qrCodeResult){
        if (isLink(qrCodeResult)){
            displayOpenLinkButton();

            openLinkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openLink(qrCodeResult);
                }
            });
        }
    }

    static boolean isLink(String qrCodeResult){
        return PatternsCompat.WEB_URL.matcher(qrCodeResult).matches();
    }

    private void displayOpenLinkButton(){
        openLinkButton.setVisibility(View.VISIBLE);
    }

    private void openLink(String qrCodeResult){
        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
        intent.putExtra("link", qrCodeResult);
        startActivity(intent);
    }
}

