package com.jmfinancial.redditdemo.presentation.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

public class SharedInfo {

    private static HashMap<String, Typeface> customFontCache = null;

    public static Typeface getCustomFontTypeFace(Context context,
                                                 String fontName) {
        HashMap<String, Typeface> customFontCache = SharedInfo.customFontCache;

        if (customFontCache == null) {
            customFontCache = new HashMap<>();
            SharedInfo.customFontCache = customFontCache;
        }

        if (customFontCache.containsKey(fontName)) {
            return customFontCache.get(fontName);
        } else {
            Typeface typeFace = Typeface.createFromAsset(context.getAssets(),
                    "fonts/" + fontName);
            customFontCache.put(fontName, typeFace);
            return typeFace;
        }
    }
}
