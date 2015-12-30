package cn.whereyougo.md.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.whereyougo.md.MainActivity;
import cn.whereyougo.md.R;
import cn.whereyougo.mdlibrary.widget.Button;
import cn.whereyougo.mdlibrary.widget.SnackBar;


public class SnackbarFragment extends Fragment {

    SnackBar mSnackBar;

    public static SnackbarFragment newInstance() {
        return new SnackbarFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_snackbar, container, false);

        Button bt_mobile_single = (Button) v.findViewById(R.id.snackbar_bt_mobile_single);
        Button bt_mobile_multi = (Button) v.findViewById(R.id.snackbar_bt_mobile_multi);
        Button bt_tablet_single = (Button) v.findViewById(R.id.snackbar_bt_tablet_single);
        Button bt_tablet_multi = (Button) v.findViewById(R.id.snackbar_bt_tablet_multi);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mSnackBar.getState() == SnackBar.STATE_SHOWN)
                    mSnackBar.dismiss();
                else {
                    switch (v.getId()) {
                        case R.id.snackbar_bt_mobile_single:
                            mSnackBar.applyStyle(R.style.Material_Widget_SnackBar_Mobile)
                                    .text("This is multi-line snackbar.\\nIt will auto-close after 5s")
                                    .actionText("CLOSE")
                                    .duration(0)
                                    .show();
                            break;
                        case R.id.snackbar_bt_mobile_multi:
                            mSnackBar.applyStyle(R.style.Material_Widget_SnackBar_Mobile_MultiLine)
                                    .text("This is multi-line snackbar.\\nIt will auto - close after 5s.")
                                    .actionText("CLOSE")
                                    .duration(5000)
                                    .show();
                            break;
                        case R.id.snackbar_bt_tablet_single:
                            mSnackBar.applyStyle(R.style.Material_Widget_SnackBar_Tablet)
                                    .text("This is single-line snackbar.")
                                    .actionText("CLOSE")
                                    .duration(0)
                                    .show();
                            break;
                        case R.id.snackbar_bt_tablet_multi:
                            mSnackBar.applyStyle(R.style.Material_Widget_SnackBar_Tablet_MultiLine)
                                    .text("This is multi-line snackbar.\nIt will auto-close after 5s.")
                                    .actionText(null)
                                    .duration(5000)
                                    .show();
                            break;
                    }
                }
            }
        };

        bt_mobile_single.setOnClickListener(listener);
        bt_mobile_multi.setOnClickListener(listener);
        bt_tablet_single.setOnClickListener(listener);
        bt_tablet_multi.setOnClickListener(listener);

        mSnackBar = ((MainActivity) getActivity()).getSnackBar();

        return v;
    }

}
