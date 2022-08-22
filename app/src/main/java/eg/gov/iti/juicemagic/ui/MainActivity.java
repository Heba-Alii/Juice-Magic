package eg.gov.iti.juicemagic.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.ActivityMainBinding;
import eg.gov.iti.juicemagic.pojo.JuiceModel;

public class MainActivity extends AppCompatActivity {
    JuiceViewModel juiceViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        juiceViewModel = ViewModelProviders.of(this).get(JuiceViewModel.class);

        juiceViewModel.getJuices();
        juiceViewModel.juiceMutableLiveData.observe(this, new Observer<JuiceModel>() {
            @Override
            public void onChanged(JuiceModel juiceModel) {
                if (juiceModel.getCategories() != null && juiceModel.getCategories().size() != 0) {
                    SliderAdapter adapter = new SliderAdapter(this, juiceModel.getCategories());
                    binding.slider.setAutoCycleDirection(binding.slider.LAYOUT_DIRECTION_LTR);
                    binding.slider.setSliderAdapter(adapter);
                    binding.slider.setScrollTimeInSec(3);
                    binding.slider.startAutoCycle();
                }
                System.out.println(juiceModel.getCategories().get(0).getParent_category_name());
                // Log.e("TAG", "onChanged: " +juiceModel.getCategories().get(0).getParent_category_name() );
            }
        });
    }
}