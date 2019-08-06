package kriti.tutorial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.google.firebase.auth.FirebaseAuth.*;


public class Firebasedlog extends AppCompatActivity implements View.OnClickListener {
    TextView login_head_one,register_head_two;

    EditText login_email_one,login_pass_two;
    Button login_btn_one;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebasedlog);
        login_head_one=(TextView)findViewById(R.id.user_login_head);
        register_head_two=(TextView)findViewById(R.id.next_register_text);
        login_email_one=(EditText)findViewById(R.id.login_email_text);
        login_pass_two= (EditText )findViewById(R.id.login_pass_text);
        login_btn_one=(Button)findViewById(R.id.Login_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog =new ProgressDialog(this);
        if(firebaseAuth.getCurrentUser()!=null)
        {   finish();
            startActivity(new Intent(getApplicationContext(),Profile.class));
        }
        login_btn_one.setOnClickListener(this);
        register_head_two.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==login_btn_one)
        {
            userlogin();

        }
        if(v==register_head_two)
        {
            startActivity(new Intent(getApplicationContext(),RegistrationFire.class));
        }
    }

    private void userlogin() {

        String email= login_email_one.getText().toString();
        String password = login_pass_two.getText().toString();
        if(email.length()==0)
        {
            login_email_one.setError("enterEm");
        }
        if(password.length()==0)
        {
            login_pass_two.setError("enter password");
        }
        progressDialog.setMessage("logging you in");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    finish();
                    startActivity(new Intent(getApplicationContext(),Profile.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"invalid credential",Toast.LENGTH_SHORT).show();

                }
                progressDialog.dismiss();
            }
        });

    }

}
