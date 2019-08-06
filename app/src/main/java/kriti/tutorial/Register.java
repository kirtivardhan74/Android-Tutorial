package kriti.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends AppCompatActivity {

    TextView j1_tvregister, j1_tvname, j1_tvemail, j1tvpass, j1_tvphone, j1_loginback,show_det;
    EditText j1_etnamer, j1_etemailr, j1_etpassr, j1_etphoner;
    Button j1_register;
    DatabaseHelper myDB1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDB1 = new DatabaseHelper(this);
        j1_tvregister = (TextView) findViewById(R.id.tvregister);
        j1_tvname = (TextView) findViewById(R.id.tvname);
        j1_tvemail = (TextView) findViewById(R.id.tvemail);
        j1tvpass = (TextView) findViewById(R.id.tvpass);
        j1_tvphone = (TextView) findViewById(R.id.tvphone);
        j1_loginback = (TextView) findViewById(R.id.loginback);
        j1_etnamer = (EditText) findViewById(R.id.etnamer);
        j1_etemailr = (EditText) findViewById(R.id.etemailr);
        j1_etpassr = (EditText) findViewById(R.id.etpassr);
        j1_etphoner = (EditText) findViewById(R.id.etphoner);
        j1_register = (Button) findViewById(R.id.register);
        show_det = (TextView)findViewById(R.id.text_show_detail);
        addData();
        show_det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myDB1.getAllData();
                Cursor res = myDB1.getAllData();
                if (res.getCount() == 0) {
                    Toast.makeText(Register.this, "Eror db empty", Toast.LENGTH_SHORT).show();

                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    /*if ((res.getString(1).equals(j1_etemailr.getText().toString()) && (res.getString(2).equals
                            (j1_etpassr.getText().toString())))) {
                        Toast.makeText(Register.this, "user exists", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Register.this, "user not exists", Toast.LENGTH_SHORT).show();

                    }*/
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                    buffer.append("Email :"+ res.getString(2)+"\n");
                    Toast.makeText(Register.this, "DAta"+buffer.toString(), Toast.LENGTH_SHORT).show();


                }
            }
        });

    }

    public void addData() {
        j1_register.setOnClickListener(new View.OnClickListener() {
            @Override
            //one more way to otast the data
            public void onClick(View v) {
                try {
                    boolean isInserted = myDB1.insertData(j1_etnamer.getText().toString(),
                            j1_etemailr.getText().toString(), j1_etpassr.getText().toString(),
                            j1_etphoner.getText().toString());
                    if (isInserted == true) {
                        Toast.makeText(Register.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Register.this, "Data nt Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(), ""+e, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}


