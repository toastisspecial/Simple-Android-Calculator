/*
Author: Peter Johnson
Description: Simple calculator app
 */


package com.example.peter.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public long runningTotal = 0;
    public long runningNumber = 0;
    public List<Character> operators = new ArrayList<Character>();
    public List<Long> numbers = new ArrayList<Long>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void numberPressed(View view)
    {

        if(view.getId() == findViewById(R.id.button0).getId())
        {
            runningNumber = concatenateInt(0);
        }
        else if(view.getId() == findViewById(R.id.button1).getId())
        {
            runningNumber = concatenateInt(1);
        }
        else if(view.getId() == findViewById(R.id.button2).getId())
        {
            runningNumber = concatenateInt(2);
        }
        else if(view.getId() == findViewById(R.id.button3).getId())
        {
            runningNumber = concatenateInt(3);
        }
        else if(view.getId() == findViewById(R.id.button4).getId())
        {
            runningNumber = concatenateInt(4);
        }
        else if(view.getId() == findViewById(R.id.button5).getId())
        {
            runningNumber = concatenateInt(5);
        }
        else if(view.getId() == findViewById(R.id.button6).getId())
        {
            runningNumber = concatenateInt(6);
        }
        else if(view.getId() == findViewById(R.id.button7).getId())
        {
            runningNumber = concatenateInt(7);
        }
        else if(view.getId() == findViewById(R.id.button8).getId())
        {
            runningNumber = concatenateInt(8);
        }
        else if(view.getId() == findViewById(R.id.button9).getId())
        {
            runningNumber = concatenateInt(9);
        }


        refreshTotalView();


    }


    long concatenateInt(int curNum)
    {

        try
        {
            long total = Long.valueOf(String.valueOf(runningNumber) + String.valueOf(curNum) );
            return total;
        }
        catch (NumberFormatException ex)
        {
            Toast.makeText(getApplicationContext(), "Overflow Error", Toast.LENGTH_LONG).show();
        }
            return 0;
    }

    void refreshTotalView()
    {
        TextView total = (TextView) findViewById(R.id.textviewAnswer);

        total.setText(String.valueOf(runningNumber));
    }

    public void plusClick(View view)
    {
        if(runningNumber != 0)
        {
            numbers.add(runningNumber);
            operators.add('+');
            runningNumber = 0;
        }

    }

    public void minusClick(View view)
    {
        if(runningNumber != 0)
        {
            numbers.add(runningNumber);
            operators.add('-');
            runningNumber = 0;
        }

    }

    public void equalClick(View view)
    {
        numbers.add(runningNumber);

        runningTotal = numbers.get(0);

        for(int i = 0; i < operators.size(); i++)
        {
            if(operators.get(i) == '+')
            {
                runningTotal += numbers.get(i+1);
            }
            else if(operators.get(i) == '-')
            {
                runningTotal -= numbers.get(i+1);
            }
        }

        TextView total = (TextView) findViewById(R.id.textviewAnswer);

        total.setText(String.valueOf(runningTotal));

        runningNumber = runningTotal;

        operators = new ArrayList<Character>();
        numbers = new ArrayList<Long>();
        runningTotal = 0;

    }

    public void clearClick(View view)
    {
        runningNumber = 0;
        runningTotal = 0;
        operators = new ArrayList<Character>();
        numbers = new ArrayList<Long>();

        refreshTotalView();
    }
}
