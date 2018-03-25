package com.elkha.zik.sakuguru;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private OnFragmentInteractionListener fragmentInteractionListener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.
     //* @param param2 Parameter 2.
     * @return A new instance of fragment tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment newInstance() {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
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
    RecyclerView rec;
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
        //rootView.setTag("RecycleViewFragment");
        //rec=(RecyclerView) rootView.findViewById(R.id.recycleViews);
        // Inflate the layout for this fragment
//        Toast.makeText(getActivity(),"bla",Toast.LENGTH_SHORT);
//        ArrayList<JadwalSekolah> con=new ArrayList<>();
//        JadwalSekolah a1=new JadwalSekolah("SDN KOMPLEKS IKIP","MATEMATIKA","081243254321",new Date());
//
//        con.add(a1);
//        UserAdapter m1=new UserAdapter(con,getActivity());
//        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rec.setItemAnimator(new DefaultItemAnimator());
//        rec.setAdapter(m1);
//        m1.notifyDataSetChanged();
        FloatingActionButton fl=(FloatingActionButton) rootView.findViewById(R.id.tam);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),AddJadwalActivity.class));

            }
        });
        showData();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction("From fragmenttttt");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String string);

    }
    JadwalDatabaseHandler jad;
    public void showData(){

        jad =new JadwalDatabaseHandler(getContext());
        TextView t1=(TextView) rootView.findViewById(R.id.dateNow);
        //get Time Now
        Calendar currentTime = Calendar.getInstance();
        currentTime.add(Calendar.DATE,1);
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        t1.setText(format1.format(currentTime.getTime())+"");
        //show the data
        List<dataJadwal> jadwal_List=jad.getAllContacts();
        ListView listView=(ListView) rootView.findViewById(R.id.list_jadwal);
        formatJadwalAdapter fr=new formatJadwalAdapter(getContext(),jadwal_List);
        listView.setAdapter(fr);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(),AbsensiPelajaran.class));
            }
        });


    }
}
