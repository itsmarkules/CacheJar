package sjcnymobile.cachejar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class CreateJar extends AppCompatActivity {

    TextView nameOfJar;
    TextView date;
    TextView time;
    Button submitJar;
    Button resetJar;
    ImageView dateImageView;
    ImageView timeImageView;
    ImageView jarImageView;

    String jarName;
    int day;
    int month;
    int year;
    Color color;
    String jarStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_jar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        jarName = nameOfJar.getText().toString();
        date = (TextView) findViewById(R.id.dateView);
        time = (TextView) findViewById(R.id.timeView);
        dateImageView = (ImageView) findViewById(R.id.dateImageView);
        timeImageView = (ImageView) findViewById(R.id.timeImageView);
        jarImageView = (ImageView) findViewById(R.id.JarView);
        submitJar = (Button) findViewById(R.id.submit);
        resetJar = (Button) findViewById(R.id.reset);

        dateImageView.setClickable(true);
        dateImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();

            }
        });

    }
    public void showDatePickerDialog()
    {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datepicker");
    }
    private void getDate(DatePicker view, int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }

    }

}

