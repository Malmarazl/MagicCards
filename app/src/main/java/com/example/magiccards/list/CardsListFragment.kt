package com.example.magiccards.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magiccards.MainActivity
import com.example.magiccards.R
import com.example.magiccards.detail.CardDetailFragment

class CardsListFragment : Fragment() {

    lateinit var viewModel: CardsListViewModel

    private var cardListener = object: CardListener {
        override fun sendCardID(id: String) {

            val cardDetailFragment = CardDetailFragment()
            val bundle = Bundle()

            bundle.putString(CARD_ID, id)
            cardDetailFragment.arguments = bundle

            view?.let{
                (activity as MainActivity).openFragment(cardDetailFragment)
            }
        }
    }

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
                val adapter = ItemCardListAdapter(it, requireContext(), cardListener)
                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(context)
            }
        )
    }

    companion object {
        const val CARD_ID = "multiverseid"
    }
}
