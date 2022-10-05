package eg.gov.iti.juicemagic.ui.login;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import java.lang.annotation.Native;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentLoginBinding;
import eg.gov.iti.juicemagic.pojo.AuthModel;
import eg.gov.iti.juicemagic.pojo.UsersModel;
import eg.gov.iti.juicemagic.ui.home.HomeFragment;
import eg.gov.iti.juicemagic.ui.signup.SignupFragment;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    SharedPreferences sharedPreferences;
    LoginViewModel loginViewModel;
    UsersModel usersModel;
    AuthModel authModel;
    SignupFragment signupFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usersModel = new UsersModel("heba", binding.loginMobileTV.getText().toString(), binding.loginPassTV.getText().toString(), "", "asbcd", "en", "Android");
                loginViewModel.getUsers(usersModel);

            }

        });
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, new SignupFragment()).commit();

            }
        });
        loginViewModel.loginMutableLiveData.observe(this, new Observer<AuthModel>() {
            @Override
            public void onChanged(AuthModel authModel) {
                if (authModel.getSuccess()==1) {
                    Log.e("TAG", "onChanged: not user" + authModel.getMessage());

                    //sharedPreferences = getActivity().getSharedPreferences("Users", Context.MODE_PRIVATE);
                    sharedPreferences=requireContext().getSharedPreferences("Users",Context.MODE_APPEND);
                    Log.e("TAG", "onChanged: not user" + authModel.getMessage());

                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("mobile", authModel.getProduct().get(0).getClient_phone());
                    edit.putString("password", authModel.getProduct().get(0).getClient_password());
                    edit.putString("confirm_pass", authModel.getProduct().get(0).getClient_password());
                    edit.putString("email", authModel.getProduct().get(0).getClient_email());
                    edit.putString("clientId", authModel.getProduct().get(0).getClient_id());
                    edit.commit();
                    Log.e("TAG", "onChanged: not user" + authModel.getMessage());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, new HomeFragment()).commit();

                } else {
                    Toast.makeText(getContext(), "user not found", Toast.LENGTH_SHORT).show();
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