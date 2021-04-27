package com.shakil.api_practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyView> {

    private List<PostPojo> datalist;
    private Context context;


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
        myView.textView.setText(datalist.get(i).getBody());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class MyView extends RecyclerView.ViewHolder{

        TextView textView ;

        public MyView(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.Textviewidrecycleview);

        }
    }
}
