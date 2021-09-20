package na.severinchik.lesson13.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import na.severinchik.lesson13.R
import na.severinchik.lesson13.data.localstorage.dto.CategoryDto
import na.severinchik.lesson13.databinding.CategoryItemBinding

class CategoriesMainScreenAdapter :
    ListAdapter<CategoryDto, CategoriesMainScreenAdapter.CategoryViewHolder>(CategoriesDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    class CategoryViewHolder(
        private val binding: CategoryItemBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(categoryDto: CategoryDto, position: Int) {

            binding.categoryButton.text = categoryDto.name[0].toString().uppercase()
            if (currentSelectedCategory == position) {
                binding.categoryButton.setBackgroundColor(categoryDto.color)
                binding.categoryButton.setTextColor(
                    context.resources.getColor(
                        R.color.colotWhiteText,
                        context.theme
                    )
                )
            } else {
                binding.categoryButton.setBackgroundColor(
                    context.resources.getColor(
                        R.color.colorDefaultCategory,
                        context.theme
                    )
                )
                binding.categoryButton.setTextColor(categoryDto.color)

            }

        }

    }

    private class CategoriesDiffCallback : DiffUtil.ItemCallback<CategoryDto>() {
        override fun areItemsTheSame(oldItem: CategoryDto, newItem: CategoryDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryDto, newItem: CategoryDto): Boolean {
            return oldItem == newItem
        }
    }


    companion object {
        private var currentSelectedCategory = 0

    }
}