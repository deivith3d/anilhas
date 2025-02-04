package com.example.novasanilhas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class BarraActivity extends AppCompatActivity {

    private RadioButton rbMasc;
    private RadioButton rbFem;
    private int N45=0,N35=0,N25=0,N15=0,N10=0,N5=0,N2=0;
    private float totalLB=0.0f, totalKG=0.0f;
    private TextView tv45,tv35,tv25,tv15,tv10,tv5,tv2;
    private ProgressBar pb45,pb35,pb25,pb15,pb10,pb5,pb2;
    private Button btA45,btA35,btA25,btA15,btA10,btA5,btA2;
    private Button btD45,btD35,btD25,btD15,btD10,btD5,btD2;
    private TextView tvTotalLB;
    private TextView tvTotalKG;
    private float barra =0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_barra);
        rbMasc = findViewById(R.id.radioButtonM);
        rbFem = findViewById(R.id.radioButtonF);
        tvTotalLB = findViewById(R.id.textViewTotalLibras);
        tvTotalKG = findViewById(R.id.textViewTotalKG);
        if(!rbMasc.isChecked()&&!rbFem.isChecked())
        {
            rbMasc.setChecked(true);
            barra = 44.0f;
            totalLB = (float) (barra);
            tvTotalLB.setText(Float.toString(totalLB));
            totalKG = (float) (totalLB/2.2);
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            tvTotalKG.setText(decimalFormat.format(totalKG));
        }
        rbMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barra = 44.0f;
                totalLB = (float) (barra);
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
                N45=0;N35=0;N25=0;N15=0;N10=0;N5=0;N2=0;
                pb45.setProgress(N45);
                pb35.setProgress(N35);
                pb25.setProgress(N25);
                pb15.setProgress(N15);
                pb10.setProgress(N10);
                pb5.setProgress(N5);
                pb2.setProgress(N2);
                tv45.setText(Integer.toString(N45/10));
                tv35.setText(Integer.toString(N35/10));
                tv25.setText(Integer.toString(N25/10));
                tv15.setText(Integer.toString(N15/10));
                tv10.setText(Integer.toString(N10/10));
                tv5.setText(Integer.toString(N5/10));
                tv2.setText(Integer.toString(N2/10));
            }
        });
        rbFem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barra = 30.0f;
                totalLB = (float) (barra);
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
                N45=0;N35=0;N25=0;N15=0;N10=0;N5=0;N2=0;
                pb45.setProgress(N45);
                pb35.setProgress(N35);
                pb25.setProgress(N25);
                pb15.setProgress(N15);
                pb10.setProgress(N10);
                pb5.setProgress(N5);
                pb2.setProgress(N2);
                tv45.setText(Integer.toString(N45/10));
                tv35.setText(Integer.toString(N35/10));
                tv25.setText(Integer.toString(N25/10));
                tv15.setText(Integer.toString(N15/10));
                tv10.setText(Integer.toString(N10/10));
                tv5.setText(Integer.toString(N5/10));
                tv2.setText(Integer.toString(N2/10));
            }
        });

        //----------------------------45 -------------------------------//
        tv45 = findViewById(R.id.textViewPerc);
        btA45 = findViewById(R.id.buttonA45);
        btD45 = findViewById(R.id.buttonD45);
        pb45 = findViewById(R.id.ProgressBar45);

        btD45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N45 = N45<=0?0:N45-20;
                pb45.setProgress(N45);
                tv45.setText(Integer.toString(N45/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
            }
        });

        btA45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N45 = N45>=100?100:N45+20;
                pb45.setProgress(N45);
                tv45.setText(Integer.toString(N45/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));


            }
        });

        //----------------------------35 -------------------------------//
        tv35 = findViewById(R.id.textViewA35);
        btA35 = findViewById(R.id.buttonA35);
        btD35 = findViewById(R.id.buttonD35);
        pb35 = findViewById(R.id.ProgressBar35);

        btD35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N35 = N35<=0?0:N35-20;
                pb35.setProgress(N35);
                tv35.setText(Integer.toString(N35/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
            }
        });

        btA35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N35 = N35>=100?100:N35+20;
                pb35.setProgress(N35);
                tv35.setText(Integer.toString(N35/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));


            }
        });

        //----------------------------25 -------------------------------//
        tv25 = findViewById(R.id.textViewA25);
        btA25 = findViewById(R.id.buttonA25);
        btD25 = findViewById(R.id.buttonD25);
        pb25 = findViewById(R.id.ProgressBar25);

        btD25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N25 = N25<=0?0:N25-20;
                pb25.setProgress(N25);
                tv25.setText(Integer.toString(N25/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
            }
        });

        btA25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N25 = N25>=100?100:N25+20;
                pb25.setProgress(N35);
                tv25.setText(Integer.toString(N25/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));


            }
        });

        //----------------------------15 -------------------------------//
        tv15 = findViewById(R.id.textViewA15);
        btA15 = findViewById(R.id.buttonA15);
        btD15 = findViewById(R.id.buttonD15);
        pb15 = findViewById(R.id.ProgressBar15);

        btD15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N15 = N15<=0?0:N15-20;
                pb15.setProgress(N15);
                tv15.setText(Integer.toString(N15/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
            }
        });

        btA15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N15 = N25>=100?100:N15+20;
                pb15.setProgress(N15);
                tv15.setText(Integer.toString(N15/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));


            }
        });

        //----------------------------10 -------------------------------//
        tv10 = findViewById(R.id.textViewA10);
        btA10 = findViewById(R.id.buttonA10);
        btD10 = findViewById(R.id.buttonD10);
        pb10 = findViewById(R.id.ProgressBar10);

        btD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N10 = N10<=0?0:N10-20;
                pb10.setProgress(N10);
                tv10.setText(Integer.toString(N10/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
            }
        });

        btA10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N10 = N10>=100?100:N10+20;
                pb10.setProgress(N10);
                tv10.setText(Integer.toString(N10/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));


            }
        });

        //----------------------------5 -------------------------------//
        tv5 = findViewById(R.id.textViewA5);
        btA5 = findViewById(R.id.buttonA5);
        btD5 = findViewById(R.id.buttonD5);
        pb5 = findViewById(R.id.ProgressBar5);

        btD5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N5 = N5<=0?0:N5-20;
                pb5.setProgress(N5);
                tv5.setText(Integer.toString(N5/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
            }
        });

        btA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N5 = N5>=100?100:N5+20;
                pb5.setProgress(N5);
                tv5.setText(Integer.toString(N5/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));


            }
        });

        //----------------------------2 -------------------------------//
        tv2 = findViewById(R.id.textViewA2);
        btA2 = findViewById(R.id.buttonA2);
        btD2 = findViewById(R.id.buttonD2);
        pb2 = findViewById(R.id.ProgressBar2);

        btD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N2 = N2<=0?0:N2-20;
                pb2.setProgress(N2);
                tv2.setText(Integer.toString(N2/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));
            }
        });

        btA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N2 = N2>=100?100:N2+20;
                pb2.setProgress(N2);
                tv2.setText(Integer.toString(N2/10));
                totalLB = (float) (barra+(N45/10*45)+(N35/10*35)+(N25/10*25)+(N15/10*15)+(N10/10*10)+(N5/10*5)+(N2/10*2.2));
                tvTotalLB.setText(Float.toString(totalLB));
                totalKG = (float) (totalLB/2.2);
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                tvTotalKG.setText(decimalFormat.format(totalKG));


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