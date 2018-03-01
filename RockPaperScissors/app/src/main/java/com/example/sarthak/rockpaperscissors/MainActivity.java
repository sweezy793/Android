package com.example.sarthak.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock,b_paper,b_scissors;
    ImageView iv_cpu,iv_me;
    String my_choice,cpu_choice,result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu=(ImageView)  findViewById(R.id.iv_cpu);
        iv_me=(ImageView)  findViewById(R.id.iv_me);

        b_rock=(Button) findViewById(R.id.b_rock);
        b_scissors=(Button) findViewById(R.id.b_scissors);
        b_paper=(Button) findViewById(R.id.b_paper);

        r=new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_choice="rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();

            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_choice="paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_choice="scissors";
                iv_me.setImageResource(R.drawable.scissors);
                calculate();
            }
        });
    }
    public void calculate()
    {
        int cpu=r.nextInt(3);
        if(cpu==0) {
            cpu_choice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }
        else if(cpu==1) {
            cpu_choice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        else if(cpu==2){
            cpu_choice="scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if(my_choice.equals("rock")&&cpu_choice.equals("scissors")){
            result="You WIN!!!";
        }else
        if(my_choice.equals("rock")&&cpu_choice.equals("paper")){
            result="You LOSE!!!";
        }else
        if(my_choice.equals("rock")&&cpu_choice.equals("rock")){
            result="DRAW!!!";
        }else
        if(my_choice.equals("paper")&&cpu_choice.equals("scissors")){
            result="You LOSE!!!";
        }else
        if(my_choice.equals("paper")&&cpu_choice.equals("paper")){
            result="DRAW!!!";
        }else
        if(my_choice.equals("paper")&&cpu_choice.equals("rock")){
            result="You WIN!!!";
        }else
        if(my_choice.equals("scissors")&&cpu_choice.equals("scissors")){
            result="DRAW!!!";
        }else
        if(my_choice.equals("scissors")&&cpu_choice.equals("paper")){
            result="You WIN!!!";
        }else
        if(my_choice.equals("scissors")&&cpu_choice.equals("rock")){
            result="You LOSE!!!";
        }
        Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();

    }
}
