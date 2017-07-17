package net.httpletters_archive.simplesporttimer.dialog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AutomaticZenRule;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.httpletters_archive.simplesporttimer.R;
import net.httpletters_archive.simplesporttimer.model.ModelTimer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddingTimerDialogFragment extends DialogFragment{

    public static String TAG = "ADDING_TIMER_DIALOG";

    @BindView(R.id.tv_roundTime)
    TextInputLayout tlRoundTime;
    @BindView(R.id.tv_restTime)
    TextInputLayout tlRestTime;
    @BindView(R.id.tv_repeat)
    TextInputLayout tlRepeat;
    @BindView(R.id.tv_title)
    TextInputLayout tlTitle;

    private Button positiveButton;
    private AddingTaskListener addingTaskListener;

    public interface AddingTaskListener {
        void onTaskAdded(ModelTimer newTimer);
        void onTaskCancel();
    }

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        addTaskListener();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        addTaskListener();
    }

    private void addTaskListener(){
        try {
            addingTaskListener = (AddingTaskListener) getActivity();
        }catch (ClassCastException e) {
            throw (new ClassCastException(getActivity().toString() + "must implement AddingTaskListener"));
        }
    }

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        AlertDialog.Builder builder   = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View container = layoutInflater.inflate(R.layout.dialog_task, null);
        ButterKnife.bind(this, container);

        final EditText etTitle  = tlTitle.getEditText();
        final EditText etRound  = tlRoundTime.getEditText();
        final EditText etRest   = tlRestTime.getEditText();
        final EditText etRepeat = tlRepeat.getEditText();

        tlTitle.setHint(getResources().getString(R.string.title));
        tlRoundTime.setHint(getResources().getString(R.string.round_title));
        tlRestTime.setHint(getResources().getString(R.string.rest_title));
        tlRepeat.setHint(getResources().getString(R.string.repeat));

        final ModelTimer modelTimer = new ModelTimer();

        builder.setView(container);
        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                modelTimer.setTitle(etTitle.getText().toString());
                if (etRound != null && !etRound.getText().toString().equals("")) {
                    modelTimer.setRound(Integer.parseInt(etRound.getText().toString()));
                }
                if (etRest != null && !etRest.getText().toString().equals("")) {
                    modelTimer.setRest(Integer.parseInt(etRest.getText().toString()));
                }
                if (etRepeat != null && !etRepeat.getText().toString().equals("")) {
                    modelTimer.setRepeat(Integer.parseInt(etRepeat.getText().toString()));
                }
                addingTaskListener.onTaskAdded(modelTimer);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addingTaskListener.onTaskCancel();
                dialog.cancel();
            }
        });

        final AlertDialog alertDialog = builder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                positiveButton = ((AlertDialog)alertDialog).getButton(DialogInterface.BUTTON_POSITIVE);
                if (etTitle != null && etTitle.length() == 0) {
                    positiveButton.setEnabled(false);
                    tlTitle.setError(getResources().getString(R.string.dialog_error_empty_title));
                }
            }
        });

        if (etTitle != null) {
            etTitle.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (s.length()==0){
                        positiveButton.setEnabled(false);
                        tlTitle.setError(getResources().getString(R.string.dialog_error_empty_title));
                    }else {
                        positiveButton.setEnabled(true);
                    }
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }

        return alertDialog;
    }
}
