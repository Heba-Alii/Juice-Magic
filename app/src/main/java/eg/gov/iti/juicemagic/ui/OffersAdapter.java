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

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersViewHolder> {
    private ArrayList<JuiceModel.Offer> offersList = new ArrayList<>();

    @NonNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OffersViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_items_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull OffersViewHolder holder, int position) {
        JuiceModel.Offer offer = offersList.get(position);
        holder.offersName.setText(offer.getSub_category_name());
        holder.offersPrice.setText(offer.getSizes().get(0).getSub_category_size_price_after_disc());
        Glide.with(holder.itemView)
                .load(offer.getSub_category_image())
                .fitCenter()
                .into(holder.offersImages);
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public void setList(ArrayList<JuiceModel.Offer> offersList) {
        this.offersList = offersList;
        notifyDataSetChanged();
    }

    public class OffersViewHolder extends RecyclerView.ViewHolder {
        ImageView offersImages;
        TextView offersName;
        TextView offersPrice;
        TextView offersDesc;
        ImageView offersIcon;

        public OffersViewHolder(@NonNull View itemView) {
            super(itemView);
            offersImages = itemView.findViewById(R.id.offers_img);
            offersName = itemView.findViewById(R.id.offers_nameTV);
            offersPrice = itemView.findViewById(R.id.offers_priceTV);
            offersDesc = itemView.findViewById(R.id.offers_desc);
            offersIcon = itemView.findViewById(R.id.offers_shopping_cart);
        }
    }
}