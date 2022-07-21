package my.periodictable;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/**
 * Dialog that shows information about the application.
 *
 * @author Steve Guidetti
 */
public class AboutFragment extends DialogFragment {
    @NonNull
    private static final String TAG = "AboutDialog";

    /**
     * Show the Dialog.
     *
     * @param fm The FragmentManager
     */
    public static void showDialog(@NonNull FragmentManager fm) {
        final DialogFragment fragment = new AboutFragment();
        fragment.show(fm, TAG);
    }

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_about, null, false);


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setTitle(R.string.titleAbout);
        }
    }


}