package com.example.myqrcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView;
    private Button goToLinkButton;
    private QRCodeResult qrCodeResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);
        goToLinkButton = findViewById(R.id.goToLinkButton);

        try {
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String qrCodeResultStr = extras.getString("qrCodeResult");
                resultTextView.setText(qrCodeResultStr);
            }
        }
        catch (Exception e) {
            resultTextView.setText("Failed to get QR code result " + e);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        analyze(resultTextView.getText().toString());
    }

    private void analyze(String qrCodeResultStr){
        qrCodeResult = new QRCodeResult(qrCodeResultStr);

        if (qrCodeResult.isLink()){
            displayGoToLinkButton();

            goToLinkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goToLink(qrCodeResult);
                }
            });
        }
    }

    private void displayGoToLinkButton(){
        goToLinkButton.setVisibility(View.VISIBLE);
    }

    private void goToLink(QRCodeResult qrCodeResult){
        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
        intent.putExtra("link", qrCodeResult.getResult());
        startActivity(intent);
    }
}