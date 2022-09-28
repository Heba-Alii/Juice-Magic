package eg.gov.iti.juicemagic.ui.menue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;
import eg.gov.iti.juicemagic.ui.details.CardMenueDetails;
//import eg.gov.iti.recyclerview.R;

public class MenueDetailsAdapter extends RecyclerView.Adapter<MenueDetailsAdapter.MenueDetailsViewHolder> {
    private ArrayList<JuiceModel.Latest> menueDetailsList = new ArrayList<>();
    CardMenueDetails cardMenueDetails;



    @NonNull
    @Override
    public MenueDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenueDetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menue_items_details, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MenueDetailsViewHolder holder, int position) {
        JuiceModel.Latest subCategoryModel = menueDetailsList.get(position);
        holder.menueNameTxt.setText(subCategoryModel.getSub_category_name());
        if (subCategoryModel.getSizes().stream().count() != 0) {
            holder.menuePriceTxt.setText(subCategoryModel.getSizes().get(0).getSub_category_size_price() + " " + "BHD");
        } else {
            holder.menuePriceTxt.setText("BHD");
        }
        Glide.with(holder.itemView)
                .load(subCategoryModel.getSub_category_image()).placeholder(R.drawable.logo)
                .fitCenter()
                .into(holder.menueDetailsImg);
        holder.menueDetailsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CardMenueDetails cardMenueDetails = new CardMenueDetails();
                Bundle bundle = new Bundle();
                bundle.putString("subCategoryId", subCategoryModel.getSub_category_id());
                if (subCategoryModel.getSizes().stream().count()!=0) {
                    bundle.putString("sizeId", subCategoryModel.getSizes().get(position).getSub_category_size_price_id());
                }else {
                    Toast.makeText(view.getContext(), "Not Available price Now", Toast.LENGTH_SHORT).show();
                }
                cardMenueDetails.setArguments(bundle);
                Navigation.findNavController(view).navigate(R.id.action_nav_menue_to_nav_details, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menueDetailsList.size();
    }

    public void setList(ArrayList<JuiceModel.Latest> menueDetailsList) {
        this.menueDetailsList = menueDetailsList;
        notifyDataSetChanged();
    }

    public class MenueDetailsViewHolder extends RecyclerView.ViewHolder {

        CircleImageView menueDetailsImg;
        TextView menueNameTxt;
        TextView menuePriceTxt;
        ImageButton favBtn;
        ImageButton cartBtn;
        CardView menueDetailsCV;

        public MenueDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            menueDetailsImg = itemView.findViewById(R.id.menue_details_circle_imgView);
            menueNameTxt = itemView.findViewById(R.id.menue_name_tv);
            menuePriceTxt = itemView.findViewById(R.id.menue_price_tv);
            favBtn = itemView.findViewById(R.id.fav_btn);
            cartBtn = itemView.findViewById(R.id.card_btn);
            menueDetailsCV = itemView.findViewById(R.id.menue_details_CV);

        }
    }
}