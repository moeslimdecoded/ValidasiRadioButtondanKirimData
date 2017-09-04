package id.co.decoded.moeslim.validasiradiobutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {

    //Step I - Deklarasi Variable
    RadioButton rbtLaki, rbtPr;
    Button btCek, btUnceck, btKirim;
    TextView tvTemporary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Step II - Mengambil Aksi dari id pada View di file XML
        rbtLaki = (RadioButton)findViewById(R.id.rbLaki);
        rbtPr = (RadioButton)findViewById(R.id.rbPerempuan);
        btCek = (Button)findViewById(R.id.btnCek);

        //Step IV - Membuat Aksi untuk button uncheck
        btUnceck = (Button)findViewById(R.id.btnUnCek);
        btUnceck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearChecked();
            }
        });

        btKirim = (Button)findViewById(R.id.btnKirim);
        btKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kirimData();
            }
        });

        tvTemporary = (TextView)findViewById(R.id.txtTemp);

        //Step III - Membuat Aksi untuk button Cek
        btCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step III - Menambahkan Method biar Jalan Methodnya
                validasiRadioButton();
            }
        });

    }

    //Step III - Membuat Method validasi RadioButton
    public void validasiRadioButton(){
        if (rbtLaki.isChecked()){
            Toast.makeText(homeActivity.this, "Anda Memilih RadioButton Laki-laki", Toast.LENGTH_SHORT).show();
            tvTemporary.setText("Laki-laki");
        }else if(rbtPr.isChecked()){
            Toast.makeText(homeActivity.this, "Anda Memilih RadioButton Perempuan", Toast.LENGTH_SHORT).show();
            tvTemporary.setText("Perempuan");
        }else{
            Toast.makeText(homeActivity.this, "Maaf, Anda Musti Pilih Salah Satu!!", Toast.LENGTH_SHORT).show();
            tvTemporary.setText("Pilih dulu salah satu!!");
        }
    }

    //Step IV - Membuat Method unCheck Semua pada RadioButton
    public void clearChecked(){
        //&& adalah dan
        //|| adalah atau
        if(rbtLaki.isChecked() || rbtPr.isChecked()){
            rbtPr.setChecked(false);
            rbtLaki.setChecked(false);
        }
    }

    //Step V - Buat Method Kirim data ke Aktivity ke 2
    public void kirimData(){
        Intent adpKirim = new Intent(getApplicationContext(), dataActivity.class);
        adpKirim.putExtra("dataPilihanRadioButton", tvTemporary.getText().toString());
        startActivity(adpKirim);
    }


}
