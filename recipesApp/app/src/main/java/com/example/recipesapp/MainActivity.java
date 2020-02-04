package com.example.recipesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.recipesapp.ui.main.FragmentDirections;
import com.example.recipesapp.ui.main.FragmentPhoto;

public class MainActivity extends AppCompatActivity {

    private Fragment mFragmentRecipeDescriptions;
    private Fragment mFragmentRecipePhotos;
    private FragmentTransaction mFragmentTransition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
       mFragmentRecipePhotos= new FragmentPhoto();
       mFragmentRecipeDescriptions=new FragmentDirections();
       mFragmentTransition=getSupportFragmentManager().beginTransaction();
       mFragmentTransition.replace(R.id.container,mFragmentRecipePhotos);
       mFragmentTransition.addToBackStack(null);
       mFragmentTransition.commit();
    }
    public void flipOver(View view){
        mFragmentTransition = getSupportFragmentManager().beginTransaction();
        mFragmentTransition.setCustomAnimations(R.anim.rotate_in, R.anim.rotate_out);
        mFragmentTransition.setCustomAnimations(R.anim.rotate_in, R.anim_rotate_out,R.anim.rotate_in,R.anim.rotate_out);
    }
}
