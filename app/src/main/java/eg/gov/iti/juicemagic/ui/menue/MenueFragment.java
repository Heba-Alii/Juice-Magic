package eg.gov.iti.juicemagic.ui.menue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import eg.gov.iti.juicemagic.databinding.FragmentMenueBinding;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.pojo.ParentCategoryModel;

public class MenueFragment extends Fragment {

    private MenueViewModel mViewModel;
    private FragmentMenueBinding binding;
    JuiceModel juiceModel;

//    public static MenueFragment newInstance() {
//        return new MenueFragment();
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //  return inflater.inflate(R.layout.fragment_menue, container, false);
        binding = FragmentMenueBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel = ViewModelProviders.of(this).get(MenueViewModel.class);
        mViewModel.getMenue();
        MenueDetailsAdapter menueDetailsAdapter = new MenueDetailsAdapter();
        MenueAdapter menueAdapter = new MenueAdapter(getChildFragmentManager());
        MenueDetailsFragment menueDetailsFragment = new MenueDetailsFragment();
        mViewModel.menueMutableliveData.observe(this, new Observer<ParentCategoryModel>() {
            @Override
            public void onChanged(ParentCategoryModel parentCategoryModel) {
                if (parentCategoryModel.getProduct() != null && parentCategoryModel.getProduct().size() != 0) {
                    binding.pager.setAdapter(menueAdapter);
                    binding.menueTab.setupWithViewPager(binding.pager);
                    binding.menueTab.addTab(parentCategoryModel.getProduct());
                    menueAdapter.addTabs(new MyTab("tab1","ede"));

                    //menueAdapter.addTab(new MyTab(parentCategoryModel.getProduct(), MenueDetailsFragment.newInstance()));
                    //  menueAdapter.addTab(new MyTab(parentCategoryModel.getProduct(), menueDetailsFragment));
                    menueAdapter.notifyDataSetChanged();

                }
            }
        });
        binding.menueTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getContext(), "Tab Selected", Toast.LENGTH_SHORT).show();
                binding.pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(getContext(), "Tab unselected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(getContext(), "Tabreselected", Toast.LENGTH_SHORT).show();
            }
        });
        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Toast.makeText(getContext(), "on page scrolled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getContext(), "on page selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Toast.makeText(getContext(), "on page scrolled state changer", Toast.LENGTH_SHORT).show();
            }

        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(MenueViewModel.class);
//        // TODO: Use the ViewModel
//    }

}