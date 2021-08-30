package na.severinchik.lesson7.presentation.base

import androidx.recyclerview.widget.DiffUtil
import na.severinchik.lesson7.data.entity.BasicUiEntity

open class BasicDiffCallback<T : BasicUiEntity<T>> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.same(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.contentSame(newItem)
    }
}