package pi14.nung.a_radioif.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;

import pi14.nung.a_radioif.R;

/**
 * Created by Богдан on 28.02.2016.
 */
public class BufferingDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Inflate dialog
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.buffering_dialog, null));

        // Creating dialog
        AlertDialog dialog = builder.create();

        // Prevent canceling on outside touch
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}