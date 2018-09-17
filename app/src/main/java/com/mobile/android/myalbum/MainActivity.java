package com.mobile.android.myalbum;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mobile.android.myalbum.ui.album.AlbumFragment;
import com.mobile.android.myalbum.ui.post.PostFragment;
import com.mobile.android.myalbum.ui.user.UserFragment;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_navigation);
        changeFragment(new AlbumFragment());
        setupBottomNav();
    }

    private void changeFragment(Fragment newFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, newFragment);
        fragmentTransaction.commit();
    }

    private void setupBottomNav() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_albums:
                        changeFragment(new AlbumFragment());
                        break;
                    case R.id.navigation_users:
                        changeFragment(new UserFragment());
                        break;
                    case R.id.navigation_posts:
                        changeFragment(new PostFragment());
                        break;
                }
                return true;
            }
        });
    }
}
