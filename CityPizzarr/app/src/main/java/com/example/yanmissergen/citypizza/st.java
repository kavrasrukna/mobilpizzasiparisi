package com.example.yanmissergen.citypizza;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class st extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;


    EditText kart,cvc;
    TextView tv0,tv1,tv2,tv3,tv4;
    Button btn_odeme;
    DatePicker tarih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.CreateDataBase();
        db=databaseHelper.getWritableDatabase();


         kart= (EditText) findViewById(R.id.kart);
         cvc= (EditText) findViewById(R.id.cvc);
        tarih= (DatePicker) findViewById(R.id.tarih);
         btn_odeme=(Button) findViewById(R.id.btn_odeme);

         tv0= (TextView) findViewById(R.id.tv0);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
         tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        final int fiyat=extras.getInt("Fiyat:");


        tv0.setText(extras.getCharSequence("PizzaAdet".toString()));
        tv1.setText(extras.getCharSequence("PizzaBoyu:".toString()));
        tv2.setText(extras.getCharSequence("Malzemeler:".toString()));
        tv3.setText(extras.getCharSequence("HamurTuru:".toString()));
        tv4.setText(Integer.toString(fiyat)+" TL");

       btn_odeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Random rnd= new Random();
                int kartbakiye=rnd.nextInt(100);

               int kartno,guvenlik;


               kartno= Integer.parseInt(kart.getText().toString());
               guvenlik=Integer.parseInt(cvc.getText().toString());

                ContentValues cv=new ContentValues();
                cv.put("kredikartno",kartno);
                cv.put("cvc",guvenlik);
                cv.put("fiyat", fiyat);


                if( db.insert("tbl_siparis",null,cv)>0 && kartbakiye>fiyat){
                    Toast.makeText(getApplicationContext(),"İşlem Başarılı",Toast.LENGTH_LONG).show();
                    kart.setText("");
                    cvc.setText("");
                }
                else {

                    Toast.makeText(getApplicationContext(),"Bakiyeniz Yetersiz, İşlem Başarısız",Toast.LENGTH_LONG).show();

                }

            }
        });

    }

}
