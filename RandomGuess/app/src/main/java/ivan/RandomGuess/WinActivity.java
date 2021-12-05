package ivan.RandomGuess;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class WinActivity extends AppCompatActivity {
    public static final String NUMBER_KEY = "number";
    public static final String APP_NUMBER = "number to guess";
    public static final String TRIES = "tries";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        ImageView endingImage = findViewById(R.id.gameOver);
        Intent intent = getIntent();
        int guessedNumber = intent.getIntExtra(NUMBER_KEY, 0);
        int numberToGuess = intent.getIntExtra(APP_NUMBER, 0);
        int numberOfTries = MainActivity.maxUserTries - intent.getIntExtra(TRIES, 0);

        TextView resultTextView = findViewById(R.id.result);
        resultTextView.setText(String.format("%s\n%s %d\n%s %d\n%s %d",
                getResources().getString(R.string.guessed),
                getResources().getString(R.string.user_number),
                guessedNumber,
                getResources().getString(R.string.app_number),
                numberToGuess,
                getResources().getString(R.string.result_number_of_tries), numberOfTries));
        endingImage.setImageResource(R.drawable.trophy);
    }
}
