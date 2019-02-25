package com.example.clabuyakchai.cryptocurrency.ui.activity.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.clabuyakchai.cryptocurrency.R;
import com.example.clabuyakchai.cryptocurrency.ui.base.BaseActivity;
import com.example.clabuyakchai.cryptocurrency.ui.fragment.login.LoginFragment;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.container);

        if(fragment == null){
            fm.beginTransaction()
                    .add(R.id.container, LoginFragment.newInstance())
                    .commit();
        }
    }
}
