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

import eg.gov.iti.juicemagic.databinding.FragmentMenueDetailsBinding;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;

public class MenueDetailsFragment extends Fragment {
    FragmentMenueDetailsBinding binding;
    private MenueDetailsViewModel mViewModel;

    public static MenueDetailsFragment newInstance() {
        return new MenueDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMenueDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel = ViewModelProviders.of(this).get(MenueDetailsViewModel.class);

        mViewModel.getSubCategory();
        //MenueAdapter menueAdapter = new MenueAdapter(getActivity().getSupportFragmentManager());
        MenueDetailsAdapter menueDetailsAdapter=new MenueDetailsAdapter();
        binding.menueRecycler.setAdapter(menueDetailsAdapter);

        mViewModel.menueDetailsMutableLiveData.observe(this, new Observer<SubCategoryModel>() {
            @Override
            public void onChanged(SubCategoryModel subCategoryModel) {
                if (subCategoryModel.getProduct() != null && subCategoryModel.getProduct().size() != 0) {
                    menueDetailsAdapter.setList(subCategoryModel.getProduct());
                }
            }
        });
        return root;
    }

}