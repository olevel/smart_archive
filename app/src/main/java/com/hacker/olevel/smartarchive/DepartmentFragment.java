package com.hacker.olevel.smartarchive;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.hacker.olevel.smartarchive.Controller.SquareTextView;
import com.hacker.olevel.smartarchive.Model.Department;
import com.hacker.olevel.smartarchive.Controller.DepartmentHandler;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DepartmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DepartmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DepartmentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DepartmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DepartmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DepartmentFragment newInstance(String param1, String param2) {
        DepartmentFragment fragment = new DepartmentFragment();
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
        View view = inflater.inflate(R.layout.grid_fragment, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new DepartmentGridAdapter(getActivity()) );

        // Inflate the layout for this fragment
        return view; //inflater.inflate(R.layout.fragment_department, container, false);
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
        void onDepartmentGridItemClick(Department department);
    }


    /**
     * File: DepartmentGridAdapter.java
     * Desc: Populates grid views with available departments
     *
     * Created by olevel on 6/4/17.
     */

    private class DepartmentGridAdapter extends BaseAdapter {
        private Context context;
        private DepartmentHandler departmentHandler;

        public DepartmentGridAdapter(Context context) {
            this.context = context;
            departmentHandler = new DepartmentHandler();
        }

        @Override
        public int getCount() {
            return departmentHandler.getDepartments().size();
        }

        @Override
        public Department getItem(int position) {
            return departmentHandler.getDepartments().get(position);//department.getSingleDepartmentCode(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            SquareTextView gridTextView;

            if (convertView == null) {

                gridTextView = new SquareTextView(context);
                //gridTextView.setLayoutParams(new GridView.LayoutParams(85, 85));
                gridTextView.setPadding(8,8,8,8);
                gridTextView.setBackgroundColor(Color.LTGRAY);
                gridTextView.setTextColor(Color.WHITE);
                gridTextView.setTextSize(22);
                gridTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                gridTextView.setGravity(Gravity.CENTER);

            } else {
                gridTextView = (SquareTextView) convertView;
            }

            gridTextView.setText(departmentHandler.getDepartments().get(position).getCode());

            gridTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onDepartmentGridItemClick(departmentHandler.getDepartments().
                                get(position));
                    }
                }
            });
            return gridTextView;
        }
    }

}
