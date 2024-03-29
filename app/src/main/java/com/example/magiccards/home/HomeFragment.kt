package com.example.magiccards.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.magiccards.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val buttonEnter = view.findViewById<Button>(R.id.buttonEnter)

        buttonEnter.setOnClickListener {
            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCardsListFragment())
        }
    }
}