package com.maikcaru.historicalyork;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SiteFragment extends Fragment {

    int selectedIndex;
    View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.activity_siteinformation, container, false);
        updateUI();
        return view;
    }

    public void updateUI(){
        selectedIndex = ((MainActivity)getActivity()).getSelectedIndex();
        Log.e("Selected index in site", "" + ((MainActivity) getActivity()).getSelectedIndex());
        Site selected = Sites.get(getActivity()).getAllSites().get(selectedIndex);

        TextView infoText = (TextView) view.findViewById(R.id.info);
        infoText.setText(selected.getInfo());

        ImageView image = (ImageView) view.findViewById(R.id.image);
        int imageID = getResources().getIdentifier(selected.getImageLocation(), "drawable", getActivity().getPackageName());
        Drawable d = getResources().getDrawable(imageID);
        image.setImageDrawable(d);
    }




    public void setSelectedIndex(int i){
        selectedIndex = i;
    }






    }




