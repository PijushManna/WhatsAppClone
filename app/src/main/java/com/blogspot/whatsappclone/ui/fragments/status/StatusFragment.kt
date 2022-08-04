package com.blogspot.whatsappclone.ui.fragments.status

import androidx.fragment.app.Fragment
import com.blogspot.whatsappclone.databinding.FragmentGroupBinding
import fragments.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [StatusFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatusFragment : BaseFragment() {
    override val binding: FragmentGroupBinding by lazy{FragmentGroupBinding.inflate(layoutInflater)}
    override val name: String = "Status"

    override fun initViews() {

    }
}