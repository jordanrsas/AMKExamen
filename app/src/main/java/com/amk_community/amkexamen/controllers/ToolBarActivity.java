package com.amk_community.amkexamen.controllers;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.amk_community.amkexamen.R;
import com.amk_community.amkexamen.login.LoginActivity;

/**
 * Created by Jordan on 06/09/2017.
 */

public class ToolBarActivity extends BaseActivity implements PopupMenu.OnMenuItemClickListener {
    private View toolbarLayout;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        toolbarLayout = findViewById(R.id.toolbarLy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTest);
        toolbar.setTitle("");


        Drawable drawable = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getDrawable(R.drawable.itunes_logo);
        } else {
            drawable = this.getResources().getDrawable(R.drawable.itunes_logo);
        }
        toolbar.setLogo(drawable);
        setSupportActionBar(toolbar);
    }

    public void changeToolbarVisibility(boolean visibility) {
        if (toolbarLayout != null) {
            toolbarLayout.setVisibility(visibility ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.account_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.configUser) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
