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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.FragmentSignupBinding;
import eg.gov.iti.juicemagic.pojo.AuthModel;
import eg.gov.iti.juicemagic.pojo.UsersModel;

public class SignupFragment extends Fragment {

    private FragmentSignupBinding binding;
    SignupViewModel signupViewModel;
    SharedPreferences sharedPreferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        signupViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
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
        signupViewModel.usersModelMutableLiveData.observe(this, new Observer<AuthModel>() {
            @Override
            public void onChanged(AuthModel authModel) {
                if (authModel.getSuccess() == 1) {
                    sharedPreferences = getActivity().getSharedPreferences("Users", Context.MODE_PRIVATE);
                    SharedPreferences.Editor info = sharedPreferences.edit();
                    info.putString("Mobile Number", binding.mobileTV.getText().toString());
                    info.putString("Password", binding.passTV.getText().toString());
                    info.putString("Confirm Password", binding.confirmPassTV.getText().toString());
                    info.putString("Email", binding.emailTV.getText().toString());
                    info.commit();
                    Log.e("TAG", "onChanged: sucess" + authModel.getMessage());
                    Navigation.findNavController(container).navigate(R.id.action_nav_signup_to_nav_home);
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