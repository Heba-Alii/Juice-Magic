package eg.gov.iti.juicemagic.ui.CartDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
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
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Users" , Context.MODE_PRIVATE);
        String clientId = sharedPreferences.getString("clientId", "");
        cartDetailsViewModel.getCart(clientId);
//        LinearLayoutManager addition = new LinearLayoutManager(requireActivity());
//        addition.setOrientation(LinearLayoutManager.VERTICAL);
//        binding.userAdditionRv.setLayoutManager(addition);
//        LinearLayoutManager remove = new LinearLayoutManager(requireActivity());
//        remove.setOrientation(LinearLayoutManager.VERTICAL);
//        binding.userRemoveRv.setLayoutManager(remove);
        LinearLayoutManager addCart = new LinearLayoutManager(requireActivity());
        addCart.setOrientation(LinearLayoutManager.VERTICAL);
        binding.addtocartItemsRv.setLayoutManager(addCart);
//        AdditionCartAdapter additionCartAdapter = new AdditionCartAdapter();
//        binding.userAdditionRv.setAdapter(additionCartAdapter);
//        RemoveCartAdapter removeCartAdapter = new RemoveCartAdapter();
//        binding.userRemoveRv.setAdapter(removeCartAdapter);
        AddCartAdapter addCartAdapter = new AddCartAdapter();
        binding.addtocartItemsRv.setAdapter(addCartAdapter);
        cartDetailsViewModel.cartDetailsMutableLiveDat.observe(this, new Observer<GetCart_Model>() {
            @Override
            public void onChanged(GetCart_Model getCart_model) {
                if (getCart_model.getProduct() != null && getCart_model.getProduct().size() != 0) {
                    addCartAdapter.setList(getCart_model.getProduct());
                    int count = getCart_model.getCount_all();
                    binding.subToatlPrice.setText(getCart_model.getProduct().get(count).getTotal_amount());
                    binding.vatPrice.setText(getCart_model.getProduct().get(count).getVat_value());
                    binding.netTotalPrice.setText(getCart_model.getProduct().get(count).getSummary());
                    //additionCartAdapter.setList(getCart_model.getProduct());
                    // removeCartAdapter.setList(getCart_model.getProduct());

                    Log.e("TAG", "onChanged: CartDeatails" + getCart_model.getProduct());
                    // }
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