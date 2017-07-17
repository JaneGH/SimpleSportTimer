package net.httpletters_archive.simplesporttimer.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.httpletters_archive.simplesporttimer.R;
import net.httpletters_archive.simplesporttimer.adapters.CurrentTimerAdapter;
import net.httpletters_archive.simplesporttimer.model.ModelTimer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentTimerFragment extends TimerFragment {

    @BindView(R.id.rv_current_timer)
    RecyclerView recyclerView;

    public CurrentTimerFragment() {
        // Required empty public constructor
    }

    OnTaskDoneListener onTaskDoneListener;

    public interface OnTaskDoneListener {
        void onTaskDone(ModelTimer task);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onTaskDoneListener = (OnTaskDoneListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnTaskDoneListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_current_alarm, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_current_timer);

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        adapter = new CurrentTimerAdapter(this);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }


    @Override
    public void moveTask(ModelTimer timer) {
        onTaskDoneListener.onTaskDone(timer);
    }
}
