package na.severinchik.lesson7.presentation.data

import android.view.LayoutInflater
import android.view.ViewGroup
import na.severinchik.lesson7.databinding.RecyclerItemAlcoholBinding
import na.severinchik.lesson7.presentation.base.BasicAdapter

class AlcoholAdapter : BasicAdapter<AlcoholItem, AlcoholItemViewHolder>(AlcoholItemDiffCallback()) {
    override fun getViewHolder(parent: ViewGroup): AlcoholItemViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = RecyclerItemAlcoholBinding.inflate(layoutInflater, parent, false)
        return AlcoholItemViewHolder(binding)
    }
}