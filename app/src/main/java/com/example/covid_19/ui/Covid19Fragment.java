package com.example.covid_19.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.covid_19.R;
import com.example.covid_19.adapters.Covid19InfoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Covid19Fragment extends Fragment {

    @BindView(R.id.gridView)
    GridView gridView;

    String[] coronaTips = {
            "What are Corona Viruses?",
            "What are the symptoms?",
            "How is it transmitted?",
            "How to prevent it?",
            "When to wear masks?",
            "Is there a vaccine or treatment?"
    };

    int[] getCoronaTipsImages = {
            R.drawable.coronavirus,
            R.drawable.fever,
            R.drawable.coughing,
            R.drawable.handwashing,
            R.drawable.mask,
            R.drawable.vaccine
    };

    public Covid19Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_covid19, container, false);
        ButterKnife.bind(this, view);

        Covid19InfoAdapter covid19InfoAdapter = new Covid19InfoAdapter(getContext(), coronaTips, getCoronaTipsImages);
        gridView.setAdapter(covid19InfoAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "You clicked " + coronaTips[position], Toast.LENGTH_SHORT).show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
