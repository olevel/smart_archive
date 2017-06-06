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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hacker.olevel.smartarchive.Controller.SquareDepartmentGridItem;
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
    public void onResume() {
        super.onResume();
        if (mListener != null) {
            mListener.onDepartmentFragmentInteraction();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onDepartmentFragmentInteraction();
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
            SquareDepartmentGridItem gridItem;
            TextView departmentCodeTextView;
            TextView departmentNameTextView;

            if (convertView == null) {

                gridItem = new SquareDepartmentGridItem(getContext());
                gridItem.setPadding(8,8,8,8);
                gridItem.setBackgroundColor(Color.LTGRAY);
                gridItem.setGravity(Gravity.CENTER);
                gridItem.setOrientation(LinearLayout.VERTICAL);

                departmentCodeTextView = new TextView(getActivity());
                departmentCodeTextView.setTextSize(22);
                departmentCodeTextView.setTextColor(Color.WHITE);
                departmentCodeTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                departmentCodeTextView.setText(departmentHandler.getDepartments().get(position).code);

                departmentNameTextView = new TextView(getActivity());
                departmentNameTextView.setTextSize(12);
                departmentNameTextView.setTextColor(Color.WHITE);
                departmentNameTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                departmentNameTextView.setPadding(0, 20, 0, 0);

                String departmentName = departmentHandler.getDepartments().get(position).name;
                //String shortDepartmentName = (departmentName.split("\\s+"))[0];

                int lastSpace = departmentName.lastIndexOf(" ");
                String actualDepartmentName;

                if (lastSpace > 0) {
                    actualDepartmentName = departmentName.substring(0, departmentName.lastIndexOf(" "));
                } else {
                    actualDepartmentName = departmentName;
                }

                departmentNameTextView.setText(actualDepartmentName);

                // Add textviews to grid item
                gridItem.addView(departmentCodeTextView);
                gridItem.addView(departmentNameTextView);
//
//                gridTextView = new SquareTextView(context);
//                //gridTextView.setLayoutParams(new GridView.LayoutParams(85, 85));
//                gridTextView.setPadding(8,8,8,8);
//                gridTextView.setBackgroundColor(Color.LTGRAY);
//                gridTextView.setTextColor(Color.WHITE);
//                gridTextView.setTextSize(22);
//                gridTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//                gridTextView.setGravity(Gravity.CENTER);


            } else {
                //gridTextView = (SquareTextView) convertView;
                gridItem = (SquareDepartmentGridItem) convertView;
            }


            gridItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onDepartmentGridItemClick(departmentHandler.getDepartments().
                                get(position));
                    }
                }
            });


            //return gridTextView;


            return gridItem;
        }
    }

}
