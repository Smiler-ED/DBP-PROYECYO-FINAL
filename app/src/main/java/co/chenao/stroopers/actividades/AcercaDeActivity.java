package co.chenao.stroopers.actividades;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import co.chenao.stroopers.R;
import co.chenao.stroopers.clases.PreferenciasJuego;

public class AcercaDeActivity extends AppCompatActivity {

    FloatingActionButton btnInicio;
    RelativeLayout layoutFondo;
    ImageButton icoYoutube,icoFace,icoInstagram,icoTwitter,icoBlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        layoutFondo=findViewById(R.id.idLayoutFondo);
        icoYoutube=findViewById(R.id.icoYoutube);
        icoFace=findViewById(R.id.icoFace);
        icoInstagram=findViewById(R.id.icoInstagram);
        icoTwitter=findViewById(R.id.icoTwitter);
        icoBlog=findViewById(R.id.icoBlog);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            layoutFondo.setBackground(getResources().getDrawable(PreferenciasJuego.formaBanner));
        }else{
            layoutFondo.setBackgroundDrawable(getResources().getDrawable(PreferenciasJuego.formaBanner));
        }

        Drawable shape = (Drawable) layoutFondo.getBackground();
        shape.setColorFilter(getResources().getColor(PreferenciasJuego.colorTema), android.graphics.PorterDuff.Mode.SRC);

        btnInicio=findViewById(R.id.btnHome);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void onClick(View view) {
        Intent miIntent=null;
        boolean error=false;
        switch (view.getId()){
            case R.id.icoBlog: miIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iconfinder.com/"));
                break;
            case R.id.icoYoutube: miIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/CristianDavidHenao?sub_confirmation=1"));
                break;
            case R.id.icoFace: miIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/"));
                break;
            case R.id.icoTwitter: miIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
                break;
            case R.id.icoInstagram: miIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
                break;
            case R.id.btnDescargar:
                String url="https://docs.google.com/presentation/d/1LSFqJRta-VBpgcxZ6xQx3rZb9vHqhnecTrKMQkVZzlE/edit#slide=id.p";

                if (!url.equals("vacio")){
                    Uri uri = Uri.parse(url);
                    miIntent = new Intent(Intent.ACTION_VIEW,uri);
                }else{
                    error=true;
                    Toast.makeText(this, "No se puede obtener el manual de usuario, intente mas tarde", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        if (error==false){
            startActivity(miIntent);
        }

    }
}
