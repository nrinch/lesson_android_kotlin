package na.severinchik.lesson7.presentation.base

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import na.severinchik.lesson7.data.entity.BasicUiEntity

abstract class BasicViewHolder<T : BasicUiEntity<T>>( binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)
}