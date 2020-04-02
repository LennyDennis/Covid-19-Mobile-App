package com.example.covid_19.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.covid_19.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Covid19InfoAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    private String[] coronaTips;
    private int[] coronaTipsImages;

    public Covid19InfoAdapter(Context context, String[] coronaTips, int[] coronaTipsImages) {
        this.context = context;
        this.coronaTips = coronaTips;
        this.coronaTipsImages = coronaTipsImages;
    }

    @Override
    public int getCount() {
        return coronaTips.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.covid_single_info, null);
        }

        CircleImageView coronaInfoImage = convertView.findViewById(R.id.corona_info_image);
        TextView coronaInfoTitle = convertView.findViewById(R.id.corona_info_title);

        coronaInfoImage.setImageResource(coronaTipsImages[position]);
        coronaInfoTitle.setText(coronaTips[position]);
        return convertView;
    }
}
