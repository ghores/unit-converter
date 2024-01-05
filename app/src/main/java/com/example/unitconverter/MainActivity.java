package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt_m;
    EditText edt_cm;
    EditText edt_km;
    EditText edt_i;

    Button btn_compute;
    Button btn_reset;

    public float getFloatValue(EditText edit) {
        return Float.parseFloat(edit.getText().toString());
    }

    public void updateFields(float m, float cm, float km, float i) {
        edt_km.setText("" + km);
        edt_m.setText("" + m);
        edt_i.setText("" + i);
        edt_cm.setText("" + cm);
    }

    public void computeByCentimeter() {
        float cm = getFloatValue(edt_cm);
        float m = cm / 100f;
        float km = m / 1000f;
        float i = cm / 2.54f;
        updateFields(m, cm, km, i);
    }

    public void computeByKilometer() {
        float km = getFloatValue(edt_km);
        float m = km * 1000f;
        float cm = m * 100f;
        float i = cm / 2.54f;
        updateFields(m, cm, km, i);
    }

    public void computeByInch() {
        float i = getFloatValue(edt_i);
        float cm = i * 2.54f;
        float m = cm / 100f;
        float km = m / 1000f;
        updateFields(m, cm, km, i);
    }

    public void computeByMeter() {
        float m = getFloatValue(edt_m);
        float cm = m * 100f;
        float km = m / 1000f;
        float i = cm / 2.54f;
        updateFields(m, cm, km, i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_compute = (Button) findViewById(R.id.btn_compute);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        edt_m = (EditText) findViewById(R.id.edt_m);
        edt_cm = (EditText) findViewById(R.id.edt_cm);
        edt_km = (EditText) findViewById(R.id.edt_km);
        edt_i = (EditText) findViewById(R.id.edt_i);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_cm.setText("");
                edt_km.setText("");
                edt_m.setText("");
                edt_i.setText("");
            }
        });

        btn_compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_m.getText().toString().length() != 0){
                    computeByMeter();
                } else if (edt_cm.getText().toString().length() != 0) {
                    computeByCentimeter();
                } else if (edt_km.getText().toString().length() != 0) {
                    computeByKilometer();
                } else if (edt_i.getText().toString().length() != 0) {
                    computeByInch();
                }
            }
        });
    }
}