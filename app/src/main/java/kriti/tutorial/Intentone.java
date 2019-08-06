package kriti.tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Intentone extends AppCompatActivity {
    EditText editText1;
    public String name;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentone);
        editText1 = (EditText)findViewById(R.id.editText);

        button = (Button)findViewById(R.id.nextact);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText1.getText().toString();
                if(name.length()==0)
                    editText1.setError("empty hai bhaiwa");
                else {

                    Intent intent = new Intent(getApplicationContext(), Intenttwo.class);//u can use this, this
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            }
        });
    }
}
