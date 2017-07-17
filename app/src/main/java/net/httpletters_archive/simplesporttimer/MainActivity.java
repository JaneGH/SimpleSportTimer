package net.httpletters_archive.simplesporttimer;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import net.httpletters_archive.simplesporttimer.adapters.TabAdapter;
import net.httpletters_archive.simplesporttimer.dialog.AddingTimerDialogFragment;
import net.httpletters_archive.simplesporttimer.fragments.AllTimerFragment;
import net.httpletters_archive.simplesporttimer.fragments.CurrentTimerFragment;
import net.httpletters_archive.simplesporttimer.fragments.SplashFragment;
import net.httpletters_archive.simplesporttimer.model.ModelTimer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AddingTimerDialogFragment.AddingTaskListener, CurrentTimerFragment.OnTaskDoneListener {

    FragmentManager fragmentManager;
    private PreferenceHelper preferenceHelper;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    android.support.design.widget.TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab_ftn;
    private TabAdapter mTabAdapter;
    private CurrentTimerFragment currentTimerFragment;
    private AllTimerFragment allTimerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        PreferenceHelper.getInstance().init(getApplicationContext());
        preferenceHelper = PreferenceHelper.getInstance();

        fragmentManager = getSupportFragmentManager();
        runSplash();
        setUI();
    }

    public void runSplash() {
       if (!preferenceHelper.getBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE)) {
           SplashFragment splashFragment = new SplashFragment();
           fragmentManager.beginTransaction().replace(R.id.coordinator, splashFragment).addToBackStack(null).commit();
       }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem splashItem = menu.findItem(R.id.action_splash);
        splashItem.setChecked(preferenceHelper.getBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.action_splash){
            item.setChecked(!item.isChecked());
            preferenceHelper.putBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE,item.isChecked());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUI() {
//        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.current));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.all));

        mTabAdapter = new TabAdapter(fragmentManager, 2);
        viewPager.setAdapter(mTabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        currentTimerFragment = (CurrentTimerFragment) mTabAdapter.getItem(TabAdapter.CURRENT_TASK_TIMER_POSITION);
    }

    @OnClick(R.id.fab)
    void fabOnClick(View view) {
        DialogFragment addingTimerDialogFragment = new AddingTimerDialogFragment();
        addingTimerDialogFragment.show(getFragmentManager(), AddingTimerDialogFragment.TAG);
    }

    @Override
    public void onTaskAdded(ModelTimer newTimer) {
        Toast.makeText(this,"add task", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTaskCancel() {
        Toast.makeText(this,"cancel task", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTaskDone(ModelTimer task) {
       // doneTaskFragment.addTask(task);
    }
}
