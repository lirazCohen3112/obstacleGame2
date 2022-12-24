package com.example.obstaclegame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordHolder> {

    private Fragment fragment;
    private ArrayList <RecordLine> records;

    public RecordAdapter(Fragment fragment , ArrayList<RecordLine> records){
        this.records=records;
        this.fragment = fragment;
    }

    @Override
    public int getItemCount() {
        return records == null ? 0 : records.size();
    }

    @Override
    public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_record, parent, false);
        RecordHolder recordHolder = new RecordHolder(view);
        return  recordHolder;
    }

    @Override
    public void onBindViewHolder(final RecordHolder holder, final int position) {

        RecordLine recordLine = records.get(position);

        holder.list_record_LBL_num.setText("  num: " + Integer.toString(position));
        holder.list_record_LBL_score.setText("  score: " + Integer.toString(recordLine.getScore()));
    }


    class RecordHolder extends RecyclerView.ViewHolder{
        private MaterialTextView list_record_LBL_num;
        private MaterialTextView list_record_LBL_score;

        public RecordHolder(View itemView) {
            super(itemView);
            list_record_LBL_num = itemView.findViewById(R.id.list_record_LBL_num);
            list_record_LBL_score = itemView.findViewById(R.id.list_record_LBL_score);
        }
    }
}
