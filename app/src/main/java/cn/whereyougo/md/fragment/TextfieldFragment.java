package cn.whereyougo.md.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.whereyougo.md.R;
import cn.whereyougo.mdlibrary.widget.EditText;

public class TextfieldFragment extends Fragment {

    public static TextfieldFragment newInstance() {
        return new TextfieldFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_textfield, container, false);

        final EditText et_helper = (EditText) v.findViewById(R.id.textfield_et_helper);

        et_helper.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP)
                    et_helper.setError("Password is incorrect.");

                return false;
            }

        });

        et_helper.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    et_helper.setError(null);
            }

        });

        final EditText et_helper_error = (EditText) v.findViewById(R.id.textfield_et_helper_error);

        et_helper_error.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP)
                    et_helper_error.setError("Password is incorrect.");

                return false;
            }

        });

        et_helper_error.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    et_helper_error.setError(null);
            }

        });

        return v;
    }

}
