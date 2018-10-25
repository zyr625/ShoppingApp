package utils;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * author：shashe
 * 日期：2018/10/24
 */
public class OkHttpUtils {
     private OkHttpUtils(){}
         private static OkHttpUtils mOkHttpUtils;

         public synchronized static OkHttpUtils getOkHttpUtils(){
             if(mOkHttpUtils==null){
                 mOkHttpUtils=new OkHttpUtils();
             }
             return mOkHttpUtils;
         }


         //get请求
         public OkHttpUtils get(String url){
             final Message message=Message.obtain();
             OkHttpClient okHttpClient = null;
             try {
                 okHttpClient = getOkHttpClient();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             final Request request=new Request.Builder()
                     .url(url)
                     .build();
             okHttpClient.newCall(request).enqueue(new Callback() {
                 @Override
                 public void onFailure(Call call, IOException e) {
                     message.what=100;
                     message.obj=e.getMessage();
                     handler.sendMessage(message);
                 }

                 @Override
                 public void onResponse(Call call, Response response) throws IOException {
                     message.what=101;
                     message.obj=response.body().string();
                     handler.sendMessage(message);
                 }
             });

             return this;
         }

         @NonNull
         private OkHttpClient getOkHttpClient() throws IOException {
             return new OkHttpClient.Builder()
                         .addInterceptor(new Interceptor() {
                             @Override
                             public Response intercept(Chain chain) throws IOException {
                                 Request re = chain.request();
                                 String method=re.method();
                                 String host=re.url().host();
                                 Log.i("OkHttpUtils",method+"=="+host);
                                 return chain.proceed(re);
                             }
                         }).build();
         }

         //post请求
         public void post(String url, RequestBody body){
             final Message message=Message.obtain();
             try {
                 OkHttpClient client=  getOkHttpClient();
                 Request request=new Request.Builder()
                         .url(url)
                         .post(body).build();
                 client.newCall(request).enqueue(new Callback() {
                     @Override
                     public void onFailure(Call call, IOException e) {
                         message.what=100;
                         message.obj=e.getMessage();
                         handler.sendMessage(message);
                     }

                     @Override
                     public void onResponse(Call call, Response response) throws IOException {
                         message.what=101;
                         message.obj=response.body().string();
                         handler.sendMessage(message);
                     }
                 });

             } catch (IOException e) {
                 e.printStackTrace();
             }
         }


         private Handler handler=new Handler(){
             @Override
             public void handleMessage(Message msg) {
                 super.handleMessage(msg);
                 switch (msg.what){
                     case 101://成功
                         String data= (String) msg.obj;
                         listener.success(data);
                         break;
                     case 100://失败
                         String error= (String) msg.obj;
                         listener.fail(error);
                         break;
                 }
             }
         };


         private HttpListener listener;
         public void result(HttpListener listener){
             this.listener=listener;
         }


         public interface HttpListener{
             void success(String data);
             void fail(String error);
         }
}
