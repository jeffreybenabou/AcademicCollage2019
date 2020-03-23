package com.jeffrey.academiccollage.advancePrograming.Fragment.example1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jeffrey.academiccollage.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        TextView textView=view.findViewById(R.id.textView66);
        textView.setText("טקסט ששיניתי דרך הקוד");
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        חלק ממעגל החיים של הפרגמנט שקורה אחרי שחוזר הערך מ onCreateView ונותן לנו אפשרות להשתמש בפרמטר getView() כדי למצוא רכיבים במערכת מכל מיני מתודות
        TextView textView=getView().findViewById(R.id.textView66);
        textView.setText("טקסט ששיניתי דרך הקוד");

    }
    public void myMethod(){
//        מתודה שאני בניתי כדי להראות דוגמא לאיך למצוא רכיב לפי מזהה
        TextView textView=getView().findViewById(R.id.textView66);
    }



}
