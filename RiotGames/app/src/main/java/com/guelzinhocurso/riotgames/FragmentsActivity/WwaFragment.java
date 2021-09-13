package com.guelzinhocurso.riotgames.FragmentsActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.guelzinhocurso.riotgames.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WwaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WwaFragment extends Fragment {

    private ImageButton buttonSeemore;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public WwaFragment() {
        // Required empty public constructor
    }

    public static WwaFragment newInstance(String param1, String param2) {
        WwaFragment fragment = new WwaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wwa, container, false);
        buttonSeemore = view.findViewById(R.id.buttonSeemore);

        buttonSeemore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Riot_Games"));
                startActivity(intent);
            }
        });

        return view;
}


}

