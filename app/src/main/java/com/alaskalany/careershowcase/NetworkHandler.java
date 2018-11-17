/*
 * MIT License
 *
 * Copyright (c) 2018 Ahmed AlAskalany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.alaskalany.careershowcase;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkHandler
        implements Runnable {
    
    private final Context context;
    
    /**
     * @param context {@link Context}
     */
    NetworkHandler(Context context) {
        
        this.context = context;
    }
    
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        // Get the connectivity manager
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        boolean isWifiConn = false;
        boolean isMobileConn = false;
        
        // Get active network information
        NetworkInfo networkInfo1 = connMgr.getActiveNetworkInfo();
        
        // Online if network info exists and is connected
        boolean isOnline = networkInfo1 != null && networkInfo1.isConnected();
        
        if (isOnline) {
            // If online
            // Check connectivity for all networks
            for (Network network : connMgr.getAllNetworks()) {
                NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    // If Wi-Fi
                    isWifiConn |= networkInfo.isConnected();
                    if (isWifiConn) {
                        doWhenWifiIsConnected();
                    }
                }
                if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    // If mobile network
                    isMobileConn |= networkInfo.isConnected();
                    if (isMobileConn) {
                        doWhenMobileIsConnected();
                    }
                }
            }
        } else {
            // If not connected
            doWhenNotConnected();
        }
    }
    
    /**
     * If connected through Wi-Fi do this
     */
    private void doWhenWifiIsConnected() {
        // TODO handle if Wi-Fi is connected
        Toast.makeText(context.getApplicationContext(), "WiFi connected", Toast.LENGTH_SHORT)
             .show();
    }
    
    /**
     * If connected through mobile network do this
     */
    private void doWhenMobileIsConnected() {
        // TODO handle if mobile network is connected
        Toast.makeText(context.getApplicationContext(), "Mobile connected", Toast.LENGTH_SHORT)
             .show();
    }
    
    /**
     * If not connected do this
     */
    private void doWhenNotConnected() {
        
        // TODO handle if disconnected
        Toast.makeText(context.getApplicationContext(), "Not connected", Toast.LENGTH_SHORT)
             .show();
    }
}