package eg.gov.iti.juicemagic.ui.CartDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentCartDetailsBinding;
import eg.gov.iti.juicemagic.pojo.GetCart_Model;
import eg.gov.iti.juicemagic.ui.details.CardMenueDetails;

public class CartDetailsFragment extends Fragment {

    private CartDetailsViewModel cartDetailsViewModel;
    private FragmentCartDetailsBinding binding;


    public static CartDetailsFragment newInstance() {
        return new CartDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCartDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //to hide action bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        cartDetailsViewModel = ViewModelProviders.of(this).get(CartDetailsViewModel.class);
        CardMenueDetails cardMenueDetails = new CardMenueDetails();
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_cart_to_nav_home);
            }
        });
        cartDetailsViewModel.getCart();
        LinearLayoutManager addition = new LinearLayoutManager(requireActivity());
        addition.setOrientation(LinearLayoutManager.VERTICAL);
        binding.userAdditionRv.setLayoutManager(addition);
        LinearLayoutManager remove = new LinearLayoutManager(requireActivity());
        remove.setOrientation(LinearLayoutManager.VERTICAL);
        binding.userRemoveRv.setLayoutManager(remove);
        AdditionCartAdapter additionCartAdapter = new AdditionCartAdapter();
        binding.userAdditionRv.setAdapter(additionCartAdapter);
        RemoveCartAdapter removeCartAdapter = new RemoveCartAdapter();
        binding.userRemoveRv.setAdapter(removeCartAdapter);
        cartDetailsViewModel.cartDetailsMutableLiveDat.observe(this, new Observer<GetCart_Model>() {
            @Override
            public void onChanged(GetCart_Model getCart_model) {
                if (getCart_model.getProduct() != null && getCart_model.getProduct().size() != 0) {
                    int count = getCart_model.getCount_all();
                    for (int i = 0; i < count; i++) {
                        binding.juiceName.setText(getCart_model.getProduct().get(i).getSub_category_name());
                        Glide.with(binding.juiceImage)
                                .load(getCart_model.getProduct().get(i).getSub_category_image())
                                .fitCenter()
                                .into(binding.juiceImage);
                        binding.juicePrice.setText(getCart_model.getProduct().get(i).getPrice() + " " + "DHD");

                        binding.quantityTxt.setText(getCart_model.getProduct().get(i).getQuantity());
                        //additionCartAdapter.setList(getCart_model.getProduct().get(0).getAddition());
                        removeCartAdapter.setList(getCart_model.getProduct());

                        Log.e("TAG", "onChanged: CartDeatails" + getCart_model.getProduct());
                    }
                } else {
                    Toast.makeText(getContext(), "not Addition added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

}