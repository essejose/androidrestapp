package com.essejose.androidrestapp.api;

/**
 * Created by essejose on 21/06/2017.
 */

public class APIUtils {

    private APIUtils() {}

    public static final String BASE_URL = "http://www.mocky.io";

    public static AndroidAPI getAndroidAPIVersion() {

        return RetrofitClient.getClient(BASE_URL).create(AndroidAPI.class);
    }
}
