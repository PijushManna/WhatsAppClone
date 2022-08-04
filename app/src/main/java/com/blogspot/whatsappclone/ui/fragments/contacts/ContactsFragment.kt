package com.blogspot.whatsappclone.ui.fragments.contacts

import com.blogspot.whatsappclone.databinding.FragmentContactsBinding
import fragments.base.BaseFragment

class ContactsFragment : BaseFragment() {
    override val name: String = "Contacts"
    override val binding:FragmentContactsBinding by lazy { FragmentContactsBinding.inflate(layoutInflater)}

    override fun initViews() {

    }
}