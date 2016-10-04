package id.sch.smktelkom_mlg.tugas01.xiirpl4002.tugas01_xiir4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton rbD, rbB;
    CheckBox cbPulang, cbPergi, cbPP;
    EditText etNama, etAlamat, etTelp, etNama2, etID, etNamaKA, etAsal, etTujuan, etTgl, etTime;
    TextView tvHasil, tvHasil2, tvHasil3, tvHasil4, tvHasil5, tvHasil6, tvHasil7, tvHasil8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbD = (RadioButton) findViewById(R.id.radiButtonDewasa);
        rbB = (RadioButton) findViewById(R.id.radiButtonBayi);

        cbPergi = (CheckBox) findViewById(R.id.checkBoxPergi);
        cbPulang = (CheckBox) findViewById(R.id.checkBoxPulang);
        cbPP = (CheckBox) findViewById(R.id.checkBoxPP);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etTelp = (EditText) findViewById(R.id.editTextTelp);
        etNama2 = (EditText) findViewById(R.id.editTextNama2);
        etID = (EditText) findViewById(R.id.editTextID);
        etNamaKA = (EditText) findViewById(R.id.editTextNamaKA);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        etTujuan = (EditText) findViewById(R.id.editTextTujuan);
        etTgl = (EditText) findViewById(R.id.editTextTgl);
        etTime = (EditText) findViewById(R.id.editTextTime);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        tvHasil5 = (TextView) findViewById(R.id.textViewHasil5);
        tvHasil6 = (TextView) findViewById(R.id.textViewHasil6);
        tvHasil7 = (TextView) findViewById(R.id.textViewHasil7);
        tvHasil8 = (TextView) findViewById(R.id.textViewHasil8);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = "PESANAN TIKET : ";
        int startlen = hasil.length();
        if (cbPergi.isChecked()) {
            hasil = cbPergi.getText().toString();
        } else if (cbPulang.isChecked()) {
            hasil = cbPulang.getText().toString();
        } else if (cbPP.isChecked()) {
            hasil = cbPP.getText().toString();
        }

        if (hasil.length() == startlen) hasil += "Tidak ada pada Pilihan";
        String tujuan = etTujuan.getText().toString();
        tvHasil.setText(hasil + " TUJUAN " + tujuan);

        doProses();
    }

    private void doProses() {
        if (isValid()) {
            String namaKA = etNamaKA.getText().toString();
            tvHasil2.setText(namaKA);

            String type = null;
            if (rbD.isChecked()) {
                type = rbD.getText().toString();
            } else if (rbB.isChecked()) {
                type = rbB.getText().toString();
            }

            if (type == null) {
                tvHasil8.setText("Belum memilih type");
            } else {
                tvHasil8.setText("Type : " + type);
            }

            String nama = etNama2.getText().toString();
            tvHasil3.setText("NAMA : " + nama);
            String id = etID.getText().toString();
            tvHasil4.setText("NO IDENTITAS : " + id);
            String asal = etAsal.getText().toString();
            String time = etTime.getText().toString();
            tvHasil5.setText(asal + " : " + time);
            String tgl = etTgl.getText().toString();
            tvHasil6.setText("TGL BERANGKAT : " + tgl);
            tvHasil7.setText("Rp. 15.000,-");
        }
    }

    private boolean isValid() {
        boolean valid = true;


        String nama = etNama.getText().toString();
        String nama2 = etNama2.getText().toString();
        String id = etID.getText().toString();
        String asal = etAsal.getText().toString();
        String tujuan = etTujuan.getText().toString();
        String time = etTime.getText().toString();
        String tgl = etTgl.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama pemesan harap diisi!");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (nama2.isEmpty()) {
            etNama2.setError("Nama penumpang harap diisi!");
            valid = false;
        } else if (nama2.length() < 3) {
            etNama2.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama2.setError(null);
        }

        if (id.isEmpty()) {
            etID.setError("NO ID tidak boleh kosong!");
            valid = false;
        } else {
            etID.setError(null);
        }

        if (asal.isEmpty()) {
            etAsal.setError("Stasiun asal harap diisi!");
            valid = false;
        } else {
            etAsal.setError(null);
        }

        if (tujuan.isEmpty()) {
            etTujuan.setError("Tujuan harap diisi!");
            valid = false;
        } else {
            etTujuan.setError(null);
        }

        if (time.isEmpty()) {
            etTime.setError("Waktu keberangkatan tidak boleh kosong!");
            valid = false;
        } else {
            etTime.setError(null);
        }

        if (tgl.isEmpty()) {
            etTgl.setError("Tanggal keberangkatan tidak boleh kosong!");
            valid = false;
        } else {
            etTgl.setError(null);
        }


        return valid;
    }

}