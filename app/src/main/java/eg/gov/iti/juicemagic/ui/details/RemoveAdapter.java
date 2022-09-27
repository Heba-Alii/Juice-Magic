package eg.gov.iti.juicemagic.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.Remove_Response;
//import eg.gov.iti.recyclerview.R;
//import eg.gov.iti.recyclerview.pojo.Remove_Response;

public class RemoveAdapter extends RecyclerView.Adapter<RemoveAdapter.RemoveViewHolder> {
    private ArrayList<Remove_Response.Product> removeList = new ArrayList<>();
    private CardMenueDetails cardMenueDetails;

    public RemoveAdapter(CardMenueDetails cardMenueDetails) {
        this.cardMenueDetails = cardMenueDetails;
    }

    @NonNull
    @Override
    public RemoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RemoveViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.remove_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull RemoveViewHolder holder, int position) {
        Remove_Response.Product remove_response = removeList.get(position);
        holder.removeText.setText(remove_response.getRemove_title());
        holder.removeChexBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardMenueDetails.removeAdapter(remove_response.getRemove_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return removeList.size();
    }

    public void setList(ArrayList<Remove_Response.Product> removeList) {
        this.removeList = removeList;
        notifyDataSetChanged();
    }

    public class RemoveViewHolder extends RecyclerView.ViewHolder {

        TextView removeText;
        ConstraintLayout removeConstraint;
        CheckBox removeChexBox;

        public RemoveViewHolder(@NonNull View itemView) {
            super(itemView);

            removeText = itemView.findViewById(R.id.remove_txt);
            removeConstraint = itemView.findViewById(R.id.remove_constraint);
            removeChexBox = itemView.findViewById(R.id.remove_checkbox);
        }
    }
}