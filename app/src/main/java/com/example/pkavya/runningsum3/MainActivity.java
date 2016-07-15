package com.example.pkavya.runningsum3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mMinus, mPlus, mSendNumber;
    TextView mN, mNumbers, mSum;
    int n = 3;
    ArrayList<Integer>list = new ArrayList<>();
    int sum=0;
    String buffer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComp();
        mN.setText(""+n);

        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n <=10 && n>3){
                    n--;
                    mN.setText(""+n);
                } else {
                    Toast.makeText(MainActivity.this, "N cannot be less than 3.", Toast.LENGTH_SHORT).show();
                }

                if (list.size()>n){
                    sum = sum - list.get(0);
                    buffer = buffer.substring(4);
                    list.remove(0);
                    mNumbers.setText(buffer);
                }

            }
        });

        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n>=3 && n<10){
                    n++;
                    mN.setText(""+n);
                } else {
                    Toast.makeText(MainActivity.this, "N cannot be higher than 10.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mSendNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int num = r.nextInt(9) + 1;
                if (list.size()<n){
                    list.add(num);
                    sum = sum + num;
                    if (list.size()==1){
                        buffer = buffer + "| " + num+ " | ";
                        mNumbers.setText(buffer);
                        mSum.setText(""+sum);
                    } else {
                        buffer = buffer + num + " | ";
                        mNumbers.setText(buffer);
                        mSum.setText(""+sum);
                    }
                }

                else if (list.size()==n){
                    sum = sum - list.get(0);
                    buffer = buffer.substring(4);
                    list.remove(0);
                    list.add(num);
                    sum = sum + num;
                    if (list.size()==1){
                        buffer = buffer + " | " + num;
                        mNumbers.setText(buffer);
                        mSum.setText(""+sum);
                    } else {
                        buffer = buffer + num + " | ";
                        mNumbers.setText(buffer);
                        mSum.setText(""+sum);
                    }
                }
            }
        });




    }


    public void initComp(){
        mMinus = (Button)findViewById(R.id.minus);
        mPlus = (Button)findViewById(R.id.plus);
        mSendNumber = (Button)findViewById(R.id.btn_send_number);

        mN = (TextView)findViewById(R.id.n);
        mNumbers = (TextView)findViewById(R.id.numbers);
        mSum = (TextView)findViewById(R.id.sum);
    }





}
