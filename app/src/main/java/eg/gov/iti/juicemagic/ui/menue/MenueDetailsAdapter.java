package eg.gov.iti.juicemagic.ui.menue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
//import eg.gov.iti.recyclerview.R;

public class MenueDetailsAdapter extends RecyclerView.Adapter<MenueDetailsAdapter.MenueDetailsViewHolder> {
    private ArrayList<JuiceModel.Latest> menueDetailsList = new ArrayList<>();

    @NonNull
    @Override
    public MenueDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenueDetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menue_items_details, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MenueDetailsViewHolder holder, int position) {
        JuiceModel.Latest subCategoryModel = menueDetailsList.get(position);
        holder.menueNameTxt.setText(subCategoryModel.getSub_category_name());
        holder.menuePriceTxt.setText(subCategoryModel.getDiscount()+"");
        Glide.with(holder.itemView)
                .load(subCategoryModel.getSub_category_image())
                .fitCenter()
                .into(holder.menueDetailsImg);
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

        public MenueDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            menueDetailsImg = itemView.findViewById(R.id.menue_details_circle_imgView);
            menueNameTxt = itemView.findViewById(R.id.menue_name_tv);
            menuePriceTxt = itemView.findViewById(R.id.menue_price_tv);
            favBtn = itemView.findViewById(R.id.fav_btn);
            cartBtn = itemView.findViewById(R.id.card_btn);

        }
    }
}