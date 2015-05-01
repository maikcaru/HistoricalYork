package com.maikcaru.historicalyork;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        return view;
    }

    public void updateUI(){
        if (getActivity() != null) {



            selectedIndex = ((MainActivity) getActivity()).getSelectedIndex();
            TextView infoText = (TextView) view.findViewById(R.id.info);
            if (selectedIndex != -1){
                Site selected = Sites.get(getActivity()).getAllSites().get(selectedIndex);

                TextView titleText = (TextView) view.findViewById(R.id.title);
                titleText.setText(selected.getName());

                infoText.setTextSize(20);
                infoText.setText(selected.getInfo());

                ImageView image = (ImageView) view.findViewById(R.id.image);
                int imageID = getResources().getIdentifier(selected.getImageLocation(), "drawable", getActivity().getPackageName());
                Drawable d = getResources().getDrawable(imageID);
                image.setImageDrawable(d);
            }
            else {
                infoText.setTextSize(40);
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            updateUI();
        }

    }
    public void setSelectedIndex(int i){
        selectedIndex = i;
    }
}




