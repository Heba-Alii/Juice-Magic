package eg.gov.iti.juicemagic.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.ui.details.CardMenueDetails;
import eg.gov.iti.juicemagic.ui.home.HomeFragment;
import eg.gov.iti.juicemagic.ui.menue.MenueFragment;
import eg.gov.iti.juicemagic.ui.signup.SignupFragment;

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
        holder.card_menue.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                MenueFragment menueFragment = new MenueFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("index", position);
                menueFragment.setArguments(bundle);
                Log.e("TAG", "onClick: error in nav" + position);
                // Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_menue,bundle);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                CardMenueDetails cardMenueDetails = new CardMenueDetails();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, menueFragment)
                        .addToBackStack("home").commit();

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
        CircleImageView categoryImg;
        TextView categoryTxt;
        CardView card_menue;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            //  bgCategoryImg = itemView.findViewById(R.id.circle_bg_category_img);
            categoryImg = itemView.findViewById(R.id.category_item_img);
            categoryTxt = itemView.findViewById(R.id.category_item_txt);
            card_menue = itemView.findViewById(R.id.card_menue);
        }
    }
    
}