package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FotosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);

        ViewPager galeria = (ViewPager) findViewById(R.id.galeria);
        GaleriaImagensAdapter adapter = new GaleriaImagensAdapter(this);
        galeria.setAdapter(adapter);
    }
}
