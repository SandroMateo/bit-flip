package com.epicodus.bitflip;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewItemActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.newItemDescription) EditText mNewItemDescription;
    @Bind(R.id.newItemName) EditText mNewItemName;
    @Bind(R.id.newItemPrice) EditText mNewItemPrice;
    @Bind(R.id.spinnerCategory) Spinner mNewItemCategory;
    @Bind(R.id.inputName) EditText mInputName;
    @Bind(R.id.inputEmail) EditText mInputEmail;
    @Bind(R.id.inputPhone) EditText mInputPhone;
    @Bind(R.id.newItemButton) Button mNewItemButton;
    private String[] mCategoryArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        ButterKnife.bind(this);
        Resources res = getResources();

        mCategoryArray = res.getStringArray(R.array.categories);

        mNewItemButton.setOnClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mCategoryArray);
        mNewItemCategory.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v == mNewItemButton) {
            String newItemDescription = mNewItemDescription.getText().toString();
            String newItemName = mNewItemName.getText().toString();
            String newItemPrice = mNewItemPrice.getText().toString();
            String inputName = mInputName.getText().toString();
            String inputEmail = mInputEmail.getText().toString();
            String inputPhone = mInputPhone.getText().toString();
            Intent intent = new Intent(NewItemActivity.this, ItemDisplayActivity.class);
            intent.putExtra("itemDescription", newItemDescription);
            intent.putExtra("itemName", newItemName);
            intent.putExtra("itemPrice", newItemPrice);
            intent.putExtra("userName", inputName);
            intent.putExtra("userEmail", inputEmail);
            intent.putExtra("userPhone", inputPhone);
            startActivity(intent);
        }
    }
}
