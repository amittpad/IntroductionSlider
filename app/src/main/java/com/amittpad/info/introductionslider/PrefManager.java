package com.amittpad.info.introductionslider;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Amit TPAD on 8/30/2017.
 */

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "slider-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";



    public PrefManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean IsFirstTimeLaunch(){

        return pref.getBoolean(IS_FIRST_TIME_LAUNCH,true);
    }





}
