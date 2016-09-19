package lanou.amg.main.welcomepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import lanou.amg.R;
import lanou.amg.main.advert.AdvertActivity;

/**
 * Created by dllo on 16/9/19.
 */
public class Fragment_Four extends Fragment {
    private Button btn_fragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, null);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_fragment = (Button) view.findViewById(R.id.btn_fragment);

        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AdvertActivity.class);
                startActivity(intent);
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("welcomepage_welComePage",getContext().MODE_PRIVATE);
                SharedPreferences.Editor savedInstanceState_edit = sharedPreferences.edit();
                savedInstanceState_edit.putBoolean("first",true);
                savedInstanceState_edit.commit();

                Intent intent1 = new Intent("MainActivity.finsh");
                getActivity().sendBroadcast(intent1);


            }
        });

    }
}
