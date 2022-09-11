package eg.gov.iti.juicemagic.ui.menue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;

public class MenueFragment extends Fragment {

    private MenueViewModel mViewModel;
    private FragmentMenueBinding binding;
    JuiceModel juiceModel;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ParentCategoryModel parentCategoryModel;
    private SubCategoryModel subCategoryModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentMenueBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel = ViewModelProviders.of(this).get(MenueViewModel.class);
        mViewModel.getMenue();
        initView();
        return root;
    }


    public void initView() {
        binding.pager.setOffscreenPageLimit(5);

        binding.pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.menueTab));
        binding.menueTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setDynamicfragmentTotabLayout();
    }

    private void setDynamicfragmentTotabLayout() {
        mViewModel.menueMutableliveData.observe(this, new Observer<ParentCategoryModel>() {
            @Override
            public void onChanged(ParentCategoryModel parentCategoryModel) {
                if (parentCategoryModel.getProduct() != null && parentCategoryModel.getProduct().size() != 0) {
                    String parentCategoryId = "";

                    MenueAdapter menueAdapter = new MenueAdapter(getChildFragmentManager());
                    int count = parentCategoryModel.getProduct().size();
                    for (int i = 0; i < count; i++) {
                        MenueDetailsFragment menueDetailsFragment = new MenueDetailsFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("parentCategoryId", parentCategoryModel.getProduct().get(i).getParent_category_id());
                        menueDetailsFragment.setArguments(bundle);
                        binding.menueTab.addTab(binding.menueTab.newTab().setText(parentCategoryModel.getProduct().get(i).getParent_category_name()));
                        menueAdapter.addFrag(menueDetailsFragment, parentCategoryModel.getProduct().get(i).getParent_category_name());
                    }


                    binding.pager.setAdapter(menueAdapter);
                    binding.pager.setCurrentItem(0);

                }
            }
        });
    }

}
