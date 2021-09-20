package na.severinchik.lesson13.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import na.severinchik.lesson13.R
import java.lang.String
import na.severinchik.lesson13.data.entity.*
import na.severinchik.lesson13.data.localstorage.dto.CategoryDto

class CategorySpinnerAdapter(context: Context, newData: List<CategoryDto>) :
    BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val context: Context
    private var data: List<CategoryDto>
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var view = convertView
        view = layoutInflater.inflate(R.layout.spinner_category_item, parent, false)

        val category: CategoryDto = data[position]
        val text = view.findViewById<TextView>(R.id.full_name_category)
        text.text = category.name
        val button = view.findViewById<Button>(R.id.ctg_button)
        button.text = String.valueOf(category.name[0])
        button.setBackgroundColor(category.color)
        button.setTextColor(context.resources.getColor(R.color.colotWhiteText))
        return view
    }

    fun setData(newData: List<CategoryDto>) {
        data = newData
    }

    init {
        data = newData
        this.context = context
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}
