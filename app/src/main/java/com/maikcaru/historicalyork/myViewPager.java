/*
package com.maikcaru.historicalyork;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

*/
/**
 * Created by michael.carr on 28/04/15.
 *//*

public class myViewPager extends ViewPager {


    public myViewPager(Context context) {
        super(context);
    }

    public myViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Button findButton(View v) {
        if (!(v instanceof ViewGroup)) {
            return null;
        }

        ViewGroup g = (ViewGroup) v;
        for (int i = 0; i < g.getChildCount(); i++) {
            if (g.getChildAt(i).getId() == R.id.dragButton) {
                return (Button) g.getChildAt(i);
            } else {
                Button b = findButton(g.getChildAt(i));
                if (b != null) {
                    return b;
                }
            }
        }

        return null;
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        //Log.e("Test", "CAN SCROLL HORIZONTAL!? " + direction);
        return true;
    }

    public boolean canScrollVertically(int direction) {
        //Log.e("Test", "CAN SCROLL HORIZONTAL!? " + direction);
        return true;
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y){
        Log.e("Test", "canScroll " + x + " " + y);
        Button button = findButton(v);
        if (button == null) {
            return true;
        }

        int[] position = new int[2];
        button.getLocationOnScreen(position);

        Log.e("Test", position[0] + " " + position[1] + " " + button.getWidth() + " " + button.getHeight());

        if ( (position[0] < x && x < position[0] + button.getWidth()) && (position[1] - button.getHeight() < y && y < position[1]) ) {
            Log.e("Test", "HIT!");
            return true;
        }

        Log.e("Test", "MISS!");
        return true;
    }
}
*/
