package kriti.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class Checked extends AppCompatActivity {
    CheckBox javaj, cj, pythonj, dsj;
    Button okj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked);
        cj = (CheckBox) findViewById(R.id.c);
        pythonj = (CheckBox) findViewById(R.id.python);
        javaj = (CheckBox) findViewById(R.id.java);
        dsj = (CheckBox) findViewById(R.id.ds);
        okj = (Button) findViewById(R.id.ok);
        okj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("C   ").append(cj.isChecked());
                result.append("Python   ").append(pythonj.isChecked());
                result.append("Java   ").append(javaj.isChecked());
                result.append("ds   ").append(dsj.isChecked());
                result.append("are the languages you know").append(dsj.isChecked() || pythonj.isChecked() || javaj.isChecked() || dsj.isChecked());
                Toast.makeText(Checked.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}

