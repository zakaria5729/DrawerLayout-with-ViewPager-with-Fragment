package zakaria.hossain.com.supervisorsolution.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import zakaria.hossain.com.supervisorsolution.R;
import zakaria.hossain.com.supervisorsolution.adapters.ViewPagerAdapter;
import zakaria.hossain.com.supervisorsolution.fragments.MyFragment1;
import zakaria.hossain.com.supervisorsolution.fragments.MyFragment2;
import zakaria.hossain.com.supervisorsolution.fragments.MyFragment3;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);

        setDrawableToggle();
        setNavigationView();
        setViewPagerAdapter();
    }

    private void setDrawableToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_camera:
                        menuItem.setChecked(true);
                        displayMessage("select nav 1");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_gallery:
                        menuItem.setChecked(true);
                        displayMessage("select nav 2");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_slideshow:
                        return true;

                    case R.id.nav_manage:
                        return true;

                    case R.id.nav_share:
                        return true;

                    case R.id.nav_send:
                        return true;
                }

                return false;
            }
        });
    }

    private void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void setViewPagerAdapter() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new MyFragment1(), "My Fragment 1");
        viewPagerAdapter.addFragment(new MyFragment2(), "My Fragment 2");
        viewPagerAdapter.addFragment(new MyFragment3(), "My Fragment 3");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
