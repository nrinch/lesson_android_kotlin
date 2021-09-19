package na.severinchik.lesson7.presentation.data

import na.severinchik.lesson7.databinding.RecyclerItemAlcoholBinding
import na.severinchik.lesson7.presentation.base.BasicViewHolder

class AlcoholItemViewHolder(
    private val binding: RecyclerItemAlcoholBinding,
    private val alcoholItemClickListener: AlcoholItemClickListener
) :
    BasicViewHolder<AlcoholItem>(binding) {
    override fun bind(item: AlcoholItem) {
        binding.root.setOnClickListener {
            alcoholItemClickListener.click(item)
        }
        binding.riaName.text = item.name
        binding.riaPower.text = item.power.toPercentStringFormat()
        binding.riaHalfLife.text = item.halfLife.toTimeStringFormat()
    }
}

private fun Int.toPercentStringFormat() = "$this %"
private fun Int.toTimeStringFormat() = "$this h"