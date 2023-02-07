package com.example.vigilantapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bn_client_bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.id_home);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, blankFragment).commit();

        }
    }

    ClientHomeFragment blankFragment = new ClientHomeFragment();
    ClientNotificationFragment blankFragment2 = new ClientNotificationFragment();
    ClientProfileViewFragment blankFragment3 = new ClientProfileViewFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, blankFragment).commit();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_main_fragment, blankFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                return true;


            case R.id.id_notification:

                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.fl_main_fragment, blankFragment2);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                return true;

            case R.id.id_account:

                FragmentManager fragmentManager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(R.id.fl_main_fragment, blankFragment3);
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount == 0) {
            AlertDialog.Builder obj = new AlertDialog.Builder(MainActivity.this);
            obj.setMessage("DO YOU WANT TO EXIT?");
            obj.setTitle("alert!");
            obj.setCancelable(false);
            obj.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finishAffinity();
                }
            });
            obj.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }
            );
            AlertDialog alertDialog = obj.create();
            alertDialog.show();
        }
    }
}

//    BottomNavigationView bottomNavigationView;
//
//    ClientHomeFragment clientHomeFragment = new ClientHomeFragment();
//    ClientNotificationFragment clientNotificationFragment = new ClientNotificationFragment();
//    ClientProfileViewFragment clientProfileViewFragment = new ClientProfileViewFragment();
//    FragmentManager fragmentManager = getSupportFragmentManager();
//    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//    FragmentManager fragmentManagerNotification = getSupportFragmentManager();
//    FragmentTransaction fragmentTransactionNotification = fragmentManagerNotification.beginTransaction();
//    FragmentManager fragmentManagerAccount = getSupportFragmentManager();
//    FragmentTransaction fragmentTransactionAccount = fragmentManagerAccount.beginTransaction();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        bottomNavigationView = findViewById(R.id.bn_client_bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
//        bottomNavigationView.setSelectedItemId(R.id.id_home);
//
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).commit();
//
//        }
//    }
//
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.id_home:
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment);
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).addToBackStack("null");
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).commit();
//
//
//                fragmentTransaction.replace(R.id.fl_main_fragment, clientHomeFragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//                return true;
//
//            case R.id.id_notification:
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment);
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).addToBackStack("null");
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientHomeFragment).commit();
//
//                fragmentTransactionNotification.replace(R.id.fl_main_fragment, clientNotificationFragment);
//                fragmentTransactionNotification.addToBackStack(null);
//                fragmentTransactionNotification.commit();
//                return true;
//
//            case R.id.id_account:
////                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_fragment, clientProfileViewFragment).commit();
//
//                fragmentTransactionAccount.replace(R.id.fl_main_fragment, clientProfileViewFragment);
//                fragmentTransactionAccount.addToBackStack(null);
//                fragmentTransactionAccount.commit();
//                return true;
//        }
//        return false;
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//    }
