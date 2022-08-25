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

public class MostsellingAdapter extends RecyclerView.Adapter<MostsellingAdapter.MostSellingViewHolder> {
    private ArrayList<JuiceModel.MostSelling> mostSellingList = new ArrayList<>();

    @NonNull
    @Override
    public MostSellingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MostSellingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.most_selling_items_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MostSellingViewHolder holder, int position) {
        JuiceModel.MostSelling mostSelling = mostSellingList.get(position);
        holder.mostSellingName.setText(mostSelling.getSub_category_name());
        Glide.with(holder.itemView)
                .load(mostSelling.getSub_category_image())
                .fitCenter()
                .into(holder.mostSellingImages);
        holder.mostSellingPrice.setText(mostSelling.getSizes().get(0).getSub_category_size_price());
    }

    @Override
    public int getItemCount() {
        return mostSellingList.size();
    }

    public void setList(ArrayList<JuiceModel.MostSelling> mostSellingList) {
        this.mostSellingList = mostSellingList;
        notifyDataSetChanged();
    }

    public class MostSellingViewHolder extends RecyclerView.ViewHolder {
        ImageView mostSellingImages;
        TextView mostSellingName;
        TextView mostSellingPrice;
        TextView mostSellingDesc;
        ImageView imgIcon;

        public MostSellingViewHolder(@NonNull View itemView) {
            super(itemView);
            mostSellingImages = itemView.findViewById(R.id.most_selling_img);
            mostSellingName = itemView.findViewById(R.id.most_selling_nameTV);
            mostSellingPrice = itemView.findViewById(R.id.most_selling_priceTV);
            mostSellingDesc = itemView.findViewById(R.id.most_selling_desc);
            imgIcon = itemView.findViewById(R.id.most_selling_shopping_cart);
        }
    }
}