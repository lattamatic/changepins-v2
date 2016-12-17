package com.example.sandeep.changepins;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by sandeep_chi on 12/17/2016.
 */

public class ReportActivity extends ChangePinsActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getTitleText() {
        return R.string.report;
    }

    @Override
    protected int getLayout() {
        return R.layout.ac_report;
    }
}
