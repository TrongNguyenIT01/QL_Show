package com.example.ql_show;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ShowAdapter extends ArrayAdapter<AddShow> {

    Context context;
    List<AddShow> list;

    public ShowAdapter(Context context, List<AddShow> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.hien_thi_show, parent, false);
        }

        AddShow show = list.get(position);

        TextView tvTenShow = convertView.findViewById(R.id.tv_TenShow);
        TextView tvDiaDiem = convertView.findViewById(R.id.tv_DiaDiem);
        TextView tvBauShow = convertView.findViewById(R.id.tv_BauShow);
        TextView tvNgay = convertView.findViewById(R.id.tv_Ngay);
        TextView tvGhiChu = convertView.findViewById(R.id.tv_GhiChu);

        tvTenShow.setText(show.getTenShow());
        tvDiaDiem.setText(show.getDiaDiem());
        tvBauShow.setText(show.getBauShow());
        tvNgay.setText(show.getThoiGian());
        tvGhiChu.setText(show.getGhiChu());

        return convertView;
    }
}