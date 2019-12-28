package com.hungphan2001.chuctet2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.hungphan2001.chuctet2020.data.MenuItem;
import com.hungphan2001.chuctet2020.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Global Declaration
    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Lời Chúc",R.drawable.chuc));
        menuItems.add(new MenuItem("Hot",R.drawable.hot));
        menuItems.add(new MenuItem("Gia Đình",R.drawable.family));
        menuItems.add(new MenuItem("SMS Cute",R.drawable.sms));
        menuItems.add(new MenuItem("Bạn Bè",R.drawable.friend));
        menuItems.add(new MenuItem("Đồng Nghiệp",R.drawable.collegue));
        menuItems.add(new MenuItem("Thầy Cô",R.drawable.teacher));
        menuItems.add(new MenuItem("Tiếng Anh",R.drawable.english));
        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass =  LoiChucFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();
        }


        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                switch (position){
                    case 0:{
                        fragmentClass = LoiChucFragment.class;
                        break;
                    }
                    case 1:{
                        fragmentClass = HotFragment.class;
                        break;
                    }
                    case 2:{
                        fragmentClass = FamilyFragment.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = SMSCuteFragment.class;
                        break;
                    }
                    case 4:{
                        fragmentClass = FriendsFragment.class;
                        break;
                    }
                    case 5:{
                        fragmentClass = ColleagueFragment.class;
                        break;
                    }
                    case 6:{
                        fragmentClass = TeacherFragment.class;
                        break;
                    }
                    case 7:{
                        fragmentClass = EnglishFragment.class;
                        break;
                    }

                }
                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening(){

                    }

                    @Override
                    public void onDrawerClosing(){
                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                    }
                });
            }
        });

    }
}