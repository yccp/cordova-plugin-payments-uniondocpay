package news.chen.yu.ionic;

import android.util.Log;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.chinaums.pppay.unify.UnifyPayListener;
import com.chinaums.pppay.unify.UnifyPayPlugin;
import com.chinaums.pppay.unify.UnifyPayRequest;


public class Uniondocpay extends CordovaPlugin implements UnifyPayListener {
    public static String TAG = "cordova-plugin-payments-uniondocpay";
    public static CallbackContext currentCallbackContext;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        UnifyPayPlugin.getInstance(cordova.getActivity()).setListener(this);
    }

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, "Execute:" + action + " with :" + args.toString());
        if (action.equals("pay")) {
            JSONObject params = args.getJSONObject(0);
            this.sendPaymentRequest(params, callbackContext);
            return true;
        }
        return false;
    }

    protected boolean sendPaymentRequest(JSONObject params, CallbackContext callbackContext) {
        try {
            String channel = params.getString("channel");
            String string = params.getString("string");
            if(channel.equals("Alipay")) {
                UnifyPayRequest msg = new UnifyPayRequest();
                msg.payChannel = UnifyPayRequest.CHANNEL_ALIPAY;
                msg.payData = string;
                currentCallbackContext = callbackContext;
                UnifyPayPlugin.getInstance(cordova.getActivity()).sendPayRequest(msg);
                return true;
            }
        } catch (Exception e) {
            Log.i(TAG, e.getMessage());

            callbackContext.error("参数错误");
            return true;
        }

        return true;
    }

    private void sendNoResultPluginResult(CallbackContext callbackContext) {
        currentCallbackContext = callbackContext;

        PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT);
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
    }

    @Override
    public void onResult(int i, String s) {
        Log.i(TAG, i + " " + s);
        sendNoResultPluginResult(currentCallbackContext);
    }
}