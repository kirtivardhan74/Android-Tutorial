package kriti.tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    TextView j_sms,j_userid,j_password,jnewuser;
    EditText j_edit_userid,j_editpassword;
    Button j_login;
    public String email1, password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB=new DatabaseHelper(this);
        j_sms = (TextView) findViewById(R.id.sms);
        j_userid= (TextView) findViewById(R.id.userid);
        j_password= (TextView) findViewById(R.id.password);
        jnewuser = (TextView) findViewById(R.id.newuser);

        j_edit_userid = (EditText) findViewById(R.id.edit_userid);
        j_editpassword = (EditText) findViewById(R.id.editpassword);
        j_login = (Button) findViewById(R.id.login);
        jnewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "will come i", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
        j_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = j_edit_userid.getText().toString();
                String pass = j_editpassword.getText().toString();
                if(email.length()==0){
                    j_edit_userid.setError("Not Empty");
                }
                else if(pass.length()==0){
                    j_editpassword.setError("not Empty");

                }
                else{
                    int id = myDB.checkuser(email,pass);
                    if(id==-1){
                        Toast.makeText(MainActivity.this, "No user found", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), navigation.class);//u can use this, this
                        startActivity(intent);

                    }
                }
            }
        });
    }


}
