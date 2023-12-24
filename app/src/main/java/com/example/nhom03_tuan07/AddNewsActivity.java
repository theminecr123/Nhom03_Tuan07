package com.example.nhom03_tuan07;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import Adapters.Model_TinTuc;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.net.URL;


public class AddNewsActivity extends AppCompatActivity {

    private EditText etImageUrl, etTitle, etUrl;
    private Button btnAddImage, btnAddNews;
    ImageView imgAdd;
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    int luaChon = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);
        etImageUrl = findViewById(R.id.etImageUrl);
        etTitle = findViewById(R.id.etTitle);
        etUrl = findViewById(R.id.URL);
        btnAddImage = findViewById(R.id.btnAddImage);
        btnAddNews = findViewById(R.id.btnAddNews);
        imgAdd = findViewById(R.id.imgAdd);
        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence optionMenu[] = {"Chụp ảnh", "Chọn ảnh", "Thoát"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AddNewsActivity.this);
                builder.setItems(optionMenu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (optionMenu[i] == "Chụp ảnh"){
                            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            setResult(RESULT_OK,takePicture);
                            luaChon = 1;
                            getPhoto.launch(takePicture);

                        }else if(optionMenu[i] == "Chọn ảnh"){
                            Intent pickPhoto = new Intent();
                            pickPhoto.setType("image/*");
                            pickPhoto.setAction(Intent.ACTION_GET_CONTENT);
                            setResult(RESULT_OK,pickPhoto);
                            luaChon = 2;
                            getPhoto.launch(pickPhoto);

                        } else if (optionMenu[i] == "Thoát") {
                            dialog.dismiss();

                        }
                    }
                });
                builder.show();
            }
        });
        btnAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imageUrl = etImageUrl.getText().toString();
                String title = etTitle.getText().toString();
                String url = etUrl.getText().toString();
                if (imageUrl.isEmpty() || title.isEmpty() || url.isEmpty()) {
                    Toast.makeText(AddNewsActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                Model_TinTuc newTinTuc = new Model_TinTuc(imageUrl, title, url);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newTinTuc", newTinTuc);
                setResult(RESULT_OK, resultIntent);

                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            etImageUrl.setText(selectedImageUri.toString());
        }
    }
    ActivityResultLauncher<Intent> getPhoto = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            Intent data = result.getData();
            if (data != null) {
                if (luaChon == 1) {
                    // Xử lý chụp ảnh
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    imgAdd.setImageBitmap(imageBitmap);
                    // Đặt Uri cho EditText (nếu có)
                } else if (luaChon == 2) {
                    // Xử lý chọn ảnh từ thư viện
                    Uri selectedImageUri = data.getData();
                    if (selectedImageUri != null) {
                        etImageUrl.setText(selectedImageUri.toString());
                        try {
                            Bitmap selectdata = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                            imgAdd.setImageBitmap(selectdata);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                imgAdd.setVisibility(View.VISIBLE);
                etImageUrl.setVisibility(View.GONE);
            }
        }
    });
}
