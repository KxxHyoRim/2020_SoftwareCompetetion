package com.example.login10;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.MyViewHolder> {

    Context context;
    ArrayList<PlanItemData> planItemData;
    DatabaseReference reference;

    public PlanAdapter(Context c, ArrayList<PlanItemData> p)
    {
        context = c;
        planItemData = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.planName.setText(planItemData.get(position).getPlanName());
        myViewHolder.memo.setText(planItemData.get(position).getMemo());
        myViewHolder.date.setText(planItemData.get(position).getDate());
        myViewHolder.time.setText(planItemData.get(position).getTime());
        myViewHolder.alarm.setText(planItemData.get(position).getAlarm());

        //myViewHolder.complete.setText("true");

//        if(myViewHolder.complete.isChecked())
//            myViewHolder.complete.setText("true");
//        else
//            myViewHolder.complete.setText("false");

        final String getPlanNameGet=planItemData.get(position).getPlanName();
        final String getMemoGet=planItemData.get(position).getMemo();
        final String getDateGet=planItemData.get(position).getDate();
        final String getTimeGet=planItemData.get(position).getTime();
        final String getAlarmGet=planItemData.get(position).getAlarm();
        final String getKeyGet=planItemData.get(position).getKey();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(context, EditPlanActivity.class);
                intent2.putExtra("planName", getPlanNameGet);
                intent2.putExtra("memo", getMemoGet);
                intent2.putExtra("date", getDateGet);
                intent2.putExtra("time", getTimeGet);
                intent2.putExtra("alarm", getAlarmGet);
                intent2.putExtra("key", getKeyGet);
                context.startActivity(intent2);
            }
        });
    }

    @Override
    public int getItemCount() {
        return planItemData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView planName, memo, date, time, alarm, key;
        ToggleButton complete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            planName=(TextView) itemView.findViewById(R.id.planName);
            memo=(TextView) itemView.findViewById(R.id.memo);
            date=(TextView) itemView.findViewById(R.id.date);
            time=(TextView) itemView.findViewById(R.id.time);
            alarm=(TextView) itemView.findViewById(R.id.alarm);
            complete=(ToggleButton) itemView.findViewById(R.id.completeOX);
        }
    }

}