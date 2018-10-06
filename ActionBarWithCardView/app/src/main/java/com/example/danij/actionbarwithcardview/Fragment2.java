package com.example.danij.actionbarwithcardview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment2 extends Fragment{

    private static final String TAG = "Fragment2";

    private ListView mlistView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout, container, false);
        mlistView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();
        list.add(new Card("angry", "drawable://" + R.drawable.angry));
        list.add(new Card("cikica", "drawable://" + R.drawable.cikica));
        list.add(new Card("cinque", "drawable://" + R.drawable.cinque));
        list.add(new Card("duel", "drawable://" + R.drawable.duel));
        list.add(new Card("galaxy", "drawable://" + R.drawable.galaxy));
        list.add(new Card("igrac 4000", "drawable://" + R.drawable.igrac4000));
        list.add(new Card("igrac let", "drawable://" + R.drawable.igraclet));
        list.add(new Card("igrac sut", "drawable://" + R.drawable.igracsut));
        list.add(new Card("kometa lotpta", "drawable://" + R.drawable.kometa_lopta_flip));
        list.add(new Card("kos", "drawable://" + R.drawable.kos));
        list.add(new Card("lopta 200x200", "drawable://" + R.drawable.lopta200x200));
        list.add(new Card("make", "drawable://" + R.drawable.make));
        list.add(new Card("moj sut", "drawable://" + R.drawable.mojsut));
        list.add(new Card("male slicice", "drawable://" + R.drawable.maleslicice));
        list.add(new Card("sut 1000", "drawable://" + R.drawable.sut1000));
        list.add(new Card("sut 700", "drawable://" + R.drawable.sut700));
        list.add(new Card("team 800", "drawable://" + R.drawable.team800));
        list.add(new Card("teren sa loptom", "drawable://" + R.drawable.maleslicice));
        list.add(new Card("vertikalna uzarena", "drawable://" + R.drawable.vertikalna_uzarena));
        list.add(new Card("zakucavanje", "drawable://" + R.drawable.zakucavanje));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.cardview_layout_action_bar, list);
        mlistView.setAdapter(adapter);

        return view;
    }
}
