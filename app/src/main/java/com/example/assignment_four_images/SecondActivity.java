package com.example.assignment_four_images;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);

        Intent intent = getIntent();
        int[] imgResource = intent.getIntArrayExtra("imageResource");

        if (imgResource != null && imgResource.length >= 1) {
            img1.setImageResource(imgResource[0]);

        }

        img1.setOnClickListener(v -> returnImage(imgResource[0]));

    }

    private void returnImage(int imgResource) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedImageResId", imgResource);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
