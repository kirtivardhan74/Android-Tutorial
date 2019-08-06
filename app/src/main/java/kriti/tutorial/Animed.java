package kriti.tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


public class Animed extends AppCompatActivity {
    TextView textView;
    Button jbutton1, jbutton2, jbutton3;
    Animation zi,zo,bo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        textView=(TextView)findViewById(R.id.Desc);
        jbutton1= (Button)findViewById(R.id.button);
        jbutton2= (Button)findViewById(R.id.button2);
       jbutton3 = (Button)findViewById(R.id.button3);
        zi= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        zo=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        bo=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        jbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               textView.setVisibility(View.VISIBLE);
                textView.startAnimation(zi);
            }
        });
        jbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(zo);
            }
        });
        jbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(bo);
            }
        });




    }
}
