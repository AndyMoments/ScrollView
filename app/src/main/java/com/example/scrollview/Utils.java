package com.example.scrollview;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

public class Utils {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void changeStatusBarAndNavigationBarColor(Activity activity, int statusBarColor, int navigationColor) {

        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(activity,statusBarColor));
        window.setNavigationBarColor(ContextCompat.getColor(activity,navigationColor));

    }
}
