package nasapp.naz.com.nasapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class AirbanqPreferencesInfo {

    private static AirbanqPreferencesInfo instance;
    private SharedPreferences preferences;

    public static AirbanqPreferencesInfo getInstance(Context context) {
        if (instance == null) {
            synchronized (AirbanqPreferencesInfo.class) {
                instance = new AirbanqPreferencesInfo(context);
            }
        }
        return instance;
    }

    public static AirbanqPreferencesInfo singleton() {
        if (instance == null) {
            throw new IllegalStateException("Must Initialize AirbanqPreferencesInfo before using singleton()");
        } else {
            return instance;
        }
    }

    private AirbanqPreferencesInfo(Context activity) {
        preferences = activity.getSharedPreferences("nasapp.naz.com.nasapplication.NasPREF",
                Context.MODE_PRIVATE);
    }

    public void setPreference(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    public void setPreference(String key, long value) {
        preferences.edit().putLong(key, value).apply();
    }

    public void setPreference(String key, boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }

    public void setPreference(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }

    public String getPreference(String key) {
        return preferences.getString(key, null);
    }

    public long getPreferenceAsLong(String key) {
        return preferences.getLong(key, 0);
    }

    public int getPreferenceAsInt(String key) {
        return preferences.getInt(key, 0);
    }

    public boolean getPreferenceAsBool(String key) {
        return preferences.getBoolean(key, false);
    }

    public Set<String> getPreferenceSet(String key) {
        return preferences.getStringSet(key, new HashSet<String>());
    }


}