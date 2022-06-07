package com.example.akbuts.View;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.akbuts.Data.CatatanImp;
import com.example.akbuts.Presenter.InputActivity;
import com.example.akbuts.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.akbuts.Model.Catatan;
import com.example.akbuts.Presenter.CatatanAdapter;
import com.example.akbuts.Presenter.CatatanInterface;


import java.util.ArrayList;
import java.util.List;
/**
 Rezha Satria SP
 10119281
 IF7
 **/
public class CatatanView extends Fragment {
    private MainActivity mAct;
    private CatatanAdapter catatanAdapter;
    private CatatanInterface catatanInterface;
    private List<Catatan> catat;
    private RecyclerView recyclerView;
    private FloatingActionButton floatBtn;


    @Nullable
    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View mView =  inflater.inflate(R.layout.list_catatan, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        mAct = (MainActivity) getActivity();
        mAct.getSupportActionBar().hide();

        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.catatan);
        floatBtn = view.findViewById(R.id.floatBtn);
        floatBtn.setOnClickListener(v ->{
            startActivity(new Intent(getContext(), InputActivity.class));
        });

        read();
    }
    private void read(){
        catat=new ArrayList<Catatan>();
        catatanInterface = new CatatanImp(getContext());
        Cursor cursor = catatanInterface.read();
        if(cursor.moveToFirst()){
            do{
                Catatan c = new Catatan(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)

                );
                catat.add(c);
            }while (cursor.moveToNext());
        }
        catatanAdapter = new CatatanAdapter(catat);
        recyclerView.setAdapter(catatanAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }

}
