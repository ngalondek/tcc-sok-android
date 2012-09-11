package com.app.android.sok4;

import java.io.IOException;

import com.app.android.sok4.R;
import com.app.android.sok4.R.id;
import com.app.android.sok4.R.layout;
import com.app.android.sok4.R.string;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class SongBoard extends Activity {
    /** Called when the activity is first created. */
    private MediaPlayer mp;
    private String songTitle;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mp = new MediaPlayer();
        setContentView(R.layout.songboard);
        showResults();

    }

    @Override
    public void onPause() {
        super.onPause();
        try {
        mp.pause();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    private void showResults() {

        Bundle bunde = this.getIntent().getExtras();
        String song = bunde.getString("SONG_TEXT");
        songTitle = bunde.getString("SONG_TITLE");
        TextView t3 = (TextView) findViewById(R.id.text);
        t3.setText(song.toCharArray(), 0, song.length());
    }

    @Override
    public boolean onSearchRequested() {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, R.string.app_about);
        menu.add(0, 1, 1, R.string.play);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
        case 0:
            openOptionsDialog();
            break;
        case 1:
            playFile();
            break;
        }
        return true;
    }
    
    private void openOptionsDialog() {
        new AlertDialog.Builder(this).setTitle(R.string.app_version)
            .setMessage(R.string.app_about_msg).setPositiveButton(
                R.string.str_ok, new DialogInterface.OnClickListener() {
                    public void onClick(
                        DialogInterface dialoginterface, int i) {
                    }
                }).show();
        }

    @SuppressLint("SdCardPath")
	private void playFile() {


        try {
            mp.reset();
            mp.setDataSource("/sdcard/Music/sok/"+songTitle+".mp3");
            
            //Toast.makeText(SongBoard.this, "/sdcard/Music/"+songTitle+".mp3",
            //        Toast.LENGTH_SHORT).show();
            mp.prepare();
            mp.start();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}