package com.example.magiccards.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.magiccards.R
import org.w3c.dom.Text

class CardDetailFragment: Fragment() {

    lateinit var viewModel: CardDetailViewModel
    var cardID = ""

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

        val bundle = this.arguments
        if (bundle != null) {
            cardID = bundle.getString(CARD_ID, "0")
            viewModel.getCard(cardID)
        }

        setObserver(view)

        buttonBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    private fun setObserver(view :View) {
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
    }

    companion object {
        const val CARD_ID = "multiverseid"
    }
}