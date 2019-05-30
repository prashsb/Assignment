package com.winjit.assignement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winjit.assignement.model.applicants_data;
import com.winjit.assignement.model.state_data;

import java.util.ArrayList;
import java.util.List;


public class Applicant_adapter extends RecyclerView.Adapter<Applicant_adapter.app_holder> {


    private List<applicants_data> data = new ArrayList<>();
    private Context context;

    public Applicant_adapter(Context context) {
        this.context = context;
    }


    public void setData(List<applicants_data> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public app_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.applicant_holder,viewGroup,false);
        return new app_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull app_holder app_holder, int i) {
        app_holder.update(data.get(i));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class app_holder extends RecyclerView.ViewHolder{



        TextView name;

        TextView address;

        TextView state;

        TextView mobile;

        TextView adhar;

        TextView pan;

        public app_holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            adhar= itemView.findViewById(R.id.adhar);
            address=itemView.findViewById(R.id.address);
            state = itemView.findViewById(R.id.state);
            mobile = itemView.findViewById(R.id.mobile);
            pan = itemView.findViewById(R.id.pan);
        }


        public void update(applicants_data data){

            name.setText("Name: "+data.getName());
            address.setText("Address: "+data.getAddress());
            state.setText("State: "+data.getState());
            mobile.setText("Mobile: "+data.getMobile());
            adhar.setText("Adhar: "+data.getAdhar_no());
            pan.setText("Pan: "+data.getPan_no());

        }
    }


}
