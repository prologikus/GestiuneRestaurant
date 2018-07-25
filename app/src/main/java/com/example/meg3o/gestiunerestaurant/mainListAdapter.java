package com.example.meg3o.gestiunerestaurant;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


public class mainListAdapter extends RecyclerView.Adapter<mainListAdapter.ViewHolder> {

    private List<orderList> orderList;
    private Context mContext;
    ViewGroup parentBoss;
    private ItemClickListener mClickListener;

    public mainListAdapter(Context context, List<orderList> orderList) {
        this.orderList = orderList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parentBoss = parent; //added
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_minimized, parent, false);
        return new ViewHolder(itemView);
}

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final orderList item = orderList.get(position);

        holder.name.setText(item.getTest());

           //     Toast.makeText(mContext, "clicked", Toast.LENGTH_LONG).show();

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView showText;
        ImageView showIcon;
        MaterialButton time;
        TextView name;
        TextView subName;
        ConstraintLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            showText = itemView.findViewById(R.id.showText);
            showIcon = itemView.findViewById(R.id.showIcon);
            time = itemView.findViewById(R.id.time);
            name = itemView.findViewById(R.id.name);
            subName = itemView.findViewById(R.id.subName);
            layout = itemView.findViewById(R.id.layout);

         //   showIcon.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

    }
    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}



