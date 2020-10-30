package com.example.recyclerviewtiki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListCategoryFragment.CallBack {
    ListCategoryFragment listCategoryFragment;
    ListProductFragment listProductFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCategoryFragment = new ListCategoryFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frgCategory, listCategoryFragment).commit();
    }


    @Override
    public void onSelectItem(int id) {
        Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();
        listProductFragment = ListProductFragment.newInstance(id);
        getSupportFragmentManager().beginTransaction().replace(R.id.frgProduct, listProductFragment, "products").commit();

    }
}