package com.hacker.olevel.smartarchive;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.hacker.olevel.smartarchive.Controller.DepartmentHandler;
import com.hacker.olevel.smartarchive.Controller.SquareTextView;
import com.hacker.olevel.smartarchive.Model.AnnualPublications;
import com.hacker.olevel.smartarchive.Model.Department;

import java.util.ArrayList;
import java.util.List;

public class YearDialogFragment extends DialogFragment {
    private Department department;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public YearDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YearDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static YearDialogFragment newInstance(String param1, String param2) {
        YearDialogFragment fragment = new YearDialogFragment();
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
            department = (Department) getArguments().getSerializable("department");
        }
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.grid_fragment, container, false);
//        GridView yearGridView = (GridView) view.findViewById(R.id.gridview);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            yearGridView.setBackground(getResources().getDrawable(R.mipmap.wallpaper_abstract));
//        } else {
//            yearGridView.setBackgroundDrawable(getResources().getDrawable(R.mipmap.wallpaper_abstract));
//        }
//
//        yearGridView.setAdapter(new YearGridAdapter(getContext(), department));
//        return view;
//    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final ArrayList<String> yearsList = department.getYearGroups();

        CharSequence[] yearsCS = yearsList.toArray(new CharSequence[yearsList.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pick_year).setItems(yearsCS, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AnnualPublications annualPublications = new AnnualPublications(department.code, yearsList.get(which));
            }
        });

        return builder.create();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        void onFragmentInteraction(Uri uri);
        void onYearGridItemClick(Department department);
    }


    /**
     * File: YearGridAdapter.java
     * Desc: Populates grid views with available years of a particular department
     *
     * Created by olevel on 6/4/17.
     */

//    private class YearGridAdapter extends BaseAdapter {
//        private Context context;
//        private Department department;
//        private List<Integer> departmentYearGroups;
//        private DepartmentHandler departmentHandler;
//
//        public YearGridAdapter(Context context, Department department) {
//            this.context = context;
//            this.department = department;
//            //departmentHandler = new DepartmentHandler();
//            departmentYearGroups = department.getYearGroups(department, 2002);
//        }
//
//        @Override
//        public int getCount() {
//            return departmentYearGroups.size();
//        }
//
//        @Override
//        public Department getItem(int position) {
//            department.establishmentDate = departmentYearGroups.get(position);
//
//            return department;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(final int position, View convertView, ViewGroup parent) {
//            SquareTextView gridTextView;
//
//            if (convertView == null) {
//
//                gridTextView = new SquareTextView(context);
//                //gridTextView.setLayoutParams(new GridView.LayoutParams(50, 50));
//                gridTextView.setPadding(8, 8, 8, 8);
//                gridTextView.setBackgroundColor(Color.LTGRAY);
//                gridTextView.setTextColor(Color.WHITE);
//                gridTextView.setTextSize(18);
//                gridTextView.setGravity(Gravity.CENTER);
//
//            } else {
//                gridTextView = (SquareTextView) convertView;
//            }
//
//            String year = departmentYearGroups.get(position) + "";
//            gridTextView.setText(year);
//
//            gridTextView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mListener != null) {
//                        // Todo;
//                    }
//                }
//            });
//            return gridTextView;
//        }
//
//    }

}
