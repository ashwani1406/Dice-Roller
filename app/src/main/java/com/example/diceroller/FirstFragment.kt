package com.example.diceroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.diceroller.databinding.FragmentFirstBinding
import java.time.Duration
import java.util.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rollButton.setOnClickListener(){
//            Toast.makeText(requireActivity().applicationContext, "YOUR MESSAGE", Toast.LENGTH_LONG).show()

            rollDice()
        }

    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1

        val diceImages: ImageView = binding.diceImage;
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImages.setImageResource(drawableResource)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}