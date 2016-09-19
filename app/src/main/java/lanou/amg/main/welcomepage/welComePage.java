package lanou.amg.main.welcomepage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;

import lanou.amg.R;
import lanou.amg.main.advert.AdvertActivity;

public class welComePage extends FragmentActivity {

    private ViewPager viewPager_WelComePage;
    private Adapter_ViewPager_WelComePage adapter_viewPager_welComePage;
    private SharedPreferences.Editor savedInstanceState_edit;
    private welComePage_BroadcastReceiver welComePage_broadcastReceiver = new welComePage_BroadcastReceiver();
    private IntentFilter intentFilter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("welcomepage_welComePage",MODE_PRIVATE);
        savedInstanceState_edit = sharedPreferences.edit();
        savedInstanceState_edit.commit();

        Boolean first = sharedPreferences.getBoolean("first",false);


        if(first){
            Intent intent = new Intent(welComePage.this, AdvertActivity.class);
            startActivity(intent);
            finish();
        }
        intentFilter.addAction("MainActivity.finsh");
        registerReceiver(welComePage_broadcastReceiver, intentFilter);

        setContentView(R.layout.welcomepage);

        viewPager_WelComePage = (ViewPager) findViewById(R.id.viewPager_WelComePage);

        adapter_viewPager_welComePage = new Adapter_ViewPager_WelComePage(getSupportFragmentManager());

        ArrayList<Fragment> arrayList = new ArrayList<>();

        arrayList.add(new Fragment_One());
        arrayList.add(new Fragment_Two());
        arrayList.add(new Fragment_Three());
        arrayList.add(new Fragment_Four());

        adapter_viewPager_welComePage.setArrayList(arrayList);

        viewPager_WelComePage.setAdapter(adapter_viewPager_welComePage);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(welComePage_broadcastReceiver);
    }
    class welComePage_BroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("GuidePageActivity_Broad", "走了");
            finish();
        }
    }
}
