package kriti.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class Spined extends AppCompatActivity {
    TextView s_area,pin_text,value_text;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spined);
        spinner = (Spinner)findViewById(R.id.spinnedar);
        s_area = (TextView)findViewById(R.id.area);
        pin_text= (TextView) findViewById(R.id.pintext);
        value_text = (TextView)findViewById(R.id.pinvalue);
        String[] area_list = {"Select the area","mahmoorganj","madauli","Ashapur","Manduadih","Sigra"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,area_list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        value_text.setText("Select any area");
                        break;
                    case 1:
                        value_text.setText("221010");
                        break;
                    case 2:
                        value_text.setText("221108");
                        break;
                    case 3:
                        value_text.setText("221007");
                        break;
                    case 4:
                        value_text.setText("221003");
                        break;
                    case 5:
                        value_text.setText("221004");
                        break;



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
