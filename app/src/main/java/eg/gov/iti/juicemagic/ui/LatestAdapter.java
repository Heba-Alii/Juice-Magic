package eg.gov.iti.juicemagic.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.JuiceModel;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.LatestViewHolder> {
    private ArrayList<JuiceModel.Latest> latestList = new ArrayList<>();

    @NonNull
    @Override
    public LatestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LatestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_items_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull LatestViewHolder holder, int position) {
        JuiceModel.Latest latest = latestList.get(position);
        holder.latestName.setText(latest.getSub_category_name());
        holder.latestPrice.setText(latest.getDiscount());
        holder.latestDesc.setText(latest.getSub_category_desc());
        Glide.with(holder.itemView)
                .load(latest.getSub_category_image())
                .into(holder.latestImages);
    }

    @Override
    public int getItemCount() {
        return latestList.size();
    }

    public void setList(ArrayList<JuiceModel.Latest> latestList) {
        this.latestList = latestList;
        notifyDataSetChanged();
    }

    public class LatestViewHolder extends RecyclerView.ViewHolder {
        ImageView latestImages;
        TextView latestName;
        TextView latestPrice;
        TextView latestDesc;
        ImageView imgIcon;

        public LatestViewHolder(@NonNull View itemView) {
            super(itemView);
            latestImages = itemView.findViewById(R.id.latest_img);
            latestName = itemView.findViewById(R.id.latest_nameTV);
            latestPrice = itemView.findViewById(R.id.latest_priceTV);
            latestDesc = itemView.findViewById(R.id.latest_desc);
            imgIcon = itemView.findViewById(R.id.latest_shopping_cart);
        }
    }
}