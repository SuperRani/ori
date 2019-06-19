package com.example.livealoneproject;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdapterListView extends RecyclerView.Adapter<AdapterListView.MainViewHolder> {

    private List<ListItem> items = new ArrayList<>();
    Context context;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_list_view, parent, false);

        MainViewHolder viewHolder = new MainViewHolder(view);
        context = parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ListItem item = items.get(position);
        holder.keyNum.setText((position+1)+"");
        holder.image.setImageDrawable(item.getImage());
        holder.tvPlace.setText(item.getPlace());
        holder.tvDay.setText(item.getDay());
        holder.tvEstate.setText(item.getEstate());
        holder.tvAddress.setText(item.getAddress());
        holder.index.setText(item.getIndex()+"");
    }

    @Override
    public int getItemCount() {
        return items.size();        //아이템을 몇개까지 만들 것인가
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        public TextView keyNum;
        public ImageView image;
        public TextView tvPlace;
        public TextView tvDay;
        public TextView tvEstate;
        public TextView tvAddress;
        public TextView index;

        public MainViewHolder(View v) {
            super(v);
            keyNum = v.findViewById(R.id.keyNum);
            image = v.findViewById(R.id.image);
            tvPlace = v.findViewById(R.id.tvPlace);
            tvDay = v.findViewById(R.id.tvDay);
            tvEstate = v.findViewById(R.id.tvEstate);
            tvAddress = v.findViewById(R.id.tvAddress);
            index = v.findViewById(R.id.index);

            v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(context, AddCheckActivity.class);
                        intent.putExtra("index", Integer.parseInt(index.getText().toString()));
                        intent.putExtra("update", true);
                        ((CheckActivity)context).startActivityForResult(intent, 1);
                    }
                }
            });

            v.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        DBHelper helper = new DBHelper(context);
                        SQLiteDatabase db = helper.getWritableDatabase();

                        int index = items.get(pos).getIndex();

                        db.delete("checklist", "key_num = " + index, null);

                        Toast.makeText(context, "삭제되었습니다.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(context, CheckActivity.class);
                        ((CheckActivity)context).finish();
                        context.startActivity(intent);
                    }
                    return false;
                }
            });
        }
    }

    public void addItem(ListItem item) {
        items.add(item);
    }
    public void updateItem(int index, ListItem item){
        items.set(index, item);
    }
}
