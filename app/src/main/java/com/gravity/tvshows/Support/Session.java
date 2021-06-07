package com.gravity.tvshows.Support;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.gravity.tvshows.Search.Model.MShow;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private static SharedPreferences pref;
    private Context context;
    private String name = "recent_search_list_tv_Show";
    private String USER_SEARCH_LIST = "user search list";
    private static SharedPreferences.Editor editor;
    private List<MShow> showList = new ArrayList<>();

    public Session(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(name, 0);
        editor = pref.edit();
    }

    public void ClearSharedPreference(){
        editor.clear();
        editor.commit();
    }


    public <T> void setSearchList(String key, List<T> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);

        set(key, json);
    }

    public static void set(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

//    public void setString(String name, String string) {
//
//        editor.putString(name, string);
//        editor.commit();
//    }
//
//    public String getString(String name) {
//
//        String json = pref.getString(name, "");
//        return json;
//    }
//
//    public List<MShow> getShowList(){
//
//        if (showList.size() < 5){
//            Gson gson = new Gson();
//
//            String json = pref.getString(USER_SEARCH_LIST, "");
//            MShow show;
//
//            if (json.isEmpty()){
//                show = new MShow();
//            }else {
//                show = gson.fromJson(json, MShow.class);
//            }
//
//            showList.add(show);
//
//        }else {
//            showList.remove(0);
//            getShowList();
//        }
//
//        return showList;
//    }
//
//    public void setShowList(MShow mShow){
//        Gson gson = new Gson();
//        String json = gson.toJson(mShow);
//        editor.putString(USER_SEARCH_LIST, json);
//        editor.commit();
//    }
}

//
//    private static SharedPreferences sharedPreferences = context.getSharedPreferences(STORE_FILE_NAME, Context.MODE_PRIVATE);
//
//    private static SharedPreferences.Editor editor = sharedPreferences.edit();
//
//    public <T> void setList(String key, List<T> list) {
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//
//        set(key, json);
//    }
//
//    public static void set(String key, String value) {
//        editor.putString(key, value);
//        editor.commit();
//    }



////////////////////*  to retrive data*//////////////////////////
//
//    publicList<YourModel> getList(){
//        List<YourModel> arrayItems;
//        String serializedObject = sharedPreferences.getString(KEY_PREFS, null);
//        if (serializedObject != null) {
//            Gson gson = new Gson();
//            Type type = new TypeToken<List<YourModel>>(){}.getType();
//            arrayItems = gson.fromJson(serializedObject, type);
//        }
//    }
