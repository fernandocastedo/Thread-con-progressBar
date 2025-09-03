package com.example.myapplicationthreaddescarga;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VestirPersonaje extends AppCompatActivity {
    private ImageButton imgbtnBrazoDerecho;
    private ImageButton imgbtnBrazoIzquierdo;
    private ImageButton imgbtnCuerpo;
    private ImageButton imgbtnLegs;
    private boolean estado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vestir_personaje);

        imgbtnBrazoDerecho = findViewById(R.id.imgbtnBrazoDerecho);
        imgbtnBrazoIzquierdo = findViewById(R.id.imgbtnBrazoIzquierdo);
        imgbtnCuerpo = findViewById(R.id.imgbtnCuerpo);
        imgbtnLegs = findViewById(R.id.imgbtnLegs);

        imgbtnBrazoDerecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (estado) return; //Si ya se esta ejecutando una descarga, no hacer nada
                estado = true;

                Thread thread = new Thread(){
                    public void Run(){
                        try{

                            }
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        estado = false;
                }
            }
        });
    }
}