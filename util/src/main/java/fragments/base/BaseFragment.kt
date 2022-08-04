package fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment : Fragment(){
    abstract val binding: ViewBinding
    abstract val name: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViews()
        addObservers()
        addClickListeners()
        return binding.root
    }

    open fun addClickListeners() {}

    open fun addObservers() {}

    abstract fun initViews()
}