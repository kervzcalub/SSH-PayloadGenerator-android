package com.kervzcodes.payloadgen.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kervzcodes.payload.generator.ssh.PayloadGenerator;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPayloadGenerator();
            }
        });
    }

    private void showPayloadGenerator() {
        PayloadGenerator paygen = new PayloadGenerator(this);
        /** set positive button**/
        paygen.setGenerateListener("Generate", new PayloadGenerator.OnGenerateListener() {
            @Override
            public void onGenerate(String payloadGenerated) {
                textView.setText(payloadGenerated);
            }
        });
        /** set negative button**/
        paygen.setCancelListener("Cancel", new PayloadGenerator.OnCancelListener() {
            @Override
            public void onCancelListener() {

            }
        });
        /** set neutral button**/
        paygen.setNeutralButtonListener("Neutral", new PayloadGenerator.OnNeutralListener() {
            @Override
            public void onNeutralListener() {

            }
        });
        paygen.show();
    }
}