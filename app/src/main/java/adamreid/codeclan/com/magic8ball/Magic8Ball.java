package adamreid.codeclan.com.magic8ball;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 01/05/2016.
 */
public class Magic8Ball extends Activity{

    private ImageButton mButtonEightBall;
    private TextView mDisplayResponse;
    private EditText mQuestionAsked;
    private ArrayList<String> mResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonEightBall = (ImageButton) findViewById(R.id.button_eight_ball);

        mButtonEightBall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("Magic8Ball:", "Eight Ball Button Clicked !! ");

                mDisplayResponse = (TextView) findViewById(R.id.response_eight_ball);
                mDisplayResponse.setText( generateResponse() );
                fade(view);
                rotate(view);
                playSound();
            }
        });
    }

    public String generateResponse() {
        mResponses = new ArrayList<>();
        mResponses.add("It is certain");
        mResponses.add("It is decidedly so");
        mResponses.add("Without a doubt");
        mResponses.add("Yes, definitely");
        mResponses.add("You may rely on it");
        mResponses.add("As I see it, yes");
        mResponses.add("Most likely");
        mResponses.add("Outlook good");
        mResponses.add("Yes");
        mResponses.add("Signs point to yes");
        mResponses.add("Reply hazy try again");
        mResponses.add("Ask again later");
        mResponses.add("Better not tell you now");
        mResponses.add("Cannot predict now");
        mResponses.add("Concentrate and ask again");
        mResponses.add("Don't count on it");
        mResponses.add("My reply is no");
        mResponses.add("My sources say no");
        mResponses.add("Outlook not so good");
        mResponses.add("Very doubtful");

        mQuestionAsked = (EditText) findViewById(R.id.question);
        String question = mQuestionAsked.getText().toString();
        Log.d("Magic8Ball:", question);


        if( question.matches("")){
            return "Ask a question above";
        }
        if( question.toLowerCase().contains("lottery")){
            return "You have a 1 in 45,057,474 chance of winning the lottery";
        }
        if( question.toLowerCase().contains("exam") || question.contains("exams")){
            return "As long as you studied hard, you'll do great!";
        }
        if ((question.toLowerCase().contains("greatest") || question.toLowerCase().contains("best")) && question.toLowerCase().contains("footballer")){
            return "Its either Zinedine Zidane or James McFadden";
        }
        if ( question.toLowerCase().contains("messi") && question.toLowerCase().contains("ronaldo")){
            return "Clearly, Messi is better. Ronaldo moans too much";
        }
        else {
            Random random = new Random();
            int result = random.nextInt(mResponses.size());
            return mResponses.get(result);
        }
    }





    public void fade(View view){
        Animation fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        mDisplayResponse.startAnimation(fade);
    }

    public void rotate(View view){
        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        mButtonEightBall.startAnimation(rotate);
    }

    public void playSound(){
        MediaPlayer sound = MediaPlayer.create(this, R.raw.magic_harp);
        sound.setAudioStreamType(AudioManager.STREAM_MUSIC);
        sound.start();
    }







}


