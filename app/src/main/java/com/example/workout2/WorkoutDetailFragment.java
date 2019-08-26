   package com.example.workout2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


   /**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    long workoutId;

    //健身動作的setter方法。activity利用這個方法設定健身動作 ID 的值。
    public void setWorkout(long id) {
        this.workoutId = id;
    }


    //無引數建構式
    public WorkoutDetailFragment() {
        // Required empty public constructor

    }

       @Override
       public void onCreate(@Nullable Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);


           if(savedInstanceState == null){
               StopwatchFragment stopwatch = new StopwatchFragment();

               FragmentTransaction ft = getChildFragmentManager().beginTransaction();

               ft.add(R.id.stopwatch_container,stopwatch   );

               ft.addToBackStack(null);

               ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE  );

               ft.commit();
           }else{
               workoutId =savedInstanceState.getLong("workoutId");
           }


       }

       @Override
       public void onSaveInstanceState(@NonNull Bundle outState) {
           super.onSaveInstanceState(outState);
         outState.putLong("workoutId", workoutId);
    }

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

       @Override
       public void onStart() {
           super.onStart();
           View view = getView();
           if(view != null ){
               TextView title = view.findViewById(R.id.textTitle);
               Workout workout = Workout.workouts[(int)workoutId];
               title.setText(workout.getName());
               TextView description = view.findViewById(R.id.txtDescription);
               description.setText(workout.getDescription());

           }
       }

}
