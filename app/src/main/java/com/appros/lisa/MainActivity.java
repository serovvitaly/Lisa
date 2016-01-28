package com.appros.lisa;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.appros.vk.Places;
import com.appros.vk.places.PlacesSearchRequest;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.util.VKUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Boolean vkUserIsLoggedIn = VKSdk.isLoggedIn();

        if (!vkUserIsLoggedIn) {

            showWelcomeLayout();
        }
        else {
            showMainLayout();
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.wifi_list:
                this.showWifiListPage();
                break;

            case R.id.nav_camera:
                this.showPlacesPage();
                break;

            case R.id.nav_gallery:
                showGalleryPage();
                break;

            case R.id.search_places:
                showPeoplesPage();
                break;

            case R.id.nav_manage:
                Places.getTypes();
                break;

            case R.id.nav_share:
                //
                break;

            case R.id.nav_send:
                //
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showWifiListPage() {

        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        List<ScanResult> wifi_points_list = wifi.getScanResults();

        TextView mainTextView = (TextView) this.findViewById(R.id.main_text_view);

        mainTextView.setText("Список найденных точек доступа Wi-Fi\n" +
                "----------------");

        for (ScanResult wifi_point : wifi_points_list) {

            String wifi_ssid = wifi_point.SSID;

            int wifi_level = wifi_point.level;

            String wifi_mac = wifi_point.BSSID;

            mainTextView.append("\nSSID: " + wifi_ssid);
            mainTextView.append("\nУровень сигнала: " + wifi_level);
            mainTextView.append("\nMAC адрес: " + wifi_mac);
            mainTextView.append("\n----------------");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Context context = drawer.getContext();

    }

    public void showPlacesPage(){
/*
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Context context = drawer.getContext();
*/
        /*
        ImageView imageView = new ImageView(context);
        Uri imageUri = Uri.parse("http://otvet.imgsmail.ru/download/c86d2883678beac2e8247bf6abefd370_i-799.jpg");
        imageView.setImageURI(imageUri);
        */
/*
        GridView gridView = new GridView(context);

        gridView.setColumnWidth(90);

        gridView.setAdapter(new ImageAdapter(this));


        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_relative_layout);

        relativeLayout.addView(gridView);
*/

        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());

        for (String fingerprint : fingerprints) {

            Log.d("FingerPrints", fingerprint);
        }

        //VKRequest request = new VKRequest("friends.get", VKParameters.from(VKApiConst.USER_ID, 167600225));
        VKRequest request = new VKRequest("places.getTypes");
        //VKRequest request = new VKRequest("places.getById", VKParameters.from("places", 4980426));

        //request.

        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {

                System.out.println("VKApi.users onComplete");

                System.out.println(response.json.toString());

            }

            @Override
            public void onError(VKError error) {

                System.out.println("VKApi.users onError");

                System.out.println(error.toString());
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {

                System.out.println("VKApi.users attemptFailed");
            }
        });

        //VkApi.getPlacesList();
    }

    public void showPeoplesPage(){

        PlacesSearchRequest placesSearchRequest = new PlacesSearchRequest();

        placesSearchRequest.setLatitude(59.935624);

        placesSearchRequest.setLongitude(30.325875);

        placesSearchRequest.execute();

    }

    public void showGalleryPage(){

        //
    }

    public void showWelcomeLayout(){

        setContentView(R.layout.welcome);

        Button welcomeLoginButton = (Button) findViewById(R.id.welcome_login_button);

        View.OnClickListener welcomeLoginButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                VKSdk.login(MainActivity.this);
            }
        };

        welcomeLoginButton.setOnClickListener(welcomeLoginButtonOnClickListener);

    }

    public void showMainLayout(){

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Пользователь успешно авторизовался
                Log.d("OK!", "Пользователь успешно авторизовался");

                showMainLayout();
            }
            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                Log.d("Fail{", "Произошла ошибка авторизации (например, пользователь запретил авторизацию)");

                showMainLayout();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
