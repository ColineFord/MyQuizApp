package com.example.android.myquizapp;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.shapes.Shape;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editView;
    private RadioGroup radioGroupQ1;
    private RadioGroup radioGroupQ3;
    private RadioGroup radioGroupQ5;


    Button submit;
    int correctAnswers = 0;

    /**
     * This method hides the text input when you touch the screen outside of it
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * This line stops the text input from opening when the app starts
         */
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);

        /**
         * This line initiates the hint buttons
         */
        Button HintQ1 = this.findViewById(R.id.Hint_Q1);
        HintQ1.setOnClickListener(this);
        Button HintQ2 = this.findViewById(R.id.Hint_Q2);
        HintQ2.setOnClickListener(this);
        Button HintQ2bis = this.findViewById(R.id.Hint_Q2Bis);
        HintQ2bis.setOnClickListener(this);
        Button HintQ3 = this.findViewById(R.id.Hint_Q3);
        HintQ3.setOnClickListener(this);
        Button HintQ4 = this.findViewById(R.id.Hint_Q4);
        HintQ4.setOnClickListener(this);
        Button HintQ5 = this.findViewById(R.id.Hint_Q5);
        HintQ5.setOnClickListener(this);
        Button HintQ6Beyonce = this.findViewById(R.id.Hint_Q6);
        HintQ6Beyonce.setOnClickListener(this);
        Button HintQ6Bocelli = this.findViewById(R.id.Hint_Q6Bis);
        HintQ6Bocelli.setOnClickListener(this);
        Button HintQ7 = this.findViewById(R.id.Hint_Q7);
        HintQ7.setOnClickListener(this);
        Button HintQ8 = this.findViewById(R.id.Hint_Q8);
        HintQ8.setOnClickListener(this);
        Button HintQ8Bis = this.findViewById(R.id.Hint_Q8Bis);
        HintQ8Bis.setOnClickListener(this);
    }

    /**
     * This method initiates and starts the hint music when the hint button is clicked.
     */
    @Override
    public void onClick(View v) {
        final MediaPlayer Q1MP = MediaPlayer.create(this, R.raw.q1hintmusic);
        final MediaPlayer Q2queenMP = MediaPlayer.create(this, R.raw.q2hintmusicqueen);
        final MediaPlayer Q2panicMP = MediaPlayer.create(this, R.raw.q2hintmusicpanic);
        final MediaPlayer Q3MP = MediaPlayer.create(this, R.raw.q3hintmusic);
        final MediaPlayer Q4MP = MediaPlayer.create(this, R.raw.q4hintmusic);
        ImageView Q5hint = findViewById(R.id.Hint_Q5image);
        final MediaPlayer Q6BeyonceMP = MediaPlayer.create(this, R.raw.q6hintbeyonce);
        final MediaPlayer Q6BocelliMP = MediaPlayer.create(this, R.raw.q6hintbocelli);
        final MediaPlayer Q7MP = MediaPlayer.create(this, R.raw.q7hintmusic);
        final MediaPlayer Q8WeekndMP = MediaPlayer.create(this, R.raw.q8hintmusicweeknd);
        final MediaPlayer Q8DaftPunkMP = MediaPlayer.create(this, R.raw.q8hintmusicdaftpunk);

        switch (v.getId()) {
            case R.id.Hint_Q1:
                Q1MP.start();
                break;
            case R.id.Hint_Q2:
                Q2queenMP.start();
                break;
            case R.id.Hint_Q2Bis:
                Q2panicMP.start();
                break;
            case R.id.Hint_Q3:
                Q3MP.start();
                break;
            case R.id.Hint_Q4:
                Q4MP.start();
                break;
            case R.id.Hint_Q5:
                Q5hint.setVisibility(View.VISIBLE);
                Q5hint.setImageResource(R.drawable.q5hintimage);
                break;
            case R.id.Hint_Q6:
                Q6BeyonceMP.start();
                break;
            case R.id.Hint_Q6Bis:
                Q6BocelliMP.start();
                break;
            case R.id.Hint_Q7:
                Q7MP.start();
                break;
            case R.id.Hint_Q8:
                Q8WeekndMP.start();
                break;
            case R.id.Hint_Q8Bis:
                Q8DaftPunkMP.start();
                break;
            default:
                break;
        }
    }

    /**
     * This method gets the name of the player to make a personalized score message
     */
    private String getUsernameUserInput() {
        EditText userInputUsername = findViewById(R.id.name_field);
        String nameInput = userInputUsername.getText().toString();
        return nameInput;
    }

    /**
     * ------ QUESTION 1 ------
     * This method gets the answer of the player for the first question and updates the score
     * Answer is Shape of You
     */
    private void checkQuestionOneAnswers() {
        RadioButton isQuestionOneShapeChecked = findViewById(R.id.shape_stream);
        if (isQuestionOneShapeChecked.isChecked()) {
            correctAnswers += 1;
        }
    }


    /**
     * ------ QUESTION 2 ------
     * This method gets the answer of the player for the second question and updates the score
     * Answer is Queen, and also Panic At The Disco which is a bonus point
     */
    private void checkQuestionTwoAnswers() {
        CheckBox isQuestionTwoBeatlesChecked = findViewById(R.id.beatles_bohemian);
        CheckBox isQuestionTwoQueenChecked = findViewById(R.id.queen_bohemian);
        CheckBox isQuestionTwoU2Checked = findViewById(R.id.u2_bohemian);
        CheckBox isQuestionTwoPanicChecked = findViewById(R.id.panic_bohemian);

        if (isQuestionTwoQueenChecked.isChecked()) {
            correctAnswers += 1;
        }
        if (isQuestionTwoPanicChecked.isChecked()) {
            correctAnswers += 1;
        }
    }

    /**
     * This method makes a Fun Fact Toast message about Panic! At The Disco and a
     * "Bonus + 1" Toast message pop up if the player selects the bonus answer
     */
    public void onCheckboxPanicClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.panic_bohemian:
                if (checked) {
                    Toast toast2 = Toast.makeText(MainActivity.this, R.string.PanicFact, Toast.LENGTH_LONG);
                    toast2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast2.show();
                    Toast.makeText(MainActivity.this, R.string.Bonus,
                            Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    break;
                }
        }
    }


    /**
     * ------ QUESTION 3 ------
     * This method gets the answer of the player for the third question and updates the score
     * Answer is Despacito
     */
    private void checkQuestionThreeAnswers() {
        RadioButton isQuestionThreeDespacitoChecked = findViewById(R.id.desp_youtube);
        if (isQuestionThreeDespacitoChecked.isChecked()) {
            correctAnswers += 1;
        }
    }


    /**
     * ------ QUESTION 4 ------
     * This method gets the user input of the player for the fourth question and updates the score
     * Answer is Trumpet
     */
    private String getQuestionFourUserInput() {
        EditText userInputAnswerQuestion4 = findViewById(R.id.Trumpet);
        String answerQ4 = userInputAnswerQuestion4.getText().toString();
        return answerQ4;
    }

    private void checkQuestionFourAnswers() {
        String name = getQuestionFourUserInput();

        if (name.trim().equalsIgnoreCase("trumpet")) {
            correctAnswers += 1;
        } else if (name.trim().equalsIgnoreCase("trompet")) {
            correctAnswers += 1;
        } else if (name.trim().equalsIgnoreCase("trompette")) {
            correctAnswers += 1;
        } else if (name.trim().equalsIgnoreCase("trumpetta")) {
            correctAnswers += 1;
        } else if (name.trim().equalsIgnoreCase("trompeta")) {
            correctAnswers += 1;
        }else if (name.trim().equalsIgnoreCase("trumpette")) {
            correctAnswers += 1;
        } else if (name.trim().equalsIgnoreCase("trumpeta")) {
            correctAnswers += 1;
        }
    }

    /**
     * ------ QUESTION 5 ------
     * This method gets the answer of the player for the fifth question and updates the score
     * Answer is Divide
     */
    private void checkQuestionFiveAnswers() {
        RadioButton isQuestionFiveDivideChecked = findViewById(R.id.divide_sheeran);
        if (isQuestionFiveDivideChecked.isChecked()) {
            correctAnswers += 1;
        }
    }

    /**
     * ------ QUESTION 6 ------
     * This method gets the answer of the player for the sixth question and updates the score
     * Answer is Andrea Bocelli & Beyonce.
     */
    private void checkQuestionSixAnswers() {
        CheckBox isQuestionSixTaylorChecked = findViewById(R.id.perfect_taylor);
        CheckBox isQuestionSixBocelliChecked = findViewById(R.id.perfect_bocelli);
        CheckBox isQuestionSixBeyonceChecked = findViewById(R.id.perfect_beyonce);
        CheckBox isQuestionSixEminemChecked = findViewById(R.id.perfect_eminem);

        if (isQuestionSixBocelliChecked.isChecked()) {
            correctAnswers += 1;
        }
        if (isQuestionSixBeyonceChecked.isChecked()) {
            correctAnswers += 1;
        }
    }

    /**
     * ------ QUESTION 7 ------
     * This method gets the user input of the player for the seventh question and updates the score
     * Answer is ZAYN
     */
    private String getQuestionSevenUserInput() {
        EditText userInputAnswerQuestion7 = findViewById(R.id.DuskZayn);
        String answerQ7 = userInputAnswerQuestion7.getText().toString();
        return answerQ7;
    }

    private void checkQuestionSevenAnswers() {
        String name = getQuestionSevenUserInput();
        if (name.trim().equalsIgnoreCase("ZAYN")) {
            correctAnswers += 1;
        }else if (name.trim().equalsIgnoreCase("ZAIN")) {
            correctAnswers += 1;
        }
    }

    /**
     * ------ QUESTION 8 ------
     * This method gets the answer of the player for the eighth question and updates the score
     * Answer is Daft Punk and The Weeknd
     */
    private void checkQuestionEightAnswers() {
        CheckBox isQuestionEightDaftChecked = findViewById(R.id.daft_starboy);
        CheckBox isQuestionEightDrakeChecked = findViewById(R.id.drake_starboy);
        CheckBox isQuestionEightWeekndChecked = findViewById(R.id.weeknd_starboy);
        CheckBox isQuestionEightKendrickChecked = findViewById(R.id.kendrick_starboy);

        if (isQuestionEightDaftChecked.isChecked()) {
            correctAnswers += 1;
        }
        if (isQuestionEightWeekndChecked.isChecked()) {
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions() {
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswers();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
        checkQuestionSixAnswers();
        checkQuestionSevenAnswers();
        checkQuestionEightAnswers();
    }


    private void resetCounterCorrectAnswers() {
        correctAnswers = 0;
    }


    /**
     * This method checks all the answers and makes a Toast pop up letting the player know his score and if he/she won or lost
     */
    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v) {
            checkAllQuestions();

            if (correctAnswers == 11) {
                String YouWon = getString(R.string.YouWonToast, getUsernameUserInput(), correctAnswers);
                Toast.makeText(MainActivity.this, YouWon,
                        Toast.LENGTH_LONG).show();
                resetCounterCorrectAnswers();
            } else {
                String TryAgain = getString(R.string.TryAgainToast, getUsernameUserInput(), correctAnswers);
                Toast.makeText(MainActivity.this, TryAgain,
                        Toast.LENGTH_LONG).show();
                resetCounterCorrectAnswers();
            }

        }

    };

}