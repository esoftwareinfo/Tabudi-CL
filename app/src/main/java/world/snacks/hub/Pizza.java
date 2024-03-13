package world.snacks.hub;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBanners;
import com.unity3d.services.banners.view.BannerPosition;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Pizza {

    public static String show_ads = "1";
    public static String splash_anim = "0";
    public static String counter_ads = "3";
    public static String splesh_ads = "1";
    public static String fb_b = "id";
    public static String fb_mr = "id";
    public static String fb_i = "id";
    public static String fb_n = "id";
    public static String fb_ns = "id";

    public static String GL_Setup_Ads = "L";


    public static String admob_i1 = "id";
    public static String admob_i11 = "id";
    public static String admob_i2 = "id";
    public static String admob_i22 = "id";
    public static String admob_i3 = "id";
    public static String admob_i33 = "id";

    public static String admob_b1 = "id";
    public static String admob_b11 = "id";
    public static String admob_b2 = "id";
    public static String admob_b22 = "id";
    public static String admob_b3 = "id";
    public static String admob_b33 = "id";

    public static String admob_n1 = "id";
    public static String admob_n11 = "id";
    public static String admob_n2 = "id";
    public static String admob_n22 = "id";
    public static String admob_n3 = "id";
    public static String admob_n33 = "id";


    public static String ac_App = "id";
    public static String ac_Inter = "id";
    public static String ac_Banner = "id";
    public static String Ac_Reward = "id";


    public static String admob_ao = "id";
    public static String i_nooff = "1";
    public static String b_nooff = "1";
    public static String n_nooff = "1";
    public static String ao_ads = "1";
    public static String b_n_ex = "0";
    public static String only_fb_inter = "0";


    public static String tappx = "id";

    public static String increase_ads = "1";
    public static String for_Approval = "0";
    public static String Native_custom = "0";

    public static int counter_ads_tot = 3;

    public static String Extra1 = "0";
    public static String Extra2 = "0";
    public static String Extra3 = "0";
    public static String Extra4 = "0";
    public static String Extra5 = "0";

    public static String BGColor1 = "#292929";
    public static String TitleTextColor1 = "#ffffff";
    public static String DescriptionTextColor1 = "#b3b3b3";
    public static String ButtonColor1 = "#474747";
    public static String ButtonTextColor1 = "#ffffff";
    public static String ButtonBorderColor1 = "#ffffff";

    public static String Exit_Pop_Setup = "0";

    public static int BGColor = Color.parseColor(BGColor1);
    public static int TitleTextColor = Color.parseColor(TitleTextColor1);
    public static int DescriptionTextColor = Color.parseColor(DescriptionTextColor1);
    public static int ButtonColor = Color.parseColor(ButtonColor1);
    public static int ButtonTextColor = Color.parseColor(ButtonTextColor1);
    public static int ButtonBorderColor = Color.parseColor(ButtonBorderColor1);

    public static String Link_URL = "";

    public static Context code_context;


    public static OnSpleshJsonCallBackListner splesh_callbck;

    public static ArrayList<String> Google_SetUp_List_Custom = new ArrayList<>(Arrays.asList("L"));

    public static ArrayList<Ads_Data> Ads_Data_List = new ArrayList<Ads_Data>();

    public Pizza(Context context, OnJsonCallBackListner onJsonCallBack, String App_Name1, String Ads_Link1, String Package, int show_ads1, int FB_setup_ads1, String GL_setup_ads1, int splesh_ads1, int increase_ads1, String splash_anim1, String FB_Banner11, String FB_Banner22, String FB_Banner33, String FB_Banner44, String FB_Banner55, String FB_MR11, String FB_MR22, String FB_MR33, String FB_MR44, String FB_MR55, String FB_Inter11, String FB_Inter22, String FB_Inter33, String FB_Inter44, String FB_Inter55, String FB_Native11, String FB_Native22, String FB_Native33, String FB_Native44, String FB_Native55, String FB_NativeSmall11, String FB_NativeSmall22, String FB_NativeSmall33, String FB_NativeSmall44, String FB_NativeSmall55, String AC_App_ID1, String AC_Inter_ID1, String AC_Banner_ID1, String AC_Reward_ID1, String Tappx1, String Admob_App_ID1, String Admob_Inter_ID_1, String Admob_Inter_ID_11, String Admob_Inter_ID_2, String Admob_Inter_ID_22, String Admob_Inter_ID_3, String Admob_Inter_ID_33, String Admob_Banner_ID_1, String Admob_Banner_ID_11, String Admob_Banner_ID_2, String Admob_Banner_ID_22, String Admob_Banner_ID_3, String Admob_Banner_ID_33, String Admob_Native_ID_1, String Admob_Native_ID_11, String Admob_Native_ID_2, String Admob_Native_ID_22, String Admob_Native_ID_3, String Admob_Native_ID_33, String Admob_AppOpen_ID_1, String Admob_AppOpen_ID_11, String Admob_AppOpen_ID_2, String Admob_AppOpen_ID_22, String Admob_AppOpen_ID_3, String Admob_AppOpen_ID_33, String Admob_rvi_id_ID1, String Admob_rvi_id_ID11, String Admob_rvi_id_ID2, String Admob_rvi_id_ID22, String Admob_rvi_id_ID3, String Admob_rvi_id_ID33

    ) {


        Link_URL = Ads_Link1;
        onJsonCallBackListner = onJsonCallBack;
        code_context = context;
        show_ads = "" + show_ads1;
        splesh_ads = "" + splesh_ads1;
        fb_b = FB_Banner11;
        fb_mr = FB_MR11;
        fb_i = FB_Inter11;
        fb_n = FB_Native11;
        fb_ns = FB_NativeSmall11;
        admob_i1 = Admob_Inter_ID_1;
        admob_i11 = Admob_Inter_ID_11;
        admob_i2 = Admob_Inter_ID_2;
        admob_i22 = Admob_Inter_ID_22;
        admob_i3 = Admob_Inter_ID_3;
        admob_i33 = Admob_Inter_ID_33;

        admob_b1 = Admob_Banner_ID_1;
        admob_b11 = Admob_Banner_ID_11;
        admob_b2 = Admob_Banner_ID_2;
        admob_b22 = Admob_Banner_ID_22;
        admob_b3 = Admob_Banner_ID_3;
        admob_b33 = Admob_Banner_ID_33;

        admob_n1 = Admob_Native_ID_1;
        admob_n11 = Admob_Native_ID_11;
        admob_n2 = Admob_Native_ID_2;
        admob_n22 = Admob_Native_ID_22;
        admob_n3 = Admob_Native_ID_3;
        admob_n33 = Admob_Native_ID_33;

        admob_ao = Admob_AppOpen_ID_1;


        ac_App = AC_App_ID1;
        ac_Inter = AC_Inter_ID1;
        ac_Banner = AC_Banner_ID1;
        Ac_Reward = AC_Reward_ID1;

        tappx = Tappx1;

        splash_anim = splash_anim1;

        if (SharPerf.get_dwnld(code_context) == 0) {

            Count_Download(code_context.getPackageName());

            SharPerf.set_dwnld(code_context, 1);
        }

        if (SharPerf.getFirst_ads(code_context) == 0) {

            SharPerf.set_show_ads(code_context, show_ads);
            SharPerf.set_counter_ads(code_context, counter_ads);
            SharPerf.set_splesh_ads(code_context, splesh_ads);
            SharPerf.set_fb_b(code_context, fb_b);
            SharPerf.set_fb_mr(code_context, fb_mr);
            SharPerf.set_fb_i(code_context, fb_i);
            SharPerf.set_fb_n(code_context, fb_n);
            SharPerf.set_fb_ns(code_context, fb_ns);

            SharPerf.set_admob_i1(code_context, admob_i1);
            SharPerf.set_admob_i11(code_context, admob_i11);
            SharPerf.set_admob_i2(code_context, admob_i2);
            SharPerf.set_admob_i2(code_context, admob_i22);
            SharPerf.set_admob_i3(code_context, admob_i3);
            SharPerf.set_admob_i33(code_context, admob_i33);


            SharPerf.set_admob_b1(code_context, admob_b1);
            SharPerf.set_admob_b11(code_context, admob_b11);
            SharPerf.set_admob_b2(code_context, admob_b2);
            SharPerf.set_admob_b22(code_context, admob_b22);
            SharPerf.set_admob_b3(code_context, admob_b3);
            SharPerf.set_admob_b33(code_context, admob_b33);

            SharPerf.set_admob_n1(code_context, admob_n1);
            SharPerf.set_admob_n11(code_context, admob_n11);
            SharPerf.set_admob_n2(code_context, admob_n2);
            SharPerf.set_admob_n22(code_context, admob_n22);
            SharPerf.set_admob_n3(code_context, admob_n3);
            SharPerf.set_admob_n33(code_context, admob_n33);

            SharPerf.set_Tappx(code_context, tappx);


            SharPerf.set_admob_ao(code_context, admob_ao);


            SharPerf.setAC_App(code_context, ac_App);
            SharPerf.setAC_Inter(code_context, ac_Inter);
            SharPerf.setAC_Banner(code_context, ac_Banner);
            SharPerf.setAC_Reward(code_context, Ac_Reward);

            SharPerf.setsplash_anim(code_context, splash_anim);
            SharPerf.setIncrease_Ads(code_context, increase_ads);
            SharPerf.setFor_Approval(code_context, for_Approval);

            SharPerf.setFirst_ads(code_context, 1);

        }

    }


    public Pizza(Context context, OnJsonCallBackListner onJsonCallBack, String App_Name1, String Ads_Link1) {


        Link_URL = Ads_Link1;
        onJsonCallBackListner = onJsonCallBack;
        code_context = context;
        show_ads = "" + 0;
        splesh_ads = "" + 0;
        fb_b = "id";
        fb_mr = "id";
        fb_i = "id";
        fb_n = "id";
        fb_ns = "id";
        admob_i1 = "id";
        admob_i11 = "id";
        admob_i2 = "id";
        admob_i22 = "id";
        admob_i3 = "id";
        admob_i33 = "id";

        admob_b1 = "id";
        admob_b11 = "id";
        admob_b2 = "id";
        admob_b22 = "id";
        admob_b3 = "id";
        admob_b33 = "id";

        admob_n1 = "id";
        admob_n11 = "id";
        admob_n2 = "id";
        admob_n22 = "id";
        admob_n3 = "id";
        admob_n33 = "id";

        admob_ao = "id";


        ac_App = "id";
        ac_Inter = "id";
        ac_Banner = "id";
        Ac_Reward = "id";

        tappx = "id";

        splash_anim = "0";

        if (SharPerf.get_dwnld(code_context) == 0) {

            Count_Download(code_context.getPackageName());

            SharPerf.set_dwnld(code_context, 1);
        }

        if (SharPerf.getFirst_ads(code_context) == 0) {

            SharPerf.set_show_ads(code_context, show_ads);
            SharPerf.set_counter_ads(code_context, counter_ads);
            SharPerf.set_splesh_ads(code_context, splesh_ads);
            SharPerf.set_fb_b(code_context, fb_b);
            SharPerf.set_fb_mr(code_context, fb_mr);
            SharPerf.set_fb_i(code_context, fb_i);
            SharPerf.set_fb_n(code_context, fb_n);
            SharPerf.set_fb_ns(code_context, fb_ns);

            SharPerf.set_admob_i1(code_context, admob_i1);
            SharPerf.set_admob_i11(code_context, admob_i11);
            SharPerf.set_admob_i2(code_context, admob_i2);
            SharPerf.set_admob_i2(code_context, admob_i22);
            SharPerf.set_admob_i3(code_context, admob_i3);
            SharPerf.set_admob_i33(code_context, admob_i33);


            SharPerf.set_admob_b1(code_context, admob_b1);
            SharPerf.set_admob_b11(code_context, admob_b11);
            SharPerf.set_admob_b2(code_context, admob_b2);
            SharPerf.set_admob_b22(code_context, admob_b22);
            SharPerf.set_admob_b3(code_context, admob_b3);
            SharPerf.set_admob_b33(code_context, admob_b33);

            SharPerf.set_admob_n1(code_context, admob_n1);
            SharPerf.set_admob_n11(code_context, admob_n11);
            SharPerf.set_admob_n2(code_context, admob_n2);
            SharPerf.set_admob_n22(code_context, admob_n22);
            SharPerf.set_admob_n3(code_context, admob_n3);
            SharPerf.set_admob_n33(code_context, admob_n33);

            SharPerf.set_Tappx(code_context, tappx);


            SharPerf.set_admob_ao(code_context, admob_ao);


            SharPerf.setAC_App(code_context, ac_App);
            SharPerf.setAC_Inter(code_context, ac_Inter);
            SharPerf.setAC_Banner(code_context, ac_Banner);
            SharPerf.setAC_Reward(code_context, Ac_Reward);

            SharPerf.setsplash_anim(code_context, splash_anim);
            SharPerf.setIncrease_Ads(code_context, increase_ads);
            SharPerf.setFor_Approval(code_context, for_Approval);

            SharPerf.setFirst_ads(code_context, 1);

        }

    }

    public static Handler handler_splesh_counter;
    public static Runnable runnable_splesh_counter;
    public static Boolean Splesh_Timer = false;
    public static int Loading_Data = 999;
    public static int Text_Color_main = Color.RED;

    public static ConsentInformation consentInformation;
    public static ConsentForm consentForm;
    public static int app_iocn;

    public static void Splesh_Screen(Context ads_context, int Text_Color, int icLauncher, String App_Name, String splesh_anim2) {

        app_iocn = icLauncher;
        Text_Color_main = Text_Color;
        try {
            splash_anim = splesh_anim2;

            if (SharPerf.getFirst_ads_splesh(code_context) == 0) {

                SharPerf.setsplash_anim(code_context, splash_anim);

                SharPerf.setFirst_ads_splesh(code_context, 1);
            }

            splash_anim = SharPerf.getsplash_anim(code_context);

            if (isNetworkConnected(ads_context)) {


                int width = 480, Height = 800;
                final Dialog builder = new Dialog(ads_context);
                builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
                builder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                builder.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(builder.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;

                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    }
                });

                DisplayMetrics displayMetrics = new DisplayMetrics();
                builder.getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

                width = displayMetrics.widthPixels;
                Height = displayMetrics.heightPixels;

                float[] hsv = new float[3];
                int color = Text_Color;
                Color.colorToHSV(color, hsv);
                hsv[2] *= 0.175f;
                color = Color.HSVToColor(hsv);


                final RelativeLayout RL = new RelativeLayout(ads_context);

                int colorFrom = ads_context.getResources().getColor(R.color.black);
                int colorTo = color;
                @SuppressLint("RestrictedApi") ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(2000);
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        RL.setBackgroundColor((int) animator.getAnimatedValue());
                    }

                });
                colorAnimation.start();

                RL.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
                builder.addContentView(RL, new RelativeLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));

                ImageView imageView = new ImageView(ads_context);
                imageView.setImageResource(icLauncher);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                int image_paadding = ((int) (width / 5));
                imageView.setPadding(image_paadding, image_paadding, image_paadding, image_paadding);
                imageView.setTranslationY(-(int) (Height / 7));
                builder.addContentView(imageView, new RelativeLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));


                TextView theText = new TextView(ads_context);
                theText.setText("" + App_Name);
                theText.setTextColor(Text_Color);
                theText.setTypeface(Typeface.DEFAULT_BOLD);
                theText.setTextSize((int) (Height / (width / 9)));
                theText.setTranslationY(-(int) (Height / 5.5));

                theText.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
                builder.addContentView(theText, new RelativeLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));

                ProgressBar progressBar = new ProgressBar(ads_context);

                progressBar.getIndeterminateDrawable().setColorFilter(Text_Color, android.graphics.PorterDuff.Mode.MULTIPLY);

                int progressBar_padding = ((int) (width / 2.5));
                progressBar.setPadding(progressBar_padding, progressBar_padding, progressBar_padding, progressBar_padding);
                progressBar.setTranslationY((float) ((Height) / 2.5));
                builder.addContentView(progressBar, new RelativeLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));

                try {
                    builder.show();

                } catch (Exception e) {

                }

                builder.getWindow().setAttributes(lp);
                builder.setCancelable(false);

                Splesh_Timer = false;

                handler_splesh_counter = new Handler();
                runnable_splesh_counter = new Runnable() {
                    public void run() {
                        Splesh_Timer = true;
                        try {
                            if (builder.isShowing()) {
                                builder.dismiss();
                            }
                        } catch (final IllegalArgumentException e) {
                        } catch (final Exception e) {
                        } finally {

                        }
                        Interstial_Load(ads_context);
                    }
                };
                handler_splesh_counter.postDelayed(runnable_splesh_counter, 15000);
                splesh_callbck = new OnSpleshJsonCallBackListner() {
                    @Override
                    public void OnSpleshJsonDone() {
                        Log.e("cccc", "OnSpleshJsonDone");
                        try {
                            if (show_ads == "0") {
                                try {
                                    if (builder.isShowing()) {
                                        builder.dismiss();
                                    }
                                } catch (final IllegalArgumentException e) {

                                } catch (final Exception e) {
                                } finally {

                                }
                            } else {


                                loadSplashAd(builder, ads_context);


                            }
                        } catch (Exception e) {

                        }

                    }
                };

                new GetData().execute();

            } else {
                error("No internet");

            }


        } catch (Exception e) {

        }


    }

    public static void loadSplashAd(Dialog builder, Context ads_context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (SharPerf.get_admob_i3(ads_context).equals("id")) {
                    Splash_Interstial(builder, ads_context);
                } else {
                    if (SharPerf.getGdper_First(code_context).equals("0")) { //for load form for first time only
                        concentFormLoading(builder, ads_context);
                    } else {
                        Splash_Interstial(builder, ads_context);

                    }
                }

            }


        }, 1000);
    }

    public static void concentFormLoading(Dialog builder, Context ads_context) {
        Log.e("TAG", "concentFormLoading: " + "====");
        ConsentRequestParameters params = new ConsentRequestParameters.Builder().setTagForUnderAgeOfConsent(false).build();
        consentInformation = UserMessagingPlatform.getConsentInformation(code_context);
        consentInformation.requestConsentInfoUpdate((Activity) code_context, params,
                new ConsentInformation.OnConsentInfoUpdateSuccessListener() {
                    @Override
                    public void onConsentInfoUpdateSuccess() {
                        Log.e("============", "onConsentInfoUpdateSuccess ===: ");
                        // The consent information state was updated.
                        // You are now ready to check if a form is available.
                        if (consentInformation.isConsentFormAvailable()) {

                            Log.e("============", "onConsentInfoUpdateSuccess: ");
                            loadForm(builder, ads_context);
                        } else {

                            Splash_Interstial(builder, ads_context);
                        }
                    }
                },
                new ConsentInformation.OnConsentInfoUpdateFailureListener() {
                    @Override
                    public void onConsentInfoUpdateFailure(FormError formError) {
                        Log.e("=============", "onConsentInfoUpdateFailure: " + formError.getMessage());
                        Splash_Interstial(builder, ads_context);
                        // Handle the error.
                    }
                });
        //        consentInformation.reset();
    }

    public static void loadForm(Dialog builder, Context ads_context) {
        // Loads a consent form. Must be called on the main thread.
        UserMessagingPlatform.loadConsentForm(
                code_context,
                new UserMessagingPlatform.OnConsentFormLoadSuccessListener() {
                    @Override
                    public void onConsentFormLoadSuccess(ConsentForm consentForm) {
                        if (consentInformation.getConsentStatus() == ConsentInformation.ConsentStatus.REQUIRED) {
                            consentForm.show((Activity) code_context, new ConsentForm.OnConsentFormDismissedListener() {
                                @Override
                                public void onConsentFormDismissed(@Nullable FormError formError) {
                                    if (consentInformation.getConsentStatus() == ConsentInformation.ConsentStatus.OBTAINED) {
                                        SharedPreferences praf = PreferenceManager.getDefaultSharedPreferences(code_context);
                                        Log.e("TAG===", "Ads_Common_Class: " + praf.getString("IABTCF_PurposeConsents", "null"));


                                        SharPerf.setGdper_First(code_context, "1");
                                        if (consentInformation.canRequestAds()) {
                                            Splash_Interstial(builder, ads_context);
                                        }
                                    }
                                    loadForm(builder, ads_context);
                                }
                            });
                        }
                    }
                },
                new UserMessagingPlatform.OnConsentFormLoadFailureListener() {
                    @Override
                    public void onConsentFormLoadFailure(FormError formError) {
                        // Handle Error.
                        Splash_Interstial(builder, ads_context);
                    }
                }
        );
    }


    public static ConsentInformation consentInformation1;


    public static void setConsentDailog(Context context_gdpr) {
        consentInformation1 = UserMessagingPlatform.getConsentInformation(context_gdpr);

        ConsentRequestParameters params = new ConsentRequestParameters
                .Builder()
                .setTagForUnderAgeOfConsent(false)
                .build();
        consentInformation1.requestConsentInfoUpdate(
                (Activity) context_gdpr,
                params,
                (ConsentInformation.OnConsentInfoUpdateSuccessListener) () -> {
                    // TODO: Load and show the consent form.

                    UserMessagingPlatform.loadAndShowConsentFormIfRequired(
                            (Activity) context_gdpr,
                            (ConsentForm.OnConsentFormDismissedListener) loadAndShowError -> {
                                if (loadAndShowError != null) {

                                    // Consent gathering failed.
                                    if (consentInformation1.canRequestAds()) {
                                    }
                                }

                                // Consent has been gathered.
                            }
                    );
                },
                (ConsentInformation.OnConsentInfoUpdateFailureListener) requestConsentError -> {
                    Log.w("TAG", String.format("%s: %s",
                            requestConsentError.getErrorCode(),
                            requestConsentError.getMessage()));

                });
    }


    static public void ResetConsentDailog(Context context_gdpr, Class dfd) {
        UserMessagingPlatform.showPrivacyOptionsForm((Activity) context_gdpr, (error) -> {

            if (error != null) {

                Toast.makeText(context_gdpr, error.getMessage(), Toast.LENGTH_SHORT).show();

                Log.w("TAG", String.format("%s: %s",
                        error.getErrorCode(),
                        error.getMessage()));
            } else {
                Intent i = new Intent(context_gdpr, dfd);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                context_gdpr.startActivity(i);
            }
        });
    }


    static OnJsonCallBackListner onJsonCallBackListner;

    public static class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            try {
                HttpHandler sh = new HttpHandler();
                String jsonStr = sh.makeServiceCall("" + Link_URL);

                if (jsonStr != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);

                        JSONArray contacts = jsonObj.getJSONArray("" + code_context.getPackageName());
                        for (int i = 0; i < contacts.length(); i++) {
                            JSONObject c = contacts.getJSONObject(i);

                            show_ads = c.getString("show_ads");
                            Exit_Pop_Setup = c.getString("exit_pop");
                            counter_ads = c.getString("counter_ads");
                            splesh_ads = c.getString("splesh_ads");
                            fb_b = c.getString("fb_b1");
                            fb_mr = c.getString("fb_mr1");
                            fb_i = c.getString("fb_i1");
                            fb_n = c.getString("fb_n1");
                            fb_ns = c.getString("fb_ns1");

                            GL_Setup_Ads = c.getString("GL_setup_ads");

                            admob_i1 = c.getString("admob_i1");
                            admob_i11 = c.getString("admob_i11");
                            admob_i2 = c.getString("admob_i2");
                            admob_i22 = c.getString("admob_i22");
                            admob_i3 = c.getString("admob_i3");
                            admob_i33 = c.getString("admob_i33");

                            admob_b1 = c.getString("admob_b1");
                            admob_b11 = c.getString("admob_b11");
                            admob_b2 = c.getString("admob_b2");
                            admob_b22 = c.getString("admob_b22");
                            admob_b3 = c.getString("admob_b3");
                            admob_b33 = c.getString("admob_b33");


                            admob_n1 = c.getString("admob_n1");
                            admob_n11 = c.getString("admob_n11");
                            admob_n2 = c.getString("admob_n2");
                            admob_n22 = c.getString("admob_n22");
                            admob_n3 = c.getString("admob_n3");
                            admob_n33 = c.getString("admob_n33");
                            admob_ao = c.getString("admob_ao1");
                            tappx = c.getString("tappx");


                            ac_App = c.getString("ac_app");
                            SharPerf.setAC_App(code_context, ac_App);
                            ac_Banner = c.getString("ac_b");
                            SharPerf.setAC_Banner(code_context, ac_Banner);
                            ac_Inter = c.getString("ac_i");
                            SharPerf.setAC_Inter(code_context, ac_Inter);
                            Ac_Reward = c.getString("ac_r");
                            SharPerf.setAC_Reward(code_context, Ac_Reward);


                            splash_anim = c.getString("splash_anim");

                            i_nooff = c.getString("i_nooff");
                            b_nooff = c.getString("b_nooff");
                            n_nooff = c.getString("n_nooff");
                            b_n_ex = c.getString("b_n_ex");

                            increase_ads = c.getString("increase_ads");
                            for_Approval = c.getString("for_Approval");
                            ao_ads = c.getString("ao_ads");
                            Native_custom = c.getString("Native_custom");

                            only_fb_inter = c.getString("only_fb_inter");

                            BGColor = Color.parseColor(c.getString("BGColor"));
                            TitleTextColor = Color.parseColor(c.getString("TitleTextColor"));
                            DescriptionTextColor = Color.parseColor(c.getString("DescriptionTextColor"));
                            ButtonColor = Color.parseColor(c.getString("ButtonColor"));
                            ButtonTextColor = Color.parseColor(c.getString("ButtonTextColor"));
                            ButtonBorderColor = Color.parseColor(c.getString("ButtonBorderColor"));


                            Extra1 = c.getString("ex1");
                            Extra2 = c.getString("ex2");
                            Extra3 = c.getString("ex3");
                            Extra4 = c.getString("ex4");
                            Extra5 = c.getString("ex5");

                            SharPerf.set_show_ads(code_context, show_ads);
                            SharPerf.setExit_Pop(code_context, Exit_Pop_Setup);

                            SharPerf.set_counter_ads(code_context, counter_ads);
                            SharPerf.set_splesh_ads(code_context, splesh_ads);
                            SharPerf.set_fb_b(code_context, fb_b);
                            SharPerf.set_fb_mr(code_context, fb_mr);
                            SharPerf.set_fb_i(code_context, fb_i);
                            SharPerf.set_fb_n(code_context, fb_n);
                            SharPerf.set_fb_ns(code_context, fb_ns);

                            SharPerf.setonly_fb_inter(code_context, only_fb_inter);


                            SharPerf.setGL_Setup_Ads(code_context, GL_Setup_Ads);

                            SharPerf.set_admob_i1(code_context, admob_i1);
                            SharPerf.set_admob_i11(code_context, admob_i11);
                            SharPerf.set_admob_i2(code_context, admob_i2);
                            SharPerf.set_admob_i22(code_context, admob_i22);
                            SharPerf.set_admob_i3(code_context, admob_i3);
                            SharPerf.set_admob_i33(code_context, admob_i33);


                            SharPerf.set_admob_b1(code_context, admob_b1);
                            SharPerf.set_admob_b11(code_context, admob_b11);
                            SharPerf.set_admob_b2(code_context, admob_b2);
                            SharPerf.set_admob_b22(code_context, admob_b22);
                            SharPerf.set_admob_b3(code_context, admob_b3);
                            SharPerf.set_admob_b33(code_context, admob_b33);

                            SharPerf.set_admob_n1(code_context, admob_n1);
                            SharPerf.set_admob_n11(code_context, admob_n11);
                            SharPerf.set_admob_n2(code_context, admob_n2);
                            SharPerf.set_admob_n22(code_context, admob_n22);
                            SharPerf.set_admob_n3(code_context, admob_n3);
                            SharPerf.set_admob_n33(code_context, admob_n33);


                            SharPerf.set_Tappx(code_context, tappx);


                            SharPerf.set_admob_ao(code_context, admob_ao);

                            SharPerf.setNative_custom(code_context, Native_custom);

                            SharPerf.seti_nooff(code_context, i_nooff);
                            SharPerf.setb_nooff(code_context, b_nooff);
                            SharPerf.setn_nooff(code_context, n_nooff);
                            SharPerf.setb_n_ex(code_context, b_n_ex);

                            SharPerf.setFor_Approval(code_context, for_Approval);
                            SharPerf.setIncrease_Ads(code_context, increase_ads);

                            SharPerf.setAO_Setup(code_context, ao_ads);

                            SharPerf.setBGColor(code_context, c.getString("BGColor"));
                            SharPerf.setTitleTextColor(code_context, c.getString("TitleTextColor"));
                            SharPerf.setDescriptionTextColor(code_context, c.getString("DescriptionTextColor"));
                            SharPerf.setButtonColor(code_context, c.getString("ButtonColor"));
                            SharPerf.setButtonTextColor(code_context, c.getString("ButtonTextColor"));
                            SharPerf.setButtonBorderColor(code_context, c.getString("ButtonBorderColor"));


                            SharPerf.setExtra1(code_context, Extra1);
                            SharPerf.setExtra2(code_context, Extra2);
                            SharPerf.setExtra3(code_context, Extra3);
                            SharPerf.setExtra4(code_context, Extra4);
                            SharPerf.setExtra5(code_context, Extra5);

                            Log.e("json = ", "done");

                        }
                        Google_SetUp_List_Custom = new ArrayList<>();
                        for (int p = 0; p < GL_Setup_Ads.length(); p++) {
                            Google_SetUp_List_Custom.add("" + GL_Setup_Ads.charAt(p));
                        }


                        if(!splash_anim.equals("id")){
                            Ads_Data_List = new ArrayList<Ads_Data>();

                            HttpHandler sh1 = new HttpHandler();
                            String jsonStr1 = sh1.makeServiceCall("" + splash_anim);
                            JSONObject jsonObj1 = new JSONObject(jsonStr1);
                            JSONArray contacts1 = jsonObj1.getJSONArray("ads");
                            for (int i = 0; i < contacts1.length(); i++) {
                                JSONObject jsonObject = contacts1.getJSONObject(i);
                                String ad_tiltle = jsonObject.optString("ad_tiltle").toString();
                                String ad_sub_tiltle = jsonObject.optString("ad_sub_tiltle").toString();
                                String ad_icon_link = jsonObject.optString("ad_icon_link").toString();
                                String ad_banner_link = jsonObject.optString("ad_banner_link").toString();
                                String ad_native_link = jsonObject.optString("ad_native_link").toString();
                                String ad_btn_text = jsonObject.optString("ad_btn_text").toString();
                                String ad_inter_link = jsonObject.optString("ad_inter_link").toString();

                                String ad_link = jsonObject.optString("ad_link").toString();
                                Ads_Data_List.add(new Ads_Data(ad_tiltle, ad_sub_tiltle, ad_icon_link, ad_banner_link, ad_native_link, ad_inter_link, ad_btn_text, ad_link));
                            }
                        }


                        Loading_Data = 1;
                    } catch (final JSONException e) {
                        error(e.getMessage());

                    }
                } else {
                    error("null json");
                }

                return null;


            } catch (Exception e) {

                Log.e("json error", "=" + e);

            }
            return null;

        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);


            onJsonCallBackListner.OnJsonDone();
            splesh_callbck.OnSpleshJsonDone();
            counter_ads_tot = Integer.parseInt(SharPerf.get_counter_ads(code_context));


        }

    }

    public static void error(String error) {
        Log.e("json error = ", error);
        try {
            show_ads = SharPerf.get_show_ads(code_context);
            Exit_Pop_Setup = SharPerf.getExit_Pop(code_context);
            counter_ads = SharPerf.get_counter_ads(code_context);
            splesh_ads = SharPerf.get_splesh_ads(code_context);
            fb_b = SharPerf.get_fb_b(code_context);
            fb_mr = SharPerf.get_fb_mr(code_context);
            fb_i = SharPerf.get_fb_i(code_context);
            fb_n = SharPerf.get_fb_n(code_context);
            fb_ns = SharPerf.get_fb_ns(code_context);


            GL_Setup_Ads = SharPerf.getGL_Setup_Ads(code_context);


            admob_i1 = SharPerf.get_admob_i1(code_context);
            admob_i11 = SharPerf.get_admob_i11(code_context);
            admob_i2 = SharPerf.get_admob_i2(code_context);
            admob_i22 = SharPerf.get_admob_i22(code_context);
            admob_i3 = SharPerf.get_admob_i3(code_context);
            admob_i33 = SharPerf.get_admob_i33(code_context);


            admob_b1 = SharPerf.get_admob_b1(code_context);
            admob_b11 = SharPerf.get_admob_b11(code_context);
            admob_b2 = SharPerf.get_admob_b2(code_context);
            admob_b22 = SharPerf.get_admob_b22(code_context);
            admob_b3 = SharPerf.get_admob_b3(code_context);
            admob_b33 = SharPerf.get_admob_b33(code_context);


            admob_n1 = SharPerf.get_admob_n1(code_context);
            admob_n11 = SharPerf.get_admob_n11(code_context);
            admob_n2 = SharPerf.get_admob_n2(code_context);
            admob_n22 = SharPerf.get_admob_n22(code_context);
            admob_n3 = SharPerf.get_admob_n3(code_context);
            admob_n33 = SharPerf.get_admob_n33(code_context);


            admob_ao = SharPerf.get_admob_ao(code_context);

            ac_App = SharPerf.getAC_App(code_context);
            ac_Banner = SharPerf.getAC_Banner(code_context);
            ac_Inter = SharPerf.getAC_Inter(code_context);
            Ac_Reward = SharPerf.getAC_Reward(code_context);


            tappx = SharPerf.get_Tappx(code_context);


            i_nooff = SharPerf.geti_nooff(code_context);
            b_nooff = SharPerf.getb_nooff(code_context);
            n_nooff = SharPerf.getn_nooff(code_context);
            b_n_ex = SharPerf.getb_n_ex(code_context);
            increase_ads = SharPerf.getIncrease_Ads(code_context);
            for_Approval = SharPerf.getFor_Approval(code_context);
            ao_ads = SharPerf.getAO_Setup(code_context);
            Native_custom = SharPerf.getNative_custom(code_context);
            only_fb_inter = SharPerf.getonly_fb_inter(code_context);

            BGColor = Color.parseColor(SharPerf.getBGColor(code_context));
            TitleTextColor = Color.parseColor(SharPerf.getTitleTextColor(code_context));
            DescriptionTextColor = Color.parseColor(SharPerf.getDescriptionTextColor(code_context));
            ButtonColor = Color.parseColor(SharPerf.getButtonColor(code_context));
            ButtonTextColor = Color.parseColor(SharPerf.getButtonTextColor(code_context));
            ButtonBorderColor = Color.parseColor(SharPerf.getButtonBorderColor(code_context));

            Extra1 = SharPerf.getExtra1(code_context);
            Extra2 = SharPerf.getExtra2(code_context);
            Extra3 = SharPerf.getExtra3(code_context);
            Extra4 = SharPerf.getExtra4(code_context);
            Extra5 = SharPerf.getExtra5(code_context);

            Google_SetUp_List_Custom = new ArrayList<>();

            for (int p = 0; p < GL_Setup_Ads.length(); p++) {
                Google_SetUp_List_Custom.add("" + GL_Setup_Ads.charAt(p));
            }

            Loading_Data = 0;
        } catch (Exception e) {

        }
    }

    public static class HttpHandler {

        public HttpHandler() {
        }

        public String makeServiceCall(String reqUrl) {
            String response = null;
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (MalformedURLException e) {
            } catch (ProtocolException e) {
            } catch (IOException e) {
            } catch (Exception e) {
            }
            return response;
        }

        private String convertStreamToString(InputStream is) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return sb.toString();
        }
    }

    public static boolean isNetworkConnected(Context aContext) {
        ConnectivityManager cm = (ConnectivityManager) aContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public static void Splash_Interstial(Dialog builder, Context ads_context) {
        try {


            if (isNetworkConnected(ads_context)) {
                if (show_ads.equals("1")) {
                    if (splesh_ads.equals("1")) {

                        if (i_nooff.equals("0")) {
                            try {
                                handler_splesh_counter.removeCallbacks(runnable_splesh_counter);
                            } catch (Exception e) {

                            }
                            try {
                                if (builder != null) {
                                    if (builder.isShowing()) {
                                        builder.dismiss();
                                    }
                                }
                            } catch (final IllegalArgumentException e) {

                            } catch (final Exception e) {
                            } finally {

                            }
                            return;
                        }

                        Splash_Interstial_FB(builder, ads_context);

                    } else {
                        try {
                            handler_splesh_counter.removeCallbacks(runnable_splesh_counter);
                        } catch (Exception e) {

                        }

                        Interstial_Load(ads_context);

                        try {
                            if (builder != null) {
                                if (builder.isShowing()) {
                                    builder.dismiss();
                                }
                            }
                        } catch (final IllegalArgumentException e) {

                        } catch (final Exception e) {
                        } finally {

                        }
                    }
                } else {

                    try {
                        if (builder != null) {
                            if (builder.isShowing()) {
                                builder.dismiss();
                            }
                        }
                    } catch (final IllegalArgumentException e) {

                    } catch (final Exception e) {
                    } finally {

                    }
                }

            } else {
                try {
                    if (builder != null) {
                        if (builder.isShowing()) {
                            builder.dismiss();
                        }
                    }
                } catch (final IllegalArgumentException e) {

                } catch (final Exception e) {
                } finally {

                }
            }

        } catch (Exception e) {

        }
    }

    public static void Splash_Interstial_FB(Dialog builder, Context cont_ads) {


        try {

            if (show_ads.equals("1")) {

                if (fb_i.equals("id")) {

                    Splash_Interstial_Google(builder, cont_ads);
                    return;
                }

                InterstitialAd FB_Inter_Splesh = new InterstitialAd(cont_ads, "" + fb_i);

                InterstitialAdListener adListener = new InterstitialAdListener() {
                    @Override
                    public void onInterstitialDisplayed(Ad ad) {
                        Splash_Show(code_context.getPackageName());
                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {


                        Interstial_Load(cont_ads);
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {

                        Splash_Interstial_Google(builder, cont_ads);

                    }


                    @Override
                    public void onAdLoaded(Ad ad) {
                        try {
                            handler_splesh_counter.removeCallbacks(runnable_splesh_counter);
                            if (Splesh_Timer) {

                            } else {
                                FB_Inter_Splesh.show();
                                try {
                                    if (builder != null) {
                                        if (builder.isShowing()) {
                                            builder.dismiss();
                                        }
                                    }
                                } catch (final IllegalArgumentException e) {

                                } catch (final Exception e) {
                                } finally {

                                }

                            }
                        } catch (Exception e) {

                        }

                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                    }
                };

                Splash_Request(code_context.getPackageName());

                FB_Inter_Splesh.loadAd(FB_Inter_Splesh.buildLoadAdConfig().withAdListener(adListener).build());


            }


        } catch (Exception e) {

        }


    }

    public static int gogole_splesh_inter_id_count = 0;
    public static int google_id_exchange_H = 1;
    public static int google_id_exchange_M = 1;
    public static int google_id_exchange_L = 1;

    public static void Splash_Interstial_Google(Dialog builder, Context cont_ads) {


        if (show_ads.equals("1")) {

            if (admob_i3.equals("id")) {
                Splash_Interstial_SA(builder, cont_ads);
                return;
            }

            String Ad_inter_request_Id = admob_i3;

            AdRequest adRequest = new AdRequest.Builder().build();

            String google_id_floor = Google_SetUp_List_Custom.get(gogole_splesh_inter_id_count);

            if (google_id_floor.equals("H")) {

                if (google_id_exchange_H == 1) {
                    Ad_inter_request_Id = admob_i1;
                    google_id_exchange_H = 11;

                } else {
                    Ad_inter_request_Id = admob_i11;
                    google_id_exchange_H = 1;
                }
            } else if (google_id_floor.equals("M")) {
                if (google_id_exchange_M == 1) {
                    Ad_inter_request_Id = admob_i2;
                    google_id_exchange_M = 11;
                } else {
                    Ad_inter_request_Id = admob_i22;
                    google_id_exchange_M = 1;
                }
            } else {


                if (google_id_exchange_L == 1) {
                    Ad_inter_request_Id = admob_i3;
                    google_id_exchange_L = 11;
                } else {
                    Ad_inter_request_Id = admob_i33;
                    google_id_exchange_L = 1;
                }
            }
            com.google.android.gms.ads.interstitial.InterstitialAd.load(cont_ads, Ad_inter_request_Id, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                    try {

                        gogole_splesh_inter_id_count = 0;
                        handler_splesh_counter.removeCallbacks(runnable_splesh_counter);
                        if (Splesh_Timer) {

                        } else {

                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdClicked() {
                                    super.onAdClicked();
                                }

                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    Interstial_Load(cont_ads);
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);


                                    Splash_Interstial_SA(builder, cont_ads);
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                    super.onAdShowedFullScreenContent();
                                }

                                @Override
                                public void onAdImpression() {
                                    super.onAdImpression();
                                }
                            });


                            interstitialAd.show((Activity) cont_ads);

                            try {
                                if (builder != null) {
                                    if (builder.isShowing()) {
                                        builder.dismiss();
                                    }
                                }
                            } catch (final IllegalArgumentException e) {

                            } catch (final Exception e) {
                            } finally {

                            }
                        }


                    } catch (Exception e) {
                        try {
                            if (builder != null) {
                                if (builder.isShowing()) {
                                    builder.dismiss();
                                }
                            }
                        } catch (final IllegalArgumentException e1) {

                        } catch (final Exception e1) {
                        } finally {

                        }
                    }

                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {


                    Log.e("sp gogole ", "loadAdError =" + loadAdError.getMessage());

                    int aa = gogole_splesh_inter_id_count + 1;
                    if (aa == Google_SetUp_List_Custom.size()) {
                        gogole_splesh_inter_id_count = 0;
                        Splash_Interstial_SA(builder, cont_ads);
                    } else {
                        gogole_splesh_inter_id_count = gogole_splesh_inter_id_count + 1;
                        Splash_Interstial_Google(builder, cont_ads);
                    }


                }
            });
        }

    }

    public static void Splash_Interstial_SA(Dialog builder, Context cont_ads) {

        if (ac_Inter.equals("id")) {


            if(!splash_anim.equals("id")){
                try {
                    if (SharPerf.get_Tappx(cont_ads).equals("2")) {
                        Link_inter1(cont_ads);
                    } else if (SharPerf.get_Tappx(cont_ads).equals("1")) {
                        Link_inter(cont_ads);
                    } else {
                        CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                        customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                        openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(getRandomAds_Data(Ads_Data_List).ad_link));
                    }
                } catch (Exception e) {

                }
            }

            if (Splesh_Timer) {

            } else {
                try {

                    handler_splesh_counter.removeCallbacks(runnable_splesh_counter);
                    try {
                        if (builder != null) {
                            if (builder.isShowing()) {
                                builder.dismiss();
                            }
                        }
                    } catch (Exception e) {
                    } finally {

                    }


                } catch (Exception e) {

                }
            }


            return;

        }

        Log.e("ac_Intersssssssssss", "" + ac_Inter);
        int time_duration = 100;
        if (!UnityAds.isInitialized()) {
            time_duration = 2500;
        }


        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                UnityAds.load(ac_Inter, new IUnityAdsLoadListener() {
                    @Override
                    public void onUnityAdsAdLoaded(String placementId) {

                        IUnityAdsShowListener showListener = new IUnityAdsShowListener() {
                            @Override
                            public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {

                                Interstial_Load(cont_ads);
                                Log.e("UnityAdsExample i", "Unity Ads failed to show ad for " + placementId + " with error: [" + error + "] " + message);
                            }

                            @Override
                            public void onUnityAdsShowStart(String placementId) {
                                Log.e("UnityAdsExample i", "onUnityAdsShowStart: " + placementId);
                            }

                            @Override
                            public void onUnityAdsShowClick(String placementId) {
                                Log.e("UnityAdsExample i", "onUnityAdsShowClick: " + placementId);
                            }

                            @Override
                            public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                                Log.e("UnityAdsExample i", "onUnityAdsShowComplete: " + placementId);
                                Interstial_Load(cont_ads);

                            }
                        };
                        if (Splesh_Timer) {

                        } else {
                            try {

                                UnityAds.show((Activity) cont_ads, ac_Inter, new UnityAdsShowOptions(), showListener);

                            } catch (Exception e) {

                            }
                        }

                        handler_splesh_counter.removeCallbacks(runnable_splesh_counter);
                        try {
                            if (builder != null) {
                                if (builder.isShowing()) {
                                    builder.dismiss();
                                }
                            }
                        } catch (Exception e) {
                        } finally {

                        }


                    }

                    @Override
                    public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
                        Log.e("onUnityAdsFailedToLoad", "" + message);


                        if(!splash_anim.equals("id")){
                            try {
                                if (SharPerf.get_Tappx(cont_ads).equals("2")) {
                                    Link_inter1(cont_ads);
                                } else if (SharPerf.get_Tappx(cont_ads).equals("1")) {
                                    Link_inter(cont_ads);
                                } else {
                                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(getRandomAds_Data(Ads_Data_List).ad_link));
                                }
                            } catch (Exception e) {

                            }
                        }


                        handler_splesh_counter.removeCallbacks(runnable_splesh_counter);
                        try {
                            if (builder != null) {
                                if (builder.isShowing()) {
                                    builder.dismiss();
                                }
                            }
                        } catch (Exception e) {
                        } finally {

                        }
                        Interstial_Load(cont_ads);

                    }
                });

            }
        }, time_duration);


    }

//    Inter

    public static Boolean Inter_Loading = false;
    public static InterstitialAd FB_Inter = null;
    public static com.google.android.gms.ads.interstitial.InterstitialAd Google_Inter = null;

    public static void Interstial_Load(Context cont_ads) {
        if (!isNetworkConnected(cont_ads)) {
            return;
        }
        if (show_ads.equals("0")) {
            return;
        }
        if (Extra5.equals("1")) {
            return;
        }
        if (Inter_Loading) {
            return;
        }
        Inter_Loading = true;
        Interstial_FB(cont_ads);

    }

    public static void Interstial_Show(Context cont_ads) {
        if (!isNetworkConnected(cont_ads)) {
            return;
        }
        if (show_ads.equals("0")) {
            return;
        }
        if (i_nooff.equals("0")) {
            return;
        }
        if (Extra5.equals("1")) {
            Interstial_LoadShow(cont_ads);
            return;
        }

        try {
            if (FB_Inter != null) {
                if (FB_Inter.isAdLoaded()) {
                    FB_Inter.show();
                    return;
                }
            }
        } catch (Exception e) {

        }
        try {
            if (Google_Inter != null) {
                Google_Inter.show((Activity) cont_ads);
                return;
            }
        } catch (Exception e) {

        }
        // Interstial_Load(cont_ads);

        Interstial_UN(cont_ads);
    }

    public static void Pre_Interstial_Show(Context cont_ads) {

        if (for_Approval.equals("1")) {
            Interstial_Counted(cont_ads);
            return;
        }
        Interstial_Show(cont_ads);
    }

    public static void Interstial_Counted(Context cont_ads) {
        try {

            if (show_ads.equals("0")) {
                return;
            }

            int counter_ads = SharPerf.getCount_Ads(cont_ads);

            if (counter_ads >= counter_ads_tot) {

                SharPerf.setCount_Ads(cont_ads, 1);

                try {
                    Interstial_Show(cont_ads);
                } catch (Exception e) {

                }

            } else {
                counter_ads = counter_ads + 1;
                SharPerf.setCount_Ads(cont_ads, counter_ads);

            }

        } catch (Exception e) {

        }
    }

    public static void Increase_Ads(Context cont_ads) {

        if (increase_ads.equals("1")) {
            Pre_Interstial_Show(cont_ads);
        }

    }

    public static Dialog open_ads_dialog;
    public static void AppOpen_Show(Activity activity) {
        if (SharPerf.getAO_Setup(activity).equals("0")) {

        } else {
            Interstial_Show(activity);
//            AppOpen_Custom(activity);
        }

    }



    public static Ads_Data getRandomAds_Data(ArrayList<Ads_Data> items) {
        return items.get(new Random().nextInt(items.size()));
    }

    public static void AppOpen_Custom(Activity activity) {

        try {

            Ads_Data ad_data = getRandomAds_Data(Ads_Data_List);


            if (open_ads_dialog != null && open_ads_dialog.isShowing()) {
                DismissDialog();
                open_ads_dialog = null;
            }

            if (open_ads_dialog == null) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        open_ads_dialog = new Dialog(activity);


                        LayoutInflater inflater = LayoutInflater.from(activity);
                        View v_open_ads = inflater.inflate(R.layout.qureka_open_ad, null, false);
                        open_ads_dialog.setContentView(v_open_ads);
                        open_ads_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        open_ads_dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                        open_ads_dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
                        open_ads_dialog.setCancelable(false);
                        open_ads_dialog.setCanceledOnTouchOutside(false);


                        ImageView ivAppLogo = v_open_ads.findViewById(R.id.ivAppLogo);
                        ivAppLogo.setImageResource(app_iocn);

                        ImageView imageView_ad = v_open_ads.findViewById(R.id.imageView_ad);
                        Glide.with(activity)
                                .load(ad_data.ad_native_link)
                                .placeholder(R.drawable.progress_animation)
                                .error(R.drawable.progress_animation)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(imageView_ad);
                        imageView_ad.setOnClickListener(view -> {
                            DismissDialog();
                            CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                            customIntent.setToolbarColor(ContextCompat.getColor(activity, R.color.black));
                            openCustomTab((Activity) activity, customIntent.build(), Uri.parse(ad_data.ad_link));
                        });

                        LinearLayout layoutContinueApp = v_open_ads.findViewById(R.id.layout_continue_app);

                        layoutContinueApp.setOnClickListener(view -> {
                            DismissDialog();
                        });


                        if (!activity.isFinishing()) {
                            open_ads_dialog.show();
                        }
                    }
                });

            }


        } catch (Exception e) {

        }

    }

    public static void DismissDialog() {
        try {
            if (open_ads_dialog != null && open_ads_dialog.isShowing()) open_ads_dialog.dismiss();
            open_ads_dialog = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void Interstial_FB(Context cont_ads) {

        if (fb_i.equals("id")) {
            Interstial_GL(cont_ads);
            return;
        }
        FB_Inter = new InterstitialAd(cont_ads, "" + fb_i);
        InterstitialAdListener adListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Inter_Show(code_context.getPackageName());
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Interstial_Load(cont_ads);
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                FB_Inter = null;
                Interstial_GL(cont_ads);
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Inter_Loading = false;
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };

        Inter_Request(code_context.getPackageName());
        FB_Inter.loadAd(FB_Inter.buildLoadAdConfig().withAdListener(adListener).build());
    }

    public static void Interstial_GL(Context cont_ads) {

        if (admob_i3.equals("id")) {
            Inter_Loading = false;
            return;
        }

        AdRequest adRequest = new AdRequest.Builder().build();
        String Ad_inter_request_Id = admob_i3;
        String google_id_floor = Google_SetUp_List_Custom.get(gogole_splesh_inter_id_count);
        if (google_id_floor.equals("H")) {
            if (google_id_exchange_H == 1) {
                Ad_inter_request_Id = admob_i1;
                google_id_exchange_H = 11;

            } else {
                Ad_inter_request_Id = admob_i11;
                google_id_exchange_H = 1;
            }
        } else if (google_id_floor.equals("M")) {
            if (google_id_exchange_M == 1) {
                Ad_inter_request_Id = admob_i2;
                google_id_exchange_M = 11;
            } else {
                Ad_inter_request_Id = admob_i22;
                google_id_exchange_M = 1;
            }
        } else {
            if (google_id_exchange_L == 1) {
                Ad_inter_request_Id = admob_i3;
                google_id_exchange_L = 11;
            } else {
                Ad_inter_request_Id = admob_i33;
                google_id_exchange_L = 1;
            }
        }

        com.google.android.gms.ads.interstitial.InterstitialAd.load(cont_ads, Ad_inter_request_Id, adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                gogole_splesh_inter_id_count = 0;

                Inter_Loading = false;
                Google_Inter = interstitialAd;
                Google_Inter.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdClicked() {
                        super.onAdClicked();
                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();
                        Interstial_Load(cont_ads);
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                        super.onAdFailedToShowFullScreenContent(adError);
                        Interstial_Load(cont_ads);
                    }

                    @Override
                    public void onAdImpression() {
                        super.onAdImpression();
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent();
                    }
                });

            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                Google_Inter = null;
                Inter_Loading = false;


                int aa = gogole_splesh_inter_id_count + 1;
                if (aa == Google_SetUp_List_Custom.size()) {
                    gogole_splesh_inter_id_count = 0;
                } else {
                    gogole_splesh_inter_id_count = gogole_splesh_inter_id_count + 1;
                    Interstial_GL(cont_ads);
                }


            }
        });


    }


    public static void Interstial_UN(Context cont_ads) {

        if (ac_Inter.equals("id")) {

            if(!splash_anim.equals("id")){
                try {
                    if (SharPerf.get_Tappx(cont_ads).equals("2")) {
                        Link_inter1(cont_ads);
                    } else if (SharPerf.get_Tappx(cont_ads).equals("1")) {
                        Link_inter(cont_ads);
                    } else {
                        CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                        customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                        openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(getRandomAds_Data(Ads_Data_List).ad_link));
                    }
                } catch (Exception e) {

                }
            }


            return;
        }

        CustomProgressDialogueInter ac_dialog111 = new CustomProgressDialogueInter(cont_ads, "Ad", "Please wait Ads is loading...", BGColor, Text_Color_main);

        ac_dialog111.show();
        UnityAds.load(ac_Inter, new IUnityAdsLoadListener() {
            @Override
            public void onUnityAdsAdLoaded(String placementId) {

                IUnityAdsShowListener showListener = new IUnityAdsShowListener() {
                    @Override
                    public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
                        if(!splash_anim.equals("id")){
                            try {
                                if (SharPerf.get_Tappx(cont_ads).equals("2")) {
                                    Link_inter1(cont_ads);
                                } else if (SharPerf.get_Tappx(cont_ads).equals("1")) {
                                    Link_inter(cont_ads);
                                } else {
                                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(getRandomAds_Data(Ads_Data_List).ad_link));
                                }
                            } catch (Exception e) {

                            }
                        }

                        try {
                            if (ac_dialog111 != null) {
                                if (ac_dialog111.isShowing()) {
                                    ac_dialog111.dismiss();
                                }
                            }
                        } catch (Exception e) {

                        }
                        Log.e("UnityAdsExample i", "Unity Ads failed to show ad for " + placementId + " with error: [" + error + "] " + message);
                    }

                    @Override
                    public void onUnityAdsShowStart(String placementId) {
                        Log.e("UnityAdsExample i", "onUnityAdsShowStart: " + placementId);
                    }

                    @Override
                    public void onUnityAdsShowClick(String placementId) {
                        Log.e("UnityAdsExample i", "onUnityAdsShowClick: " + placementId);
                    }

                    @Override
                    public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                        Log.e("UnityAdsExample i", "onUnityAdsShowComplete: " + placementId);


                    }
                };
                try {
                    if (ac_dialog111 != null) {
                        if (ac_dialog111.isShowing()) {
                            ac_dialog111.dismiss();
                        }
                    }
                } catch (Exception e) {

                }

                try {

                    UnityAds.show((Activity) cont_ads, ac_Inter, new UnityAdsShowOptions(), showListener);

                } catch (Exception e) {

                }

            }

            @Override
            public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
                Log.e("onUnityAdsFailedToLoad", "" + message);

                if(!splash_anim.equals("id")){
                    try {
                        if (SharPerf.get_Tappx(cont_ads).equals("2")) {
                            Link_inter1(cont_ads);
                        } else if (SharPerf.get_Tappx(cont_ads).equals("1")) {
                            Link_inter(cont_ads);
                        } else {
                            CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                            customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                            openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(getRandomAds_Data(Ads_Data_List).ad_link));
                        }
                    } catch (Exception e) {

                    }
                }
                try {
                    if (ac_dialog111 != null) {
                        if (ac_dialog111.isShowing()) {
                            ac_dialog111.dismiss();
                        }
                    }
                } catch (Exception e) {

                }


            }
        });

    }


//    Inter Load And Show


    public static void Interstial_LoadShow(Context cont_ads) {

        if (!isNetworkConnected(cont_ads)) {
            return;
        }
        if (show_ads.equals("0")) {
            return;
        }
        if (i_nooff.equals("0")) {
            return;
        }

        CustomProgressDialogueInter builder = new CustomProgressDialogueInter(cont_ads, "Loading Ads . . .", "Wait While Loading Ads, Sorry for Inconvenience and Thank You for Support and Waiting.", BGColor, TitleTextColor);
        builder.show();

        Interstial_FB_LoadShow(builder, cont_ads);
    }

    public static void Interstial_FB_LoadShow(CustomProgressDialogueInter builder, Context cont_ads) {

        try {

            if (show_ads.equals("1")) {

                if (fb_i.equals("id")) {

                    Interstial_Gl_LoadShow(builder, cont_ads);
                    return;
                }

                InterstitialAd FB_Inter_Splesh = new InterstitialAd(cont_ads, "" + fb_i);

                InterstitialAdListener adListener = new InterstitialAdListener() {
                    @Override
                    public void onInterstitialDisplayed(Ad ad) {
                        Inter_Show(code_context.getPackageName());
                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {

                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {

                        Interstial_Gl_LoadShow(builder, cont_ads);

                    }


                    @Override
                    public void onAdLoaded(Ad ad) {
                        try {
                            FB_Inter_Splesh.show();
                            try {
                                if (builder != null) {
                                    if (builder.isShowing()) {
                                        builder.dismiss();
                                    }
                                }
                            } catch (final IllegalArgumentException e) {

                            } catch (final Exception e) {
                            } finally {

                            }
                        } catch (Exception e) {

                        }

                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                    }
                };

                Inter_Request(code_context.getPackageName());

                FB_Inter_Splesh.loadAd(FB_Inter_Splesh.buildLoadAdConfig().withAdListener(adListener).build());
            }


        } catch (Exception e) {

        }


    }

    public static void Interstial_Gl_LoadShow(CustomProgressDialogueInter builder, Context cont_ads) {

        if (show_ads.equals("1")) {

            if (admob_i3.equals("id")) {
                Interstial_SA_LoadShow(builder, cont_ads);
                return;
            }


            AdRequest adRequest = new AdRequest.Builder().build();

            String Ad_inter_request_Id = admob_i3;
            String google_id_floor = Google_SetUp_List_Custom.get(gogole_splesh_inter_id_count);
            if (google_id_floor.equals("H")) {
                if (google_id_exchange_H == 1) {
                    Ad_inter_request_Id = admob_i1;
                    google_id_exchange_H = 11;

                } else {
                    Ad_inter_request_Id = admob_i11;
                    google_id_exchange_H = 1;
                }
            } else if (google_id_floor.equals("M")) {
                if (google_id_exchange_M == 1) {
                    Ad_inter_request_Id = admob_i2;
                    google_id_exchange_M = 11;
                } else {
                    Ad_inter_request_Id = admob_i22;
                    google_id_exchange_M = 1;
                }
            } else {
                if (google_id_exchange_L == 1) {
                    Ad_inter_request_Id = admob_i3;
                    google_id_exchange_L = 11;
                } else {
                    Ad_inter_request_Id = admob_i33;
                    google_id_exchange_L = 1;
                }
            }

            com.google.android.gms.ads.interstitial.InterstitialAd.load(cont_ads, Ad_inter_request_Id, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                    try {
                        gogole_splesh_inter_id_count = 0;
                        interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                super.onAdClicked();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                Interstial_SA_LoadShow(builder, cont_ads);
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();
                            }
                        });


                        interstitialAd.show((Activity) cont_ads);

                        try {
                            if (builder != null) {
                                if (builder.isShowing()) {
                                    builder.dismiss();
                                }
                            }
                        } catch (final IllegalArgumentException e) {

                        } catch (final Exception e) {
                        } finally {

                        }

                    } catch (Exception e) {
                        try {
                            if (builder != null) {
                                if (builder.isShowing()) {
                                    builder.dismiss();
                                }
                            }
                        } catch (final IllegalArgumentException e1) {

                        } catch (final Exception e1) {
                        } finally {

                        }
                    }

                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {


                    int aa = gogole_splesh_inter_id_count + 1;
                    if (aa == Google_SetUp_List_Custom.size()) {
                        gogole_splesh_inter_id_count = 0;

                        Interstial_SA_LoadShow(builder, cont_ads);
                    } else {
                        gogole_splesh_inter_id_count = gogole_splesh_inter_id_count + 1;
                        Interstial_GL(cont_ads);
                    }


                }
            });
        }
    }

    public static void Interstial_SA_LoadShow(CustomProgressDialogueInter builder, Context cont_ads) {


        if (show_ads.equals("0")) {
            return;
        }

        if (ac_Inter.equals("id")) {


            if(!splash_anim.equals("id")){
                try {
                    if (SharPerf.get_Tappx(cont_ads).equals("2")) {
                        Link_inter1(cont_ads);
                    } else if (SharPerf.get_Tappx(cont_ads).equals("1")) {
                        Link_inter(cont_ads);
                    } else {
                        CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                        customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                        openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(getRandomAds_Data(Ads_Data_List).ad_link));
                    }
                } catch (Exception e) {

                }
            }

            try {
                if (builder != null) {
                    if (builder.isShowing()) {
                        builder.dismiss();
                    }
                }
            } catch (final IllegalArgumentException e) {

            } catch (final Exception e) {
            } finally {

            }
            return;
        }

        UnityAds.load(ac_Inter, new IUnityAdsLoadListener() {
            @Override
            public void onUnityAdsAdLoaded(String placementId) {

                IUnityAdsShowListener showListener = new IUnityAdsShowListener() {
                    @Override
                    public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
                        if(!splash_anim.equals("id")){
                            try {
                                if (SharPerf.get_Tappx(cont_ads).equals("2")) {
                                    Link_inter1(cont_ads);
                                } else if (SharPerf.get_Tappx(cont_ads).equals("1")) {
                                    Link_inter(cont_ads);
                                } else {
                                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(getRandomAds_Data(Ads_Data_List).ad_link));
                                }
                            } catch (Exception e) {

                            }
                        }

                        try {
                            if (builder != null) {
                                if (builder.isShowing()) {
                                    builder.dismiss();
                                }
                            }
                        } catch (Exception e) {

                        }

                        Log.e("UnityAdsExample i", "Unity Ads failed to show ad for " + placementId + " with error: [" + error + "] " + message);
                    }

                    @Override
                    public void onUnityAdsShowStart(String placementId) {
                        Log.e("UnityAdsExample i", "onUnityAdsShowStart: " + placementId);
                    }

                    @Override
                    public void onUnityAdsShowClick(String placementId) {
                        Log.e("UnityAdsExample i", "onUnityAdsShowClick: " + placementId);
                    }

                    @Override
                    public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                        Log.e("UnityAdsExample i", "onUnityAdsShowComplete: " + placementId);


                    }
                };
                try {
                    if (builder != null) {
                        if (builder.isShowing()) {
                            builder.dismiss();
                        }
                    }
                } catch (Exception e) {

                }

                try {

                    UnityAds.show((Activity) cont_ads, ac_Inter, new UnityAdsShowOptions(), showListener);

                } catch (Exception e) {

                }

            }

            @Override
            public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
                Log.e("onUnityAdsFailedToLoad", "" + message);

                if(!splash_anim.equals("id")){
                    try {
                        if (SharPerf.get_Tappx(cont_ads).equals("2")) {
                            Link_inter1(cont_ads);
                        } else if (SharPerf.get_Tappx(cont_ads).equals("1")) {
                            Link_inter(cont_ads);
                        } else {
                            CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                            customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                            openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(getRandomAds_Data(Ads_Data_List).ad_link));
                        }
                    } catch (Exception e) {

                    }
                }

                try {
                    if (builder != null) {
                        if (builder.isShowing()) {
                            builder.dismiss();
                        }
                    }
                } catch (Exception e) {

                }


            }
        });


    }


    public static void openCustomTab(Activity activity, CustomTabsIntent customTabsIntent, Uri uri) {
        // package name is the default package
        // for our custom chrome tab
        String packageName = "com.android.chrome";
        if (packageName != null) {
            // we are checking if the package name is not null
            // if package name is not null then we are calling
            // that custom chrome tab with intent by passing its
            // package name.
            customTabsIntent.intent.setPackage(packageName);
            // in that custom tab intent we are passing
            // our url which we have to browse.
            customTabsIntent.launchUrl(activity, uri);
        } else {
            // if the custom tabs fails to load then we are simply
            // redirecting our user to users device default browser.
            activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }


    public static void Link_inter(Context cont_ads) {


        try {


            Dialog dialog = new Dialog(cont_ads, R.style.DialogTheme);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.link_inter);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setFlags(1024, 1024);
            dialog.onWindowFocusChanged(true);
            dialog.setCancelable(false);
            int currentApiVersion;
            currentApiVersion = Build.VERSION.SDK_INT;


            final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
                dialog.getWindow().getDecorView().setSystemUiVisibility(flags);
                final View decorView = dialog.getWindow().getDecorView();
                decorView.setOnSystemUiVisibilityChangeListener(i -> {
                    if ((i & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                });
            }

            ImageView main_img = dialog.findViewById(R.id.main_img);

            ImageView close_img = dialog.findViewById(R.id.close_img);
            CardView card_ad = dialog.findViewById(R.id.card_ad);
            TextView text_ad = dialog.findViewById(R.id.text_ad);
            CardView crdClose = dialog.findViewById(R.id.crdClose);


            RelativeLayout main = dialog.findViewById(R.id.main);
            try {
                main.setBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                crdClose.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                close_img.setColorFilter(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)), android.graphics.PorterDuff.Mode.MULTIPLY);
                card_ad.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                text_ad.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));
            } catch (Exception e) {

            }
            Ads_Data ad_data = getRandomAds_Data(Ads_Data_List);
            Glide.with(cont_ads)
                    .load(ad_data.ad_inter_link)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(main_img);

            crdClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            main_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));

                }
            });


            dialog.show();
        } catch (Exception e) {

        }
    }

    public static void Link_inter1(Context cont_ads) {


        try {
            final int min = 1;
            final int max = 2;
            final int random = new Random().nextInt((max - min) + 1) + min;

            if (random == 1) {
                Link_inter11(cont_ads);
            } else if (random == 2) {
                Link_inter22(cont_ads);
            } else {
                Link_inter22(cont_ads);
            }
        } catch (Exception e) {

        }
    }

    public static void Link_inter11(Context cont_ads) {
        try {
            Dialog dialog = new Dialog(cont_ads, R.style.DialogTheme);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.link_inter1);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setFlags(1024, 1024);
            dialog.onWindowFocusChanged(true);
            dialog.setCancelable(false);
            int currentApiVersion;
            currentApiVersion = Build.VERSION.SDK_INT;


            final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
                dialog.getWindow().getDecorView().setSystemUiVisibility(flags);
                final View decorView = dialog.getWindow().getDecorView();
                decorView.setOnSystemUiVisibilityChangeListener(i -> {
                    if ((i & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                });
            }

            TextView btnInstall = dialog.findViewById(R.id.btnInstall);

            TextView sub_title = dialog.findViewById(R.id.sub_title);
            TextView title = dialog.findViewById(R.id.title);

            ImageView close_img = dialog.findViewById(R.id.close_img);

            CardView card_ad = dialog.findViewById(R.id.card_ad);
            TextView text_ad = dialog.findViewById(R.id.text_ad);

            CardView crdClose = dialog.findViewById(R.id.crdClose);
            CardView crdInstall = dialog.findViewById(R.id.crdInstall);
            CardView card_icon = dialog.findViewById(R.id.card_icon);
            ImageView main_img = dialog.findViewById(R.id.main_img);


            Ads_Data ad_data = getRandomAds_Data(Ads_Data_List);

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));

                }
            });

            sub_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));

                }
            });


            RelativeLayout main = dialog.findViewById(R.id.main);
            try {
                main.setBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                card_icon.setCardBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                crdClose.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                close_img.setColorFilter(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)), android.graphics.PorterDuff.Mode.MULTIPLY);

                card_ad.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                text_ad.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));
                crdInstall.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                btnInstall.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));
                title.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
                sub_title.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
            } catch (Exception e) {
                Log.e("exc 1234", "=" + e.getMessage());
            }

            title.setText(ad_data.ad_tiltle);
            sub_title.setText(ad_data.ad_sub_tiltle);
            btnInstall.setText(ad_data.ad_btn_text);
            Glide.with(cont_ads)
                    .load(ad_data.ad_icon_link)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(main_img);

            crdClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            crdInstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));
                }
            });

            main_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));

                }
            });

            dialog.show();

        } catch (Exception e) {

        }
    }

    public static void Link_inter22(Context cont_ads) {


        try {


            Dialog dialog = new Dialog(cont_ads, R.style.DialogTheme);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.link_inter2);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setFlags(1024, 1024);
            dialog.onWindowFocusChanged(true);
            dialog.setCancelable(false);
            int currentApiVersion;
            currentApiVersion = Build.VERSION.SDK_INT;


            final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
                dialog.getWindow().getDecorView().setSystemUiVisibility(flags);
                final View decorView = dialog.getWindow().getDecorView();
                decorView.setOnSystemUiVisibilityChangeListener(i -> {
                    if ((i & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                });
            }

            ImageView close_img = dialog.findViewById(R.id.close_img);
            TextView btnInstall = dialog.findViewById(R.id.btnInstall);

            TextView sub_title = dialog.findViewById(R.id.sub_title);
            TextView title = dialog.findViewById(R.id.title);

            CardView crdClose = dialog.findViewById(R.id.crdClose);
            CardView crdInstall = dialog.findViewById(R.id.crdInstall);

            ImageView main_img = dialog.findViewById(R.id.main_img);
            ImageView native_img = dialog.findViewById(R.id.native_img);

            CardView card_ad = dialog.findViewById(R.id.card_ad);
            TextView text_ad = dialog.findViewById(R.id.text_ad);

            CardView card_icon= dialog.findViewById(R.id.card_icon);


            Ads_Data ad_data = getRandomAds_Data(Ads_Data_List);
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));

                }
            });

            sub_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));

                }
            });

            RelativeLayout main = dialog.findViewById(R.id.main);
            try {
                main.setBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                card_icon.setCardBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                crdClose.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                card_ad.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                text_ad.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));
                crdInstall.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                close_img.setColorFilter(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)), android.graphics.PorterDuff.Mode.MULTIPLY);
                btnInstall.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));
                title.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
                sub_title.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
            } catch (Exception e) {

            }
            title.setText(ad_data.ad_tiltle);
            sub_title.setText(ad_data.ad_sub_tiltle);
            btnInstall.setText(ad_data.ad_btn_text);
            Glide.with(cont_ads)
                    .load(ad_data.ad_icon_link)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(main_img);

            Glide.with(cont_ads)
                    .load(ad_data.ad_native_link)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(native_img);

            crdClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            native_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));
                }
            });
            crdInstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));
                }
            });

            main_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));

                }
            });

            dialog.show();
        } catch (Exception e) {

        }
    }


//    Native

    public static void Native(Context cont_ads, RelativeLayout adView, int nativeType) {

        if (!isNetworkConnected(cont_ads)) {
            return;
        }
        if (show_ads.equals("0")) {
            return;
        }


        if (n_nooff.equals("1")) {
            if (b_n_ex.equals("1")) {
                Banner_FB(cont_ads, adView, nativeType);
            } else {
                Native_FB(cont_ads, adView, nativeType);
            }
        }

    }

    public static void Native_FB(Context cont_ads, RelativeLayout adView, int nativeType) {

        if (SharPerf.getNative_custom(cont_ads).equals("3") || SharPerf.getNative_custom(cont_ads).equals("4") || SharPerf.getNative_custom(cont_ads).equals("5") || SharPerf.getNative_custom(cont_ads).equals("6")) {

            if (nativeType == 2) {
                LayoutInflater inflater =
                        (LayoutInflater) cont_ads.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.gnt_medium_template_view_shimmer, adView);

            }
            if (nativeType == 1) {
                LayoutInflater inflater =
                        (LayoutInflater) cont_ads.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.gnt_small_template_view_shimmer, adView);
            }
        }
        if (SharPerf.getNative_custom(cont_ads).equals("4") || SharPerf.getNative_custom(cont_ads).equals("5") || SharPerf.getNative_custom(cont_ads).equals("6")) {
            Native_FB_Coustom(cont_ads, adView, nativeType);
            return;
        }


        if (nativeType == 2) {

            if (fb_n.equals("id")) {
                Native_GL(cont_ads, adView, nativeType);
                return;
            }

            if (only_fb_inter.equals("1")) {
                Native_GL(cont_ads, adView, nativeType);
                return;
            }
            Log.e("Native_FB", "Native_FB");
            NativeAd nativeAd = new NativeAd(cont_ads, fb_n);
            NativeAdListener nativeAdListener = new NativeAdListener() {

                @Override
                public void onError(Ad ad, AdError adError) {

                    Log.e("Fb native onError", "=" + adError.getErrorMessage());
                    Native_GL(cont_ads, adView, nativeType);
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    NativeAdViewAttributes viewAttributes = new NativeAdViewAttributes().setBackgroundColor(BGColor).setTitleTextColor(TitleTextColor).setDescriptionTextColor(DescriptionTextColor).setButtonColor(ButtonColor).setButtonTextColor(ButtonTextColor).setButtonBorderColor(ButtonBorderColor);

                    try {
                        View adView1 = NativeAdView.render(cont_ads, nativeAd, viewAttributes);
                        adView.setVisibility(View.VISIBLE);
                        adView.removeAllViews();
                        adView.addView(adView1, new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 800));

                        Native_Show(code_context.getPackageName());

                    } catch (Exception E) {

                    }
                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }

                @Override
                public void onMediaDownloaded(Ad ad) {

                }

            };

            Native_Request(code_context.getPackageName());

            nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());

        } else {

            if (fb_ns.equals("id")) {
                Native_GL(cont_ads, adView, nativeType);
                return;
            }


            if (only_fb_inter.equals("1")) {
                Native_GL(cont_ads, adView, nativeType);
                return;
            }

            NativeBannerAd mNativeBannerAd = new NativeBannerAd(cont_ads, fb_ns);

            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {

                    Native_GL(cont_ads, adView, nativeType);
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    NativeAdViewAttributes viewAttributes = new NativeAdViewAttributes().setBackgroundColor(BGColor).setTitleTextColor(TitleTextColor).setDescriptionTextColor(DescriptionTextColor).setButtonColor(ButtonColor).setButtonTextColor(ButtonTextColor).setButtonBorderColor(ButtonBorderColor);
                    try {
                        View adView1 = NativeBannerAdView.render(cont_ads, mNativeBannerAd, NativeBannerAdView.Type.HEIGHT_120, viewAttributes);
                        adView.setVisibility(View.VISIBLE);
                        adView.removeAllViews();
                        adView.addView(adView1);

                        Native_Show(code_context.getPackageName());

                    } catch (Exception E) {

                    }
                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }

                @Override
                public void onMediaDownloaded(Ad ad) {

                }
            };

            Native_Request(code_context.getPackageName());

            mNativeBannerAd.loadAd(mNativeBannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public static void Native_FB_Coustom(Context cont_ads, RelativeLayout adView1, int nativeType) {


        try {
            if (nativeType == 2) {
                NativeAd nativeAd;
                nativeAd = new NativeAd(cont_ads, fb_n);

                NativeAdListener nativeAdListener = new NativeAdListener() {
                    @Override
                    public void onMediaDownloaded(Ad ad) {

                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.e("onError", "=" + adError);
                        Native_GL(cont_ads, adView1, nativeType);
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.e("nativeAd", "=" + nativeAd);
                        if (nativeAd == null || nativeAd != ad) {
                            return;
                        }
                        nativeAd.unregisterView();
                        LayoutInflater inflater = LayoutInflater.from(cont_ads);
                        View adView;
                        if (SharPerf.getNative_custom(cont_ads).equals("4")) {
                            adView = inflater.inflate(R.layout.fb_native_ad_layout4, adView1, false);
                        } else if (SharPerf.getNative_custom(cont_ads).equals("5")) {
                            adView = inflater.inflate(R.layout.fb_native_ad_layout5, adView1, false);
                        } else {
                            adView = inflater.inflate(R.layout.fb_native_ad_layout6, adView1, false);
                        }

                        RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
                        AdOptionsView adOptionsView = new AdOptionsView(cont_ads, nativeAd, null);
                        adChoicesContainer.removeAllViews();
                        adChoicesContainer.addView(adOptionsView, 0);
                        setClickable(adChoicesContainer);

                        // Create native UI using the ad metadata.
                        MediaView nativeAdIcon = adView.findViewById(R.id.native_ad_icon);
                        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
                        MediaView nativeAdMedia = adView.findViewById(R.id.native_ad_media);
                        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
                        TextView nativeAdBody = adView.findViewById(R.id.native_ad_body);
                        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
                        AppCompatButton nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

                        // Set the Text.
                        nativeAdTitle.setText(nativeAd.getAdvertiserName());
                        nativeAdBody.setText(nativeAd.getAdBodyText());
                        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
                        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
                        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
                        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

                        CardView card_main = adView.findViewById(R.id.card_main);
                        CardView cardbutton = adView.findViewById(R.id.cardbutton);
                        try {
                            card_main.setCardBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                            nativeAdTitle.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
                            nativeAdSocialContext.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
                            nativeAdBody.setTextColor(Color.parseColor(SharPerf.getDescriptionTextColor(cont_ads)));
                            sponsoredLabel.setTextColor(Color.parseColor(SharPerf.getDescriptionTextColor(cont_ads)));
                            cardbutton.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                            nativeAdCallToAction.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));
                        } catch (Exception e) {
                            Log.e("Exception", "=" + e.getMessage());
                        }


                        // Create a list of clickable views
                        List<View> clickableViews = new ArrayList<>();
                        clickableViews.add(nativeAdTitle);
                        clickableViews.add(nativeAdCallToAction);
                        clickableViews.add(nativeAdMedia);
                        clickableViews.add(nativeAdSocialContext);
                        clickableViews.add(nativeAdBody);
                        clickableViews.add(sponsoredLabel);
                        clickableViews.add(nativeAdIcon);
                        // Register the Title and CTA button to listen for clicks.
                        nativeAd.registerViewForInteraction(
                                adView, nativeAdMedia, nativeAdIcon, clickableViews);
                        try {
                            adView1.removeAllViews();
                            adView1.addView(adView);
                            adView1.setVisibility(View.VISIBLE);
                        } catch (Exception E) {
                            Log.e("dccfdvfvf", "=" + E);
                        }
                    }

                    @Override
                    public void onAdClicked(Ad ad) {

                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {

                    }
                };

                // Request an ad
                nativeAd.loadAd(
                        nativeAd.buildLoadAdConfig()
                                .withAdListener(nativeAdListener)
                                .build());
            } else {


                NativeBannerAd nativeBannerAd;
                nativeBannerAd = new NativeBannerAd(cont_ads, fb_ns);
                NativeAdListener nativeAdListener = new NativeAdListener() {
                    @Override
                    public void onMediaDownloaded(Ad ad) {

                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Native_GL(cont_ads, adView1, nativeType);
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        if (nativeBannerAd == null || nativeBannerAd != ad) {
                            return;
                        }


                        nativeBannerAd.unregisterView();

                        // Add the Ad view into the ad container.
                        LayoutInflater inflater = LayoutInflater.from(cont_ads);
                        View adView;
                        if (SharPerf.getNative_custom(cont_ads).equals("4")) {
                            adView = inflater.inflate(R.layout.fb_native_banner_ad_layout4_5, adView1, false);
                        } else if (SharPerf.getNative_custom(cont_ads).equals("5")) {
                            adView = inflater.inflate(R.layout.fb_native_banner_ad_layout4_5, adView1, false);
                        } else {
                            adView = inflater.inflate(R.layout.fb_native_banner_ad_layout6, adView1, false);
                        }

                        // Inflate the Ad view.  The layout referenced is the one you created in the last step.

                        // Add the AdChoices icon
                        RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
                        AdOptionsView adOptionsView = new AdOptionsView(cont_ads, nativeBannerAd, null);
                        adChoicesContainer.removeAllViews();
                        adChoicesContainer.addView(adOptionsView, 0);

                        setClickable(adChoicesContainer);

                        // Create native UI using the ad metadata.
                        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
                        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
                        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
                        MediaView nativeAdIconView = adView.findViewById(R.id.native_icon_view);
                        Button nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

                        // Set the Text.
                        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
                        nativeAdCallToAction.setVisibility(
                                nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
                        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
                        nativeAdSocialContext.setText(nativeBannerAd.getAdSocialContext());
                        sponsoredLabel.setText(nativeBannerAd.getSponsoredTranslation());


                        CardView card_main = adView.findViewById(R.id.card_main);
                        CardView cardbutton = adView.findViewById(R.id.cardbutton);
                        try {
                            card_main.setCardBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                            nativeAdTitle.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
                            nativeAdSocialContext.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
                            sponsoredLabel.setTextColor(Color.parseColor(SharPerf.getDescriptionTextColor(cont_ads)));
                            cardbutton.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                            nativeAdCallToAction.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));

                        } catch (Exception e) {
                            Log.e("Exception", "=" + e.getMessage());
                        }


                        // Register the Title and CTA button to listen for clicks.
                        List<View> clickableViews = new ArrayList<>();
                        clickableViews.add(nativeAdTitle);
                        clickableViews.add(nativeAdCallToAction);
                        clickableViews.add(nativeAdSocialContext);
                        clickableViews.add(nativeAdIconView);
                        clickableViews.add(sponsoredLabel);

                        nativeBannerAd.registerViewForInteraction(adView, nativeAdIconView, clickableViews);

                        try {
                            adView1.removeAllViews();
                            adView1.addView(adView);
                            adView1.setVisibility(View.VISIBLE);
                        } catch (Exception E) {
                            Log.e("dccfdvfvf", "=" + E);
                        }

                    }

                    @Override
                    public void onAdClicked(Ad ad) {

                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {

                    }
                };
                // load the ad
                nativeBannerAd.loadAd(
                        nativeBannerAd.buildLoadAdConfig()
                                .withAdListener(nativeAdListener)
                                .build());
            }
        } catch (Exception e) {

        }

    }

    public static void setClickable(View view) {
        if (view != null) {
            view.setClickable(false);
            if (view instanceof ViewGroup) {
                ViewGroup vg = ((ViewGroup) view);
                for (int i = 0; i < vg.getChildCount(); i++) {
                    setClickable(vg.getChildAt(i));
                }
            }
        }
    }

    public static int gogole_native_id_count = 0;
    public static int google_native_id_exchange_H = 1;
    public static int google_native_id_exchange_M = 1;
    public static int google_native_id_exchange_L = 1;

    public static void Native_GL(Context cont_ads, RelativeLayout adView, int nativeType) {

        if (admob_n3.equals("id")) {
            Native_SA(cont_ads, adView, nativeType);
            return;
        }

        String Ad_native_request_Id = admob_n3;
        String google_id_floor = Google_SetUp_List_Custom.get(gogole_native_id_count);
        if (google_id_floor.equals("H")) {
            if (google_native_id_exchange_H == 1) {
                Ad_native_request_Id = admob_n1;
                google_native_id_exchange_H = 11;

            } else {
                Ad_native_request_Id = admob_n11;
                google_native_id_exchange_H = 1;
            }
        } else if (google_id_floor.equals("M")) {
            if (google_native_id_exchange_M == 1) {
                Ad_native_request_Id = admob_n2;
                google_native_id_exchange_M = 11;
            } else {
                Ad_native_request_Id = admob_n22;
                google_native_id_exchange_M = 1;
            }
        } else {
            if (google_native_id_exchange_L == 1) {
                Ad_native_request_Id = admob_n3;
                google_native_id_exchange_L = 11;
            } else {
                Ad_native_request_Id = admob_n33;
                google_native_id_exchange_L = 1;
            }
        }

        AdLoader adLoader = new AdLoader.Builder(cont_ads, Ad_native_request_Id).forNativeAd(new com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener() {

            @Override
            public void onNativeAdLoaded(com.google.android.gms.ads.nativead.NativeAd nativeAd) {

                gogole_native_id_count = 0;

                NativeStyle styles = new NativeStyle.Builder().build();

                TemplateView Native_templateView;
                Native_templateView = new TemplateView(cont_ads, nativeType);
                Native_templateView.setStyles(styles);
                Native_templateView.setNativeAd(nativeAd);
                Native_templateView.setVisibility(View.VISIBLE);

                try {
                    adView.removeAllViews();
                    adView.setVisibility(View.VISIBLE);
                    adView.addView(Native_templateView);


                } catch (Exception E) {

                }


            }

        }).withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError adError) {

                int aa = gogole_native_id_count + 1;
                if (aa == Google_SetUp_List_Custom.size()) {
                    gogole_native_id_count = 0;
                    Native_SA(cont_ads, adView, nativeType);
                } else {
                    gogole_native_id_count = gogole_native_id_count + 1;
                    Native_GL(cont_ads, adView, nativeType);
                }

            }
        }).withNativeAdOptions(new NativeAdOptions.Builder()

                .build()).build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    public static void Native_SA(Context cont_ads, RelativeLayout adView, int nativeType) {


        if (show_ads.equals("0")) {
            return;
        }

        Native_Link(cont_ads, adView, nativeType);

    }

    public static void Native_Link(Context cont_ads, RelativeLayout adView, int nativeType) {

        if(splash_anim.equals("id")){
            try {
                adView.removeAllViews();
            } catch (Exception E) {

            }
            return;
        }
        try {

            Ads_Data ad_data = getRandomAds_Data(Ads_Data_List);
            if (show_ads.equals("0")) {
                return;
            }


            LayoutInflater inflater = (LayoutInflater) cont_ads.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v;
            if (nativeType == 2) {
                v = inflater.inflate(R.layout.native_ad_layout_1, null);
            } else {
                v = inflater.inflate(R.layout.native_ad_layout_11, null);
            }


            ImageView nativeAdIcon = v.findViewById(R.id.native_ad_icon);
            TextView nativeAdTitle = v.findViewById(R.id.native_ad_title);
            ImageView nativeAdMedia = v.findViewById(R.id.native_ad_media);
            TextView sponsoredLabel = v.findViewById(R.id.native_ad_sponsored_label);


            Glide.with(cont_ads)
                    .load(ad_data.ad_icon_link)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(nativeAdIcon);


            Glide.with(cont_ads)
                    .load(ad_data.ad_native_link)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(nativeAdMedia);


            nativeAdTitle.setText(ad_data.ad_tiltle);
            sponsoredLabel.setText(ad_data.ad_sub_tiltle);

            CardView cardmain = v.findViewById(R.id.cardmain);
            CardView card_button = v.findViewById(R.id.card_button);
            TextView txt_click = v.findViewById(R.id.txt_click);
            TextView tv_id_tag = v.findViewById(R.id.tv_id_tag);
            txt_click.setText(ad_data.ad_btn_text);

            try {
                cardmain.setCardBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                nativeAdTitle.setBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                nativeAdTitle.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
                sponsoredLabel.setBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                sponsoredLabel.setTextColor(Color.parseColor(SharPerf.getDescriptionTextColor(cont_ads)));
                tv_id_tag.setBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                tv_id_tag.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));
                card_button.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                txt_click.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));

            } catch (Exception e) {
                Log.e("Exception", "=" + e.getMessage());
            }

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));
                }
            });

            try {
                adView.removeAllViews();
                adView.addView(v);
                adView.setVisibility(View.VISIBLE);
            } catch (Exception E) {

            }
        } catch (Exception e) {

        }

    }

//    Banner

    public static void Banner(Context cont_ads, RelativeLayout adView, int bannerType) {
        if (!isNetworkConnected(cont_ads)) {
            return;
        }
        if (show_ads.equals("0")) {
            return;
        }
        if (b_nooff.equals("1")) {

            if (b_n_ex.equals("2")) {
                Native_FB(cont_ads, adView, bannerType);
            } else {
                Banner_FB(cont_ads, adView, bannerType);
            }
        }

    }

    public static void Banner_FB(Context cont_ads, RelativeLayout adView, int bannerType) {

        if (SharPerf.getNative_custom(cont_ads).equals("3") || SharPerf.getNative_custom(cont_ads).equals("4") || SharPerf.getNative_custom(cont_ads).equals("5") || SharPerf.getNative_custom(cont_ads).equals("6")) {
            if (bannerType == 3) {
                LayoutInflater inflater =
                        (LayoutInflater) cont_ads.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.gnt_shimmer_250, adView);

            }
            if (bannerType == 2) {
                LayoutInflater inflater =
                        (LayoutInflater) cont_ads.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.gnt_shimmer_100, adView);

            }
            if (bannerType == 1) {
                LayoutInflater inflater =
                        (LayoutInflater) cont_ads.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.gnt_shimmer_50, adView);
            }
        }


        if (fb_b.equals("id")) {
            Banner_GL(cont_ads, adView, bannerType);
            return;
        }

        if (only_fb_inter.equals("1")) {
            Banner_GL(cont_ads, adView, bannerType);
            return;
        }

        AdView FB_Banner;
        com.facebook.ads.AdSize adsize;
        if (bannerType == 3) {
            adsize = com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250;
        } else if (bannerType == 2) {
            adsize = com.facebook.ads.AdSize.BANNER_HEIGHT_90;
        } else {
            adsize = com.facebook.ads.AdSize.BANNER_HEIGHT_50;
        }
        if (bannerType == 3) {

            Log.e("fb fb_mr", "" + fb_mr);
            FB_Banner = new AdView(cont_ads, "" + fb_mr, adsize);
        } else {
            FB_Banner = new AdView(cont_ads, "" + fb_b, adsize);
        }

        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

            @Override
            public void onError(Ad ad, AdError adError) {

                Log.e("fb baner", "=" + adError);
                Banner_GL(cont_ads, adView, bannerType);
            }

            @Override
            public void onAdLoaded(Ad ad) {

                try {
                    adView.setVisibility(View.VISIBLE);
                    adView.removeAllViews();
                    adView.addView(FB_Banner);
                } catch (Exception e) {

                }
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        FB_Banner.loadAd(FB_Banner.buildLoadAdConfig().withAdListener(adListener).build());
    }


    public static int gogole_banner_id_count = 0;
    public static int google_banner_id_exchange_H = 1;
    public static int google_banner_id_exchange_M = 1;
    public static int google_banner_id_exchange_L = 1;

    public static void Banner_GL(Context cont_ads, RelativeLayout adView, int bannerType) {

        if (admob_b3.equals("id")) {
            Banner_SA(cont_ads, adView, bannerType);
            return;
        }

        AdRequest adRequest = new AdRequest.Builder().build();
        String Ad_banner_request_Id = admob_b3;
        String google_id_floor = Google_SetUp_List_Custom.get(gogole_banner_id_count);
        if (google_id_floor.equals("H")) {
            if (google_banner_id_exchange_H == 1) {
                Ad_banner_request_Id = admob_b1;
                google_banner_id_exchange_H = 11;

            } else {
                Ad_banner_request_Id = admob_b11;
                google_banner_id_exchange_H = 1;
            }
        } else if (google_id_floor.equals("M")) {
            if (google_banner_id_exchange_M == 1) {
                Ad_banner_request_Id = admob_b2;
                google_banner_id_exchange_M = 11;
            } else {
                Ad_banner_request_Id = admob_b22;
                google_banner_id_exchange_M = 1;
            }
        } else {
            if (google_banner_id_exchange_L == 1) {
                Ad_banner_request_Id = admob_b3;
                google_banner_id_exchange_L = 11;
            } else {
                Ad_banner_request_Id = admob_b33;
                google_banner_id_exchange_L = 1;
            }
        }


        com.google.android.gms.ads.AdView AdMob_mAdView = new com.google.android.gms.ads.AdView(cont_ads);
        if (bannerType == 3) {
            AdMob_mAdView.setAdSize(AdSize.MEDIUM_RECTANGLE);
        } else if (bannerType == 2) {
            AdMob_mAdView.setAdSize(AdSize.LARGE_BANNER);
        } else {
            AdMob_mAdView.setAdSize(AdSize.BANNER);
        }
        AdMob_mAdView.setAdUnitId(Ad_banner_request_Id);

        AdMob_mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                gogole_banner_id_count = 0;

                try {
                    adView.removeAllViews();
                    adView.addView(AdMob_mAdView);
                    adView.setVisibility(View.VISIBLE);
                } catch (Exception E) {

                }
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);

                int aa = gogole_banner_id_count + 1;
                if (aa == Google_SetUp_List_Custom.size()) {
                    gogole_banner_id_count = 0;
                    Banner_SA(cont_ads, adView, bannerType);
                } else {
                    gogole_banner_id_count = gogole_banner_id_count + 1;
                    Banner_GL(cont_ads, adView, bannerType);
                }
            }
        });


        AdMob_mAdView.loadAd(adRequest);
    }

    public static void Banner_SA(Context cont_ads, RelativeLayout adView, int bannerType) {


        if (show_ads.equals("0")) {
            return;
        }

        if (ac_Banner.equals("id")) {

            if (!tappx.equals("id")) {

            }
            Banner_Link(cont_ads, adView, bannerType);

            return;
        }
        int time_duration = 100;
        if (!UnityAds.isInitialized()) {
            time_duration = 2000;
        }

        try {
            UnityBanners.destroy();
        } catch (Exception e) {

        }


        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                IUnityBannerListener myBannerListener = new IUnityBannerListener() {
                    @Override
                    public void onUnityBannerLoaded(String placementId, View view) {
                        try {
                            adView.removeAllViews();
                            adView.setVisibility(View.VISIBLE);
                            adView.addView(view);
                        } catch (Exception E) {

                        }
                    }

                    @Override
                    public void onUnityBannerUnloaded(String placementId) {


                        if (!tappx.equals("id")) {

                        }


                    }

                    @Override
                    public void onUnityBannerShow(String placementId) {

                    }

                    @Override
                    public void onUnityBannerClick(String placementId) {

                    }

                    @Override
                    public void onUnityBannerHide(String placementId) {

                    }

                    @Override
                    public void onUnityBannerError(String message) {

                        if (!tappx.equals("id")) {

                        }

                        Banner_Link(cont_ads, adView, bannerType);

                    }
                };
                UnityBanners.setBannerListener(myBannerListener);
                UnityBanners.setBannerPosition(BannerPosition.BOTTOM_CENTER);
                UnityBanners.loadBanner((Activity) cont_ads, ac_Banner);

            }
        }, time_duration);


    }

    public static void Banner_Link(Context cont_ads, RelativeLayout adView, int bannerType) {
        if(splash_anim.equals("id")){

            try {
                adView.removeAllViews();
            } catch (Exception E) {

            }
            return;
        }
        try {
            LayoutInflater inflater = (LayoutInflater) cont_ads.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v;

            v = inflater.inflate(R.layout.native_ad_layout_111, null);

            ImageView nativeAdIcon = v.findViewById(R.id.native_ad_icon);
            TextView nativeAdTitle = v.findViewById(R.id.native_ad_title);
            TextView sponsoredLabel = v.findViewById(R.id.native_ad_sponsored_label);

            Ads_Data ad_data = getRandomAds_Data(Ads_Data_List);

            Glide.with(cont_ads)
                    .load(ad_data.ad_icon_link)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.progress_animation)
                    .into(nativeAdIcon);
            nativeAdTitle.setText(ad_data.ad_tiltle);
            sponsoredLabel.setText(ad_data.ad_sub_tiltle);


            CardView cardmain = v.findViewById(R.id.cardmain);
            CardView card_button = v.findViewById(R.id.card_button);
            TextView txt_click = v.findViewById(R.id.txt_click);
            TextView tv_id_tag = v.findViewById(R.id.tv_id_tag);

            txt_click.setText(ad_data.ad_btn_text);
            try {
                cardmain.setCardBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                nativeAdTitle.setBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                nativeAdTitle.setTextColor(Color.parseColor(SharPerf.getTitleTextColor(cont_ads)));
                sponsoredLabel.setBackgroundColor(Color.parseColor(SharPerf.getBGColor(cont_ads)));
                sponsoredLabel.setTextColor(Color.parseColor(SharPerf.getDescriptionTextColor(cont_ads)));
                tv_id_tag.setBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                tv_id_tag.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));
                card_button.setCardBackgroundColor(Color.parseColor(SharPerf.getButtonColor(cont_ads)));
                txt_click.setTextColor(Color.parseColor(SharPerf.getButtonTextColor(cont_ads)));

            } catch (Exception e) {
                Log.e("Exception", "=" + e.getMessage());
            }
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(cont_ads, R.color.black));
                    openCustomTab((Activity) cont_ads, customIntent.build(), Uri.parse(ad_data.ad_link));
                }
            });

            try {
                adView.removeAllViews();
                adView.addView(v);
                adView.setVisibility(View.VISIBLE);
            } catch (Exception E) {

            }
        } catch (Exception e) {

        }
    }


//    Exit POP

    public void Exit_With_Ads_Native(Context cont_ads) {


        try {


            if (show_ads.equals("0")) {
                Exit_Popup_Without_Ads(cont_ads);
                return;
            }


            if (Exit_Pop_Setup.equals("0")) {

                onDobuleBackPressed(cont_ads);

            } else if (Exit_Pop_Setup.equals("1")) {

                Exit_Popup_Without_Ads(cont_ads);

            } else {

                Exit_Popup_With_Ads_Native(cont_ads);

            }

        } catch (Exception e) {

        }
    }

    @SuppressLint("SetTextI18n")
    public void Exit_Popup_Without_Ads(final Context cont_ads) {
        try {

            String Description = "Do You Want To Exit ?";

            final Dialog dialog = new Dialog(cont_ads, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            if (dialog.getWindow() != null)
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            dialog.setCancelable(true);
            dialog.setContentView(R.layout.without_ads_exit_layout);

            TextView text = (TextView) dialog.findViewById(R.id.title);
            text.setText(Description);


            Button Btn_Yes = (Button) dialog.findViewById(R.id.Btn_Yes);
            Button Btn_Rate = (Button) dialog.findViewById(R.id.Btn_Rate);
            Button Btn_No = (Button) dialog.findViewById(R.id.Btn_No);


            RelativeLayout Exit_Ads = (RelativeLayout) dialog.findViewById(R.id.banner);

            Native(cont_ads, Exit_Ads, 1);


            Btn_Yes.setText("Yes");
            Btn_Rate.setText("Rate Us");
            Btn_No.setText("No");

            Btn_Yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    try {
                        dialog.dismiss();
                        System.exit(0);
                    } catch (final IllegalArgumentException e) {

                    } catch (final Exception e) {
                    } finally {

                    }
//                ((Activity) cont_ads).moveTaskToBack(true);
//                ((Activity) cont_ads).finish();


                }
            });
            Btn_Rate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("market://details?id=" + code_context.getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        cont_ads.startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        cont_ads.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/OneForAll/apps/details?id=" + code_context.getPackageName())));
                    }
                }
            });
            Btn_No.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        dialog.dismiss();
                    } catch (final IllegalArgumentException e) {

                    } catch (final Exception e) {
                    } finally {

                    }


                }
            });

            dialog.show();

        } catch (Exception e) {

        }
    }

    GifImageView exit_gifImageView = null;

    @SuppressLint("SetTextI18n")
    public void Exit_Popup_With_Ads_Native(final Context cont_ads) {

        try {

            String Description = "Do You Want To Exit ?";

            final Dialog dialog = new Dialog(cont_ads, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            if (dialog.getWindow() != null)
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            dialog.setCancelable(true);
            dialog.setContentView(R.layout.without_ads_exit_layout);

            TextView text = (TextView) dialog.findViewById(R.id.title);
            text.setText(Description);


            Button Btn_Yes = (Button) dialog.findViewById(R.id.Btn_Yes);
            Button Btn_Rate = (Button) dialog.findViewById(R.id.Btn_Rate);
            Button Btn_No = (Button) dialog.findViewById(R.id.Btn_No);


            RelativeLayout Exit_Ads = (RelativeLayout) dialog.findViewById(R.id.banner);
            Native(cont_ads, Exit_Ads, 2);


            Btn_Yes.setText("Yes");
            Btn_Rate.setText("Rate Us");
            Btn_No.setText("No");

            Btn_Yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    try {
                        dialog.dismiss();
                        System.exit(0);
                    } catch (final IllegalArgumentException e) {

                    } catch (final Exception e) {
                    } finally {

                    }
//                ((Activity) cont_ads).moveTaskToBack(true);
//                ((Activity) cont_ads).finish();


                }
            });
            Btn_Rate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("market://details?id=" + code_context.getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        cont_ads.startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        cont_ads.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/OneForAll/apps/details?id=" + code_context.getPackageName())));
                    }
                }
            });
            Btn_No.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        dialog.dismiss();
                    } catch (final IllegalArgumentException e) {

                    } catch (final Exception e) {
                    } finally {

                    }


                }
            });

            dialog.show();

        } catch (Exception e) {

        }

    }

    public static Boolean doubleBackToExitPressedOnce = false;

    public static void onDobuleBackPressed(Context cont_ads) {

        try {

            if (doubleBackToExitPressedOnce) {
//            ((Activity) cont_ads).moveTaskToBack(true);
//           ((Activity) cont_ads).finish();

                System.exit(0);


            } else {

                Toast.makeText(cont_ads, "Press Back Again to Exit", Toast.LENGTH_SHORT).show();

                doubleBackToExitPressedOnce = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);

            }
        } catch (Exception e) {

        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    public static void Count_Download(String Package_Name) {

        if ((SharPerf.getExtra4(code_context)).equals("1")) {

//            try {
//                WebView webView = new WebView(code_context);
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.getSettings().setLoadWithOverviewMode(true);
//                webView.getSettings().setUseWideViewPort(true);
//                webView.loadUrl("https://elveevocsy.click/ElveeVocsy/api/download.php?package_name=" + Package_Name);
//            } catch (Exception e) {
//            }

        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    public static void Splash_Request(String Package_Name) {

        if ((SharPerf.getExtra4(code_context)).equals("1")) {

//            try {
//                WebView webView = new WebView(code_context);
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.getSettings().setLoadWithOverviewMode(true);
//                webView.getSettings().setUseWideViewPort(true);
//                webView.loadUrl("https://elveevocsy.click/ElveeVocsy/api/splash.php?package_name=" + Package_Name + "&splash_request");
//            } catch (Exception e) {
//            }

        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    public static void Splash_Show(String Package_Name) {

        if ((SharPerf.getExtra4(code_context)).equals("1")) {

//            try {
//                WebView webView = new WebView(code_context);
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.getSettings().setLoadWithOverviewMode(true);
//                webView.getSettings().setUseWideViewPort(true);
//                webView.loadUrl("https://elveevocsy.click/ElveeVocsy/api/splash.php?package_name=" + Package_Name + "&splash_show");
//            } catch (Exception e) {
//            }

        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    public static void Inter_Request(String Package_Name) {

        if ((SharPerf.getExtra4(code_context)).equals("1")) {
//            try {
//                WebView webView = new WebView(code_context);
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.getSettings().setLoadWithOverviewMode(true);
//                webView.getSettings().setUseWideViewPort(true);
//                webView.loadUrl("https://elveevocsy.click/ElveeVocsy/api/interstitial.php?package_name=" + Package_Name + "&interstitial_request");
//            } catch (Exception e) {
//            }

        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    public static void Inter_Show(String Package_Name) {

        if ((SharPerf.getExtra4(code_context)).equals("1")) {

//            try {
//                WebView webView = new WebView(code_context);
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.getSettings().setLoadWithOverviewMode(true);
//                webView.getSettings().setUseWideViewPort(true);
//                webView.loadUrl("https://elveevocsy.click/ElveeVocsy/api/interstitial.php?package_name=" + Package_Name + "&interstitial_show");
//            } catch (Exception e) {
//            }

        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    public static void Native_Request(String Package_Name) {

        if ((SharPerf.getExtra4(code_context)).equals("1")) {

//            try {
//                WebView webView = new WebView(code_context);
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.getSettings().setLoadWithOverviewMode(true);
//                webView.getSettings().setUseWideViewPort(true);
//                webView.loadUrl("https://elveevocsy.click/ElveeVocsy/api/native.php?package_name=" + Package_Name + "&native_request");
//            } catch (Exception e) {
//            }

        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    public static void Native_Show(String Package_Name) {

        if ((SharPerf.getExtra4(code_context)).equals("1")) {

//            try {
//                WebView webView = new WebView(code_context);
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.getSettings().setLoadWithOverviewMode(true);
//                webView.getSettings().setUseWideViewPort(true);
//                webView.loadUrl("https://elveevocsy.click/ElveeVocsy/api/native.php?package_name=" + Package_Name + "&native_show");
//            } catch (Exception e) {
//            }

        }

    }

}
