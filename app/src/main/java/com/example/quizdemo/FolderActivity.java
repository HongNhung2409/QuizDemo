package com.example.quizdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FolderActivity extends AppCompatActivity {

    private ListView listViewFolder;
    private FloatingActionButton floatingActionButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);

        // Thiết lập Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarFolder);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Thư mục cá nhân");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Khởi tạo các thành phần giao diện
        listViewFolder = findViewById(R.id.listViewFolder);
        floatingActionButtonAdd = findViewById(R.id.floatingActionButtonAdd);

        // Xử lý sự kiện FloatingActionButton
        floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FolderActivity.this, "Thêm thư mục mới!", Toast.LENGTH_SHORT).show();
                // Thêm logic để mở giao diện thêm thư mục mới
            }
        });

        // Thiết lập dữ liệu mẫu cho ListView
        setupListView();
    }

    private void setupListView() {
        // Dữ liệu mẫu
        String[] folders = {"Thư mục 1", "Thư mục 2", "Thư mục 3", "Thư mục 4"};
        FolderAdapter adapter = new FolderAdapter(this, folders);
        listViewFolder.setAdapter(adapter);

        // Xử lý sự kiện khi chọn một thư mục
        listViewFolder.setOnItemClickListener((parent, view, position, id) -> {
            String folderName = folders[position];
            Toast.makeText(FolderActivity.this, "Bạn đã chọn: " + folderName, Toast.LENGTH_SHORT).show();

            // Mở LibActivity và truyền tên thư mục qua Intent
            Intent intent = new Intent(FolderActivity.this, LibActivity.class);
            intent.putExtra("folder_name", folderName);
            startActivity(intent);
        });
    }
}
