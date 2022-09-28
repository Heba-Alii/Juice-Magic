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
import androidx.recyclerview.widget.LinearLayoutManager;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentCardMenueDetailsBinding;
import eg.gov.iti.juicemagic.pojo.AddCart_Model;
import eg.gov.iti.juicemagic.pojo.Additions_Model;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.pojo.Remove_Response;
import eg.gov.iti.juicemagic.pojo.ResponseCart_Model;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;
import eg.gov.iti.juicemagic.ui.JuiceViewModel;
import eg.gov.iti.juicemagic.ui.SideMenue;
import eg.gov.iti.juicemagic.ui.menue.MenueDetailsAdapter;
import eg.gov.iti.juicemagic.ui.menue.MenueViewModel;

public class CardMenueDetails extends Fragment {

    private CardMenueDetailsViewModel mViewModel;
    private FragmentCardMenueDetailsBinding binding;
    SideMenue sideMenue;
    String addition_id = "";
    String remove_id = "";


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
        //linear layout RecyclerView
        LinearLayoutManager addition = new LinearLayoutManager(requireActivity());
        LinearLayoutManager remove = new LinearLayoutManager(requireActivity());
        addition.setOrientation(LinearLayoutManager.VERTICAL);
        remove.setOrientation(LinearLayoutManager.VERTICAL);
        binding.additionRecyclerView.setLayoutManager(addition);
        binding.withoutRecyclerView.setLayoutManager(remove);
        //Add to cart Adapters
        AdditionAdapter additionAdapter = new AdditionAdapter(this);
        RemoveAdapter removeAdapter = new RemoveAdapter(this);
        // MenueDetailsAdapter menueDetailsAdapter=new MenueDetailsAdapter(this);
        //My Adapters
        binding.withoutRecyclerView.setAdapter(removeAdapter);
        binding.additionRecyclerView.setAdapter(additionAdapter);
        String id = getArguments().getString("subCategoryId");
        String sizeId = getArguments().getString("sizeId");

        mViewModel.getItemDetails(id);
        mViewModel.getAddition(id);
        mViewModel.getRemoves(id);
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
        //increament button
        binding.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = binding.quantityTxt.getText().toString();
                int count = Integer.parseInt(number);
                count++;
                binding.quantityTxt.setText(String.valueOf(count));

            }
        });
        //decrement Button
        binding.decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = binding.quantityTxt.getText().toString();
                int count = Integer.parseInt(number);
                if (count > 1) {
                    count--;
                    binding.quantityTxt.setText(String.valueOf(count));
                } else {
                    Toast.makeText(getContext(), "Minimum quantity is ONE", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //add to cart button
        binding.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCart_Model addCartModel = new AddCart_Model("en", "1", binding.quantityTxt.getText().toString(), sizeId, id, addition_id, remove_id, binding.addNoteET.getText().toString());
                mViewModel.addToCart(addCartModel);

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
        //addition Api
        mViewModel.additionMutableLiveData.observe(this, new Observer<Additions_Model>() {
            @Override
            public void onChanged(Additions_Model additions_model) {
                if (additions_model.getProduct() != null && additions_model.getProduct().size() != 0) {
                    additionAdapter.setList(additions_model.getProduct());
                    Log.e("TAG", "onChanged: onchange " + additions_model.getProduct());

                } else {
                    Log.e("TAG", "onChanged: on change size" + additions_model.getProduct().size());
                    binding.additionText.setVisibility(View.GONE);
                    binding.arrowBtn.setVisibility(View.GONE);
                    binding.textView4.setVisibility(View.GONE);
                }
            }
        });
        //Remove Api
        mViewModel.removeResponseMutableLiveData.observe(this, new Observer<Remove_Response>() {
            @Override
            public void onChanged(Remove_Response remove_response) {
                if (remove_response.getProduct() != null && remove_response.getProduct().size() != 0) {
                    removeAdapter.setList(remove_response.getProduct());
                } else {
                    binding.withoutTxt.setVisibility(View.GONE);
                    binding.arrowBtn2.setVisibility(View.GONE);
                    binding.textView5.setVisibility(View.GONE);
                }

            }
        });
        mViewModel.responseCart_modelMutableLiveData.observe(this, new Observer<ResponseCart_Model>() {
            @Override
            public void onChanged(ResponseCart_Model responseCart_model) {
                if (responseCart_model.getSuccess() == 1) {
                    Toast.makeText(getContext(), "Your Data" + responseCart_model.getMessage(), Toast.LENGTH_SHORT).show();

                } else {
                    Log.e("TAG", "onChanged: add to cart failed on change" + responseCart_model.getMessage());
                }
            }
        });
        return root;
    }

    //Add addition To Cart
    public void addditionAdapter(String addition_id) {
        this.addition_id = addition_id;
        Log.e("TAG", "addditionAdapter: addition_id is" + addition_id);

    }

    //Add remove to cart
    public void removeAdapter(String remove_id) {
        this.remove_id = remove_id;
        Log.e("TAG", "removeAdapter:remove id " + remove_id);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CardMenueDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}