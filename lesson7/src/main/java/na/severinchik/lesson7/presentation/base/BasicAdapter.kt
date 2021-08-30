package na.severinchik.lesson7.presentation.base

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import na.severinchik.lesson7.data.entity.BasicUiEntity

abstract class BasicAdapter<T : BasicUiEntity<T>, VH : BasicViewHolder<T>>(diffCallback: BasicDiffCallback<T>) :
    ListAdapter<T, VH>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item: T = getItem(position)
        holder.bind(item)
    }

    abstract fun getViewHolder(parent: ViewGroup): VH
}