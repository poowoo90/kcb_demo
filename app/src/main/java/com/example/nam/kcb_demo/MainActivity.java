package com.example.nam.kcb_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    WebView web;            //웹뷰 선언
    JSONObject jsonData; // 자바스크립트에서 값을 받을 json 변수 선언

    /* 테스트용 변수 */
    // String receive = "";   // 자바스크립트에서 값을 받을 변수 선언

    private final Handler handler = new Handler();


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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            web.setWebContentsDebuggingEnabled(true); 				//API 레벨 19부터 이용 가능.
        }
        web.addJavascriptInterface(new WebAppInterface(this), "android");


        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;

            }

        });

        web.loadUrl("file:///android_asset/1001.html"); // 처음 로드할 페이지
        layout.addView(web);
        setContentView(layout);


    }

    /* 물리 백버튼키 처리 */
    @Override
    public void onBackPressed() {
        WebBackForwardList list = web.copyBackForwardList(); // 누적된 history 를 저장할 변수
        //int listSize = list.getSize(); // list의 크기
        //web.goBackOrForward(-(list.getCurrentIndex())); // 현재 페이지로 부터 history 수 만큼 뒷 페이지로 이동

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

        } else { // history 가 있는 경우

            if (web.canGoBack()) {
                web.goBack();
            }

            web.clearHistory(); // history 삭제

        }
    }

    /* 안드로이드와 자바스크립트간의 데이터 주고 받기 */
    public class WebAppInterface {
        Context mContext;


        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        /* 비활성화 메뉴 toast 보여주기 */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        /* 뒤로가기 */
        @JavascriptInterface
        public void onCancelPressed() {
            Log.d("[JeongjinKim]", "onCancelPressed: start ");
            web.post(new Runnable() {
                @Override
                public void run() {
                    WebBackForwardList list = web.copyBackForwardList(); // 누적된 history 를 저장할 변수
                    web.goBackOrForward(-(list.getCurrentIndex()) + 1);
                }
            });
            Log.d("[JeongjinKim]", "onCancelPressed: end ");
        }

        /* 페이지 이동, 자바스크립트에서 데이터받기 */
        @JavascriptInterface
        public void movePage(final String url, final String json) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //web.loadUrl("file:///android_asset/sub2.html"); // url로 페이지 이동
                    if(json != null) {
                        try {
                            jsonData = new JSONObject(json);
                            //Toast.makeText(mContext, json, Toast.LENGTH_SHORT).show();
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    web.loadUrl("file:///android_asset/" + url); // url로 페이지 이동
                }
            });
        }

        /* 자바스크립트 함수로 데이터 전송 */
        @JavascriptInterface
        public void getJsonData() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    web.loadUrl("javascript:onCreate('" + jsonData.toString() + "')"); // 해당 url의 자바스크립트 함수 호출
                }
            });
        }

        //----------------------------------------------------------------------------------------------------------------------------------------//
        // TEST 용 함수들
        //----------------------------------------------------------------------------------------------------------------------------------------//

        /*

        /* 뒤로가기
        @JavascriptInterface
        public void onCancelPressed(final String args) {
            Log.d("[JeongjinKim]", "onCancelPressed: start ");
            web.post(new Runnable() {
                @Override
                public void run() {
                    WebBackForwardList list = web.copyBackForwardList(); // 누적된 history 를 저장할 변수
                    Log.d("NGW", "args = [ " + args + " ]");
                    if(args.equals("Y")){
                        web.goBackOrForward(-(list.getCurrentIndex()) + 1);
                    }else if(args.equals("N")) {
                        if (web.canGoBack()) {
                            web.goBack();
                        }
                    }
                    web.clearHistory(); // history 삭제
                }
            });
            Log.d("[JeongjinKim]", "onCancelPressed: end ");
        }


        /* 자바스크립트에서 전송된 데이터 받기
        @JavascriptInterface
        public void receive(String arg) {
            receive = arg;      // 자바스크립트에서 받은 데이터
            //String url = "file:///android_asset/index.html";
        }


        /* 페이지 이동
        @JavascriptInterface
        public void movePage(final String receiveUrl) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //web.loadUrl("file:///android_asset/sub2.html"); // url로 페이지 이동
                    web.loadUrl(receiveUrl); // url로 페이지 이동
                }
            });
        }

        /* 자바스크립트 함수로 데이터 전송
        @JavascriptInterface
        public void sendMessage() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    web.loadUrl("javascript:receive('" + receive + "')"); // 해당 url의 자바스크립트 함수 호출
                }
            });
        }

         */


    }


}
