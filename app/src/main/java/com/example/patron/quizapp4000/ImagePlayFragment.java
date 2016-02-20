package com.example.patron.quizapp4000;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link ImagePlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImagePlayFragment extends Fragment {

    private Button nextButton;


    /**
     * Use this factory method to create a new instance of
     * this fragment
     */
    public static ImagePlayFragment newInstance() {
        ImagePlayFragment fragment = new ImagePlayFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ImagePlayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = null;
        view = inflater.inflate(R.layout.fragment_image_play, container, false);

        nextButton = (Button) view.findViewById(R.id.next_button);

        return view;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //different way of implementing click interaction.
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText eText = (EditText) view.findViewById(R.id.response_edittext);
                String text = eText.getText().toString();

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, TextPlayFragment.newInstance(text))
                        .addToBackStack(null)
                        .commit();

            }
        });
    }
}
