package io.github.agusprayogi02.latihan2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.github.agusprayogi02.latihan2.R;
import io.github.agusprayogi02.latihan2.models.NegaraModel;

public class NegaraAdapter extends RecyclerView.Adapter<NegaraAdapter.ViewHolder> {
    private List<NegaraModel> listNegara = new ArrayList<>();
    private OnNegaraClickListener listener;

    public NegaraAdapter(List<NegaraModel> list) {
        this.listNegara = list;
    }

    public interface OnNegaraClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(OnNegaraClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.negara_item, parent, false);
        return new ViewHolder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(listNegara.get(position), position);
    }

    @Override
    public int getItemCount() {
        return listNegara.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView negara;
        public TextView ibuKota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_flag);
            negara = itemView.findViewById(R.id.namaNegara);
            ibuKota = itemView.findViewById(R.id.ibuKota);
            itemView.setOnClickListener(view -> {
                listener.onClick(view, getBindingAdapterPosition());
            });
        }

        public void bindView(NegaraModel item, int position) {
            Glide.with(itemView).load(item.getImageUrl()).centerCrop().placeholder(R.drawable.ic_launcher_background).into(image);
            negara.setText(item.getNama());
            ibuKota.setText(item.getIbuKota());
        }
    }
}
