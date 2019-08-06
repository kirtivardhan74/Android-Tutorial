package kriti.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//import kriti.Tutorial.R;

public class RadioTest extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_test);
        rg=(RadioGroup) findViewById(R.id.rgroup);



    }
    public void rbclick(View v)
    {
        int radiobuttonid = rg.getCheckedRadioButtonId();
        rb= (RadioButton)findViewById(radiobuttonid);
        Toast.makeText(RadioTest.this, rb.getText(), Toast.LENGTH_SHORT).show();
    }
}
