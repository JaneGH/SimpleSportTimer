package net.httpletters_archive.simplesporttimer.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import net.httpletters_archive.simplesporttimer.fragments.TimerFragment;
import net.httpletters_archive.simplesporttimer.model.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class TimerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Item> items;

    TimerFragment timerFragment;

    public TimerAdapter(TimerFragment timerFragment) {
        this.timerFragment = timerFragment;
        items = new ArrayList<>();
    }

    public Item getItem(int position) {
        return items.get(position);
    }

    public void addItem(Item item) {
        items.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    public void addItem(int location, Item item) {
        items.add(location, item);
        notifyItemInserted(location);
    }

    public void removeItem(int location) {
        if (location >= 0 && location <= getItemCount() -1) {
            items.remove(location);
            notifyItemRemoved(location);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected class TimerViewHolder extends RecyclerView.ViewHolder {
        protected TextView title;
//        protected CircleImageView priority;

        public TimerViewHolder(View itemView, TextView title) {
            super(itemView);
            this.title = title;
//            this.priority = priority;
        }
    }

    public TimerFragment getTimerFragment() {
        return timerFragment;
    }
}
