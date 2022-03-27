package com.example.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnThem;
    private  Button btnSua;
    private  Button bthXoa;
    private EditText etId;
    private EditText etName;
    private EditText etToan;
    private EditText etLi;
    private EditText etHoa;
    private  MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = new MyDatabase(this);
        initView();
        initListener();
    }
       private void initListener(){
           btnThem.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
              String name = etName.getText().toString();
              String toan = etToan.getText().toString();
              String li = etLi.getText().toString();
              String hoa = etHoa.getText().toString();
              boolean b1= myDatabase.insertData(name,toan,li,hoa);
              if (b1){
                  Toast.makeText(MainActivity.this,"Insert ",Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(MainActivity.this,"Insert fail",Toast.LENGTH_SHORT).show();
             }
               }
           });

           btnSua.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String id = etId.getText().toString();
                   String name = etName.getText().toString();
                   String toan = etToan.getText().toString();
                   String li = etLi.getText().toString();
                   String hoa = etHoa.getText().toString();
                   boolean b1= myDatabase.updateData(id,name,toan,li,hoa);
                   if (b1){
                       Toast.makeText(MainActivity.this,"Updated",Toast.LENGTH_SHORT).show();
                   }else {
                       Toast.makeText(MainActivity.this,"Updated fail",Toast.LENGTH_SHORT).show();
                   }
               }
           });
           bthXoa.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String id = etId.getText().toString();
                   boolean b1= myDatabase.deletaData(id);
                   if (b1){
                       Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
                   }else {
                       Toast.makeText(MainActivity.this,"Deleted fail",Toast.LENGTH_SHORT).show();
                   }
               }
           });
       }
    private void initView(){
        btnThem = (Button) findViewById(R.id.btn_them);
        btnSua =  (Button) findViewById(R.id.btn_sua);
        bthXoa = (Button) findViewById(R.id.btn_xoa);
        etId = (EditText) findViewById(R.id.et_id);
        etName = (EditText) findViewById(R.id.et_name);
        etToan = (EditText) findViewById(R.id.et_toan);
        etHoa = (EditText) findViewById(R.id.et_hoa);
        etLi = (EditText) findViewById(R.id.et_li);

    }
}