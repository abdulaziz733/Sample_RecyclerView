package com.listne.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.listne.R;
import com.listne.model.Ne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdul on 6/13/2017.
 */

public class ListNeAdapter extends RecyclerView.Adapter<ListNeAdapter.MyViewHolder> {

    private List<Ne> listNe = new ArrayList<Ne>();
    private Context context;

    public ListNeAdapter(List<Ne> listNe, Context context) {
        this.listNe = listNe;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_ne_row, parent, false);

        return new ListNeAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Ne ne = listNe.get(position);
        holder.neId.setText(ne.getIdNe() + "");
        holder.neName.setText(ne.getNe());
    }

    @Override
    public int getItemCount() {
        return listNe.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView neId, neName;

        public MyViewHolder(View itemView) {
            super(itemView);
            neId = (TextView) itemView.findViewById(R.id.id_ne);
            neName = (TextView) itemView.findViewById(R.id.ne_name);
        }
    }

}
