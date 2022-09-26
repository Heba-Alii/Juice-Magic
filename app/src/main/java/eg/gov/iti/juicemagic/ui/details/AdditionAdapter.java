package eg.gov.iti.juicemagic.ui.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.Additions_Model;
//import eg.gov.iti.recyclerview.R;
//import eg.gov.iti.recyclerview.pojo.Additions_Model;

public class AdditionAdapter extends RecyclerView.Adapter<AdditionAdapter.AdditionViewHolder> {
    private ArrayList<Additions_Model.Product> additionsList = new ArrayList<>();

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

        public AdditionViewHolder(@NonNull View itemView) {
            super(itemView);
            additionText = itemView.findViewById(R.id.addition_txt);

        }
    }
}