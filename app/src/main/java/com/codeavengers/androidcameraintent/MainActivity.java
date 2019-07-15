package com.codeavengers.androidcameraintent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    // PS: Don't ask your teacher for solution
    // TODO: Task - Write code for choosing an existing image from Gallery.
    // TODO: Task v2 - Write code for choosing an existing image from Gallery (multiple).

    @BindView(R.id.imgCameraImage)
    ImageView imgCameraImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Attach ButterKnife to this Activity
        * */
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.fab)
    void onFabClick()
    {
        /*
        * Open Camera and Click Photo.
        * */
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 3131);
    }

    /*
    * Jevha pan hya activity la return data bhetnar,
    * tevha onActivityResult(...) call honar #Janmabhar
    * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 3131)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                /*
                * Code to Get Image from Camera and show on ImageView #Janmabhar #Special
                * */
                Bundle extraData = data.getExtras();
                Bitmap bitmap = (Bitmap) extraData.get("data");

                /*
                * Set bitmap on imgCameraImage
                * */
                imgCameraImage.setImageBitmap(bitmap);

                // TODO: Write code for Saving Captured Image in Gallery.
                // TODO: You have "Intent data" with you.

            }
            else if (resultCode == Activity.RESULT_CANCELED)
            {
                for (int i = 0; i < 10; i++)
                {
                    Toast.makeText(this, "Photo kadhla nahi tar ka camera open kela. Ugach battery vaya. Haddd", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
