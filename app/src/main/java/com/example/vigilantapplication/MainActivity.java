package com.example.vigilantapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    ClientHomeFragment clientHomeFragment = new ClientHomeFragment();
    ClientNotificationFragment clientNotificationFragment = new ClientNotificationFragment();
    ClientProfileViewFragment clientProfileViewFragment = new ClientProfileViewFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bn_client_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.id_home);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).commit();

        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.id_home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).addToBackStack("null");
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).commit();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_main_fragment, clientHomeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                return true;

            case R.id.id_notification:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).addToBackStack("null");
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).commit();

                FragmentManager fragmentManagerNotification = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionNotification = fragmentManagerNotification.beginTransaction();
                fragmentTransactionNotification.replace(R.id.fl_main_fragment, clientNotificationFragment);
                fragmentTransactionNotification.addToBackStack(null);
                fragmentTransactionNotification.commit();
                return true;

            case R.id.id_account:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientProfileViewFragment).commit();

                FragmentManager fragmentManagerAccount = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionAccount = fragmentManagerAccount.beginTransaction();
                fragmentTransactionAccount.replace(R.id.fl_main_fragment, clientProfileViewFragment);
                fragmentTransactionAccount.addToBackStack(null);
                fragmentTransactionAccount.commit();
                return true;
        }
        return false;

    }

}