/*
An adapter class , the adapter is a link between  the UI and the data source(json data). This help fill the UI component with
data. This class mainly holds the data fetched and sends it to an adapter view , then the data from the adapter is then taken
by a cardview
 */

package com.example.listviewtutorial;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import static com.example.listviewtutorial.MainActivity.IMAGE_URL;
import static com.example.listviewtutorial.MainActivity.INFO;
import static com.example.listviewtutorial.MainActivity.PUBLISHER;
import static com.example.listviewtutorial.MainActivity.TITLE;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<recyclevi> list;
    private Context context;




    public MyAdapter(List<recyclevi> list,Context context){
        this.list=list;
        this.context= context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview2,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        recyclevi recyclevi = list.get(position);
        holder.textTitle.setText(recyclevi.getTitle());
        holder.textpublisher.setText(recyclevi.getPublisher());
        holder.textTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NewsFrame.class);
                recyclevi clickeditem= list.get(position);
                intent.putExtra(TITLE,clickeditem.getTitle());
                intent.putExtra(PUBLISHER,clickeditem.getPublisher());
                intent.putExtra(IMAGE_URL,clickeditem.getImageUrl());
                intent.putExtra(INFO,clickeditem.getInform());
                System.out.println(clickeditem.getImageUrl());

                context.startActivity(intent);

            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, textpublisher;



        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textView);
            textpublisher = itemView.findViewById(R.id.textView2);


        }
    }
}
