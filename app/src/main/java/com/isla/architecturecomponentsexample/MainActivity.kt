package com.isla.architecturecomponentsexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.isla.architecturecomponentsexample.screens.repositories.RepositoriesFragment

class MainActivity : AppCompatActivity(), MainActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            showRepositoriesScreen()
        }
    }


    override fun showRepositoriesScreen() {
         replaceFragment(RepositoriesFragment.newInstance(), false)
    }

    private fun replaceFragment(fragment: Fragment, needToAddToBackStack: Boolean = true) {
        val name = fragment.javaClass.simpleName
        with(supportFragmentManager.beginTransaction()) {
            replace(R.id.container, fragment, name)
            if (needToAddToBackStack) {
                addToBackStack(name)
            }
            commit()
        }
        supportFragmentManager.executePendingTransactions()
    }
}
