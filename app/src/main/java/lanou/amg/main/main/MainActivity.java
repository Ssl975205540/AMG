package lanou.amg.main.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import lanou.amg.R;
import lanou.amg.main.guidepage.GuidePageActivity;

public class MainActivity extends MainActivity_Base implements View.OnClickListener {

    private MainActivity_BroadcastReceiver mainActivity_broadcastReceiver = new MainActivity_BroadcastReceiver();
    private IntentFilter intentFilter = new IntentFilter();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreference_edit;
    private FrameLayout frameLayout_MainActivity;
    private ImageView nav_icon_article,nav_icon_findcar,nav_icon_forum,nav_icon_my,nav_icon_sale;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected  void control() {
        frameLayout_MainActivity = (FrameLayout)findViewById(R.id.frameLayout_MainActivity);

        nav_icon_article = (ImageView) findViewById(R.id.nav_icon_article);
        nav_icon_findcar = (ImageView) findViewById(R.id.nav_icon_findcar);
        nav_icon_forum = (ImageView) findViewById(R.id.nav_icon_forum);
        nav_icon_my = (ImageView) findViewById(R.id.nav_icon_my);
        nav_icon_sale = (ImageView) findViewById(R.id.nav_icon_sale);

        sharedPreferences = getSharedPreferences("main_mainActivity",MODE_PRIVATE);
        sharedPreference_edit = sharedPreferences.edit();
        sharedPreference_edit.commit();
        Boolean first = sharedPreferences.getBoolean("first",false);
        if(first == false){
            Intent intent = new Intent(MainActivity.this, GuidePageActivity.class);
            startActivity(intent);
            sharedPreference_edit.putBoolean("first",true);
            sharedPreference_edit.commit();
        }
        intentFilter.addAction("GuidePagerActivity.finsh");
        registerReceiver(mainActivity_broadcastReceiver,intentFilter);


    }


    @Override
    protected void listenIn() {
        nav_icon_article.setOnClickListener(this);
        nav_icon_findcar.setOnClickListener(this);
        nav_icon_forum.setOnClickListener(this);
        nav_icon_my.setOnClickListener(this);
        nav_icon_sale.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mainActivity_broadcastReceiver);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.nav_icon_article:




                break;


            case R.id.nav_icon_forum:

                break;

            case R.id.nav_icon_findcar:

                break;

            case R.id.nav_icon_sale:

                break;

            case R.id.nav_icon_my:

                break;

        }



    }

    class MainActivity_BroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            finish();

        }
    }

}
