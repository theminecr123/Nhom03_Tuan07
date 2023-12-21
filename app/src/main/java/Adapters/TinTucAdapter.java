package Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom03_tuan07.R;

import java.util.List;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.tintucHolder> {
    Context context;
    List<Model_TinTuc> list;

    public TinTucAdapter(Context context, List<Model_TinTuc> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public tintucHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tintuc_layout, parent, false);
        return new tintucHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tintucHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.image.setImageResource(list.get(position).getImage());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class tintucHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView description;

        public tintucHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageview);
            name = itemView.findViewById(R.id.textview_tieude);
            description = itemView.findViewById(R.id.textview_noidung);


        }
    }

}