package com.example.quizdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LibActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Toolbar toolbar;
    private TextView textViewFolder;
    private ListView listViewLib;
    private FloatingActionButton floatingActionButtonAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);

        // Ánh xạ các view từ layout
        progressBar = findViewById(R.id.progressBarLoad);
        toolbar = findViewById(R.id.toolbar);
        textViewFolder = findViewById(R.id.textViewFolder);
        listViewLib = findViewById(R.id.listViewLib);
        floatingActionButtonAdd = findViewById(R.id.floatingActionButtonAdd);

        // Thiết lập Toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Library");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Thiết lập FloatingActionButton
        floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi nhấn nút thêm
                // Ví dụ: Hiển thị thông báo hoặc mở một activity khác
                // Toast.makeText(LibActivity.this, "Add button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Ẩn ProgressBar sau khi load xong (demo)
        simulateLoading();
    }

    private void simulateLoading() {
        progressBar.setVisibility(View.VISIBLE);
        listViewLib.postDelayed(() -> {
            progressBar.setVisibility(View.GONE);
            // Hiển thị nội dung ListView nếu cần
        }, 2000); // 2 giây
    }
}
