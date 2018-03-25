package com.elkha.zik.sakuguru;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;


public class FragmentTimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentTimePicker() {
        // Required empty public constructor
    }

    public static FragmentTimePicker newInstance(String param1, String param2) {
        FragmentTimePicker fragment = new FragmentTimePicker();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_picker, container, false);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar cal=Calendar.getInstance();
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minute=cal.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(getActivity(),this,hour,minute,true);
        return timePickerDialog;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        EditText editText=(EditText) getActivity().findViewById(R.id.jam);
        editText.setText(i+" : "+i1);
    }
}
