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

public class CategoryMenueAdapter extends RecyclerView.Adapter<CategoryMenueAdapter.CategoryViewHolder> {
    private ArrayList<JuiceModel.Category> juiceList = new ArrayList<>();

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menue_items_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        JuiceModel.Category category = juiceList.get(position);
        holder.categoryTxt.setText(category.getParent_category_name());

        // Glide is use to load image
        // from url in your imageview.
        Glide.with(holder.itemView)
                .load(category.getParent_category_image()).placeholder(R.drawable.mob).fitCenter()
                .fitCenter()
                .into(holder.categoryImg);
//        if (category.getParent_category_image()==null){
//            holder.categoryImg.setImageBitmap(R.id.category_item_img);
//        }

    }

    @Override
    public int getItemCount() {
        return juiceList.size();
    }

    public void setList(ArrayList<JuiceModel.Category> juiceList) {
        this.juiceList = juiceList;
        notifyDataSetChanged();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        // ImageView bgCategoryImg;
        ImageView categoryImg;
        TextView categoryTxt;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            //  bgCategoryImg = itemView.findViewById(R.id.circle_bg_category_img);
            categoryImg = itemView.findViewById(R.id.category_item_img);
            categoryTxt = itemView.findViewById(R.id.category_item_txt);
        }
    }
}