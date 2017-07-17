package net.httpletters_archive.simplesporttimer.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import net.httpletters_archive.simplesporttimer.adapters.CurrentTimerAdapter;
import net.httpletters_archive.simplesporttimer.adapters.TimerAdapter;
import net.httpletters_archive.simplesporttimer.model.ModelTimer;

/**
 * Created by MyComp on 17.07.2017.
 */

public abstract class TimerFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;

    protected TimerAdapter adapter;



    public void addTask(ModelTimer newTask) {
        int position = -1;

        for (int i = 0; i < adapter.getItemCount(); i ++) {
            if (adapter.getItem(i).isTimer()) {
                ModelTimer task = (ModelTimer) adapter.getItem(i);
            }
        }

        if (position != -1) {
            adapter.addItem(position, newTask);
        } else {
            adapter.addItem(newTask);
        }
    }

    public abstract void moveTask(ModelTimer task);
}
