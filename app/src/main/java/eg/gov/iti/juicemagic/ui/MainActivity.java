package eg.gov.iti.juicemagic.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.ActivityMainBinding;
import eg.gov.iti.juicemagic.pojo.JuiceModel;

public class MainActivity extends AppCompatActivity {
    JuiceViewModel juiceViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_title);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        juiceViewModel = ViewModelProviders.of(this).get(JuiceViewModel.class);
        juiceViewModel.getJuices();
        CategoryMenueAdapter categoryMenueAdapter = new CategoryMenueAdapter();
        SlideraAdapter slideraAdapter = new SlideraAdapter();
        binding.categoryRecycler.setAdapter(categoryMenueAdapter);
        binding.slider.setSliderAdapter(slideraAdapter);
        LatestAdapter latestAdapter = new LatestAdapter();
        binding.latestRecycler.setAdapter(latestAdapter);


        juiceViewModel.juiceMutableLiveData.observe(this, new Observer<JuiceModel>() {
            @Override
            public void onChanged(JuiceModel juiceModel) {
//                ArrayList list=juiceModel.getLatest();
//                list.add()
//
//                slideraAdapter.setList(list);
                if (juiceModel.getSlider() != null && juiceModel.getSlider().size() != 0) {
                    slideraAdapter.setList(juiceModel.getSlider());
                    binding.slider.setIndicatorAnimation(IndicatorAnimationType.WORM);
                    binding.slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                    binding.slider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
                    binding.slider.setIndicatorSelectedColor(Color.WHITE);
                    binding.slider.setIndicatorUnselectedColor(Color.GRAY);
                    binding.slider.setScrollTimeInSec(4);
                    binding.slider.startAutoCycle();
                } else {
                }

                if (juiceModel.getCategories() != null && juiceModel.getCategories().size() != 0) {

                    categoryMenueAdapter.setList(juiceModel.getCategories());

                } else {
                    Log.e("TAG", "onChanged: " + juiceModel.getCategories().get(0).getParent_category_name());


                }
                if (juiceModel.getLatest() != null && juiceModel.getLatest().size() != 0) {
                    latestAdapter.setList(juiceModel.getLatest());
                }
                //System.out.println(juiceModel.getCategories().get(0).getParent_category_name());
                // Log.e("TAG", "onChanged: " +juiceModel.getCategories().get(0).getParent_category_name() );
            }

        });
        binding.categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.setLifecycleOwner(this);
        binding.latestRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.setLifecycleOwner(this);

    }
}