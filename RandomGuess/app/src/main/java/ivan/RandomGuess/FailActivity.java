package ivan.RandomGuess;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FailActivity extends AppCompatActivity {
    public static final String APP_NUMBER = "number to guess";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        ImageView endingImage = findViewById(R.id.gameOver);
        Intent intent = getIntent();
        int numberToGuess = intent.getIntExtra(APP_NUMBER, 0);

        TextView resultTextView = findViewById(R.id.result);
        resultTextView.setText(String.format("%s %d",
                getResources().getString(R.string.unguessed), numberToGuess));
        endingImage.setImageResource(R.drawable.game_over);
    }
}
