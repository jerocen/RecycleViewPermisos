package com.example.recycleviewpermisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 123;
    private static final int GALLERY_PERMISSION_REQUEST_CODE = 124;
    private static final int CONTACTS_PERMISSION_REQUEST_CODE = 125;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Acceso a la Cámara"));
        items.add(new Item("Acceso a Galería"));
        items.add(new Item("Acceso a contactos"));

        adapter = new SwitchAdapter(items, new SwitchAdapter.OnSwitchChangeListener() {
            @Override
            public void onSwitchChanged(Item switchItem, boolean isChecked) {
                if (isChecked)
                {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Item.getPermission()) != PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Item.getPermission()});
                    }
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(), items));


    }

    private void VerificarPermisoCamara()
    {
        ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
    }
}