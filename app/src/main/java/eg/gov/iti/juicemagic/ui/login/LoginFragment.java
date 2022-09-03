package eg.gov.iti.juicemagic.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.navigation.NavigationView;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentLoginBinding;
import eg.gov.iti.juicemagic.databinding.NavHeaderSideMenueBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    SharedPreferences sharedPreferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                sharedPreferences = getActivity().getSharedPreferences("Users", Context.MODE_PRIVATE);

                String mob = binding.loginMobileTV.getText().toString();
                String pass = binding.loginPassTV.getText().toString();
                String suphone = sharedPreferences.getString("mobile", "");
                String suEmail = sharedPreferences.getString("email", "");
                String supassword = sharedPreferences.getString("password", "");
                if (mob.equals(suphone) && pass.equals(supassword)) {

                    Navigation.findNavController(container).navigate(R.id.action_nav_login_to_nav_home);



                } else {
                    Toast.makeText(getContext(), "User not found please Register", Toast.LENGTH_SHORT).show();
                }

            }

        });
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(container).navigate(R.id.action_nav_login_to_nav_signup);

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}