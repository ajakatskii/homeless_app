package com.damon.literarium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.damon.literarium.adapters.TuitionRequestAdapter;
import com.damon.literarium.adapters.UpcomingTuitionsAdapter;
import com.damon.literarium.data.Registry;

public class RequestedTuitionsActivity extends AppCompatActivity {

    private RecyclerView rvTuitionSuggestions;
    private UpcomingTuitionsAdapter upcAdapter;

    private RecyclerView rvTuitionsRequests;
    private TuitionRequestAdapter reqAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_tuitions);
        this.initViews();
    }

    private void initViews()
    {
        rvTuitionSuggestions = findViewById(R.id.rvTuitionSuggestions);
        upcAdapter = new UpcomingTuitionsAdapter(Registry.getInstance().getTuitionSuggestions(), true);
        rvTuitionSuggestions.setLayoutManager(new LinearLayoutManager(
                this, RecyclerView.HORIZONTAL, false
        ));
        rvTuitionSuggestions.setAdapter(upcAdapter);

        rvTuitionsRequests = findViewById(R.id.rvTuitionReqs);
        rvTuitionsRequests.setLayoutManager(new LinearLayoutManager(
                this, RecyclerView.VERTICAL, false
        ));
        reqAdapter = new TuitionRequestAdapter(Registry.getInstance().getAllTuitionRequests());
        rvTuitionsRequests.setAdapter(reqAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //high chance of things being removed so refresh datalists
        this.upcAdapter.notifyDataSetChanged();
        this.reqAdapter.notifyDataSetChanged();
    }
}
