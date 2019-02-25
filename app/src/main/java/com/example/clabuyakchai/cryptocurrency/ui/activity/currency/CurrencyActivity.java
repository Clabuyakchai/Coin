package com.example.clabuyakchai.cryptocurrency.ui.activity.currency;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.clabuyakchai.cryptocurrency.R;
import com.example.clabuyakchai.cryptocurrency.ui.base.BaseActivity;
import com.example.clabuyakchai.cryptocurrency.ui.fragment.currency.CurrencyFragment;

public class CurrencyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.container_crypto);
        if(fragment == null){
            fm.beginTransaction()
                    .add(R.id.container_crypto, CurrencyFragment.newInstance())
                    .commit();
        }
    }
}
