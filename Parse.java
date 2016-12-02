/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 *
 * @author alejandrocallis
 */
public class Parse {
    private String appid, apikey,url;
    
    public Parse() {
        this.apikey ="";
        this.appid = "";
        this.url = "";
    }
    public String getAll(String clase) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
          .url(url+clase)
          .get()
          .addHeader("x-parse-application-id", appid)
          .addHeader("x-parse-rest-api-key", apikey)
          .build();
        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string().toString();
    }
    public String get(String clase,String clause) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
          .url(url+clase+"?where="+clause)
          .get()
          .addHeader("x-parse-application-id", appid)
          .addHeader("x-parse-rest-api-key", apikey)
          .build();
        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string().toString();
    }
    public String delete(String clase,String clause) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
        .url(url+clase+"/"+clause)
        .delete()
        .addHeader("x-parse-application-id", appid)
        .addHeader("x-parse-rest-api-key", apikey)
        .build();
        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string().toString();
    }
    public String put(String clase,String data,String where) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, data);
        Request request = new Request.Builder()
        .url(url+clase+"/"+where)
        .put(body)
        .addHeader("x-parse-application-id", appid)
        .addHeader("x-parse-rest-api-key", apikey)
        .build();
        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string().toString();
    }
    public String post(String clase,String data) throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, data);
        Request request = new Request.Builder()
        .url(url+clase)
        .post(body)
        .addHeader("x-parse-application-id", appid)
        .addHeader("x-parse-rest-api-key", apikey)
        .build();
        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string().toString();
    }
}