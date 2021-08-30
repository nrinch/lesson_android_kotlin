package na.severinchik.lesson7.presentation.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import na.severinchik.lesson7.data.entity.BasicUiEntity

abstract class BasicViewHolder<T : BasicUiEntity<T>>(val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)
}