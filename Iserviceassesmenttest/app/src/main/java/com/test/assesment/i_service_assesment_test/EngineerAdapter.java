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

public class EngineerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity mContext;
    String rqstuserid;
    ProgressDialog progressDialog;
    public int arrpos;
    int serial = 0;

    private int lastPosition = -1;
    private ArrayList<EngineerModel> engineerModelArrayList;
    IServiceModel dataModel = IServiceModel.getInstance();

    private static String add_default_qty = "1";
    public ProgressBar progress;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_engineer_name;

        public CardView card_view_engineer_details;


        public MyViewHolder(View view) {
            super(view);

            tv_engineer_name = (TextView) itemView.findViewById(R.id.tv_engineer_name);

            card_view_engineer_details = (CardView) itemView.findViewById(R.id.card_view_engineer_details);

        }
    }

    public EngineerAdapter(ArrayList<EngineerModel> engineerModelArrayList, Activity mContext) {
        this.mContext = mContext;
        this.engineerModelArrayList = engineerModelArrayList;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 1: {
                View v = inflater.inflate(R.layout.inflate_engineer_layout, parent, false);
                viewHolder = new MyViewHolder(v);
                final RecyclerView.ViewHolder finalViewHolder = viewHolder;

                break;
            }
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final EngineerModel engineerModel = engineerModelArrayList.get(holder.getAdapterPosition());
        Log.e("view_cart_position", String.valueOf(position));
        switch (holder.getItemViewType()) {
            case 1: {
                final MyViewHolder viewholder = (MyViewHolder) holder;



                viewholder.tv_engineer_name.setText(engineerModel.getName());





                break;
            }
        }
    }


    public int getItemViewType(int position) {

        return engineerModelArrayList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return engineerModelArrayList.size();
    }

    public EngineerModel getItem(int position) {
        return engineerModelArrayList.get(position);
    }
}
