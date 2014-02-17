package com.wedy.poboxinputh;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class NotificationiconPatcher implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.sonyericsson.android.pobox")) {
            ClassLoader classLoader = lpparam.classLoader;
            XC_MethodReplacement methodreplacer = new XC_MethodReplacement() {
                protected Object replaceHookedMethod(
                        XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam)
                        throws Throwable {
                    return null;
                }
            };
            XposedHelpers.findAndHookMethod("com.sonyericsson.android.pobox.core.DefaultSoftKeyboardJAJP",
                    classLoader, "setStatusIcon", methodreplacer);
        }
    }

}