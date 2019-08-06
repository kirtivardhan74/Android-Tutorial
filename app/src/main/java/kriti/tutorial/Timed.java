package kriti.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;



public class Timed extends AppCompatActivity {
    TimePicker timePicker;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timed);
        timePicker = (TimePicker)findViewById(R.id.time_picker);
        tv = (TextView)findViewById(R.id.text_time);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tv.setText(hourOfDay+":"+minute);

            }
        });

    }
    }

