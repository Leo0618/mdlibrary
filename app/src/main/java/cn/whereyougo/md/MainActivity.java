package cn.whereyougo.md;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import cn.whereyougo.mdlibrary.widget.SnackBar;


public class MainActivity extends AppCompatActivity {

    private Activity mActivity;
    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;

        //titleBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        ab.setDisplayHomeAsUpEnabled(true);

        //menu
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv_main_navigation);
        navigationView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //main content
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager();

    }

    private NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();
            Intent intent = new Intent(mActivity, InfoActivity.class);
            switch (menuItem.getItemId()) {
                case R.id.menu_a:
                    intent.putExtra("title", "GitHub-Leo");
                    intent.putExtra("url", "https://github.com/Leo0618");
                    break;
                case R.id.menu_b:
                    intent.putExtra("title", "Blog-Leo");
                    intent.putExtra("url", "http://blog.csdn.net/lzj922718?viewmode=list");
                    break;
            }
            startActivity(intent);
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabsFromPagerAdapter(fragmentPagerAdapter);
    }

    public SnackBar getSnackBar() {
        return (SnackBar) findViewById(R.id.main_sn);
    }

}
