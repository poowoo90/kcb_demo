package com.example.nam.kcb_demo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by JH on 2018-01-31.
 */

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
        textView1.setText("100% 모바일 금융플랫폼");
        textView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        textView1.setGravity(Gravity.CENTER_HORIZONTAL);
        textView1.setTextColor(context.getResources().getColor(R.color.colorAccent));

        textView2.setText("SUNNY BANK");
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 32);
        textView2.setTextColor(context.getResources().getColor(R.color.colorAccent));
        textView2.setGravity(Gravity.CENTER_HORIZONTAL);
        textView2.setTypeface(textView2.getTypeface(), Typeface.BOLD);

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
