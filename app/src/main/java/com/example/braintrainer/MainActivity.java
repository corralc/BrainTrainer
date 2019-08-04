package com.example.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Boolean gameState = false;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView problem;
    TextView timer;
    int rightCount = 0;
    int questionCount = 0;
    TextView rightorwrongMessage;
    TextView trackingRight;
    Random rand = new Random();
    int randNum;
    int randNum2;
    int solution;
    int choicePosition;


    public void settingrandomNumbers()
    {
        //Random Number from 1 to 1000 for question
        randNum = rand.nextInt((1000 - 0) + 1) + 0;
        //Random Number from 1 to 1000 for question
        randNum2 = rand.nextInt((1000 - 0) + 1) + 0;
        //Random Number from 1 to 4 for setting position of the answer
        choicePosition = rand.nextInt((4 - 1) + 1) + 1;
        //Variable containing the solution of the question
        solution = randNum + randNum2;

        //Set the text for the question containing the two random numbers
        problem.setText(Integer.toString(randNum) + "+" + Integer.toString(randNum2));

        //Tests to see if the random position equals to the position of button 1
        if(button1.getTag().equals((Integer.toString(choicePosition))))
        {

            button1.setText(Integer.toString(solution));
            button2.setText(Integer.toString(rand.nextInt(1000 - 0) + 0));
            button3.setText(Integer.toString(rand.nextInt(1000 - 0)+ 0));
            button4.setText(Integer.toString(rand.nextInt(1000 - 0)+ 0));

        }
        //Tests to see if the random position of the answer equals to the position of button 2
        else if(button2.getTag().equals((Integer.toString(choicePosition))))
        {
            button2.setText(Integer.toString(solution));
            button1.setText(Integer.toString(rand.nextInt(1000 - 0)));
            button3.setText(Integer.toString(rand.nextInt(1000 - 0)));
            button4.setText(Integer.toString(rand.nextInt(1000 - 0)));


        }
        //Tests to see if the random position of the answer equals to the position of button 3
        else if(button3.getTag().equals((Integer.toString(choicePosition))))
        {
            button3.setText(Integer.toString(solution));
            button1.setText(Integer.toString(rand.nextInt(1000 - 0)));
            button2.setText(Integer.toString(rand.nextInt(1000 - 0)));
            button4.setText(Integer.toString(rand.nextInt(1000 - 0)));

        }
        //Tests to see if the random position of the answer equals to the position of button 4
        else if(button4.getTag().equals((Integer.toString(choicePosition)))){

            button4.setText(Integer.toString(solution));
            button1.setText(Integer.toString(rand.nextInt(1000 - 0)));
            button3.setText(Integer.toString(rand.nextInt(1000 - 0)));
            button2.setText(Integer.toString(rand.nextInt(1000 - 0)));


        }
    }

    public void settingCountDown()
    {
        //Sets the count down to 30 seconds and counts down by 1
        CountDownTimer countDown = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //Updates the text that displays the time
                timer.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }
            //When the timer finishes
            @Override
            public void onFinish() {
                //Sets the variable to the text indicating right or wrong
                TextView rightorwrongMessage = findViewById(R.id.statusView);
                //Sets the visibility of the text to visible
                rightorwrongMessage.setVisibility(View.VISIBLE);
                //Sets the text right or wrong message text to Done!
                rightorwrongMessage.setText("Done!");
                gameState = false;
                //Sets the variable to the play again button
                Button playAgain = findViewById(R.id.playagainButton);
                //Makes the button visible
                playAgain.setVisibility(View.VISIBLE);

            }
        }.start();

    }

    public void checkingifRight(int num)
    {
         rightorwrongMessage = (TextView) findViewById(R.id.statusView);
        //Sets the variable to the text indicating how many questions right the user got
         trackingRight = (TextView) findViewById(R.id.rightquestionsView);
         //If the user gets the questions right
        if(num == solution)
        {   //Adds one to the value in the variable
            rightCount = rightCount + 1;
            //Sets the text indicating right or wrong text to visible
            rightorwrongMessage.setVisibility(View.VISIBLE);
            //Sets the text indicating right or wrong to Correct
            rightorwrongMessage.setText("Correct!");
            //Adds one when one question is answered
            questionCount = questionCount + 1;
            //Displays the number right as well as the number of questions answered
            trackingRight.setText(Integer.toString(rightCount) + "/" + Integer.toString(questionCount));
            //Calls the function to set the random numbers
            settingrandomNumbers();




        }
        else
        {
            //Sets the text indicating right or wrong to visible
            rightorwrongMessage.setVisibility(View.VISIBLE);
            //Sets the text to wrong
            rightorwrongMessage.setText("Wrong");
            //Keeps track of the amount of questions answered
            questionCount = questionCount + 1;
            //Displays the number right as well as the number of questions answered
            trackingRight.setText(Integer.toString(rightCount) + "/" + Integer.toString(questionCount));
            //Calls the function to set the random number
            settingrandomNumbers();

        }


    }
    //The action that takes place when the go button when app starts gets tapped on
    public void goClick (View view)
    {
        //Sets the variable to the go button
        Button goButton = findViewById(R.id.goButton);
        //Sets the go button invisible
        goButton.setVisibility(View.INVISIBLE);
        //Sets the button  to the button that is a possible answer to the question
         button1 = findViewById(R.id.button1);
         //Sets the button's visibility to visible
        button1.setVisibility(View.VISIBLE);
        //Sets the button  to the button that is a possible answer to the question
         button2 = findViewById(R.id.button2);
        //Sets the button's visibility to visible
        button2.setVisibility(View.VISIBLE);
        //Sets the button  to the button that is a possible answer to the question
         button3 =findViewById(R.id.button3);
        //Sets the button's visibility to visible
        button3.setVisibility(View.VISIBLE);
        //Sets the button  to the button that is a possible answer to the question
         button4 = findViewById(R.id.button4);
        //Sets the button's visibility to visible
        button4.setVisibility(View.VISIBLE);

        //Sets the variable to the text that displays the question
         problem = (TextView) findViewById(R.id.problemView);
         //Sets the variable to visible
        problem.setVisibility(View.VISIBLE);
        //Sets the variable to the text indicating how much time is left
        timer = (TextView) findViewById(R.id.timeView);
        //Sets the timer text to visible
        timer.setVisibility(View.VISIBLE);
        //Sets the variable to the text displaying the right questions and questions answered
        TextView rightProblems = (TextView) findViewById(R.id.rightquestionsView);
        //Sets the text to visible
        rightProblems.setVisibility(View.VISIBLE);
        //Sets the gamestate to true
        gameState = true;
        //Starts the countdown
        settingCountDown();

        //Sets the random numbers for the texts and positions of the answer
        settingrandomNumbers();



    }
    //If choice 1 is tapped on
    public void choiceClick1(View view)
    {
        //Creates a variable and sets it to the number displayed on the button
        int answer = Integer.parseInt((String)button1.getText());
        //Checks if the game is still active
        if(gameState == true) {
            //Calls the function to check it is right
            checkingifRight(answer);
        }

    }
    //If choice 2 is tapped on
    public void choiceClick2(View view)
    {
        //Creates a variable and sets it to the number displayed on the button
        int answer = Integer.parseInt((String)button2.getText());
        //Checks if the game is still active
        if(gameState == true) {
            //Calls the function to check it is right
            checkingifRight(answer);
        }
    }
    //If choice 3 is tapped on
    public void choiceClick3(View view)
    {   //Creates a variable and sets it to the number displayed on the button
        int answer = Integer.parseInt((String)button3.getText());
        //Checks if the game is still active
        if(gameState == true) {
            //Calls the function to check it is right
            checkingifRight(answer);
        }
    }
    //If choice 4 is tapped on
    public void choiceClick4(View view)
    {
        //Creates a variable and sets it to the number displayed on the button
        int answer = Integer.parseInt((String)button4.getText());
        //Checks if the game is still active
        if(gameState == true) {
            //Calls the function to check it is right
            checkingifRight(answer);
        }
    }
    //If the play again button is tapped
    public void playagainClick(View view)
    {
        //Gamestate becomes true
        gameState = true;
        //Count down timer is set again
        settingCountDown();
        //Random numbers are set as well for the questions, button positions and answers
        settingrandomNumbers();
        //Sets the variable to the play again button
        Button playagain = findViewById(R.id.playagainButton);
        //Sets the button to invisible
        playagain.setVisibility(View.INVISIBLE);
        //Sets the right or wrong message to invisible
        rightorwrongMessage.setVisibility(View.INVISIBLE);
        //Resets the number of questions correct counter
        rightCount = 0;
        //Resets the number of questions answered counter
        questionCount = 0;
        //Sets the text of the number of questions right and the number of questions answered
        trackingRight.setText(Integer.toString(rightCount)+ "/" + Integer.toString(questionCount));


    }










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
