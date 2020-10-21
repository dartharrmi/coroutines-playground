package com.dartharrmi.coroutinesonandroid

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val IMAGE_URL =
        "https://raw.githubusercontent.com/DevTides/JetpackDogsApp/master/app/src/main/res/drawable/dog.png"
    private val coroutinesScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coroutinesScope.launch {
            val originalDeferred = coroutinesScope.async(Dispatchers.IO) {
                getOriginalBitmap()
            }
            loadImage(originalDeferred.await())
        }
    }

    private fun getOriginalBitmap() = URL(IMAGE_URL).openStream().use {
        BitmapFactory.decodeStream(it)
    }

    private fun loadImage(bitmap: Bitmap) {
        progressBar.visibility = GONE
        imageView.visibility = VISIBLE
        imageView.setImageBitmap(bitmap)
    }
}