package util;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class PermissionDialog extends AlertDialog {
    public PermissionDialog(Context context, DialogInterface.OnClickListener OkOnClickListener, DialogInterface.OnClickListener CancelOnClickListener, String message, String label) {
        super(context);

        Builder builder = new Builder(context);
        builder.setTitle(label);
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, OkOnClickListener);
        builder.setNegativeButton(android.R.string.cancel, CancelOnClickListener);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
