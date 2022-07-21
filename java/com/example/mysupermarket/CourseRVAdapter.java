package com.example.mysupermarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<SupermarketModel> itemModelArrayList;
    private Context context;

    // constructor
    public CourseRVAdapter(ArrayList<SupermarketModel> itemModelArrayList, Context context) {
        this.itemModelArrayList = itemModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        SupermarketModel modal = itemModelArrayList.get(position);
        holder.courseNameTV.setText(modal.getitemName());
        holder.courseDescTV.setText(modal.getitemPrice());
        holder.courseDurationTV.setText(modal.getitemQuantity());
        holder.courseTracksTV.setText(modal.getitemCat());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return itemModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.idTVItemName);
            courseDescTV = itemView.findViewById(R.id.itTVCategory);
            courseDurationTV = itemView.findViewById(R.id.idTVQuantity);
            courseTracksTV = itemView.findViewById(R.id.idTVItemPrice);
        }
    }
}


