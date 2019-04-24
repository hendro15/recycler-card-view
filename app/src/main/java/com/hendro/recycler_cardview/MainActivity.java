package com.hendro.recycler_cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.hendro.recycler_cardview.adapters.RiwayatStudyAdapter;
import com.hendro.recycler_cardview.models.Mahasiswa;
import com.hendro.recycler_cardview.models.Study;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Mahasiswa mhs;
    private Study study;
    private List<Study> mhsStudy;

    protected RiwayatStudyAdapter riwayatStudyAdapter;

    @Bind(R.id.tv_nama_pengguna)
    TextView tvNamaPengguna;
    @Bind(R.id.tv_instansi_pengguna)
    TextView tvInstansiPengguna;
    @Bind(R.id.rv_data_sekolah)
    RecyclerView rvDataSekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setLayout();
    }

    private void setLayout(){
        mhs = new Mahasiswa();
        mhs.setNama("Hendro Eko Prabowo");
        mhs.setInstansi("Universitas Negeri Semarang");
        mhsStudy = new ArrayList<>();

        data();

        tvNamaPengguna.setText(mhs.getNama());
        tvInstansiPengguna.setText(mhs.getInstansi());

        riwayatStudyAdapter = new RiwayatStudyAdapter(mhs.getRiwayatStudy());
        rvDataSekolah.setLayoutManager(new LinearLayoutManager(this));
        rvDataSekolah.setItemAnimator(new DefaultItemAnimator());
        rvDataSekolah.setAdapter(riwayatStudyAdapter);
    }

    private void data(){
        study = new Study();
        study.setNamaSekolah("SD N Mondoteko");
        study.setJenisSekolah("SD");
        study.setKota("Kab. Rembang");
        study.setTahunMasuk(1999);
        study.setTahunLulus(2006);
        mhsStudy.add(study);

        study = new Study();
        study.setNamaSekolah("SMP N 2 Rembang");
        study.setJenisSekolah("SMP");
        study.setKota("Kab. Rembang");
        study.setTahunMasuk(2006);
        study.setTahunLulus(2008);
        mhsStudy.add(study);

        study = new Study();
        study.setNamaSekolah("SMA N 1 Rembang");
        study.setJenisSekolah("SMA");
        study.setKota("Kab. Rembang");
        study.setJurusan("IPA");
        study.setTahunMasuk(2008);
        study.setTahunLulus(2011);
        mhsStudy.add(study);

        mhs.setRiwayatStudy(mhsStudy);
    }
}
