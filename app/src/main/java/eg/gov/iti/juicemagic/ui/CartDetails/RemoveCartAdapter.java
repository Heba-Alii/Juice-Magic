package eg.gov.iti.juicemagic.ui.CartDetails;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.GetCart_Model;
//import eg.gov.iti.recyclerview.R;
//import eg.gov.iti.recyclerview.pojo.GetCart_Model;

public class RemoveCartAdapter extends RecyclerView.Adapter<RemoveCartAdapter.RemoveCartViewHolder> {
    private ArrayList<GetCart_Model.Product> removeCartList = new ArrayList<>();

    @NonNull
    @Override
    public RemoveCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RemoveCartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.remove_add_cart_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull RemoveCartViewHolder holder, int position) {
        GetCart_Model.Product getCartModel = removeCartList.get(position);

          holder.user_remove_text.setText(getCartModel.getRemove().get(0).getRemove_name());

    }

    @Override
    public int getItemCount() {
        return removeCartList.size();
    }

    public void setList(ArrayList<GetCart_Model.Product> removeCartList) {
        this.removeCartList = removeCartList;
        notifyDataSetChanged();
    }

    public class RemoveCartViewHolder extends RecyclerView.ViewHolder {
        TextView user_remove_text;

        public RemoveCartViewHolder(@NonNull View itemView) {
            super(itemView);
            user_remove_text = itemView.findViewById(R.id.user_remove_text);

        }
    }
}