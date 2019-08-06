package kriti.tutorial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;


public class Profile extends AppCompatActivity implements View.OnClickListener {
    TextView textView_welcome;
    Button logout_btb_one,choose_btn_two,upload_btn_three;
    ImageView imageView_one;
    private FirebaseAuth firebaseAuth;
    private static final int PICK_IMAGE_REQUEST=234;
    private Uri filepath;
    FirebaseStorage storage;
    StorageReference storageReference;


;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        textView_welcome=(TextView)findViewById(R.id.welcome_text);
        logout_btb_one=(Button)findViewById(R.id.logout_btn);
        choose_btn_two =(Button)findViewById(R.id.choose_btn);
        upload_btn_three=(Button)findViewById(R.id.upload_btn);
        imageView_one =(ImageView)findViewById(R.id.imageView_profile);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        firebaseAuth= FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,Firebasedlog.class));

        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        textView_welcome.setText("welcome"+ user.getEmail());
        logout_btb_one.setOnClickListener(this);
        choose_btn_two.setOnClickListener(this);
        upload_btn_three.setOnClickListener(this);



    }
    public void onClick(View v){


        if(v==logout_btb_one)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,Firebasedlog.class));

        }
        if(v==choose_btn_two)
        {
            chooseimage();
        }
        if(v==upload_btn_three)
        {
            uploadimage();
        }


    }

    private void uploadimage()
    {
        if(filepath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("uploading your image");
            progressDialog.show();
            StorageReference srefer = storageReference.child("images/pic.jpg");
            srefer.putFile(filepath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"File Uploaded",Toast.LENGTH_SHORT).show();


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                    double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                    progressDialog.setMessage("upload"+((int)progress)+"%...");

                }
            });
        }
        else{

        }
    }

    private void chooseimage()
    {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select IMage"),PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!= null && data.getData()!=null) {
            filepath = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                imageView_one.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
