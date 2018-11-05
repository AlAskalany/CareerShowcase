package com.alaskalany.careershowcase;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.alaskalany.careershowcase.databinding.ActivityMainBinding;
import com.alaskalany.careershowcase.ui.BottomNavigationManager;
import com.alaskalany.careershowcase.ui.overview.OverviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Main activity
 */
public class MainActivity
        extends AppCompatActivity
        implements OverviewFragment.OnOverviewFragmentInteractionListener {

    public static final String TAG = "MainActivity";

    /**
     * Activity layout bindings
     */
    ActivityMainBinding mBinding;

    /**
     * Bottom navigation
     */
    private BottomNavigationManager mNavigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mNavigationManager = new BottomNavigationManager(this, mBinding.navigation);
        // Set bottom navigation to first fragment
        mNavigationManager.init(savedInstanceState == null);
        Runnable networkHandler = new Runnable() {

            @Override
            public void run() {

                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                boolean isWifiConn = false;
                boolean isMobileConn = false;
                NetworkInfo networkInfo1 = connMgr.getActiveNetworkInfo();
                boolean isOnline = networkInfo1 != null && networkInfo1.isConnected();
                if (isOnline) {
                    for (Network network : connMgr.getAllNetworks()) {
                        NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
                        if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                            isWifiConn |= networkInfo.isConnected();
                            if (isWifiConn) {
                                doWhenWifiIsConnected();
                            }
                        }
                        if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                            isMobileConn |= networkInfo.isConnected();
                            if (isMobileConn) {
                                doWhenMobileIsConnected();
                            }
                        }
                    }
                    Log.d(TAG, "Wifi connected: " + isWifiConn);
                    Log.d(TAG, "Mobile connected: " + isMobileConn);
                } else {
                    doWhenNotConnected();
                }
            }

            private void doWhenWifiIsConnected() {

                Toast.makeText(getApplicationContext(), "WiFi connected", Toast.LENGTH_SHORT).show();
            }

            private void doWhenMobileIsConnected() {

                Toast.makeText(getApplicationContext(), "Mobile connected", Toast.LENGTH_SHORT).show();
            }

            private void doWhenNotConnected() {

                Toast.makeText(getApplicationContext(), "Not connected", Toast.LENGTH_SHORT).show();
            }
        };
        networkHandler.run();
    }

    /**
     * @param uri uri
     */
    @Override
    public void onOverviewFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {

        if (!mNavigationManager.onBackPressed()) {
            //getSupportFragmentManager().popBackStack();
            super.onBackPressed();
        }
    }
}
