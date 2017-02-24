package com.discordler.discordler;

import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_about);

        Element adsElemnt = new Element();
        adsElemnt.setTitle("Advertise here");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.banner)
                .setDescription("This is really pre Alpha stuff!")
                .addItem(new Element().setTitle("Version 0.0.3"))
                .addGroup("Connect with us!")
                .addWebsite("https://discordler.github.io/")
                .addGitHub("discordler")
                .addEmail("seitzf1@yahoo.de")
                .addYoutube("FaserF11")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }

    private Element createCopyright() {
        Element copyright = new Element();
        final String copyrightString = String.format("Copyright %d by the Discordler Team", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setIconDrawable(R.mipmap.ic_launcher);
        copyright.setTitle(copyrightString);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(About.this, copyrightString, Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}
