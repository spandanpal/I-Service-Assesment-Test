package com.test.assesment.i_service_assesment_test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by vyomahp on 9/22/2017.
 */

public class ShiftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity mContext;
    String rqstuserid;
    ProgressDialog progressDialog;
    public int arrpos;
    int serial = 0;

    private int lastPosition = -1;
    private ArrayList<DayShiftModel> weekModelArrayList;
    IServiceModel dataModel = IServiceModel.getInstance();

    private static String add_default_qty = "1";
    public ProgressBar progress;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_day,tv_engineer_one_day_shift,tv_engineer_one_night_shift;

        public CardView card_view_engineer_details;


        public MyViewHolder(View view) {
            super(view);

            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_engineer_one_day_shift = (TextView) itemView.findViewById(R.id.tv_engineer_one_day_shift);
            tv_engineer_one_night_shift = (TextView) itemView.findViewById(R.id.tv_engineer_one_night_shift);

            card_view_engineer_details = (CardView) itemView.findViewById(R.id.card_view_engineer_details);

        }
    }

    public ShiftAdapter(ArrayList<DayShiftModel> weekModelArrayList, Activity mContext) {
        this.mContext = mContext;
        this.weekModelArrayList = weekModelArrayList;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 1: {
                View v = inflater.inflate(R.layout.inflate_shift_layout, parent, false);
                viewHolder = new MyViewHolder(v);
                final RecyclerView.ViewHolder finalViewHolder = viewHolder;

                break;
            }
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final DayShiftModel weekModel = weekModelArrayList.get(holder.getAdapterPosition());
        Log.e("view_cart_position", String.valueOf(position));
        switch (holder.getItemViewType()) {
            case 1: {
                final MyViewHolder viewholder = (MyViewHolder) holder;

                viewholder.tv_day.setText(weekModel.getDay());
                viewholder.tv_engineer_one_night_shift.setText(weekModel.getName_one());
                viewholder.tv_engineer_one_day_shift.setText(weekModel.getName_two());


               // viewholder.tv_engineer_name.setText(engineerModel.getName());





                break;
            }
        }
    }


    public int getItemViewType(int position) {

        return weekModelArrayList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return weekModelArrayList.size();
    }

    public DayShiftModel getItem(int position) {
        return weekModelArrayList.get(position);
    }
}
