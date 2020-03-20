package com.jeffrey.academiccollage.advancePrograming.Fragment.example1;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

public class BottomNavigation extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom_navigation);
        setTheFragmentManger();
    }

    private void setTheFragmentManger() {
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        /*
        * קודם מוצאים את האובייקט של הניווט שלנו לפי המזהה שלו
         * */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            /*
            * לאחר מכן נוסיף אל האובייקט שיצרנו מאזין מסוג setOnNavigationItemSelectedListener שמקבל כפרמטר אובייקט מסוג OnNavigationItemSelectedListener.

             * */
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragmant=null;
                /*נגדיר אובייקט מסוג פרגמנט ונאתחל אותו בשלב הראשוני אל null
                 */
                switch (item.getItemId())
                {
                    /*
                    * בודק את המזהה של הכפתור שנלחץ בניווט התחתון ולאחר מכן מאתחל את הפרמנט שיצרנו בפרגמנט שנרצה להציג למשתמש 

                     * */
                    case R.id.fragment1:
                        selectedFragmant=new FirstFragment();
                        break;
                    case R.id.fragment2:
                        selectedFragmant=new SecondFragment();
                        break;
                    case R.id.fragment3:
                        selectedFragmant=new ThirdFragment();
                        break;
                }
                /*
                * נפנה אל מנהל הפרגמנטים getSupportFragmentManager נבקש ממנו להתחיל לבצע שינוי של הפרגמנט שנרצה שיוצג באמצעות beginTransaction ולאחר מכן נגדיר לו את הפרגמנט שאנחנו רוצים שהוא יציג באמצעות replace
                *  שמקבל כפרמטר את המזהה של הפרגמנט שהוספנו בפעילות הראשית וגם את האובייקט מסוג פרגמנט שהגדרנו למעלה ובסוף commit כדי לאשר את כל העניין.

                 * */

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view,selectedFragmant).commit();
                return true;
            }
        });
    }
}
