package com.jmfinancial.redditdemo.presentation.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.jmfinancial.redditdemo.R;

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context, String fontName) {
        super(context);
        Typeface typeface;
        typeface = SharedInfo.getCustomFontTypeFace(context, fontName);
        this.setTypeface(typeface);

    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray arr = context.obtainStyledAttributes(attrs,
                R.styleable.FontStyle);
        int fontEnum = arr
                .getInt(R.styleable.FontStyle_fontview, 15);

        Typeface typeface;
        String fontName = getFontName(fontEnum);

        typeface = SharedInfo.getCustomFontTypeFace(context, fontName);
        this.setTypeface(typeface);

        arr.recycle();
    }

    public void setFont(Context context, String fontName) {
        Typeface typeface = SharedInfo.getCustomFontTypeFace(context, fontName);
        this.setTypeface(typeface);
    }

    public static String getFontName(int fontEnum) {
        switch (fontEnum) {
            case 0:
                return "poppinsregular.ttf";

            case 1:
                return "poppinsmedium.ttf";

            case 2:
                return "poppinsbold.ttf";
            default:
                return "poppinsregular.ttf";
        }
    }


}
