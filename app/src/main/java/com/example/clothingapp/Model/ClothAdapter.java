package com.example.clothingapp.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clothingapp.R;

import java.util.ArrayList;

public class ClothAdapter extends RecyclerView.Adapter<ClothAdapter.ViewHolder> {

    private ArrayList<Cloth> clothArrayList;
    final private OnListItemClickListener mOnListItemClickListener;

    public ClothAdapter(ArrayList<Cloth> cloth, OnListItemClickListener listener) {
        clothArrayList = cloth;
        mOnListItemClickListener = listener;
    }

    @NonNull
    public ClothAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cloth_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(clothArrayList.get(position).getStore());
        viewHolder.icon.setImageResource(clothArrayList.get(position).getIcon());
    }

    public int getItemCount() {
        return clothArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView name;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition(), clothArrayList);
        }
    }
    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex, ArrayList<Cloth> clothArrayList);
    }
}


