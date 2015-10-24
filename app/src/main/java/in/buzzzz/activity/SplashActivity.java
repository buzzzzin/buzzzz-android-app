package in.buzzzz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import in.buzzzz.R;

/**
 * Created by ekansh on 24/10/15.
 */
public class SplashActivity extends Activity{

//    private static final int SPLASH_TIME_OUT = 3000;
    private static boolean isClicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        }, SPLASH_TIME_OUT);
    onClickListeners();
    }


    private void onClickListeners(){
        ImageView imageView = (ImageView) findViewById(R.id.splash_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isClicked) {
                    toggleSettings();
                } else {
                    isClicked = true;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            isClicked =false;
                        }
                    }, 400);
                }
            }

        });
    }

    private void toggleSettings(){
        System.out.println("#### show seeting snow");
        findViewById(R.id.splash_settings).setVisibility(View.VISIBLE);
        findViewById(R.id.splash_branding).setVisibility(View.GONE);
        findViewById(R.id.splash_enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
