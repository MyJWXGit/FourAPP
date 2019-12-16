package com.wd.doctor.view.activity.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.wd.doctor.R;

/**
 * date:2019/12/15
 * author:金豪(Lenovo)
 * function:
 */
public class MyEditView extends LinearLayout {
    private EditText edit_query;
    private ImageView image;
    private TextView sousd;
    private onTextAddListener onTextAddListener;

    public MyEditView(final Context context) {
        this(context, null);
    }

    public MyEditView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyEditView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        initArrts(context, attrs);
    }

    private void initArrts(final Context context, final AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyEditView);
        String text_hint = typedArray.getString(R.styleable.MyEditView_hint_text);
        Drawable icon = typedArray.getDrawable(R.styleable.MyEditView_icon);
        int hint_color = typedArray.getColor(R.styleable.MyEditView_hint_color, Color.RED);
        int text_color = typedArray.getColor(R.styleable.MyEditView_text_color, Color.GREEN);
        float text_size = typedArray.getDimension(R.styleable.MyEditView_text_size, 30);
        edit_query.setHint(text_hint);
        edit_query.setHintTextColor(hint_color);
        edit_query.setTextColor(text_color);
        edit_query.setTextSize(text_size);
        image.setImageDrawable(icon);
    }

    private void init(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.edit_layout, this, true);
        edit_query = view.findViewById(R.id.edit_query);
        image = view.findViewById(R.id.image);
        sousd = view.findViewById(R.id.sousd);
        sousd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (onTextAddListener != null) {
                    onTextAddListener.onSucceed(onConText());
                    String trim = edit_query.getText().toString().trim();
                    onTextAddListener.Edtext(trim);
                }
            }
        });

    }

    public String onConText() {
        String edit = edit_query.getText().toString();
        return edit;
    }

    public interface onTextAddListener {
        void onSucceed(String msg);
        void Edtext(String sd);
    }

  /*  public void setOnTextAddListener(final MyEditView.onTextAddListener onTextAddListener) {
        this.onTextAddListener = onTextAddListener;
    }*/

    public void setOnTextAddListener(MyEditView.onTextAddListener onTextAddListener) {
        this.onTextAddListener = onTextAddListener;
    }
}
