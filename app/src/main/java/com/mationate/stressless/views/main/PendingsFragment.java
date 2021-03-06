package com.mationate.stressless.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mationate.stressless.R;
import com.mationate.stressless.adapters.PendingClickListener;
import com.mationate.stressless.adapters.PendingsAdapter;
import com.mationate.stressless.models.Pending;
import com.mationate.stressless.views.details.DetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class PendingsFragment extends Fragment implements PendingClickListener {

    private PendingsAdapter adapter;

    public PendingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.pendingRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


       /* for (int i = 0; i < 20; i++) {
            Pending pending = new Pending();
            pending.setName(String.valueOf(i));
            pending.setDone(false);
            pending.save();
        }*/

        adapter = new PendingsAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void updateList(Pending pending) {
        adapter.update(pending);
        Log.e("TAG", pending.getName());


    }


    @Override
    public void clickedID(long id) {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra("ID",id);
        startActivity(intent);


    }
}
