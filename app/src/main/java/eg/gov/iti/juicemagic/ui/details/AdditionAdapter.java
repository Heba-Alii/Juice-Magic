package eg.gov.iti.juicemagic.ui.details;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.Additions_Model;
//import eg.gov.iti.recyclerview.R;
//import eg.gov.iti.recyclerview.pojo.Additions_Model;

public class AdditionAdapter extends RecyclerView.Adapter<AdditionAdapter.AdditionViewHolder> {

    boolean chkActivated = false;
    private ArrayList<Additions_Model.Product> additionsList = new ArrayList<>();
    private CardMenueDetails cardMenueDetails;

    public AdditionAdapter(CardMenueDetails cardMenueDetails) {
        this.cardMenueDetails = cardMenueDetails;
    }

    @NonNull
    @Override
    public AdditionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdditionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.addition_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull AdditionViewHolder holder, int position) {
        Additions_Model.Product additions_model = additionsList.get(position);
        if (additions_model.getAddition_name() != null) {
            holder.additionText.setText(additions_model.getAddition_name());
        } else {
            holder.additionText.setText("Null");
        }
        //add to card btn ( send id to fragment)
        holder.additionCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardMenueDetails.addditionAdapter(additions_model.getAddition_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return additionsList.size();
    }

    public void setList(ArrayList<Additions_Model.Product> additionsList) {
        this.additionsList = additionsList;
        notifyDataSetChanged();
    }

    public class AdditionViewHolder extends RecyclerView.ViewHolder {
        TextView additionText;
        AppCompatButton addToCart;
        ConstraintLayout additionConstraint;
        CheckBox additionCheckbox;


        public AdditionViewHolder(@NonNull View itemView) {
            super(itemView);
            additionText = itemView.findViewById(R.id.addition_txt);
            addToCart = itemView.findViewById(R.id.add_to_cart_btn);
            additionConstraint = itemView.findViewById(R.id.addition_constraint);
            additionCheckbox = itemView.findViewById(R.id.addition_checkbox);
        }
    }
}