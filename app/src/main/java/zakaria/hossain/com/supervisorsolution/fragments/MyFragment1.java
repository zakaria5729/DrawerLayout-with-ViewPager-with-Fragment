package zakaria.hossain.com.supervisorsolution.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zakaria.hossain.com.supervisorsolution.R;


public class MyFragment1 extends Fragment {

    public MyFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_fragment1, container, false);
        return view;
    }
}
