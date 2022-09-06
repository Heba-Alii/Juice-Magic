package eg.gov.iti.juicemagic.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import eg.gov.iti.juicemagic.R;
import eg.gov.iti.juicemagic.databinding.ActivitySideMenueBinding;
import eg.gov.iti.juicemagic.pojo.AuthModel;
import eg.gov.iti.juicemagic.pojo.UsersModel;
import eg.gov.iti.juicemagic.ui.home.HomeFragment;
import eg.gov.iti.juicemagic.ui.login.LoginFragment;
import eg.gov.iti.juicemagic.ui.signup.SignupFragment;

public class SideMenue extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivitySideMenueBinding binding;

    NavigationView navigationView;
    NavController navController;
    DrawerLayout drawer;
    AuthModel authModel;
    UsersModel usersModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySideMenueBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // setSupportActionBar(binding.tool);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Home");
        drawer = binding.drawerLayout;
        navigationView = binding.navView;


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_login, R.id.nav_signup, R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        Log.e("TAG", "onCreate: on create");

        //NavController navController=Navigation.findNavController(this,R.id.nav_host_fragment_content_side_menue);
        //NavigationUI.setupActionBarWithNavController(this,navController,mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView,navController);

        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {

                View header = navigationView.getHeaderView(0);
                TextView userMail = (TextView) header.findViewById(R.id.user_email_tv);
                TextView userMobile = (TextView) header.findViewById(R.id.user_mobile_tv);
                SharedPreferences sharedPreferences = getSharedPreferences("Users", MODE_PRIVATE);
                String suMobmob = sharedPreferences.getString("mobile", "");
                String suEmail = sharedPreferences.getString("email", "");
                String suPass = sharedPreferences.getString("password", "");
                invalidateOptionsMenu();
                userMail.setText("Mobile Number :" + suMobmob);
                userMobile.setText("Password :" + suPass);
                if (suEmail != "" || suMobmob != "") {
                    navigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_signup).setVisible(false);
                    navigationView.getMenu().findItem(R.id.nav_logout).setVisible(true);
                } else {
                    navigationView.getMenu().findItem(R.id.nav_login).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_signup).setVisible(true);
                    navigationView.getMenu().findItem(R.id.nav_logout).setVisible(false);
                }
            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.side_menue, menu);
        Log.e("TAG", "onchange");

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        Fragment replaceFragment = null;

        switch (item.getItemId()) {
            case R.id.nav_logout:
                logOut();
                return true;
            case R.id.nav_home:
                // getSupportActionBar().setTitle("Home");
                replaceFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, replaceFragment).commit();
                break;
            case R.id.nav_login:

                // getSupportActionBar().setTitle("Login");
                replaceFragment = new LoginFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, replaceFragment).commit();
                break;
            case R.id.nav_signup:
                //    getSupportActionBar().setTitle("Signup");

                replaceFragment = new SignupFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, replaceFragment).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void logOut() {

        drawer.closeDrawer(GravityCompat.START);
        getSharedPreferences("Users", MODE_PRIVATE)
                .edit().clear().commit();
        SharedPreferences sharedPreferences = getSharedPreferences("Users", MODE_PRIVATE);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_side_menue, new HomeFragment()).commit();

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_side_menue);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}