package eg.gov.iti.juicemagic.ui.details;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eg.gov.iti.juicemagic.R;

public class CardMenueDetails extends Fragment {

    private CardMenueDetailsViewModel mViewModel;

    public static CardMenueDetails newInstance() {
        return new CardMenueDetails();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card_menue_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CardMenueDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}