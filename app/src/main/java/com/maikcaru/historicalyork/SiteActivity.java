package com.maikcaru.historicalyork;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenjishi.slide.IntentUtils;
import com.chenjishi.slide.SlidingActivity;


public class SiteActivity extends SlidingActivity {

    int selectedIndex;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siteinformation);
        selectedIndex = getIntent().getIntExtra("index", 0);
        Site selected = Sites.get(SiteActivity.this).getAllSites().get(selectedIndex);

        setTitle(selected.getName());
        TextView infoText = (TextView) findViewById(R.id.info);
        infoText.setText(selected.getInfo());

        ImageView image = (ImageView) findViewById(R.id.image);
        int imageID = getResources().getIdentifier(selected.getImageLocation(), "drawable", getPackageName());

        Drawable d = getResources().getDrawable(imageID);
        Log.e("Image ID ", imageID + " ");
        image.setImageDrawable(d);
    }

    @Override
    public void startNextActivity(){
        Intent intent = new Intent(SiteActivity.this,MapsActivity.class);
        intent.putExtra("index", selectedIndex);
        IntentUtils.startPreviewActivity(SiteActivity.this,intent);
    }

}
