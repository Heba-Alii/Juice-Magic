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

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentLoginBinding;
import eg.gov.iti.juicemagic.ui.home.HomeFragment;
import eg.gov.iti.juicemagic.ui.signup.SignupFragment;

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
//                    HomeFragment fragment2 = new HomeFragment();
//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.nav_host_fragment_content_side_menue, fragment2);
//                    fragmentTransaction.commit();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, new HomeFragment()).commit();

                } else {
                    Toast.makeText(getContext(), "User not found please Register", Toast.LENGTH_SHORT).show();
                }

            }

        });
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SignupFragment fragment2 = new SignupFragment();
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.nav_host_fragment_content_side_menue, fragment2);
//                fragmentTransaction.commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, new SignupFragment()).commit();

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