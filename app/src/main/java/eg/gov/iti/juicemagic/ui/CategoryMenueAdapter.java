package eg.gov.iti.juicemagic.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.ui.menue.MenueFragment;

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
        holder.categoryImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenueFragment menueFragment=new MenueFragment();
                Bundle bundle = new Bundle();
               // bundle.putString("parentCategoryId", category.getParent_category_id());
                bundle.putInt("index",position);
                menueFragment.setArguments(bundle);
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_menue, bundle);
            }
        });


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