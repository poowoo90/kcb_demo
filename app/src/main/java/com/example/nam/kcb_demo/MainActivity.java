package com.example.nam.kcb_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    WebView web; //웹뷰 선언

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);  // 레이아웃 설정
        layout.setOrientation(1);                                // setOrientation(LinearLayout.HORIZONTAL) : 수평
        // setOrientation(LinearLayout.VERTICAL)   : 수직
        // setOrientation(1) : 세로정렬, setOrientation(0) : 가로정렬

        web = new WebView(this);                        // 웹뷰 생성
        WebSettings webSet = web.getSettings();                   // 웹뷰 설정

        webSet.setJavaScriptEnabled                     (true) ; // 자바스크립트 허용
        webSet.setUseWideViewPort                       (true) ; // 웹뷰에 맞게 출력하기
        webSet.setBuiltInZoomControls                   (false); // 안드로이드 내장 줌 컨트롤 사용 X
        webSet.setAllowUniversalAccessFromFileURLs      (true) ; // file://URL이면 어느 오리진에 대해서도 Ajax로 요청을 보낼 수 있다.
                                                                 // API 레벨 16부터 이용할 수 있다.
        webSet.setJavaScriptCanOpenWindowsAutomatically (true) ; // javascript 가  window.open()을 사용할 수 있도록 설정
        webSet.setSupportMultipleWindows                (true) ; // 여러개의 윈도우를 사용할 수 있도록 설정
        webSet.setSaveFormData                          (false); // 폼의 입력값를 저장하지 않는다
        webSet.setSavePassword                          (false); // 암호를 저장하지 않는다.
        webSet.setLayoutAlgorithm                       (WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기

        web.addJavascriptInterface(new WebAppInterface(this), "android");

        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Uri requested = Uri.parse(url);
                String scheme = requested.getScheme();

                if(scheme != null) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);

                    return true; // true를 리턴하면  webview는 해당 URL을 랜더하지 않는다.
                } else {

                    //Log.d("WebView", "else");
                    view.loadUrl(url);
                    Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();

                    return false;
                }
            }

        });
        web.loadUrl("file:///android_asset/index.html");
        layout.addView(web);
        setContentView(layout);

    }

    /* 휴대폰의 이전 키를 눌렀을 때, 웹뷰에서 뒤로갈 수 있으면 뒤로 가고, 뒤로가지 못하면 앱을 끄는 부분
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (web.canGoBack()) {
                        web.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    */

    /* 휴대폰의 이전 키를 눌렀을 때, 웹뷰에서 뒤로갈 수 있으면 뒤로 가고, 뒤로가지 못하면 앱을 끄는 부분
    @Override
    public void onBackPressed() {
        WebBackForwardList list = web.copyBackForwardList(); // 누적된 history를 저장할 변수

        if(list.getCurrentIndex() <= 0 && !web.canGoBack()) { // 처음 들어온 페이지이거나, history가 없는 경우
            super.onBackPressed();
        }else { // history가 있는 경우
            web.goBackOrForward(-(list.getCurrentIndex())); // 현재 페이지로 부터 histoty 수 만큼 뒷 페이지로 이동
            web.clearHistory(); // history 삭제
        }
    }

     여기까지 */

    /*
    @Override
    public void onBackPressed()
    {
        if(web.canGoBack()){
            web.goBack();
        }else{
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Exit!")
                    .setMessage("앱을 종료하시겠습니까?")
                    .setPositiveButton("예", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("아니오", null)
                    .show();
        }
    }
    */


    @Override
    public void onBackPressed() {
        WebBackForwardList list = web.copyBackForwardList(); // 누적된 history 를 저장할 변수

        Log.d("[JeongjinKim]", "onBackPressed: During");
        if (list.getCurrentIndex() <= 0 && !web.canGoBack()) { // 처음 들어온 페이지이거나, history 가 없는 경우
            //super.onBackPressed();

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    //.setTitle("Exit!")
                    .setMessage("SUNNY BANK앱을 종료하시겠습니까?")
                    .setPositiveButton("예", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("아니오", null)
                    .show();

        }else { // history 가 있는 경우

            if(web.canGoBack()){
                web.goBack();
            }
            web.clearHistory(); // history 삭제

        }
    }
/*
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //Log.d("check URL",url);


            Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();

            view.loadUrl(url);
            return true;
        }
    }
*/

    /* 비활성화 메뉴 toast 보여주기 */
    public class WebAppInterface {
        Context mContext;


        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void onCancelPressed() {
            Log.d("[JeongjinKim]", "onCancelPressed: start ");
            web.post(new Runnable() {
                @Override
                public void run() {
                    onBackPressed();
                }
            });
            Log.d("[JeongjinKim]", "onCancelPressed: end ");
        }
    }
/*
    public class MyWebViewClient extends WebViewClient {
    }
*/

}
