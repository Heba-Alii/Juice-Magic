package eg.gov.iti.juicemagic.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentLoginBinding;

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
                final Boolean isLoggedIn = sharedPreferences.getBoolean("is Logged in", false);
                final String suMobmob = sharedPreferences.getString("mobile", "DEFAULT_NUMBER");
                final String suPass = sharedPreferences.getString("password", "DEFAULT_PASSWORD");
                String mob = binding.loginMobileTV.getText().toString();
                String pass = binding.loginPassTV.getText().toString();
                if (mob.equals(suMobmob) && pass.equals(suPass)) {
                    sharedPreferences.edit().putBoolean("is Logged in", false).apply();
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