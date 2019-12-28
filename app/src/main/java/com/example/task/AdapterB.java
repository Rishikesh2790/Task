package com.example.task;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterB extends RecyclerView.Adapter<AdapterB.AView> {

    private Context context;
    private ArrayList<Dataa> all;

    public AdapterB(Context context, ArrayList<Dataa> all) {
        this.context = context;
        this.all = all;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        return new AView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AView holder, final int position) {

        final Dataa dataa = all.get(position);


        holder.name.setText(dataa.getName());
        holder.type.setText(dataa.getType());
        holder.endtime.setText(dataa.getEndtime());
        holder.startime.setText(dataa.getStarttime());
        holder.text.setText(dataa.getDays());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {


                final String [] a = {"Edit","Delete","Share"};

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setItems(a, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (a[0].equals(a[which])){
                            context.startActivity(new Intent(context,SecondActivity.class));
                        }
                        else if (a[1].equals(a[which])){
                        OpenHelperMethod op = new OpenHelperMethod(v.getContext());
                        SQLiteDatabase db = op.getWritableDatabase();
                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                        db.delete("PASSCODE","_id"+"=?",new String[]{dataa.getId()});
                        notifyDataSetChanged();
                        }
                        else if (a[2].equals(a[which]))
                            {
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_TEXT,"Hello World!");
                                context.startActivity(intent);
                            }

                    }
                });

                AlertDialog alertDialog=builder.create();
                alertDialog.show();
                return true;

            }
        });


    }

    @Override
    public int getItemCount() {
        return all.size();
    }

    public class AView extends RecyclerView.ViewHolder {
        TextView name,startime,endtime,type,text;

        public AView(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            startime = itemView.findViewById(R.id.starttime);
            endtime = itemView.findViewById(R.id.endtime);
            type = itemView.findViewById(R.id.type);
            text = itemView.findViewById(R.id.line1);

        }

    }

    @Override
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
    }

    @Override
    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
    }
}
