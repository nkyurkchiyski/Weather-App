package com.example.weatherapp.views;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.R;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseActivity extends AppCompatActivity {
    protected static Map<Integer, Class<?>> activities = new HashMap<>();

    static {
        activities.put(R.id.action_history, HistoryActivity.class);
        activities.put(R.id.action_home, MainActivity.class);
        activities.put(R.id.action_search, SearchActivity.class);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        final Intent intent = new Intent(this, activities.get(id));
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
