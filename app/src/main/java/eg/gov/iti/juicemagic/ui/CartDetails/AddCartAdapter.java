package eg.gov.iti.juicemagic.ui.CartDetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.GetCart_Model;
//import eg.gov.iti.recyclerview.R;
//import eg.gov.iti.recyclerview.pojo.GetCart_Model;

public class AddCartAdapter extends RecyclerView.Adapter<AddCartAdapter.AddCartViewHolder> {
    private ArrayList<GetCart_Model.Product> cartItemsList = new ArrayList<>();

    @NonNull
    @Override
    public AddCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AddCartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.add_cart_items_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull AddCartViewHolder holder, int position) {
        GetCart_Model.Product getCartModel = cartItemsList.get(position);
        holder.juice_name.setText(getCartModel.getSub_category_name());
        Glide.with(holder.itemView)
                .load(getCartModel.getSub_category_image())
                .placeholder(R.drawable.logo)
                .fitCenter()
                .into(holder.juice_image);
        holder.juice_price.setText(getCartModel.getPrice());
        holder.quantity_txt.setText(getCartModel.getQuantity());


    }

    @Override
    public int getItemCount() {
        return cartItemsList.size()-1;
    }

    public void setList(ArrayList<GetCart_Model.Product> cartItemsList) {
        this.cartItemsList = cartItemsList;
        notifyDataSetChanged();
    }

    public class AddCartViewHolder extends RecyclerView.ViewHolder {
        TextView juice_name;
        ImageView juice_image;
        TextView juice_price;
        TextView quantity_txt;
        AppCompatButton increment_btn;
        AppCompatButton decrement_btn;
        ImageView delete_quntity_btn;


        public AddCartViewHolder(@NonNull View itemView) {
            super(itemView);
            juice_name = itemView.findViewById(R.id.juice_name);
            juice_image = itemView.findViewById(R.id.juice_image);
            juice_price = itemView.findViewById(R.id.juice_price);
            quantity_txt = itemView.findViewById(R.id.quantity_txt);
            increment_btn = itemView.findViewById(R.id.increment_btn);
            decrement_btn = itemView.findViewById(R.id.decrement_btn);
            delete_quntity_btn = itemView.findViewById(R.id.delete_quntity_btn);

        }
    }
}