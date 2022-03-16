package com.example.magiccards.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magiccards.R

class CardsListFragment : Fragment() {

    lateinit var viewModel: CardsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cards_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = CardsListViewModel()
        viewModel.getCards()

        val recycler: RecyclerView = view.findViewById(R.id.recyclerCardsList)


        viewModel.cardsList.observe(
            viewLifecycleOwner,{
                val adapter = ItemCardListAdapter(it, requireContext())
                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(context)
            }
        )
    }

}
