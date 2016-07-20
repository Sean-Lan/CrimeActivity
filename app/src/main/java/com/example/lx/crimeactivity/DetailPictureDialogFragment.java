package com.example.lx.crimeactivity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by lx on 16/7/7.
 */
public class DetailPictureDialogFragment extends DialogFragment {
    private static final String EXTRA_PICTURE_PATH
            = "com.example.lx.crimeactivity.picturePath";
    private ImageView mImageView;

    public static DetailPictureDialogFragment newInstance(String picturePath) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_PICTURE_PATH, picturePath);

        DetailPictureDialogFragment fragment = new DetailPictureDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String picturePath = getArguments().getString(EXTRA_PICTURE_PATH);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_picture, null);

        mImageView = (ImageView) v.findViewById(R.id.dialog_picture_detail_picture);

        Point size = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(size);

        Bitmap bitmap = PictureUtils.getScaledBitmap(picturePath,
               size.x, size.y);
        mImageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.detail_picture_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
