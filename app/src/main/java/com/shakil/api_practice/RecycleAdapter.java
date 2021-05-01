package com.shakil.api_practice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyView> {

    private List<PostPojo> datalist;
    private Context context;
    public static final String Body_text="com.shakil.api_practice.Body_text";




    public RecycleAdapter(Context context,List<PostPojo> datalist){
        this.context=context;
        this.datalist=datalist;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        View view= layoutInflater.inflate(R.layout.recycleview,viewGroup,false);
        
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(MyView myView, int i) {
        myView.textView.setText(datalist.get(i).getTitle());
        myView.useridtext.setText(datalist.get(i).getId());
        myView.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String body= datalist.get(i).getBody().toString();
                Intent intent=new Intent(context,Detailes_activity.class);
                intent.putExtra(Body_text,body);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class MyView extends RecyclerView.ViewHolder{

        TextView textView,useridtext ;
        LinearLayout linearLayout;

        public MyView(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.Textviewidrecycleview);
            useridtext=itemView.findViewById(R.id.userid);
            linearLayout=itemView.findViewById(R.id.parantlayoutid);

        }
    }
}
