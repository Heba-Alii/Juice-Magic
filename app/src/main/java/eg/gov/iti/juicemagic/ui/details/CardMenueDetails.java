package eg.gov.iti.juicemagic.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentCardMenueDetailsBinding;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;
import eg.gov.iti.juicemagic.ui.JuiceViewModel;
import eg.gov.iti.juicemagic.ui.SideMenue;

public class CardMenueDetails extends Fragment {

    private CardMenueDetailsViewModel mViewModel;
    private FragmentCardMenueDetailsBinding binding;
    SideMenue sideMenue;

    public static CardMenueDetails newInstance() {
        return new CardMenueDetails();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCardMenueDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //to hide toolbar in this fragment
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        mViewModel = ViewModelProviders.of(this).get(CardMenueDetailsViewModel.class);
        String id = getArguments().getString("subCategoryId");
        mViewModel.getItemDetails(id);
        //ratingBar
        LayerDrawable stars = (LayerDrawable) binding.itemRating.getProgressDrawable();
        stars.getDrawable(1).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        //Expand Arrow Button Additions
        binding.arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.hiddenView.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(binding.consraintLayout, new AutoTransition());
                    binding.hiddenView.setVisibility(View.GONE);
                    binding.arrowBtn.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24);
                } else {
                    TransitionManager.beginDelayedTransition(binding.consraintLayout, new AutoTransition());
                    binding.hiddenView.setVisibility(View.VISIBLE);
                    binding.arrowBtn.setImageResource(R.drawable.ic_baseline_expand_more_24);

                }
            }
        });
        //Without Expand Arrow Button
        binding.arrowBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.hiddenView2.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(binding.consraintLayout, new AutoTransition());
                    binding.hiddenView2.setVisibility(View.GONE);
                    binding.arrowBtn3.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24);
                } else {
                    TransitionManager.beginDelayedTransition(binding.consraintLayout, new AutoTransition());
                    binding.hiddenView2.setVisibility(View.VISIBLE);
                    binding.arrowBtn3.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }
            }
        });
        //AddNotes Expand Arrow Button
        binding.arrowBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.hiddenWithoutView.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(binding.consraintLayout, new AutoTransition());
                    binding.hiddenWithoutView.setVisibility(View.GONE);
                    binding.arrowBtn2.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24);
                } else {
                    TransitionManager.beginDelayedTransition(binding.consraintLayout, new AutoTransition());
                    binding.hiddenWithoutView.setVisibility(View.VISIBLE);
                    binding.arrowBtn2.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }
            }
        });
        binding.circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_details_to_nav_menue);
            }
        });
        Log.e("TAG", "onCreateView: " + id);
        mViewModel.menueDetailsMutableLiveData.observe(this, new Observer<SubCategoryModel>() {
            @Override
            public void onChanged(SubCategoryModel subCategoryModel) {
                if (subCategoryModel.getProduct() != null && subCategoryModel.getProduct().size() != 0) {
                    Log.e("TAG", "onChanged: success");
                    binding.itemName.setText(subCategoryModel.getProduct().get(0).getSub_category_name());
                    if (subCategoryModel.getProduct().get(0).getSizes().stream().count() != 0) {
                        binding.itemPrice.setText(subCategoryModel.getProduct().get(0).getSizes().get(0).getSub_category_size_price() + " " + "BHD");
                    } else {
                        binding.itemPrice.setText("BHD");
                    }
                    Glide.with(binding.imgItem)
                            .load(subCategoryModel.getProduct().get(0).getSub_category_image()).placeholder(R.drawable.logo)
                            .fitCenter()
                            .into(binding.imgItem);
                    binding.itemRating.setRating(subCategoryModel.getProduct().get(0).getEvaluate());
                    // binding.itemRating.setRating(3);
                }
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CardMenueDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}