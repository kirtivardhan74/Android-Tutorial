package kriti.tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//import kriti.Tutorial.R;

public class Imgview extends AppCompatActivity {
    Button jswitch;
    ImageView jimg;
    int current_img_index;
    int[] images = {R.drawable.c, R.drawable.java, R.drawable.python};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgview);
        jimg= (ImageView)findViewById(R.id.imageView);
        jswitch = (Button)findViewById(R.id.switched);
        jswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               current_img_index++;
                current_img_index= current_img_index % images.length;
                jimg.setImageResource(images[current_img_index]);
            }
        });
    }
}
