package kriti.tutorial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class RegistrationFire extends AppCompatActivity implements OnClickListener {
    TextView user_head_one,login_text_two;
    EditText user_email_one,user_pass_two;
    Button user_register_btn_one;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_fire);
        user_head_one =(TextView)findViewById(R.id.user_text_head);
        login_text_two = (TextView)findViewById(R.id.back_login_text);
        user_email_one = (EditText)findViewById(R.id.user_email_text);
        user_pass_two = (EditText)findViewById(R.id.user_pass_text);
        user_register_btn_one = (Button) findViewById(R.id.registration_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null) {
            finish();
            startActivity(new Intent(getApplicationContext(), Profile.class));
        }
        progressDialog =new ProgressDialog(this);
       user_register_btn_one.setOnClickListener(this);
        login_text_two.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==user_register_btn_one){
            registeruser();
        }
        if(v==login_text_two){
            startActivity(new Intent(getApplicationContext(), Firebasedlog.class));
        }

    }

    private void registeruser() {
        String email= user_email_one.getText().toString();
        String password = user_pass_two.getText().toString();
        if(email.length()==0)
        {
            user_email_one.setError("enterEm");
        }
        if(password.length()==0)
        {
            user_pass_two.setError("enter password");
        }
        progressDialog.setMessage("registering");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(),Firebasedlog.class));
                    Toast.makeText(getApplicationContext(),"Now you can Login",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }
}
