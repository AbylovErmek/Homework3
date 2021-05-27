package com.geektech.homework3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.geektech.homework3.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private String text;
    private FragmentFirstBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnFirst.setOnClickListener(v -> {
            if (binding.etTitle.getText().toString().isEmpty()) {
                binding.etTitle.setError("Заполните поле");
            } else {
                Bundle bundle = new Bundle();
                Fragment fragment = new SecondFragment();
                text = binding.etTitle.getText().toString();
                bundle.putString("first", text);
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container_, fragment).addToBackStack(null).commit();
            }
        });
    }
}