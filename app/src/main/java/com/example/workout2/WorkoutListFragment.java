package com.example.workout2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    Listener listener;

    interface Listener{
        void itemClicked(long id);
    }

    //當fragment接到activity，會實作onAttach，所以在這邊設定listener的值。
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener=(Listener)context;
    }

    //當listview裡面的項目被按下的時候，通知監聽器
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener != null) {
            listener.itemClicked(id);
        }
    }

    //無引數建構式
    public WorkoutListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Workout.workouts.length];
        for(int i = 0; i< names.length;i++){
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),android.R.layout.simple_list_item_1,names);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);


    }

}
