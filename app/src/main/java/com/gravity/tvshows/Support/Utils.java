package com.gravity.tvshows.Support;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.gravity.tvshows.API.ResponseData;
import com.gravity.tvshows.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava2.HttpException;

public class Utils implements Constant {

    /*________________________________checking internet connection___________________________*/
    public static boolean isConnectingToInternet(Activity activity) {
        ConnectivityManager connectivity = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        if (info[i].isConnectedOrConnecting())
                            return true;
                    }
        }
        return false;
    }


    // log this
    public static void logthis(Context context, String message){

        if(context!=null) {
            Log.d(Utils.TAG_ABHI,  message);
            //   Log.d(Utils.TAG_ABHI, "\n" + context.getClass().getName() + "\n" + message);
        }else{
            Log.d(Utils.TAG_ABHI, "\n" + message);

        }

    }
    // log this
    public static void logthisString(String name, String message){

        Log.d(Utils.TAG_ABHI, name +" . "+ message);

    }


    public static void openKeyboard(Activity activity, EditText editText) {
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
//
//    public static ResponseData<String> errorMessageParsing(Throwable e) {
//        try {
//            return new Gson().fromJson(((HttpException) e).response().errorBody().string(), ResponseData.class);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }catch (JsonSyntaxException e2){
//            e2.getMessage();
//        }
//        return null;
//    }

    /*________________method to hide keyboard________________*/
    public static void hideKeyboard(Context context) {
        InputMethodManager inputManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) context).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    // Show Toast
    public static void ShowToast(Context context, String msg, int duration) {

        int gravity = Gravity.CENTER; // the position of toast
        int xOffset = 0; // horizontal offset from current gravity
        int yOffset = 0;

        Toast toast = Toast.makeText(context, msg, duration);
        toast.setGravity(gravity, xOffset, yOffset);
        toast.show();

    }

//
//    public static String getMessageFromErrorBody(ResponseBody errorBody) {
//        JSONObject jsonObject = null;
//        try {
//            String jsonString = errorBody.string();
//            jsonObject = new JSONObject(jsonString);
//
//            return jsonObject.getString("message");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return "Try again";
//    }


    // Check value null and return
    public static String checkNull(String value) {
        return value == null ? "" : value;
    }

    public static void showToast(Context context, String msg) {
        if (msg != null && !msg.isEmpty())
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToastServerError(Context context, String msg,String error) {
        if (msg != null && !msg.isEmpty())
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToastConnection(Context context) {
        Toast.makeText(context, context.getString(R.string.error_connection), Toast.LENGTH_SHORT).show();
    }

    public static void showToastAuthFailed(Context context) {
        Toast.makeText(context, context.getString(R.string.error_auth_failed), Toast.LENGTH_SHORT).show();
    }

    public static void showToastAuthCancelled(Context context) {
        Toast.makeText(context, context.getString(R.string.error_auth_cancelled), Toast.LENGTH_SHORT).show();
    }

    public static void showToastWentWrong(Context context) {
        Toast.makeText(context, context.getString(R.string.error_something_wrong), Toast.LENGTH_SHORT).show();
    }
}
