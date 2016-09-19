package lanou.amg.main.guidepage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Button;

import lanou.amg.R;

public class GuidePageActivity extends FragmentActivity {

    private Button btn_GuidePageActivity;
    private GuidePageActivity_BroadcastReceiver guidePageActivity_broadcastReceiver = new GuidePageActivity_BroadcastReceiver();
    private IntentFilter intentFilter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
        intentFilter.addAction("GuidePagerActivity.finsh");
        registerReceiver(guidePageActivity_broadcastReceiver, intentFilter);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_GuidePageActivity,new GuidePager_Fagment_One());
        fragmentTransaction.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(guidePageActivity_broadcastReceiver);
    }

    class GuidePageActivity_BroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("GuidePageActivity_Broad", "走了");
            finish();
        }
    }
}
