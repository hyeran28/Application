package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mMainRecyclerView;
    private MainAdapter mAdapter;
    private  List<BoardActivity> mBoardList;
    private FloatingActionButton mWriteButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainRecyclerView = findViewById(R.id.main_recycler_view);
        mWriteButton = findViewById(R.id.main_write_button);

        mWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WriteActivity.class);
                startActivity(intent);
            }
        });

        mBoardList = new ArrayList<>();
        mBoardList.add(new BoardActivity(null, "Board",null, "Name"));
        mBoardList.add(new BoardActivity(null, "Board 2",null, "Name2"));
        mBoardList.add(new BoardActivity(null, "Board 3",null, "Name3"));
        mBoardList.add(new BoardActivity(null, "Board 4",null, "Name4"));
        mBoardList.add(new BoardActivity(null, "Board 5",null, "Name5"));

        mAdapter = new MainAdapter(mBoardList);
        mMainRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {

    }

    private class MainAdapter extends  RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        private List<BoardActivity> mBoardList;

        public MainAdapter(List<BoardActivity> mBoardList) {
            this.mBoardList = mBoardList;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            BoardActivity data = mBoardList.get(position);
            holder.mTitleTextView.setText(data.getTitle());
            holder.mNameTextView.setText(data.getName());
        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class  MainViewHolder extends  RecyclerView.ViewHolder {
            private TextView mTitleTextView;
            private  TextView mNameTextView;

            public MainViewHolder(View itemView){
                super(itemView);

                mTitleTextView = itemView.findViewById(R.id.item_title_text);
                mNameTextView = itemView.findViewById(R.id.item_name_text);
            }
       }
    }
}