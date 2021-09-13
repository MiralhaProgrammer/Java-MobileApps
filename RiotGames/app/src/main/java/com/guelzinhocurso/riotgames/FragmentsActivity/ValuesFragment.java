package com.guelzinhocurso.riotgames.FragmentsActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guelzinhocurso.riotgames.FragmentsActivity.RecyclerValues.Adapter;
import com.guelzinhocurso.riotgames.FragmentsActivity.RecyclerValues.ValuesList;
import com.guelzinhocurso.riotgames.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ValuesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ValuesFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ValuesList> originalList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ValuesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ValuesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ValuesFragment newInstance(String param1, String param2) {
        ValuesFragment fragment = new ValuesFragment();
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
        View view = inflater.inflate(R.layout.fragment_values, container, false);

        this.listCreate();

        Adapter adapter = new Adapter(originalList);

        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;


    }

    public void listCreate(){
        ValuesList valuesList = new ValuesList("PLAYER EXPERIENCE FIRST", "We belive our lasers focus on players inspires the most meaningful and lasting game experiences. \n \n- We put players at the center of evertything we do. " +
                "\n \n - We share a love of games and proritize play as an important part of our lives. \n \n - We deepen our empathy and understanding by listening, lernaing, and engaging with players around the world.",
                R.drawable.playerexperience);
        this.originalList.add(valuesList);

        valuesList = new ValuesList("DARE TO DREAM", "We believe the courage to chase to chase bold ideas will make impossible dreams come true for players. \n \n - we make bold" +
                ", focused bets aimed at advancing the gaming landscape. \n \n - We seek unique perspectives, create room for experimentation, and anticipate failure as part of the journey." +
                "\n \n - We work from best practices, value expertise, and innovate when there's a better way.",
                R.drawable.dream);
        this.originalList.add(valuesList);

        valuesList = new ValuesList("THRIVE TOGETHER", "We believe we're stronger when we respect each other, invest in each other, and succeed as one team." +
                "\n \n - We approach every interaction with empathy, sincerity, and respect." +
                "\n \n - We cultivate inclusive teams to amplify each Rioter's strengths." +
                "\n \n - We hold ourselves to the highest standard of professionalism and together we embrace the joy of making games.",
                R.drawable.together);
        this.originalList.add(valuesList);

        valuesList = new ValuesList("EXECUTE WITH EXCELLENCE", "We believe operational excellence will unlock us to deliver better experiences for the long run." +
                "\n\n - We set ambitious goals, measure ourselver against results, and continually iterate towards improvement." +
                "\n\n - We collaborate across teams to deliver holistic experiences to players and Rioters." +
                "\n\n - We focus where it matters, prioritize efficiency, and spend player resources as our own.",
                R.drawable.excellence);
        this.originalList.add(valuesList);

        valuesList = new ValuesList("STAY HUNGRY;STAY HUMBLE", "We believe there is always more to learn from each other, from players, and from the world." +
                "\n \n - We approach each problem with optimism, abition, and curiosity." +
                "\n\n - We celebrate our wins, learn from our failures, and challenge ourselver to envolve." +
                "\n \n - We value feedback as an essential part of improvement." +
                "\n \n - We recognize our teams, our families, our industry peers, and our players who make this all possible.",
                R.drawable.humble);
        this.originalList.add(valuesList);
    }
}