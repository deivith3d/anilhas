package com.example.novasanilhas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etKg;
    private EditText etLb;
    private EditText etVperc;
    private EditText etTotal;
    private EditText etTotalSb;
    private EditText etPerc;
    private EditText etIniAnilhas;
    private RadioButton rbMasc;
    private RadioButton rbFem;
    private Button btConverte;
    private Button btCalcula;
    private Button btLimpa;
    private float kg;
    private double lb=2.2f;
    private float vperc =50.0f;
    private double totalLb;
    private double totalSB;
    private int an45,an35,an25,an15,an10,an5,an2,iniAnilhas;
    private TextView tvA45,tvA35,tvA25,tvA15,tvA10,tvA5,tvA2;
    private TextView tvPorcentagem;
    private ProgressBar pbBarra;
    private Button btDiminui;
    private Button btAumenta;
    private int valor=50;
    private int maxanilha = 0;
    private CheckBox cbManterPesadas;
 //   private float vperc = 50.0f;
    private int MaxAnil =0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etKg = findViewById(R.id.editTextKg);
        etLb = findViewById(R.id.editTextLb);
        etTotal = findViewById(R.id.editTextTotalLb);
        //etVperc = findViewById(R.id.editTextVPerc);
        etTotalSb = findViewById(R.id.editTextPerc);
        rbMasc = findViewById(R.id.radioButtonM);
        rbFem = findViewById(R.id.radioButtonF);
        btConverte = findViewById(R.id.buttonConverteLb);
        btCalcula = findViewById(R.id.buttonCalculaTot2);
        btLimpa = findViewById(R.id.buttonLimpar);
        tvA45 = findViewById(R.id.textViewA45);
        tvA35 = findViewById(R.id.textViewA35);
        tvA25 = findViewById(R.id.textViewA25);
        tvA15 = findViewById(R.id.textViewA15);
        tvA10 = findViewById(R.id.textViewA10);
        tvA5 = findViewById(R.id.textViewA5);
        tvA2 = findViewById(R.id.textViewA2);
       // etIniAnilhas = findViewById(R.id.editTextIniAnilha);
        tvPorcentagem = findViewById(R.id.textViewPerc);
        pbBarra = findViewById(R.id.ProgressBar45);
        pbBarra.setProgress(valor);
        tvPorcentagem.setText(valor+"%");
        cbManterPesadas =findViewById(R.id.CheckboxManterAnilhas);

      //  lb = Float.parseFloat(etKg.getText().toString());
     //   totalLb = (lb * vperc)/ 100;
     //   etTotal.setText(String.format("%.2f",totalLb));
        btDiminui = findViewById(R.id.buttonD45);
        btDiminui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor = valor<=0?0:valor-5;
                pbBarra.setProgress(valor);
                tvPorcentagem.setText(valor+"%");
                totalLb = (lb * valor)/ 100;
                etTotal.setText(String.format("%.2f",totalLb));
            }
        });
        btAumenta = findViewById(R.id.buttonA45);
        btAumenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor = valor>=100?100:valor+5;
                pbBarra.setProgress(valor);
                tvPorcentagem.setText(valor+"%");
                totalLb = (lb * valor)/ 100;
                etTotal.setText(String.format("%.2f",totalLb));
            }
        });


        btConverte.setOnClickListener(new View.OnClickListener() {

            public void fecharTecladoNaActivity() {
                View view = MainActivity.this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
            }
            @Override
            public void onClick(View v) {
                kg = Float.parseFloat(etKg.getText().toString());
                lb = kg * 2.20;
                etLb.setText(String.format("%.2f",lb));
                totalLb = (lb * vperc)/ 100;
                etTotal.setText(String.format("%.2f",totalLb));
                fecharTecladoNaActivity();

            }
        });
        btCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!rbMasc.isChecked() && !rbFem.isChecked()) {
                    rbMasc.setChecked(true);
                }
                vperc = valor;//Float.parseFloat(etVperc.getText().toString());
                totalLb = (lb * vperc) / 100;
                etTotal.setText(String.format("%.2f", totalLb));
                if (rbMasc.isChecked()) {
                    totalSB = totalLb - 20 * 2.2;
                }
                if (rbFem.isChecked()) {
                    totalSB = totalLb - 15 * 2.2;
                }
                etTotalSb.setText(String.format("%.2f", totalSB));
                iniAnilhas = 45;//Integer.parseInt((etIniAnilhas.getText().toString()));
                if (!cbManterPesadas.isChecked()) {
                    iniAnilhas = 0;

                    if (totalSB > 90) {
                        an45 = (int) (totalSB / 90);
                        totalSB = totalSB - (an45) * 90;
                        an45 = an45 * 2;
                        tvA45.setText(String.valueOf(an45));
                        if (iniAnilhas == 0) {
                            iniAnilhas = 45;
                        }
                    }
                    if (totalSB >70) {
                        an35 = (int) (totalSB / 70);
                        totalSB = totalSB - (an35) * 70;
                        an35 = an35 * 2;
                        tvA35.setText(String.valueOf(an35));
                        if (iniAnilhas == 0) {
                            iniAnilhas = 35;
                        }
                    }
                    if (totalSB>50) {

                        an25 = (int) (totalSB / 50);
                        totalSB = totalSB - (an25) * 50;
                        an25 = an25 * 2;
                        tvA25.setText(String.valueOf(an25));
                        if (iniAnilhas == 0) {
                            iniAnilhas = 25;
                        }
                    }
                    if (totalSB>30) {
                        an15 = (int) (totalSB / 30);
                        totalSB = totalSB - (an15) * 30;
                        an15 = an15 * 2;
                        tvA15.setText(String.valueOf(an15));
                        if (iniAnilhas == 0) {
                            iniAnilhas = 15;
                        }
                    }
                    if (totalSB>20) {
                        an10 = (int) (totalSB / 20);
                        totalSB = totalSB - (an10) * 20;
                        an10 = an10 * 2;
                        tvA10.setText(String.valueOf(an10));
                        if (iniAnilhas == 0) {
                            iniAnilhas = 10;
                        }
                    }
                    if (totalSB>10) {
                          an5 = (int) (totalSB / 10);
                        totalSB = totalSB - (an5) * 10;
                        an5 = an5 * 2;
                        tvA5.setText(String.valueOf(an5));

                        if (iniAnilhas == 0) {
                            iniAnilhas = 5;
                        }
                    }
                    if (totalSB>4.4) {
                        an2 = (int) (totalSB / 4.4);
                        totalSB = totalSB - (an2) * 4.4;
                        an2 = an2 * 2;
                        tvA2.setText(String.valueOf(an2));
                         if (iniAnilhas == 0) {
                            iniAnilhas = 2;
                        }
                    }
                }
                else {
                    if (totalSB>90 && iniAnilhas>=45) {
                        an45 = (int) (totalSB / 90);
                        totalSB = totalSB - (an45) * 90;
                        an45 = an45 * 2;
                        tvA45.setText(String.valueOf(an45));
                    }
                    if (totalSB>70 && iniAnilhas>=35) {
                        an35 = (int) (totalSB / 70);
                        totalSB = totalSB - (an35) * 70;
                        an35 = an35 * 2;
                        tvA35.setText(String.valueOf(an35));
                    }
                    if (totalSB>50 && iniAnilhas>=25) {

                        an25 = (int) (totalSB / 50);
                        totalSB = totalSB - (an25) * 50;
                        an25 = an25 * 2;
                        tvA25.setText(String.valueOf(an25));
                    }
                    if (totalSB>30 && iniAnilhas>=15) {
                        an15 = (int) (totalSB / 30);
                        totalSB = totalSB - (an15) * 30;
                        an15 = an15 * 2;
                        tvA15.setText(String.valueOf(an15));
                    }
                    if (totalSB>20 && iniAnilhas>=10) {
                        an10 = (int) (totalSB / 20);
                        totalSB = totalSB - (an10) * 20;
                        an10 = an10 * 2;
                        tvA10.setText(String.valueOf(an10));
                    }
                    if (totalSB>10 && iniAnilhas>=5) {
                        an5 = (int) (totalSB / 10);
                        totalSB = totalSB - (an5) * 10;
                        an5 = an5 * 2;
                        tvA5.setText(String.valueOf(an5));
                    }
                    if (totalSB>4.4 && iniAnilhas>=2) {
                        an2 = (int) (totalSB / 4.4);
                        totalSB = totalSB - (an2) * 4.4;
                        an2 = an2 * 2;
                        tvA2.setText(String.valueOf(an2));
                    }
                }
            }
        });
        btLimpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etLb.setText("");
                etKg.setText("");
                etTotalSb.setText("");
                etTotal.setText("");
                tvA45.setText("0");
                tvA35.setText("0");
                tvA25.setText("0");
                tvA15.setText("0");
                tvA10.setText("0");
                tvA5.setText("0");
                tvA2.setText("0");
                rbMasc.setChecked(true);
                rbFem.setChecked(false);
                //etIniAnilhas.setText("45");
                //tvPorcentagem.setText("");
                valor = 50;
                pbBarra.setProgress(valor);
                tvPorcentagem.setText(valor+"%");
                etKg.requestFocus();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()==R.id.itemMontar)
        {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId()==R.id.itemPr) {
            Intent intent = new Intent(getApplicationContext(),BarraActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}