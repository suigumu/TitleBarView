package com.aries.title.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


/**
 * Created: AriesHoo on 2017-03-14 08:54
 * Function: app使用工具类
 * Desc:
 */
public class AppUtil {

    public static void jumpMarket(Context mContext) {
        jumpMarket(mContext, null);
    }

    public static void jumpMarket(Context mContext, String packageName) {
        if (mContext == null) {
            return;
        }
        if (packageName == null || packageName.isEmpty()) {
            packageName = mContext.getPackageName();
        }
        String mAddress = "market://details?id=" + packageName;
        try {
            Intent marketIntent = new Intent("android.intent.action.VIEW");
            marketIntent.setData(Uri.parse(mAddress));
            mContext.startActivity(marketIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param activity
     * @param bundle
     */
    public static void startActivity(Activity mContext, Class<? extends Activity> activity, Bundle bundle) {
        if (mContext == null) {
            return;
        }
        Intent intent = new Intent(mContext, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        mContext.startActivity(intent);
    }

    public static void startActivity(Activity mContext, Class<? extends Activity> activity) {
        startActivity(mContext, activity, null);
    }

}
