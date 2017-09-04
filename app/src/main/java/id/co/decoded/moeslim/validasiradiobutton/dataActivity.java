package id.co.decoded.moeslim.validasiradiobutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class dataActivity extends AppCompatActivity {

    TextView tvAmbilData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvAmbilData = (TextView)findViewById(R.id.txtTampung);

        Intent adpTampunganKirim = getIntent();

        String tangkapData = adpTampunganKirim.getStringExtra("dataPilihanRadioButton");
        tvAmbilData.setText(tangkapData);
    }
}
