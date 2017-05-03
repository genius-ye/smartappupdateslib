package com.genius.smartappupdateslib;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * APK Patch工具类
 *
 * @author yuyuhang
 * @date 2016-1-26 下午1:10:40
 */
public class PatchUtils {
    private static final int BUF_SIZE = 8 * 1024;

    static PatchUtils instance;  
          
    public static PatchUtils getInstance() {  
        if (instance == null)  
            instance = new PatchUtils();  
        return instance;  
    }  
          
    static {  
        System.loadLibrary("ApkPatchLibrary");  
    }

    /**
     * native方法 使用路径为oldApkPath的apk与路径为patchPath的补丁包，合成新的apk，并存储于newApkPath
     *
     * 返回：0，说明操作成功
     *
     * @param oldApkPath
     *            示例:/sdcard/old.apk
     * @param newApkPath
     *            示例:/sdcard/new.apk
     * @param patchPath
     *            示例:/sdcard/xx.patch
     * @return
     */
    public native int patch(String oldApkPath, String newApkPath, String patchPath);

    /**
     * 将assets中的patch复制到data/data/patch下
     * @param context
     * @param patchName
     */
    public String copyPatch(Context context, String patchName) {
        File patchInternalStoragePath = new File(context.getDir("patch", Context.MODE_PRIVATE),
                patchName);
        BufferedInputStream bis = null;
        OutputStream patchWriter = null;

        try {
            bis = new BufferedInputStream(context.getAssets().open(patchName));
            patchWriter = new BufferedOutputStream(
                    new FileOutputStream(patchInternalStoragePath));
            byte[] buf = new byte[BUF_SIZE];
            int len;
            while ((len = bis.read(buf, 0, BUF_SIZE)) > 0) {
                patchWriter.write(buf, 0, len);
            }
            patchWriter.close();
            bis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return patchInternalStoragePath.getPath();
    }
}