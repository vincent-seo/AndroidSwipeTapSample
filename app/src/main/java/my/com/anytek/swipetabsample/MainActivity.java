package my.com.anytek.swipetabsample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    TabLayout swipeTab;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeTab = (TabLayout) findViewById(R.id.swipe_tab);
        pager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        pager.setAdapter(new MyAdapter(fm));

        swipeTab.addTab(swipeTab.newTab().setText("Fragment A"));
        swipeTab.addTab(swipeTab.newTab().setText("Fragment B"));
        swipeTab.addTab(swipeTab.newTab().setText("Fragment C"));

        swipeTab.setOnTabSelectedListener(this);
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        System.out.println("onTabSelected " + tab.getText());
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        System.out.println("onTabUnselected " + tab.getText());
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        System.out.println("onTabReselected " + tab.getText());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        swipeTab.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
