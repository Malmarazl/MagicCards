package com.example.magiccards.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.magiccards.MainActivity
import com.example.magiccards.R
import kotlinx.android.synthetic.main.card_detail_fragment.*
import kotlinx.android.synthetic.main.cards_list_fragment.screen_error
import kotlinx.android.synthetic.main.error_screen.*

class CardDetailFragment: Fragment() {

    private lateinit var viewModel: CardDetailViewModel
    private var cardID = ""
    private val args: CardDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.card_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = CardDetailViewModel()
        cardID = args.cardID
        viewModel.getCard(cardID)

        setObservers()

        buttonBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun setObservers() {
        viewModel.card.observe(
            viewLifecycleOwner, {
                card_detail_name.text = it.name
                card_detail_type.text = it.type
                card_detail_rarity.text = it.rarity
                card_detail_description.text = it.text

                Glide
                    .with(this)
                    .load(it.imageUrl)
                    .into(card_detail_image)
            }
        )

        viewModel.loading.observe(
            viewLifecycleOwner, {
                (requireActivity() as MainActivity).showSpinner(it)
            }
        )

        viewModel.error.observe(
            viewLifecycleOwner, {
                screen_error.visibility = View.VISIBLE

                button_retry.setOnClickListener {
                    viewModel.getCard(cardID)
                    screen_error.visibility = View.GONE
                }
            }
        )

    }
}