package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button zeroButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private TextView qtyTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.oneButton = this.findViewById(R.id.button1);
        this.qtyTv = this.findViewById(R.id.qtyTV);
    }


    public void qtyButtonPressed(View v) {
        if (v == this.oneButton) {
            this.qtyTv.setText("1");
        }
        if (v == this.twoButton) {
            this.qtyTv.setText("2");
        }

        if (v == this.threeButton) {
            this.qtyTv.setText("3");
        }

        if (v == this.fourButton) {
            this.qtyTv.setText("4");
        }

        if (v == this.fiveButton) {
            this.qtyTv.setText("5");
        }

        if (v == this.sixButton) {
            this.qtyTv.setText("6");
        }

        if (v == this.sevenButton) {
            this.qtyTv.setText("7");
        }

        if (v == this.eightButton) {
            this.qtyTv.setText("8");
        }

        if (v == this.nineButton) {
            this.qtyTv.setText("9");
        }

        if (v == this.zeroButton) {
            this.qtyTv.setText("0");
        }


    }
}