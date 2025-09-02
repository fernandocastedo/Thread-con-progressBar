package com.example.myapplicationthreaddescarga;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciarDescarga;
    private ProgressBar progressBarDescarga;
    private TextView tvEstadoDescarga;
    private Handler handler = new Handler(Looper.getMainLooper()); //El handler se encarga de gestionar la comunicacion entre hilos
    private boolean estado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarDescarga = findViewById(R.id.btnDescarga); //Asociando las variables a los componentes del layout
        progressBarDescarga = findViewById(R.id.progressBarDescarga);
        tvEstadoDescarga = findViewById(R.id.tvEstadoDescarga);

        btnIniciarDescarga.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               if (estado) return; //Si ya se esta ejecutando una descarga, no hacer nada
               estado = true;
               progressBarDescarga.setProgress(0);
               tvEstadoDescarga.setText(R.string.tv_iniciando_descarga);

               Thread thread = new Thread (){
                   @Override
                   public void run(){
                       try{
                           for(int i=1;i<=100; i++){
                               Thread.sleep(100);
                               int progress = i;
                               handler.post(new Runnable(){
                                   @Override
                                   public void run(){
                                       progressBarDescarga.setProgress(progress);
                                       tvEstadoDescarga.setText("Descargando..."+ progress + "%");
                                   }
                               });
                           }
                           handler.post(new Runnable(){
                               @Override
                               public void run(){
                                   tvEstadoDescarga.setText(R.string.tv_descarga_completada);
                                   progressBarDescarga.setProgress(100);
                                   estado = false;
                               }
                           });

                       } catch (InterruptedException e){
                           e.printStackTrace();
                       }
                   }
               };
               thread.start();
           }
        });
    }
}