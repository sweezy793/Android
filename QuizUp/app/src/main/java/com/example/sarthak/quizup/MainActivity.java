package com.example.sarthak.quizup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
    Button mTrueButton;
    Button mFalseButton;
    TextView mScoreTextView;
    ProgressBar mProgressBar;
    int mScore;
    TextView mQuestionTextView;
    int mIndex=0;
    int mQuestion;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };
    final int PROGRESS_BAR_INCREMENT=8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        mScoreTextView=(TextView)findViewById(R.id.score);
        mQuestion=mQuestionBank[mIndex].getQuestionID();

        mQuestionTextView.setText(mQuestion);

        View.OnClickListener myListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestion();

            }
        };
        mTrueButton.setOnClickListener(myListener);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();
            }
        });
    }
        private  void updateQuestion()
        {
            mIndex=(mIndex+1)%mQuestionBank.length;
            if(mIndex==0)
            {
                AlertDialog.Builder alert=new AlertDialog.Builder(this);
                alert.setTitle("Game Over");
                alert.setCancelable(false);
                alert.setMessage("You scored "+mScore+" points!");
                alert.setPositiveButton("Close Quiz Up!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.show();
            }
            mQuestion=mQuestionBank[mIndex].getQuestionID();
            mQuestionTextView.setText(mQuestion);
            mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
            mScoreTextView.setText("Score "+mScore +"/"+mQuestionBank.length);

        }
        private void checkAnswer(boolean userSelection)
        {
            boolean correctAnswer=mQuestionBank[mIndex].isAnswer();

            if(userSelection==correctAnswer)
            {
                Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
                mScore=mScore+1;
            }
            else
            {
                Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }
        }
}
