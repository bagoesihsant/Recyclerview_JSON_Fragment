package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    private static String MY_PREFS = "MyPrefs";
    private static String KEY_STATUS_LOGIN = "status_login";
    private static String KEY_LOGGED_IN_NAME = "logged_in_name";
    private static String KEY_LOGGED_IN_EMAIL = "logged_in_email";


    public static void setLoggedInName(Context context, String name)
    {
        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LOGGED_IN_NAME, name);
        editor.apply();
    }

    public static void setLoggedInEmail(Context context, String email)
    {
        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LOGGED_IN_EMAIL, email);
        editor.apply();
    }

    public static void setLoggedInStatus(Context context, boolean status)
    {
        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_STATUS_LOGIN, status);
        editor.apply();
    }

    public static String getLoggedInName(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        return preferences.getString(KEY_LOGGED_IN_NAME, null);
    }

    public static String getLoggedInEmail(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        return preferences.getString(KEY_LOGGED_IN_EMAIL, null);
    }

    public static boolean getLoggedInStatus(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        return preferences.getBoolean(KEY_STATUS_LOGIN, false);
    }



}
