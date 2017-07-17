package net.httpletters_archive.simplesporttimer.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.httpletters_archive.simplesporttimer.R;
import net.httpletters_archive.simplesporttimer.fragments.TimerFragment;
import net.httpletters_archive.simplesporttimer.model.Item;
import net.httpletters_archive.simplesporttimer.model.ModelTimer;


/**
 * Created by MyComp on 14.07.2017.
 */

public class CurrentTimerAdapter extends TimerAdapter {

    private static final int TYPE_TIMER = 0;
    private static final int TYPE_SEPARATOR = 1;

    public CurrentTimerAdapter(TimerFragment timerFragment) {
        super(timerFragment);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_TIMER:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_task, parent, false);
                TextView title = (TextView) v.findViewById(R.id.tv_timer_name);
                return  new TimerViewHolder(v, title);
            case TYPE_SEPARATOR:
                break;
            default:
                return null;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = items.get(position);
        if (item.isTimer()) {
            holder.itemView.setEnabled(true);
            ModelTimer modelTimer = (ModelTimer) item;
            TimerViewHolder timerViewHolder = (TimerViewHolder) holder;
            timerViewHolder.title.setText(modelTimer.getTitle());
        }else{
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (getItem(position).isTimer()) {
            return TYPE_TIMER;
        }else{
            return  TYPE_SEPARATOR;
        }
    }

}
