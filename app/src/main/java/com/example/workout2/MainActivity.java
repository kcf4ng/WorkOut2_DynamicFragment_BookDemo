package com.example.workout2;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity  implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //MainActivity 在 implement 監聽器之後，實作介面
    @Override
    public void itemClicked(long id) {
        View fragmentConainer =findViewById(R.id.fragment_container);

        if(fragmentConainer != null){
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            //底甕transition
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkout(id);
            //替換fragment
            ft.replace(R.id.fragment_container,details);
            //設定轉場動畫（transition animation）：淡入淡出
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            //將transition加入back堆疊。多數情況下用不到，所以只需要給null
            ft.addToBackStack(null);
            //送出transition
            ft.commit();
        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID,(int)id);
            startActivity(intent);
        }

    }
}
