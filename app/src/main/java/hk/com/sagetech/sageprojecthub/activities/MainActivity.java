package hk.com.sagetech.sageprojecthub.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import hk.com.sagetech.sageprojecthub.fragments.BoardFragment;
import hk.com.sagetech.sageprojecthub.fragments.HomeFragment;
import hk.com.sagetech.sageprojecthub.fragments.NotificationFragment;
import hk.com.sagetech.sageprojecthub.fragments.ProjectsFragment;
import hk.com.sagetech.sageprojecthub.utils.BottomNavigationViewHelper;
import hk.com.sagetech.sageprojecthub.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentMgr = getSupportFragmentManager();
            FragmentTransaction fragmentTx = fragmentMgr.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTx.replace(R.id.content,new HomeFragment()).commit();
                    return true;
                case R.id.navigation_projects:
                    fragmentTx.replace(R.id.content,new ProjectsFragment()).commit();
                    return true;
                case R.id.navigation_board:
                    fragmentTx.replace(R.id.content,new BoardFragment()).commit();
                    return true;
                case R.id.navigation_notification:
                    fragmentTx.replace(R.id.content,new NotificationFragment()).commit();
                    return true;
                default:
                    return false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
