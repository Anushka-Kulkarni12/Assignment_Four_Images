package com.example.assignment_four_images;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnDog, btnCat, btnTiger, btnLion;
    ImageView imageView;

    private static final int IMAGE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    public void initView() {
        imageView = findViewById(R.id.imageView);
        btnDog = findViewById(R.id.btnDog);
        btnCat = findViewById(R.id.btnCat);
        btnTiger = findViewById(R.id.btnTiger);
        btnLion = findViewById(R.id.btnLion);
    }

    private void initListener() {
        btnDog.setOnClickListener(v -> openSecondActivity(R.drawable.img1));
        btnCat.setOnClickListener(v -> openSecondActivity(R.drawable.img2));
        btnTiger.setOnClickListener(v -> openSecondActivity(R.drawable.img3));
        btnLion.setOnClickListener(v -> openSecondActivity(R.drawable.img4));
    }

    private void openSecondActivity(int imgResource) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("imageResource", new int[]{imgResource});
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            int selectedImageResId = data.getIntExtra("selectedImageResId", -1);
            if (selectedImageResId != -1) {
                imageView.setImageResource(selectedImageResId);
            }
        }
    }
}
