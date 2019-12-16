package com.wd.doctor.view.activity.myview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * date:2019/12/15
 * author:金豪(Lenovo)
 * function:
 */
public class MyStreaming_View extends ViewGroup {

    private int widthPixels;
    private onTextSetClickListener onTextSetClickListener;

    public MyStreaming_View(final Context context) {
        super(context);
    }

    public MyStreaming_View(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        //屏幕参数
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        //屏幕宽度
        widthPixels = displayMetrics.widthPixels;
    }

    public MyStreaming_View(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //左右间距
    int wSpace = 30;
    //上下间距
    int hSpace = 15;

    @Override
    protected void onLayout(final boolean changed, final int l, final int t, final int r, final int b) {
        int childCount = getChildCount();
        int left = wSpace;
        int top = hSpace;
        int right = 0;
        int bottom = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            //手动测量
            childAt.measure(0, 0);
            //测量的宽度高度
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            //设置right右边的位置   判断是否超出屏幕宽度
            right = left + measuredWidth;
            if (right > widthPixels) {
                left = wSpace;
                right = left + measuredWidth;
                top = bottom + hSpace;
            }
            bottom = top + measuredHeight + hSpace;
            childAt.layout(left, top, right, bottom);
            left = left + measuredWidth + wSpace;
        }
    }

    public void addText(final String msg) {
        TextView tv = new TextView(getContext());
        tv.setText(msg);
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(12);
        //tv.setBackgroundColor(Color.WHITE);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        addView(tv, layoutParams);

        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (onTextSetClickListener != null) {
                    onTextSetClickListener.onSucceed(msg);
                }
            }
        });
    }

    public interface onTextSetClickListener {
        void onSucceed(String msg);
    }

    public void setOnTextSetClickListener(final MyStreaming_View.onTextSetClickListener onTextSetClickListener) {
        this.onTextSetClickListener = onTextSetClickListener;
    }
}
