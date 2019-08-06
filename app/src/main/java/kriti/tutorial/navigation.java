package kriti.tutorial;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.TimedMetaData;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class navigation extends AppCompatActivity {
    Button jradio,jcheck,janimation,jimg,jrecycle,jseeked,jdater,jtimed,jspined,jintented,jfired,jfrags;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        jradio=(Button)findViewById(R.id.Radio);
        jradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), RadioTest.class);//u can use this, this
                        startActivity(intent);
                    }
        });
        jcheck=(Button)findViewById(R.id.check);
        jcheck    .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Checked.class);//u can use this, this
                startActivity(intent);
            }
        });
        janimation=(Button)findViewById(R.id.animation);
        janimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Animed.class);//u can use this, this
                startActivity(intent);
            }
        });
        jimg=(Button)findViewById(R.id.img);
        jimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Imgview.class);//u can use this, this
                startActivity(intent);
            }
        });
        jrecycle=(Button)findViewById(R.id.recyclercard);
        jrecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Recycled.class);//u can use this, this
                startActivity(intent);


            }
        });
        jseeked=(Button)findViewById(R.id.seeked);
        jseeked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Seeked.class);//u can use this, this
                startActivity(intent);


            }
        });
        jdater=(Button)findViewById(R.id.dater);
        jdater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Dater.class);//u can use this, this
                startActivity(intent);


            }
        });
        jtimed=(Button)findViewById(R.id.timed);
        jtimed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Timed.class);//u can use this, this
                startActivity(intent);


            }
        });
        jspined=(Button)findViewById(R.id.spined);
        jspined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Spined.class);//u can use this, this
                startActivity(intent);


            }
        });
        jintented=(Button)findViewById(R.id.intented);
        jintented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Intentone.class);//u can use this, this
                startActivity(intent);


            }
        });

        jfired =(Button)findViewById(R.id.fired);
        jfired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Now you can Login",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Firebasedlog.class);//u can use this, this
                startActivity(intent);

                //Toast.makeText(getApplicationContext(),"Now you can Login",Toast.LENGTH_SHORT).show();


            }
        });
        jfrags=(Button)findViewById(R.id.frag);
        jfrags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fragmented.class);//u can use this, this
                startActivity(intent);
            }
        });




    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    private void showAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setTitle("exit");
                builder.setMessage("Sura ? u want exit?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.create().show();;

    }
}
