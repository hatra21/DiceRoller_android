package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView qtyTv;
    private TextView selectdDieTV;
    private String currentQtyText;
    private TextView rollsTV;
    private TextView totalTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.qtyTv = this.findViewById(R.id.qtyTV);
        this.selectdDieTV = this.findViewById(R.id.selectedDieTV);
        this.rollsTV = this.findViewById(R.id.rollsTV);
        this.totalTV = this.findViewById(R.id.totalTV);
        this.qtyTv.setText("");
        this.currentQtyText = "";
        this.rollsTV.setText("");
        this.totalTV.setText("");
        this.selectdDieTV.setText("");
    }

    private String extractNumberOfSides(String diceType) {
        String answer = "";
        for (int i=1; i<diceType.length(); i++) {
            answer += diceType.charAt(i);
        }
        return answer;
    }

    public void onRollButtonPressed(View v) {
        String qtyString = this.qtyTv.getText().toString();
        String fullDiceString = this.selectdDieTV.getText().toString(); //like "D4" or "D6"
        String errorMsg = "";

        if (qtyString.length() == 0) {
            errorMsg = "You must enter a quantity before rolling!";
        } else if (fullDiceString.length() == 0) {
            errorMsg = "You must select a Dice before rolling!";
        }

        if (errorMsg.length() > 0) {
            Toast t = Toast.makeText(this, errorMsg, Toast.LENGTH_LONG);
            t.show();
            return; //immediately end this method, don't try to do any rolling
        }

        //get the qty as an int
        int qtyInt = Integer.parseInt(qtyString);
        int[] theRolls = new int[qtyInt];

        //get the number of sides as an int

        String trimmedDiceString = this.extractNumberOfSides(fullDiceString);
        //String trimmerDiceString = fullDiceString.substring(1);
        int numberOfSidesInt = Integer.parseInt(trimmedDiceString);
        Random r= new Random();

        int total = 0;
        String individualRolls = "";
        for (int i=0; i < theRolls.length; i++) {
            theRolls[i] = r.nextInt(numberOfSidesInt) +1;
            total += theRolls[i];

            if (individualRolls.length() == 0) {
                individualRolls = "" + theRolls[i];
            } else {
                individualRolls += " + " + theRolls[i];
            }
        }

        this.rollsTV.setText(individualRolls);
        this.totalTV.setText("" + total);


    }

    public void diceButtonPressed(View v) {
        this.selectdDieTV.setText(v.getTag().toString());

    }

    public void clearButtonPressed(View v) {
        this.currentQtyText = "";
        this.qtyTv.setText(this.currentQtyText);

    }


    public void qtyButtonPressed(View v) {
        Button b = (Button)v;
        if (this.currentQtyText.length() == 0 && this.currentQtyText.equals(0)) {
            return;
        }
        this.currentQtyText += b.getText();
        this.qtyTv.setText(this.currentQtyText);




    }
}