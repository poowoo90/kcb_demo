package com.example.nam.kcb_demo;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyProgressDialog extends Dialog {

    public static MyProgressDialog show(Context context, CharSequence title,
                                        CharSequence message) {
        return show(context, title, message, false);
    }

    public static MyProgressDialog show(Context context, CharSequence title,
                                        CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, false, null);
    }

    public static MyProgressDialog show(Context context, CharSequence title,
                                        CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }

    public static MyProgressDialog show(Context context, CharSequence title,
                                        CharSequence message, boolean indeterminate,
                                        boolean cancelable, OnCancelListener cancelListener) {
        MyProgressDialog dialog = new MyProgressDialog(context);
        dialog.setTitle(title);
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);

        /* The next line will add the ProgressBar to the dialog. */

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(new ProgressBar(context));

        TextView textView1 = new TextView(context);
        TextView textView2 = new TextView(context);

        textView1.setText("100% MOBILE Banking Platform");
        textView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
        textView1.setGravity(Gravity.CENTER_HORIZONTAL);
        textView1.setTextColor(context.getResources().getColor(R.color.colorAccent));

        textView2.setText("SUNNY BANK");
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        textView2.setTextColor(context.getResources().getColor(R.color.colorAccent));
        textView2.setGravity(Gravity.CENTER_HORIZONTAL);
        textView2.setTypeface(textView2.getTypeface(), Typeface.BOLD);

        // Font 설정
        String NotoSansCJKkr_Bold       = "NotoSansCJKkr_Bold.otf";
        String NotoSansCJKkr_Medum      = "NotoSansCJKkr_Medium.otf";
        String NotoSansCJKkr_Regular    = "NotoSansCJKkr_Regular.otf";
        String Montserrat               = "Montserrat_SemiBold_0.ttf";

        Typeface typeNotoSansCJKkr_Bold     = null;
        Typeface typeNotoSansCJKkr_Medum    = null;
        Typeface typeNotoSansCJKkr_Regular  = null;
        Typeface typeMontserrat       = null;


        typeNotoSansCJKkr_Bold      = Typeface.createFromAsset(context.getAssets(), "fonts/" + NotoSansCJKkr_Bold);
        typeNotoSansCJKkr_Medum     = Typeface.createFromAsset(context.getAssets(), "fonts/" + NotoSansCJKkr_Medum);
        typeNotoSansCJKkr_Regular   = Typeface.createFromAsset(context.getAssets(), "fonts/" + NotoSansCJKkr_Regular);
        typeMontserrat              = Typeface.createFromAsset(context.getAssets(), "fonts/" + Montserrat);

        textView1.setTypeface(typeNotoSansCJKkr_Medum);
        textView2.setTypeface(typeNotoSansCJKkr_Bold);

        linearLayout.addView(textView1);
        linearLayout.addView(textView2);

        dialog.addContentView(linearLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        dialog.show();

        return dialog;
    }


    public MyProgressDialog(Context context) {
        super(context, R.style.NewDialog);
    }
}
