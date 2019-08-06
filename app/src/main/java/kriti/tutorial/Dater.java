package kriti.tutorial;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;


public class Dater extends AppCompatActivity {
    DatePicker datePicker;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dater);
        datePicker = (DatePicker)findViewById(R.id.date_picker);
        tv = (TextView)findViewById(R.id.text_date);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        datePicker.init(calendar.get(java.util.Calendar.YEAR), calendar.get(java.util.Calendar.MONTH),
                calendar.get(java.util.Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tv.setText(dayOfMonth+"/"+monthOfYear+"/"+year);

                    }
                });

    }
}
