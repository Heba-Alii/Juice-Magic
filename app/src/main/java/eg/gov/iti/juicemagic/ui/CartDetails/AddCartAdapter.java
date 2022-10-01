package eg.gov.iti.juicemagic.ui.CartDetails;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
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

        LinearLayoutManager addition = new LinearLayoutManager(CartDetailsFragment.newInstance().getContext());
        LinearLayoutManager remove = new LinearLayoutManager(CartDetailsFragment.newInstance().getContext());
        addition.setOrientation(LinearLayoutManager.VERTICAL);
        holder.user_addition_rv.setLayoutManager(addition);
        remove.setOrientation(LinearLayoutManager.VERTICAL);
        holder.user_remove_rv.setLayoutManager(remove);
        AdditionCartAdapter additionCartAdapter = new AdditionCartAdapter();
        RemoveCartAdapter removeCartAdapter = new RemoveCartAdapter();
        holder.user_addition_rv.setAdapter(additionCartAdapter);
        holder.user_remove_rv.setAdapter(removeCartAdapter);
        additionCartAdapter.setList(getCartModel.getAddition());
        removeCartAdapter.setList(getCartModel.getRemove());
        holder.user_addNotes_text.setText(getCartModel.getSub_category_desc());
        if (getCartModel.getAddition().stream().count()!=0){
            holder.addition_txt.setVisibility(View.VISIBLE);
        }else {
            holder.addition_txt.setVisibility(View.GONE);
        }
        if (getCartModel.getRemove().stream().count()!=0){
            holder.without_txt.setVisibility(View.VISIBLE);
        }else {
            holder.without_txt.setVisibility(View.GONE);
        }
        if (getCartModel.getSub_category_desc().isEmpty()){
            holder.addAnyNotes_txt.setVisibility(View.GONE);

        }else {
            holder.addAnyNotes_txt.setVisibility(View.VISIBLE);

        }
        holder.increment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=holder.quantity_txt.getText().toString();
                int count=Integer.parseInt(number);
                count++;
                holder.quantity_txt.setText(String.valueOf(count));
            }
        });
        holder.decrement_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=holder.quantity_txt.getText().toString();
                int count=Integer.parseInt(number);
                if (count>1){
                    count--;
                    holder.quantity_txt.setText(String.valueOf(count));
                }else {
                    Toast.makeText(view.getContext(), "Minimum order is 1", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartItemsList.size() - 1;
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
        RecyclerView user_addition_rv;
        RecyclerView user_remove_rv;
        TextView user_addNotes_text;
        TextView addition_txt;
        TextView without_txt;
        TextView addAnyNotes_txt;



        public AddCartViewHolder(@NonNull View itemView) {
            super(itemView);
            juice_name = itemView.findViewById(R.id.juice_name);
            juice_image = itemView.findViewById(R.id.juice_image);
            juice_price = itemView.findViewById(R.id.juice_price);
            quantity_txt = itemView.findViewById(R.id.quantity_txt);
            increment_btn = itemView.findViewById(R.id.increment_btn);
            decrement_btn = itemView.findViewById(R.id.decrement_btn);
            delete_quntity_btn = itemView.findViewById(R.id.delete_quntity_btn);
            user_addition_rv = itemView.findViewById(R.id.user_addition_rv);
            user_remove_rv = itemView.findViewById(R.id.user_remove_rv);
            user_addNotes_text=itemView.findViewById(R.id.user_addNotes_text);
            addition_txt=itemView.findViewById(R.id.addition_txt);
            without_txt=itemView.findViewById(R.id.without_txt);
            addAnyNotes_txt=itemView.findViewById(R.id.addAnyNotes_txt);

        }
    }
}