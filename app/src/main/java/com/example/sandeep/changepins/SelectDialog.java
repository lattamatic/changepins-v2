package com.example.sandeep.changepins;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sandeep on 24/11/16.
 */

public class SelectDialog extends DialogFragment  {

    SDInterface sdInterface;


    interface SDInterface{
        void onClickPlace();
        void onClickCampaign();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.d_addselect,null);

        builder.setView(view);

        sdInterface = (SDInterface) getActivity();

        ImageView addPlace = (ImageView) view.findViewById(R.id.ivAddPlace);
        ImageView addCampaing = (ImageView) view.findViewById(R.id.ivAddCampaign);

        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdInterface.onClickPlace();
                dismiss();
            }
        });

        addCampaing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdInterface.onClickCampaign();
                dismiss();
            }
        });

        return builder.create();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
