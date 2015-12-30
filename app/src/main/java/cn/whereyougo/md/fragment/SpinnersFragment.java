package cn.whereyougo.md.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import cn.whereyougo.md.R;
import cn.whereyougo.mdlibrary.widget.Spinner;


public class SpinnersFragment extends Fragment {

    public static SpinnersFragment newInstance() {
        return new SpinnersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_spinner, container, false);

        Spinner spn_label = (Spinner) v.findViewById(R.id.spinner_label);
        Spinner spn_no_arrow = (Spinner) v.findViewById(R.id.spinner_no_arrow);
        String[] items = new String[20];
        for (int i = 0; i < items.length; i++) {
            items[i] = "Item " + String.valueOf(i + 1);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_spn_row, items);
        adapter.setDropDownViewResource(R.layout.item_spn_row_dropdown);
        spn_label.setAdapter(adapter);
        spn_no_arrow.setAdapter(adapter);

        return v;
    }
}
