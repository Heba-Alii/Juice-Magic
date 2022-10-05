package eg.gov.iti.juicemagic.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentHomeBinding;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.ui.CategoryMenueAdapter;
import eg.gov.iti.juicemagic.ui.JuiceViewModel;
import eg.gov.iti.juicemagic.ui.LatestAdapter;
import eg.gov.iti.juicemagic.ui.MostsellingAdapter;
import eg.gov.iti.juicemagic.ui.OffersAdapter;
import eg.gov.iti.juicemagic.ui.SlideraAdapter;
import eg.gov.iti.juicemagic.ui.menue.MenueFragment;

public class HomeFragment extends Fragment {
    JuiceViewModel juiceViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        juiceViewModel = ViewModelProviders.of(this).get(JuiceViewModel.class);
        juiceViewModel.getJuices();
        CategoryMenueAdapter categoryMenueAdapter = new CategoryMenueAdapter();
        binding.categoryRecycler.setAdapter(categoryMenueAdapter);
        LatestAdapter latestAdapter = new LatestAdapter();
        binding.latestRecycler.setAdapter(latestAdapter);
        SlideraAdapter slideraAdapter = new SlideraAdapter();
        binding.slider.setSliderAdapter(slideraAdapter);
        MostsellingAdapter mostsellingAdapter = new MostsellingAdapter();
        binding.mostsellingRecycler.setAdapter(mostsellingAdapter);
        OffersAdapter offersAdapter = new OffersAdapter();
        binding.offersRecycler.setAdapter(offersAdapter);


        juiceViewModel.juiceMutableLiveData.observe(this, new Observer<JuiceModel>() {
            @Override
            public void onChanged(JuiceModel juiceModel) {
                if (juiceModel.getSlider() != null && juiceModel.getSlider().size() != 0) {
                    slideraAdapter.setList(juiceModel.getSlider());
                    binding.slider.setIndicatorAnimation(IndicatorAnimationType.WORM);
                    binding.slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                    binding.slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
                    binding.slider.setScrollTimeInSec(4);
                    binding.slider.setAutoCycle(true);
                    binding.slider.startAutoCycle();
                }
                if (juiceModel.getCategories() != null && juiceModel.getCategories().size() != 0) {
                    categoryMenueAdapter.setList(juiceModel.getCategories());
                }
                if (juiceModel.getLatest() != null && juiceModel.getLatest().size() != 0) {
                    latestAdapter.setList(juiceModel.getLatest());
                }
                if (juiceModel.getMost_selling() != null && juiceModel.getMost_selling().size() != 0) {
                    mostsellingAdapter.setList(juiceModel.getMost_selling());
                }
                if (juiceModel.getOffers() != null && juiceModel.getOffers().size() != 0) {
                    offersAdapter.setList(juiceModel.getOffers());
                }


            }
        });
//        binding.categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        binding.setLifecycleOwner(this);
//        binding.latestRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        binding.setLifecycleOwner(this);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}