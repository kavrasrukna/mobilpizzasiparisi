package com.example.yanmissergen.citypizza;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    int fiyat=0;




     String gelendeger;
     String icindekiler;
     CheckBox sucuk, sosis,salam,mantar,zeytin,kavurma,jelapeno,karides,tonbaligi;
     String togıl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);









        sucuk= (CheckBox) findViewById(R.id.sucuk);

         sosis= (CheckBox) findViewById(R.id.sosis);

         salam= (CheckBox) findViewById(R.id.salam);

         mantar= (CheckBox) findViewById(R.id.mantar);

         zeytin= (CheckBox) findViewById(R.id.zeytin);

         kavurma= (CheckBox) findViewById(R.id.kavurma);

         jelapeno= (CheckBox) findViewById(R.id.jelapeno);

         tonbaligi= (CheckBox) findViewById(R.id.tonbaligi);

         karides= (CheckBox) findViewById(R.id.karides);

         sucuk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                 if(sucuk.isChecked())
                 {

                     Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();

                 }
             }
         });
         salam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(salam.isChecked())
                {

                    Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        zeytin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(zeytin.isChecked())
                {

                    Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        kavurma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(kavurma.isChecked())
                {

                    Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        sosis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(sosis.isChecked())
                {

                    Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        jelapeno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(jelapeno.isChecked())
                {

                    Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        karides.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(karides.isChecked())
                {

                    Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        tonbaligi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(tonbaligi.isChecked())
                {

                    Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        mantar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(mantar.isChecked())
                {

                    Toast.makeText(getApplicationContext(),buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        final RadioGroup rg_usertype= (RadioGroup) findViewById(R.id.rg_usertype);


        final AlertDialog.Builder dlg=new AlertDialog.Builder(this);

        final Button tv_sonuc = (Button) findViewById(R.id.tv_sonuc);
        tv_sonuc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final ImageButton bir= (ImageButton) findViewById(R.id.bir);
                final ImageButton iki= (ImageButton) findViewById(R.id.iki);
                final ImageButton uc= (ImageButton) findViewById(R.id.uc);

                if(sucuk.isChecked())
                {
                    icindekiler=" "+sucuk.getText().toString();
                    fiyat+=1;
                }
                else if(salam.isChecked())
                {
                    icindekiler+=" "+salam.getText().toString();
                    fiyat+=1;
                }
                if(zeytin.isChecked()) {
                    icindekiler+=" "+zeytin.getText().toString();
                    fiyat+=1;
                }
                if(kavurma.isChecked())
                {
                   icindekiler+= " "+kavurma.getText().toString();
                    fiyat+=1;
                }
                if(mantar.isChecked())
                {
                    icindekiler+=" "+mantar.getText().toString();
                    fiyat+=1;
                }
                if(jelapeno.isChecked())
                {
                    icindekiler+=" "+jelapeno.getText().toString();
                    fiyat+=1;
                }
                if(tonbaligi.isChecked())
                {
                    icindekiler+=" "+tonbaligi.getText().toString();
                    fiyat+=1;
                }
                if(karides.isChecked())
                {
                    icindekiler+=" "+karides.getText().toString();
                    fiyat+=1;
                }
                if(sosis.isChecked())
                {
                    icindekiler+=" "+sosis.getText().toString();
                    fiyat+=1;
                }

                RadioButton kucuk= (RadioButton) findViewById(R.id.kucuk);
                RadioButton orta= (RadioButton) findViewById(R.id.orta);
                RadioButton buyuk= (RadioButton) findViewById(R.id.buyuk);
                if(kucuk.isChecked())
                {
                    gelendeger=kucuk.getText().toString();
                    fiyat+=10;
                }
                else if(orta.isChecked())
                {
                    gelendeger=orta.getText().toString();
                    fiyat+=15;

                }
                else if(buyuk.isChecked())
                {
                    gelendeger=buyuk.getText().toString();
                    fiyat+=20;
                }

                final Spinner spinner = (Spinner) findViewById(R.id.spinner);
                dlg.setTitle("Sipariş Verilmeye Hazır");
                dlg.setMessage("Sipariş Detayları:\n Adet:" +(spinner.getSelectedItem().toString())+"\n"+" Boyu: "+gelendeger+"\n"
                        +"Malzemeler:"+icindekiler+"\n"+"Hamur Türü:"+togıl+"\n"+"Fiyat:"+fiyat);
                dlg.setPositiveButton("Gönder", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(getApplicationContext(), st.class);
                        intent.putExtra("PizzaAdet",spinner.getSelectedItem().toString());
                        intent.putExtra("PizzaBoyu:",gelendeger);
                        intent.putExtra("Malzemeler:",icindekiler);
                        intent.putExtra("HamurTuru:",togıl);
                        intent.putExtra("Fiyat:",fiyat);
                        startActivity(intent);


                    }});
                dlg.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }});
                AlertDialog dialog = dlg.create();
                dialog.show();
            }


        });
        final Spinner spinner= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.PizzaSayısı, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                spinner.setOnItemSelectedListener(this);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        final ToggleButton toggle = (ToggleButton) findViewById(R.id.togglebutton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (toggle.isChecked()) {

                    togıl=toggle.getTextOn().toString();
                    fiyat+=5;
                    


                } else {

                    togıl=toggle.getTextOff().toString();
                    fiyat+=5;

                }
            }
        });

    }





    }
