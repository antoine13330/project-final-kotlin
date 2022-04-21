package com.example.speachmyapp.ui.chipRating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.speachmyapp.databinding.FragmentChipRatingBinding
import com.google.android.material.chip.Chip


class ChipRatingFragment : Fragment() {

    private var _binding: FragmentChipRatingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChipRatingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.compButtonAdd.setOnClickListener {
            addChip()

        }
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addChip(){
        val chip = Chip(activity)
        chip.text= "${binding.compRating.rating.toInt()} stars rating"
        chip.isClickable = true
        chip.isCheckable = true
        chip.setOnClickListener{
            deleteChip(it);
        }
        binding.compChigroup.addView(chip)
    }
    fun deleteChip(chip : View) {
        binding.compChigroup.removeView(chip);
    }
}