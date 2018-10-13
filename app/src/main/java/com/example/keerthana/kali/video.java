package com.example.keerthana.kali;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends AppCompatActivity {
    VideoView video;
    MediaController mediac;
    Button btn;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video = (VideoView) findViewById(R.id.vid);
        btn=(Button)findViewById(R.id.btn1);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m=new Intent(video.this,terms.class);
                startActivity(m);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediac==null)
                {
                    mediac=new MediaController(video.this);
                    mediac.setAnchorView(video);
                }


                video.setMediaController(mediac);
                video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video2));
                video.start();
            }
        });

    }
}
