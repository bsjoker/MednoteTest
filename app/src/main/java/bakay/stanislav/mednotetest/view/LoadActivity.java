package bakay.stanislav.mednotetest.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bakay.stanislav.mednotetest.R;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        startActivity(new Intent(LoadActivity.this, MainActivity.class));
    }
}
