package com.example.materialspinner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.materialspinner.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initRecyclerView();
        setupAdapter();
    }

    private void initRecyclerView() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupAdapter() {
        List<String> list = new ArrayList<String>() {{
            add("Arezoo");
            add("Arezoo");
            add("Arezoo");
            add("Arezoo");
            add("Arezoo");
            add("Arezoo");
            add("Arezoo");
        }};

        TestAdapter adapter = new TestAdapter(this, list);
        mBinding.recyclerView.setAdapter(adapter);
    }
}