package com.blogspot.whatsappclone.ui.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.blogspot.whatsappclone.R
import com.blogspot.whatsappclone.databinding.ActivityMainBinding
import com.blogspot.whatsappclone.ui.activity.base.BaseActivity
import com.blogspot.whatsappclone.ui.activity.login.LoginActivity
import com.blogspot.whatsappclone.ui.activity.main.adapter.MainTabNavAdapter
import com.blogspot.whatsappclone.utils.InjectorUtils
import com.blogspot.whatsappclone.utils.ProviderUtils
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : BaseActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tabsItems by lazy {ProviderUtils.getFragmentsList()}
    private val tabsAdapter by lazy { MainTabNavAdapter(tabsItems, activity = this@MainActivity) }

    private val firebaseLogin = InjectorUtils.loginService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)
        initView()
    }

    private fun initView() {
        binding.apply {
            pgrTabs.adapter = tabsAdapter
            TabLayoutMediator(tabsMain, pgrTabs) { tab, position ->
                tab.text = tabsItems[position].name
            }.attach()
        }
    }

    override fun onBackPressed() {
        showConfirmExit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId) {
            R.id.mnuSettings -> {}
            R.id.mnuSignOut -> {
                firebaseLogin.logout()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
        return true
    }
}