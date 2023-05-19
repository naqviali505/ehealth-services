package com.example.cutsomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
{
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.ManageProfile:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(MainActivity.this, Manage_Profile_Patient.class);
                        startActivity(intent1);
                        break;

                    case R.id.Appointment:
                        drawerLayout.closeDrawer(GravityCompat.START);

                        Intent intent2 = new Intent(MainActivity.this, Make_Appointment_Patient.class);
                        startActivity(intent2);
                        break;

                    case R.id.Make_cancel_Appointment:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent3 = new Intent(MainActivity.this, Update_Appointment_Patient.class);
                        startActivity(intent3);
                        break;

                    case R.id.view_p_details:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent6 = new Intent(MainActivity.this, view_Prescription_detail_patient.class);
                        startActivity(intent6);
                        break;

                    case R.id.Doctor_list:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent4 = new Intent(MainActivity.this, View_Doctor_Patient.class);
                        startActivity(intent4);
                        break;

                    case R.id.chat:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent5 = new Intent(MainActivity.this, Chat_Patient.class);
                        startActivity(intent5);
                        break;
                }

                return true;
            }
        });
    }
}
