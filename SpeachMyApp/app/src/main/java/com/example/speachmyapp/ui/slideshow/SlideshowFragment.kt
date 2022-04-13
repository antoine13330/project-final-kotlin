package com.example.speachmyapp.ui.slideshow

import android.R
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.speachmyapp.BuildConfig
import com.example.speachmyapp.databinding.FragmentSlideshowBinding
import com.google.android.material.chip.Chip


class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
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