package net.httpletters_archive.simplesporttimer;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MyComp on 12.04.2017.
 */

public class PreferenceHelper {

    private static PreferenceHelper instance;
    private Context context;
    private SharedPreferences preferences;

    public static String SPLASH_IS_INVISIBLE = "splash_is_invisible";

    public static PreferenceHelper getInstance(){
        if (instance==null){
            instance = new PreferenceHelper();
        }
        return instance;
    }

    public void init(Context context){
        this.context = context;
        preferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    public void putBoolean(String key, Boolean value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key,value);
        editor.apply();

    }

    public  boolean getBoolean(String key){
        return preferences.getBoolean(key, false);
    }
}
