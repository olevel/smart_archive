package com.hacker.olevel.smartarchive;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hacker.olevel.smartarchive.Model.Department;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IndexFragment.OnFragmentInteractionListener,
        DepartmentFragment.OnFragmentInteractionListener, CategoryFragment.OnFragmentInteractionListener,
        YearDialogFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // check that the activity is using the layout version with
        // fragment_container Framelayout
        if (findViewById(R.id.fragment_container) != null) {
            // We avoid fragment overlapping by making sure we do not inflate
            // a new fragment when returning from a previous state
            if (savedInstanceState != null) {
                return;
            }

            // Create a new fragment to be placed in the activity layout
            IndexFragment indexFragment = new IndexFragment();

            // Pass in arguments if any
            indexFragment.setArguments(getIntent().getExtras());

            // Add fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, indexFragment).commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Instantiate a new Index fragment by default
        Fragment fragment = new IndexFragment();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new IndexFragment();
            fragment.setArguments(getIntent().getExtras());
        } else if (id == R.id.nav_category) {
            fragment = new CategoryFragment();
            fragment.setArguments(getIntent().getExtras());

        } else if (id == R.id.nav_department) {
            fragment = new DepartmentFragment();
            fragment.setArguments(getIntent().getExtras());

        }

        // Add fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(null).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setActionbarTitle(String actionbarTitle, String actionbarSubtitle) {
        getSupportActionBar().setTitle(actionbarTitle);
        getSupportActionBar().setSubtitle(actionbarSubtitle);
    }

    @Override
    public void onIndexFragmentInteraction() {
        setActionbarTitle(getResources().getString(R.string.app_name), null);
    }

    @Override
    public void onYearGridItemClick(Department department) {

    }

    @Override
    public void onDepartmentFragmentInteraction() {
        setActionbarTitle(getResources().getString(R.string.app_name), "Departments in UMaT");
    }

    @Override
    public void onDepartmentGridItemClick(Department department) {
        Bundle args = new Bundle();
        args.putSerializable("department", department);
        DialogFragment dialogFragment = new YearDialogFragment();
        dialogFragment.setArguments(args);
        dialogFragment.show(getSupportFragmentManager(), "YearDialogFragment");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCategoryFragmentInteraction() {
        setActionbarTitle(getResources().getString(R.string.app_name), "Publication categories");
    }
}
