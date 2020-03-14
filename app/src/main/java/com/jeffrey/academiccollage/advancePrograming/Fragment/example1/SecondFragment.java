package com.jeffrey.academiccollage.advancePrograming.Fragment.example1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jeffrey.academiccollage.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    public SecondFragment() {
        // חובה שיהיה בנאי ריק
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // מתודה זו דומה מאוד למתודה שאתם מכירים בפעילות onCreate רק שההבדל היחידי שהיא מחזירה את תבנית העיצוב שהפרגמנט ישתמש בו

        //מחזירים את תבנית העיצוב שבה נרצה להשתמש בפרגמנט שלנו
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}
