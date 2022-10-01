package eg.gov.iti.juicemagic.ui.CartDetails;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.GetCart_Model;
//import eg.gov.iti.recyclerview.R;
//import eg.gov.iti.recyclerview.pojo.GetCart_Model;

public class AdditionCartAdapter extends RecyclerView.Adapter<AdditionCartAdapter.AdditonCartViewHolder> {
    private ArrayList<GetCart_Model.Addition> additionCartList = new ArrayList<>();

    @NonNull
    @Override
    public AdditonCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdditonCartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.addition_add_cart_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull AdditonCartViewHolder holder, int position) {
        GetCart_Model.Addition getCartModel = additionCartList.get(position);

            holder.user_addition_text.setText(getCartModel.getAddition_name());

    }

    @Override
    public int getItemCount() {
        return additionCartList.size();
    }

    public void setList(ArrayList<GetCart_Model.Addition> additionCartList) {
        this.additionCartList = additionCartList;
        notifyDataSetChanged();
    }

    public class AdditonCartViewHolder extends RecyclerView.ViewHolder {
         TextView user_addition_text;


        public AdditonCartViewHolder(@NonNull View itemView) {
            super(itemView);

            user_addition_text = itemView.findViewById(R.id.user_addition_text);
        }
    }
}