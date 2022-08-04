package com.blogspot.whatsappclone.ui.activity.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.blogspot.whatsappclone.R
import com.blogspot.whatsappclone.components.DaggerUserLoginComponents
import com.blogspot.whatsappclone.databinding.ActivityMainBinding
import com.blogspot.whatsappclone.ui.activity.base.BaseActivity
import com.blogspot.whatsappclone.ui.activity.login.LoginActivity
import com.blogspot.whatsappclone.ui.activity.main.adapter.MainTabNavAdapter
import com.blogspot.whatsappclone.utils.ProviderUtils
import com.example.signup.base.services.BaseUserLoginService
import com.google.android.material.tabs.TabLayoutMediator
import utils.showConfirmExit
import javax.inject.Inject

class MainActivity : BaseActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tabsItems by lazy {ProviderUtils.getFragmentsList()}
    private val tabsAdapter by lazy {
        MainTabNavAdapter(
            tabsItems, activity = this@MainActivity
        )
    }

    @Inject
    lateinit var firebaseLogin: BaseUserLoginService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerUserLoginComponents.builder().build().inject(this)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {
            pgrTabs.adapter = tabsAdapter
            TabLayoutMediator(tabsMain, pgrTabs) { tab, position ->
                tab.text = tabsItems[position].name
            }.attach()
        }
        setSupportActionBar(binding.topAppBar)
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