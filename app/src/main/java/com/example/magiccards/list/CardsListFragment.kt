package com.example.magiccards.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magiccards.MainActivity
import com.example.magiccards.R
import kotlinx.android.synthetic.main.cards_list_fragment.*
import kotlinx.android.synthetic.main.error_screen.*

class CardsListFragment : Fragment() {

    private lateinit var viewModel: CardsListViewModel

    private var cardListener = object: CardListener {
        override fun sendCardID(id: String) {
            view?.findNavController()?.
                navigate(CardsListFragmentDirections.actionCardsListFragmentToCardDetailFragment(id))
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

        setObservers()
    }

    private fun setObservers() {

        viewModel.cardsList.observe(
            viewLifecycleOwner,{
                val adapter = ItemCardListAdapter(it, requireContext(), cardListener)
                recyclerCardsList.adapter = adapter
                recyclerCardsList.layoutManager = LinearLayoutManager(context)
            }
        )

        viewModel.loading.observe(
            viewLifecycleOwner,{
                (requireActivity() as MainActivity).showSpinner(it)
            }
        )

        viewModel.error.observe(
            viewLifecycleOwner, {
                screen_error.visibility = View.VISIBLE

                button_retry.setOnClickListener {
                    viewModel.getCards()
                    screen_error.visibility = View.GONE
                }
            }
        )
    }
}
