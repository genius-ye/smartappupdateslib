# smartappupdateslib
android增量更新库
使用方法：
```java
    //新包保存的位置
    String newApk = App.CACHE_PATH + File.separator + updateInfo.getVersion()+".apk";
    int i = PatchUtils.getInstance().patch(ApkUtils.getSourceApkPath(mContext,"包名"),newApk,"patch增量包地址");
    if(i ==  0)
    {
        ApkUtils.installApk(mContext,newApk);
        Logger.d("合成成功");
    }
```
