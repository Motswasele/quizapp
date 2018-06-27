package com.example.android.agriculturalmanagementpractices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.RadioButton;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //Declared variables for checkbox
    CheckBox question1_a, question1_b, question2_a, question2_b;

    //Declared variables for RadioButtons
    RadioButton question3_a,question4_b,male_gender,female_gender;

    //Declared variables for 'Submit' button
    Button buttonAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }


    public void addListenerOnButtonClick(){
        //Getting instance of CheckBoxes

        question1_a=(CheckBox)findViewById(R.id.q1_checkbox_a);
        question1_b=(CheckBox)findViewById(R.id.q1_checkbox_b);
        question2_a=(CheckBox)findViewById(R.id.q2_checkbox_a);
        question2_b=(CheckBox)findViewById(R.id.q2_checkbox_b);

        //Getting instance of RadioButtons and Button from the activty_main.xml file

        male_gender=(RadioButton)findViewById(R.id.male_gender);
        female_gender=(RadioButton)findViewById(R.id.female_gender);
        question3_a=(RadioButton)findViewById(R.id.q3_radiobutton_a);
        question4_b=(RadioButton)findViewById(R.id.q4_radiobutton_b);
        buttonAnswers=(Button)findViewById(R.id.submitAnswers);

        //Applying the Listener on the Button click
        buttonAnswers.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View view) {
                int totalAmount=0;
                String gender="";
                StringBuilder result=new StringBuilder();
                result.append(getString(R.string.correct_answers));



                //Will display the male gender if chosen
                if (male_gender.isChecked()){
                    gender = getString(R.string.male_gender);
                }

                //Will display the female gender if chosen
                if (female_gender.isChecked()){
                    gender = getString(R.string.female_gender);
                }

                //marks given for the selected first question
                if(question1_a.isChecked()){
                    totalAmount+=1;
                }
                //marks given for the selected first question
                if(question1_b.isChecked()){
                    totalAmount+=1;
                }
                //marks given for the selected second question
                if(question2_a.isChecked()){
                    totalAmount+=1;
                }

                //marks given for the selected second question
                if(question2_b.isChecked()){
                    totalAmount+=1;
                }

                //marks given for the selected third question
                if (question3_a.isChecked()) {
                    totalAmount+=2;
                }

                //marks given for the selected fourth question
                if (question4_b.isChecked()) {
                    totalAmount+=2;
                }

                //Calculation for the selected correct answers for all questions
                result.append("\n"+ getString(R.string.total)+" " +totalAmount+"/8");

                /**
                 * Displaying the message on the toast
                 * This method displays the given selected correct answers value on the screen.
                 */
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

                //For the text name field
                EditText nameField = (EditText) findViewById(R.id.full_name);
                String name = nameField.getText().toString();

                /**This will display the name inserted in the EditText field and will
                 * display which ever gender button clicked on.
                 */

                String fullNames =getString(R.string.full_names) + ": " + name;
                displayName(fullNames);

                /**This will display which ever gender button clicked on.
                 */
                String genderDisplay = getString(R.string.gender) + ": " + gender;
                displayGender(genderDisplay);

                //Displaying the correct answers below the questions
                String answersDisplay = getString(R.string.question_1)+ "\n" + "\n" +
                        getString(R.string.correct_answers_1)+ "\n"+ "\n"+
                        getString(R.string.question_2)
                        + "\n"+ "\n" + getString(R.string.correct_answers_2) +"\n"
                        + "\n" + getString(R.string.question_3)+ "\n"+ "\n" +
                        getString(R.string.correct_answer_3) +
                        "\n"+ "\n"+ getString(R.string.question_4)+ "\n"+ "\n" +
                        getString(R.string.correct_answer_4);
                displayAnswers(answersDisplay);

            }

        });
    }
    /**
     * This method displays the answers on the screen.
     */
    private void displayAnswers(String messages){
        TextView answersTextView = (TextView) findViewById(R.id.answers_text_view);
        answersTextView.setText(messages);
    }

    /**
     * This method displays the names typed in the EditText field on the screen.
     */

    private void displayName(String fullNames){
        TextView nameTextView = (TextView) findViewById(R.id.name_display);
        nameTextView.setText(fullNames);
    }

    /**
     * This method displays the gender chosen on the screen.
     */
    private void displayGender(String sex){
        TextView genderTextView = (TextView) findViewById(R.id.gender_display);
        genderTextView.setText(sex);
    }

    //This method is for clearing the displayed answer, the names and gender.

    public void clearText(View view){

        String clearAnswersDisplayed ="";
        displayAnswers(clearAnswersDisplayed);

        String clearDisplayName= "";
        displayName(clearDisplayName);

        String clearGender="";
        displayGender(clearGender);
    }

}
