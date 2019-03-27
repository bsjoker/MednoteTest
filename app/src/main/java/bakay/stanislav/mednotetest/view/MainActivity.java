package bakay.stanislav.mednotetest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import bakay.stanislav.mednotetest.R;
import bakay.stanislav.mednotetest.model.data.Stock;
import bakay.stanislav.mednotetest.presenter.MainPresenterImpl;
import bakay.stanislav.mednotetest.view.adapters.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder mUnbinder;

    private RecyclerViewAdapter adapter;

    private MainPresenterImpl mMainPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mMainPresenterImpl = new MainPresenterImpl(this);

        mMainPresenterImpl.onStartFetch();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);


        recyclerView.setOnClickListener(v -> {
            v.getId();
            Log.d("MainActivity", "Pos: " + v.getId());
        });
    }

    @Override
    public void showData(List<Stock> list) {
        adapter.setList(list, getApplicationContext(), new RecyclerViewAdapter.ItemClickListener() {
            @Override
            public void itemViewOnClick(View v, int position) {
                mMainPresenterImpl.onClickPosition(position);
            }
        });
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void showEmptyList() {
        makeToast(getString(R.string.empty_list));
    }

    @Override
    public void showClickedItem(String name) {
        makeToast(name);
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            mMainPresenterImpl.onStartButtonClick();
        }
        return super.onOptionsItemSelected(item);
    }
}
