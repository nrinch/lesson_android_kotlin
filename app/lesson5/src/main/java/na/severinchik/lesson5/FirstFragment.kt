package na.severinchik.lesson5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager

private const val DEFAULT_NAME = ""
private const val DEFAULT_AGE = -1


class FirstFragment : Fragment() {


    var instanceName = DEFAULT_NAME
    var instanceAge = DEFAULT_AGE

    companion object {
        private val TAG = FirstFragment.javaClass.name

        private val NAME = "name"
        private val AGE = "age"

        fun getInstance(fragmentManager: FragmentManager) =
            fragmentManager.findFragmentByTag(TAG) ?: newInstance

        fun instanceWithParams(fragmentManager: FragmentManager, name: String, age: Int) =
            getInstance(fragmentManager).apply {
                arguments?.let { arguments ->
                    arguments.putString(NAME, name)
                    arguments.putInt(AGE, age)
                }
            }


        fun instanceWithParams(
            instance: () -> FirstFragment,
            name: String,
        ) =
//            instance.invoke().apply {
            instance().apply {
                arguments?.let { arguments ->
                    arguments.putString(NAME, name)
                }
            }


        private val newInstance = Fragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { arguments ->
            instanceName = arguments.getString(NAME) ?: DEFAULT_NAME
            instanceAge = arguments.getInt(AGE, DEFAULT_AGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_first, container, false)

}