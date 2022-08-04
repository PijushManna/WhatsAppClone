package com.blogspot.whatsappclone.ui.activity.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainTabNavAdapter(private val list: List<Fragment>,activity:FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}






//    FragmentPagerAdapter(fm, behavior) {
//    override fun getItem(position: Int): Fragment {
//        when (position) {
//            0 -> return ChatsFragment()
//            1 -> return GroupFragment()
//            3 -> return ContactsFragment()
//        }
//        return ChatsFragment()
//    }
//
//    override fun getCount(): Int {
//        return 3
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        when (position) {
//            0 -> return "Chats"
//            1 -> return "Groups"
//            2 -> return "Contacts"
//        }
//        return null
//    }
//}