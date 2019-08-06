package kriti.tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Intenttwo extends AppCompatActivity {
    String res="hello";
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intenttwo);
        textView = (TextView)findViewById(R.id.tvshow);
        String name = getIntent().getStringExtra("name");
        textView.setText("hello"+name);
        button = (Button)findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Intentone.class);//u can use this, this
                startActivity(intent);




            }
        });

    }
}
