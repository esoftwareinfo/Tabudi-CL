package world.snacks.hub;

import static androidx.lifecycle.Lifecycle.Event.ON_START;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;


public class AppOpenManager_Exclude implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
    private Activity currentActivity;
    private static boolean isShowingAd = false;
    String App_Open_ID = "";
    private final Application myApplication;
    String AC1 = "", AC2 = "", AC3 = "", AC4 = "", AC5 = "";


    public AppOpenManager_Exclude(Application myApplication, String Ac1, String Ac2, String Ac3, String Ac4, String Ac5) {
        this.myApplication = myApplication;

        this.AC1 = Ac1;
        this.AC2 = Ac2;
        this.AC3 = Ac3;
        this.AC4 = Ac4;
        this.AC5 = Ac5;

        this.myApplication.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

    }

    public void showAdIfAvailable() {

            Pizza.AppOpen_Show(currentActivity);

    }

    @OnLifecycleEvent(ON_START)
    public void onStart() {


        Log.e("onStart","onStart");

        Log.e("onStart",""+currentActivity.getLocalClassName());
        Log.e("onStart",""+AC1);
        if ((currentActivity.getLocalClassName()).equals(AC1) ||
                (currentActivity.getLocalClassName()).equals(AC2) ||
                (currentActivity.getLocalClassName()).equals(AC3) ||
                (currentActivity.getLocalClassName()).equals(AC4) ||
                (currentActivity.getLocalClassName()).equals(AC5)) {


        } else {

                showAdIfAvailable();


        }
    }

    @Override
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        Log.e("onActivityPreCreated", "="+activity);
    }
    Activity cu_next;
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.e("onActivityCreated", "="+cu_next);
        cu_next = activity;
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e("onActivityStarted", "="+activity);
        currentActivity = activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        currentActivity = activity;

        Log.e("onActivityResumed", "="+activity);

        if(currentActivity != cu_next){
            if(SharPerf.get_Tappx(activity).equals("1") || SharPerf.get_Tappx(activity).equals("2")){
                if (SharPerf.get_fb_i(activity).equals("id") && SharPerf.get_admob_i1(activity).equals("id")&& SharPerf.get_admob_i2(activity).equals("id")&& SharPerf.get_admob_i3(activity).equals("id") && SharPerf.getAC_Inter(activity).equals("id")) {
                    Log.e("activity","="+activity);
                    Pizza.Interstial_Counted(activity);
                }
            }
        }

    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e("onActivityStopped", "="+activity);

    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.e("onActivityPaused", "="+activity);
        if(SharPerf.get_Tappx(activity).equals("0")){
            if(cu_next != activity){
                if (SharPerf.get_fb_i(activity).equals("id") && SharPerf.get_admob_i1(activity).equals("id")&& SharPerf.get_admob_i2(activity).equals("id")&& SharPerf.get_admob_i3(activity).equals("id") && SharPerf.getAC_Inter(activity).equals("id")) {
                    Pizza.Interstial_Counted(activity);
                }
            }
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        currentActivity = null;
        Log.e("onActivityDestroyed", "="+activity);
    }

}

