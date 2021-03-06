package sq.rogue.rosettadrone;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;

import static sq.rogue.rosettadrone.util.TYPE_DRONE_ID;
import static sq.rogue.rosettadrone.util.TYPE_DRONE_RTL_ALTITUDE;
import static sq.rogue.rosettadrone.util.TYPE_GCS_IP;
import static sq.rogue.rosettadrone.util.TYPE_GCS_PORT;
import static sq.rogue.rosettadrone.util.TYPE_VIDEO_IP;
import static sq.rogue.rosettadrone.util.TYPE_VIDEO_PORT;

public class NotificationHandler {
    public static void notifySnackbar(View view, int resID, int duration) {
        Snackbar snackbar = Snackbar.make(view, resID, duration);
        snackbar.show();
    }

    public static void notifyAlert(Context context, int input, DialogInterface.OnClickListener clickListener,
                                   DialogInterface.OnCancelListener cancelListener) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(context, R.style.AppDialog);
        builder.setPositiveButton(android.R.string.ok, clickListener);
        builder.setOnCancelListener(cancelListener);
        switch (input) {
            case TYPE_GCS_IP:
                builder.setMessage("Invalid IP address entered for GCS IP. Enter a valid IP " +
                        "(0.0.0.0 - 255.255.255.255).");
                break;
            case TYPE_GCS_PORT:
                builder.setMessage("Invalid port entered for GCS Port.");
                break;
            case TYPE_VIDEO_IP:
                builder.setMessage("Invalid IP address entered for Video IP. Enter a valid IP " +
                        "(0.0.0.0 - 255.255.255.255).");
                break;
            case TYPE_VIDEO_PORT:
                builder.setMessage("Invalid port entered for Video Port.");
                break;
            case TYPE_DRONE_ID:
                builder.setMessage("Invalid ID entered for the drone. Enter a valid ID (1 - 255).");
                break;
            case TYPE_DRONE_RTL_ALTITUDE:
                builder.setMessage("Invalid altitude entered for the drone RTL altitude. Enter a " +
                        "valid altitude (20 - 500).");
                break;
        }
        builder.show();
    }

}
