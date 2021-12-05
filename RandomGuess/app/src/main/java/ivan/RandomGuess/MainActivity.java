package ivan.RandomGuess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int userTries;
    static final int maxUserTries = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        userTries = maxUserTries;
        TextView title = findViewById(R.id.title);
        title.setText(String.format("%s\n\n%s %d", getStringFromValue(R.string.title), getStringFromValue((R.string.number_of_tries)), userTries));
        int numberToGuess = (int) (Math.random() * 9);
        Button enterButton = findViewById(R.id.enter_button);
        TextView resultTextView = findViewById(R.id.result);
        resultTextView.setText("");
        EditText numberUserGuessedEditText = findViewById(R.id.get_guessed_number);
        numberUserGuessedEditText.setText("");
        Log.e("Developing", String.valueOf(numberToGuess));
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userTries > 0){
                    try {
                        int guessedNumber = Integer.valueOf(numberUserGuessedEditText.getText().toString());

                        if (numberToGuess == guessedNumber) {
                            userTries--;
                            Intent intent = new Intent();
                            intent.setClass(MainActivity.this, WinActivity.class);
                            //Agregamos los extras
                            intent.putExtra(WinActivity.NUMBER_KEY, guessedNumber);
                            intent.putExtra(WinActivity.APP_NUMBER, numberToGuess);
                            intent.putExtra(WinActivity.TRIES, userTries);
                            startActivity(intent);
                        } else {
                            userTries--;
                            resultTextView.setText("");
                            resultTextView.setText(R.string.unguessed_game);
                            title.setText(String.format("%s\n\n%s %d", getStringFromValue(R.string.title), getStringFromValue((R.string.number_of_tries)), userTries));
                            if (userTries == 0){
                                //Cuando se acaban los tries lanzamos la ventana de fin del juego
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, FailActivity.class);
                                intent.putExtra(FailActivity.APP_NUMBER, numberToGuess);
                                startActivity(intent);
                            }
                        }
                    } catch (NumberFormatException e) {
                        resultTextView.setText("");
                        resultTextView.setText(getStringFromValue(R.string.number_format_error));
                    }

                }
                else {

                }



            }
        });
    }

    protected String getStringFromValue(int p) {
        return getResources().getString(p);
    }
}