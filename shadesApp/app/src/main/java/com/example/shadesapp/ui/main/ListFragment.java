package com.example.shadesapp.ui.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shadesapp.R;

public class ListFragment extends Fragment {
private OnItemSelectedListener listener;
private String information;


    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.list_fragment, container, false);
        Button button1 = (Button) view.findViewById(R.id.button);
        button1.setOnClickListener(ShadeChangeListener);
        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(ShadeChangeListener);
        Button button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(ShadeChangeListener);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    private View.OnClickListener ShadeChangeListener = new View.OnClickListener() {
        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {
            String description = (String) view.getContentDescription();
            information = description;
            if (description.equals(R.string.gold_is)){
            view.setBackgroundColor(R.color.gold);}
            else if (description.equals(R.string.blue_is)){
                view.setBackgroundColor(R.color.blue);}
            else if (description.equals(R.string.plum_is)){
                view.setBackgroundColor(R.color.plum);}
            updateDetail();
        }
    };
    public interface OnItemSelectedListener {
        void onShadeItemSelected(String link);
    }
public void onAttach (Context context){

        super.onAttach(context);
        Activity act;
        if(context instanceof Activity){
            act = (Activity)context;

        if (act instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) act;
        }

    }
        else{
            throw new ClassCastException(context.toString()+ " must implement MyListFragment.OnItemSelectedListener");
        }
}
public void updateDetail(){
        listener.onShadeItemSelected(information);
}



}
