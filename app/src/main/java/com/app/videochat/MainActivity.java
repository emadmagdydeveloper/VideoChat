package com.app.videochat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.app.videochat.databinding.ActivityMainBinding;


import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetUserInfo;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    //chatapp2020.com@gmail.com
    //chat123456
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initView();
    }

    private void initView() {
        binding.btnStart.setOnClickListener(view -> {
            startVideoChat();
        });
    }

    private void startVideoChat() {
        try {
           JitsiMeetUserInfo userInfo = new JitsiMeetUserInfo();
            userInfo.setDisplayName("Emad");
            userInfo.setEmail("emad@gmail.com");

            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL("https://meet.jit.si"))
                    .setRoom("test123")
                    .setUserInfo(userInfo)
                    .setAudioMuted(false)
                    .setVideoMuted(false)
                    .setAudioOnly(false)
                    .setWelcomePageEnabled(false)
                    .build();
            JitsiMeetActivity.launch(this,options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}