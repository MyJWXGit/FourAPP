package com.wd.my_message.utils;

/* Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */

import java.io.File;

import android.content.Context;

public class FileUtil {
    public static File getSaveFile(Context context) {
        File file = new File(context.getFilesDir(), "pic.jpg");
        return file;
    }
}
