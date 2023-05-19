package com.example.cutsomnavigation;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Slide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;

public class Activity_main_Admin extends AppCompatActivity
{
    NavigationView nav2;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        nav2=(NavigationView)findViewById(R.id.navmenu_admin);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.Overview:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(Activity_main_Admin.this, Overview_admin.class);
                        startActivity(intent1);
                        break;

                    case R.id.Manage_Doctor_admin:

                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2 = new Intent(Activity_main_Admin.this, Manage_Doctor_Admin.class);
                        startActivity(intent2);
                        break;


                    case R.id.Manage_Patient_admin:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent3 = new Intent(Activity_main_Admin.this, Manage_Patient_Admin.class);
                        startActivity(intent3);
                        break;

                    case R.id.Chat_admin:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent4 = new Intent(Activity_main_Admin.this, chat_admin.class);
                        startActivity(intent4);
                        break;
                }

                return true;
            }
        });

    }

}
