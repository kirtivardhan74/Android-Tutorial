package kriti.tutorial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kriti.tutorial.R;

public class Recycled extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context;
    private List<Clubs> clubs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycled);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_item);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        insertdataoncard();
        initializeadapter();


    }



    private void insertdataoncard() {
        clubs = new ArrayList<>();
        clubs.add(new Clubs("javaa",R.drawable.java));
        clubs.add(new Clubs("c",R.drawable.c));
        clubs.add(new Clubs("python",R.drawable.python));
        clubs.add(new Clubs("tv",R.drawable.third));
        clubs.add(new Clubs("images", R.drawable.images));


    }
    private void initializeadapter() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(clubs);
        recyclerView.setAdapter(adapter);
    }
}

//password toggle enabled
