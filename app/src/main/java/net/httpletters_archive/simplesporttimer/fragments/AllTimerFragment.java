package net.httpletters_archive.simplesporttimer.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.httpletters_archive.simplesporttimer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllTimerFragment extends Fragment {

    @BindView(R.id.rv_all_timer)
    RecyclerView rvAllTimer;

    private RecyclerView.LayoutManager layoutManager;
    private OnFragmentInteractionListener mListener;

    public AllTimerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_all_alarm, container, false);
        ButterKnife.bind(this, rootView);

        layoutManager = new LinearLayoutManager(getActivity());
        rvAllTimer.setLayoutManager(layoutManager);

        return rootView;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
