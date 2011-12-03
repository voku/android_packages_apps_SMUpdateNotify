package com.spicagenmod.updatenotify.utils;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class RegistrationClient {
    static final String C2DM_URL = "http://nebkat.com/spicagenmod/c2dm.php";

    public HttpResponse serverRequest(List<NameValuePair> params) throws Exception {
        final HttpParams httpparams = createParamsForPosting();
        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient.setParams(httpparams);
        HttpPost httppost = new HttpPost(C2DM_URL);
        httppost.setEntity(new UrlEncodedFormEntity(params));
        HttpResponse res = httpclient.execute(httppost);
        return res;
    }

    private static HttpParams createParamsForPosting() {
        final HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, "UTF_8");
        HttpProtocolParams.setUseExpectContinue(params, false); // solves the '417' issue
        return params;
    }
}
