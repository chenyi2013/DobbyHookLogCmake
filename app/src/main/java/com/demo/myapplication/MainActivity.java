package com.demo.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.myapplication.databinding.ActivityMainBinding;
import com.jiliguala.hook.HookLog;

public class MainActivity extends AppCompatActivity {

    private static HookLog hookLog;

    // Used to load the 'myapplication' library on application startup.
    static {
        System.loadLibrary("hook-log");
        HookLog.init();
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.sampleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Example of a call to a native method
                TextView tv = binding.sampleText;
                tv.setText(stringFromJNI());
            }
        });


    }

    /**
     * A native method that is implemented by the 'myapplication' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}