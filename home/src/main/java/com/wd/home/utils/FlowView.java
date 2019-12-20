package com.wd.home.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @name Health
 * @class name：com.wd.home.utils
 * @class describe
 * @anthor 24673
 * @time 2019/12/20 14:17
 * @change
 * @chang time
 * @class describe
 */
public class FlowView extends ViewGroup {
    public FlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 10;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            view.layout(0, top, measuredWidth, top + measuredHeight);
            top += measuredHeight;
        }
    }
}
