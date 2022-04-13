package com.example.speachmyapp.ui.datepicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.set

import com.example.speachmyapp.databinding.FragmentDatepickerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Datepicker.newInstance] factory method to
 * create an instance of this fragment.
 */
class Datepicker : Fragment() {
    // -- for view binding --
    private var _binding: FragmentDatepickerBinding? = null
    /* _binding props getter */
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        // -- for view binding --
        _binding = FragmentDatepickerBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // ----------------------



        // -- set event listeners --
        binding.compCalendar.setOnDateChangeListener { calendarView, i, i2, i3 ->
            val date = "Selected date: $i-$i2-$i3"
            binding.inputDate.setText(date)
        }
        // ------------------------

        return root
    }
}