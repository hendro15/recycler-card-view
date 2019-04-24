package com.hendro.recycler_cardview.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hendro.recycler_cardview.R;
import com.hendro.recycler_cardview.models.Study;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RiwayatStudyAdapter extends RecyclerView.Adapter<RiwayatStudyAdapter.MyViewHolder> {

    private List<Study> myStudy;

    public RiwayatStudyAdapter(List<Study> myStudy){
        this.myStudy = myStudy;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tv_head_jurusan)
        TextView tvHeadJurusan;
        @Bind(R.id.tv_ttk_dua_jurusan)
        TextView tvTitikDuaJur;
        @Bind(R.id.tv_nama_sekolah)
        TextView tvNamaSekolah;
        @Bind(R.id.tv_kota_sekolah)
        TextView tvKotaSekolah;
        @Bind(R.id.tv_jurusan_sekolah)
        TextView tvJurSekolah;
        @Bind(R.id.tv_tahun_sekolah)
        TextView tvTahunSekolah;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_riwayat_study, viewGroup, false);
        return new RiwayatStudyAdapter.MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Study item = myStudy.get(i);
        myViewHolder.tvNamaSekolah.setText(item.getNamaSekolah());
        myViewHolder.tvKotaSekolah.setText(item.getKota());
        if(item.getJenisSekolah().equals("SMA") || item.getJenisSekolah().equals("SMK")){
            myViewHolder.tvJurSekolah.setText(item.getJurusan());
        } else {
            myViewHolder.tvJurSekolah.setVisibility(View.GONE);
            myViewHolder.tvHeadJurusan.setVisibility(View.GONE);
            myViewHolder.tvTitikDuaJur.setVisibility(View.GONE);
        }
        myViewHolder.tvTahunSekolah.setText(String.valueOf(item.getTahunMasuk() + " - " + item.getTahunLulus()));
    }

    @Override
    public int getItemCount() {
        return myStudy.size();
    }
}
