package eg.gov.iti.juicemagic.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.pojo.JuiceModel;

public class SlideraAdapter extends SliderViewAdapter<SlideraAdapter.SliderAdapterVH> {
    private ArrayList<JuiceModel.Slider> juiceList = new ArrayList<>();


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        return new SliderAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapterVH holder, int position) {

        JuiceModel.Slider sliderItem = juiceList.get(position);
        Glide.with(holder.itemView)
                .load(sliderItem.getSlider_image()).placeholder(R.drawable.mob).fitCenter()
                .into(holder.sliderImages);
    }

    public void setList(ArrayList<JuiceModel.Slider> juiceList) {
        this.juiceList = juiceList;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {


        return juiceList.size();
    }

    public class SliderAdapterVH extends SlideraAdapter.ViewHolder {
        ImageView sliderImages;

        public SliderAdapterVH(@NonNull View itemView) {
            super(itemView);
            sliderImages = itemView.findViewById(R.id.slider_img);

        }
    }
}