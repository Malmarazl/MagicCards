package com.example.magiccards.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.magiccards.MainActivity
import com.example.magiccards.R

class CardDetailFragment: Fragment() {

    lateinit var viewModel: CardDetailViewModel
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

        val buttonBack = view.findViewById<Button>(R.id.buttonBack)
        viewModel = CardDetailViewModel()
        cardID = args.cardID

        viewModel.getCard(cardID)


        setObservers(view)

        buttonBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    private fun setObservers(view :View) {
        viewModel.card.observe(
            viewLifecycleOwner, {
                view.findViewById<TextView>(R.id.card_detail_name).text = it.name
                view.findViewById<TextView>(R.id.card_detail_type).text = it.type
                view.findViewById<TextView>(R.id.card_detail_rarity).text = it.rarity

                Glide
                    .with(this)
                    .load(it.imageUrl)
                    .into(view.findViewById(R.id.card_detail_image))
            }
        )

        viewModel.loading.observe(
            viewLifecycleOwner, {
                (requireActivity() as MainActivity).showSpinner(it)
            }
        )

    }
}