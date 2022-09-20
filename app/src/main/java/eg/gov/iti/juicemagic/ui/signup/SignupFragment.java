package eg.gov.iti.juicemagic.ui.signup;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.navigation.NavigationView;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentSignupBinding;
import eg.gov.iti.juicemagic.pojo.AuthModel;
import eg.gov.iti.juicemagic.pojo.UsersModel;
import eg.gov.iti.juicemagic.ui.home.HomeFragment;
import eg.gov.iti.juicemagic.ui.login.LoginFragment;

public class SignupFragment extends Fragment {

    private FragmentSignupBinding binding;
    NavigationView navigationView;
    SignupViewModel signupViewModel;
    FragmentManager fragmentManager;
    public static SharedPreferences sharedPreferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        //signupViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        signupViewModel = ViewModelProviders.of(this).get(SignupViewModel.class);
        //signup_btn_click
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.mobileTV == null || binding.mobileTV.length() != 11) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Enter Valid Mobile Number", Toast.LENGTH_SHORT).show();
                } else if (binding.passTV == null || binding.passTV.length() < 6) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Enter 6 or more letters in your password ", Toast.LENGTH_SHORT).show();

                } else if (binding.confirmPassTV == null || !binding.confirmPassTV.getText().toString().equals(binding.passTV.getText().toString())) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter same password", Toast.LENGTH_SHORT).show();

                } else if (binding.emailTV == null || !binding.emailTV.getText().toString().matches(emailPattern)) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter valid mail", Toast.LENGTH_SHORT).show();

                } else {
                    UsersModel usersModel = new UsersModel("heba", binding.mobileTV.getText().toString(), binding.passTV.getText().toString(), binding.emailTV.getText().toString(), "asbcd", "en", "Android");
                    signupViewModel.postUsers(usersModel);
                }
            }
        });
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, new LoginFragment()).commit();

            }
        });
        signupViewModel.usersModelMutableLiveData.observe(this, new Observer<AuthModel>() {
            @Override
            public void onChanged(AuthModel authModel) {
                if (authModel.getSuccess() == 1) {
                    sharedPreferences = requireContext().getSharedPreferences("Users", Context.MODE_PRIVATE);
                    SharedPreferences.Editor info = sharedPreferences.edit();
                    info.putString("mobile", authModel.getProduct().get(0).getClient_phone());
                    info.putString("password", authModel.getProduct().get(0).getClient_password());
                    info.putString("confirm_pass", authModel.getProduct().get(0).getClient_password());
                    info.putString("email", authModel.getProduct().get(0).getClient_email());
                    info.putString("clientId", authModel.getProduct().get(0).getClient_id());
                    info.commit();
                    Log.e("TAG", "onChanged: not nav" + authModel.getMessage());

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, new HomeFragment()).commit();

                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "this user already register", Toast.LENGTH_SHORT).show();
                }
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